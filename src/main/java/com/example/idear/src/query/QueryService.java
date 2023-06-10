package com.example.idear.src.query;

import com.example.idear.common.BaseResponseStatus;
import com.example.idear.exception.BaseException;
import com.example.idear.src.chatGPT.ChatGPTService;
import com.example.idear.src.query.dto.request.QueryReq;
import com.example.idear.src.query.dto.response.QueryRes;
import com.example.idear.src.query.model.Query;
import com.example.idear.src.user.UserRepository;
import com.example.idear.src.user.model.User;
import com.theokanning.openai.completion.chat.ChatCompletionChoice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueryService {
    private final ChatGPTService chatGPTService;
    private final QueryRepository queryRepository;
    private final UserRepository userRepository;

    // 질문하기
    public QueryRes query(QueryReq queryReq){
        ChatCompletionChoice result = chatGPTService.query(queryReq);

        saveQuery(queryReq);

        return new QueryRes(
                result.getMessage().getContent(),
                result.getFinishReason());
    }

    // 질문 저장
    public void saveQuery(QueryReq queryReq) {
        // 질문 저장
        User user = userRepository.findById(queryReq.getUserId())
                .orElseThrow(
                        () -> new BaseException(BaseResponseStatus.INVALID_USER_ID)
                );

        Query query = Query.builder()
                .to(queryReq.getTo())
                .content(queryReq.getContent())
                .type(queryReq.getType())
                .user(user)
                .build();

        queryRepository.save(query);
    }
}
