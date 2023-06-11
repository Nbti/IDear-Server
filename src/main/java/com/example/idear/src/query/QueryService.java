package com.example.idear.src.query;

import com.example.idear.common.BaseResponseStatus;
import com.example.idear.exception.BaseException;
import com.example.idear.src.chatGPT.ChatGPTService;
import com.example.idear.src.content.ContentService;
import com.example.idear.src.content.dto.response.ContentRes;
import com.example.idear.src.content.model.Content;
import com.example.idear.src.profile.ProfileRepository;
import com.example.idear.src.profile.models.Profile;
import com.example.idear.src.query.dto.request.QueryReq;
import com.example.idear.src.query.dto.request.RequeryReq;
import com.example.idear.src.query.dto.response.QueryRes;
import com.example.idear.src.query.model.MyQuery;
import com.example.idear.src.user.UserRepository;
import com.example.idear.src.user.model.User;
import com.example.idear.utils.EntityDtoMapper;
import com.theokanning.openai.completion.chat.ChatCompletionChoice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueryService {
    private final ChatGPTService chatGPTService;
    private final ContentService contentService;
    private final QueryRepository queryRepository;
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;

    // 질문하기
    public QueryRes query(QueryReq queryReq){
        String content = makeContent(queryReq);
        ChatCompletionChoice result = chatGPTService.query(content);

        MyQuery myQueryCreated = saveQuery(content, queryReq);
        Content contentCreated = contentService.saveContent(result.getMessage().getContent(), myQueryCreated);

        return new QueryRes(
                myQueryCreated.getId(),
                myQueryCreated.getDear(),
                myQueryCreated.getType(),
                myQueryCreated.getCreatedAt(),
                new ContentRes(contentCreated.getId(), result.getMessage().getContent(), result.getFinishReason())
        );
    }

    public QueryRes requery(Long queryId, RequeryReq requeryReq){
        MyQuery query = queryRepository.findById(queryId)
                .orElseThrow(
                        () -> new BaseException(BaseResponseStatus.INVALID_QUERY_ID)
                );
        ChatCompletionChoice result = chatGPTService.requery(query, requeryReq);
        // content 저장하기
        Content contentCreated = contentService.saveContent(result.getMessage().getContent(), requeryReq.getFeedback(), query);

        QueryRes queryRes = EntityDtoMapper.INSTANCE.toQueryRes(query);
        queryRes.setContentRes(new ContentRes(contentCreated.getId(), contentCreated.getContent(), result.getFinishReason()));

        return queryRes;
    }

    // 질문 저장
    public MyQuery saveQuery(String question, QueryReq queryReq) {
        // 질문 저장
        User user = userRepository.findById(queryReq.getUserId())
                .orElseThrow(
                        () -> new BaseException(BaseResponseStatus.INVALID_USER_ID)
                );
        Profile profile = profileRepository.findById(queryReq.getProfileId())
                .orElseThrow(
                        () -> new BaseException(BaseResponseStatus.INVALID_PROFILE_ID)
                );

        MyQuery myQuery = MyQuery.builder()
                .dear(queryReq.getDear())
                .type(queryReq.getType())
                .content(queryReq.getContent())
                .question(question)
                .user(user)
                .profile(profile)
                .build();

        return queryRepository.save(myQuery);
    }

    public String makeContent(QueryReq queryReq){
        Profile profile = profileRepository.findById(queryReq.getProfileId())
                .orElseThrow(
                        () -> new BaseException(BaseResponseStatus.INVALID_PROFILE_ID)
                );

        String content =
                "- To : " + queryReq.getDear() + "\n" +
                        "- Type : " + queryReq.getType() + "\n" +
                        "- Writing tone : ";
        if(profile.getMbti().charAt(0) == 'E')
            content += "Outgoing, Sociable, Energetic, ";
        else if(profile.getMbti().charAt(0) == 'I')
            content += "Introverted, Deliberate, Thoughtful, ";

        if(profile.getMbti().charAt(1) == 'N')
            content += "Imaginative, Creative, Open-minded, ";
        else if(profile.getMbti().charAt(1) == 'S')
            content += "Realistic, Detail-oriented, Factual, ";

        if(profile.getMbti().charAt(2) == 'F')
            content += "Empathetic, Caring, Emotional, Supportive, Harmonious, Compassionate, Caring, ";
        else if(profile.getMbti().charAt(2) == 'T')
            content += "Logical, Objective, Rational, Critical, Detached, Pragmatic, Impartial, Analytical, ";

        if(profile.getMbti().charAt(3) == 'P')
            content += "Flexible, Easygoing, Laid-back, Adaptive\n";
        else if(profile.getMbti().charAt(3) == 'J')
            content += "Systematic, Responsible, Efficient, Punctual\n";

        // TODO : 키워드 추가

        content += "- Content : " + queryReq.getContent() + "\n" +
                "- Language : in Korean\n" +
                "- Character limit : 400 characters in Korean\n";
        if(profile.getIs_polite())
            content += "- polite speech";
        else
            content += "- casual speech";

        System.out.println(content);

        return content;
    }
}
