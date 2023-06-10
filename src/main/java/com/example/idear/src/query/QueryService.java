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
import com.example.idear.src.query.dto.response.FirstQueryRes;
import com.example.idear.src.query.model.MyQuery;
import com.example.idear.src.user.UserRepository;
import com.example.idear.src.user.model.User;
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
    public FirstQueryRes query(QueryReq queryReq){
        ChatCompletionChoice result = chatGPTService.query(queryReq);

        MyQuery myQueryCreated = saveQuery(queryReq);
        Content contentCreated = contentService.saveContent(result.getMessage().getContent(), myQueryCreated);

        return new FirstQueryRes(
                myQueryCreated.getDear(),
                myQueryCreated.getType(),
                myQueryCreated.getCreatedAt(),
                new ContentRes(contentCreated.getId(), result.getMessage().getContent(), result.getFinishReason())
        );
    }

    // 질문 저장
    public MyQuery saveQuery(QueryReq queryReq) {
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
                .user(user)
                .profile(profile)
                .build();

        return queryRepository.save(myQuery);
    }
}
