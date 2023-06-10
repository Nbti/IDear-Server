package com.example.idear.src.chatGPT;

import com.example.idear.common.BaseResponseStatus;
import com.example.idear.common.Constant;
import com.example.idear.exception.BaseException;
import com.example.idear.src.profile.ProfileRepository;
import com.example.idear.src.profile.models.Profile;
import com.example.idear.src.query.dto.request.QueryReq;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.chat.ChatCompletionChoice;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatGPTService {
    private OpenAiService openAiService = new OpenAiService(Constant.OPEN_API_KEY, Duration.ofSeconds(60));
    private final ProfileRepository profileRepository;

    public ChatCompletionChoice query(QueryReq queryReq){
        Profile profile = profileRepository.findById(queryReq.getProfileId())
                .orElseThrow(
                        () -> new BaseException(BaseResponseStatus.INVALID_PROFILE_ID)
                );

        List<ChatMessage> chatMessages = new ArrayList<>();

        chatMessages.add(new ChatMessage("system", "You are the author. please apply the options below to compose your mail."));

        System.out.println(profile.getMbti());
        System.out.println(profile.getMbti().charAt(0));

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

        chatMessages.add(new ChatMessage("user", content));

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
                .temperature(0.8)
                .frequencyPenalty(0.8)
                .presencePenalty(0.8)
                .build();

        ChatCompletionChoice chatCompletionChoice = openAiService.createChatCompletion(chatCompletionRequest).getChoices().get(0);

        return chatCompletionChoice;
    }
}
