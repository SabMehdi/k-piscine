package com.example.demo.provider;

import com.theokanning.openai.service.OpenAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;

import java.util.Collections;

@Service
public class OpenAIProvider {

    @Value("${openai.apiKey}")
    private String apiKey;

    public String askOpenAI(String prompt) {
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalArgumentException("OPENAI_API_KEY environment variable not set");
        }

        OpenAiService service = new OpenAiService(apiKey);

        ChatMessage message = new ChatMessage("user", prompt); 

        ChatCompletionRequest completionRequest = ChatCompletionRequest.builder()
                .model("gpt-3.5-turbo") 
                .messages(Collections.singletonList(message))
                .maxTokens(1000)
                .n(1)
                .build();

        String response = service.createChatCompletion(completionRequest).getChoices().get(0).getMessage().getContent();
        return response;
    }
}
