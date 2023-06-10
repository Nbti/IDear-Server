package com.example.idear.src.chatGPT;

import com.example.idear.common.Constant;
import com.example.idear.src.query.dto.request.QueryReq;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.chat.ChatCompletionChoice;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChatGPTService {
    private OpenAiService openAiService = new OpenAiService(Constant.OPEN_API_KEY, Duration.ofSeconds(60));

    public ChatCompletionChoice query(QueryReq queryReq){
        List<ChatMessage> chatMessages = new ArrayList<>();

        chatMessages.add(new ChatMessage("system", "You are the author. please apply the options below to compose your mail."));
        chatMessages.add(new ChatMessage("user", queryReq.getContent()));

//        content = "안녕 나의 사랑,\n" +
//                "이번 주는 어떤 하루를 보내고 있니? 이렇게 일어나서 바로 너에게 참 좋은 아침인 것 같아. 그래도 조금 더 너와 함께 기상할 수 있다면 정말 행복할 거야.\n" +
//                "오늘도 반가운 하루가 되길 바래. 매 순간, 내 마음은 당신만을 바라보며 달려요. 언제든지 연락해줘, 나는 항상 당신 곁에서 지켜볼게.\n" +
//                "너무 사랑스러운 하루 보내길!\n" +
//                "사랑해 ♥";
//
//        chatMessages.add(new ChatMessage("assistant", content));
//
//        content = "더 귀엽게 써줘";
//
//        chatMessages.add(new ChatMessage("user", content));

        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest.builder()
                .model("gpt-3.5-turbo")
                .messages(chatMessages)
                .temperature(1.0)
                .frequencyPenalty(1.0)
                .presencePenalty(1.0)
                .build();

        ChatCompletionChoice chatCompletionChoice = openAiService.createChatCompletion(chatCompletionRequest).getChoices().get(0);

        return chatCompletionChoice;
    }
}
