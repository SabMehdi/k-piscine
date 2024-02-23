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
        // Ensure API key is set
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalArgumentException("OPENAI_API_KEY environment variable not set");
        }

        // Initialize OpenAI service
        OpenAiService service = new OpenAiService(apiKey);

        // Prepare chat completion request
        ChatMessage message = new ChatMessage("user", prompt); // Use constructor

        ChatCompletionRequest completionRequest = ChatCompletionRequest.builder()
                .model("gpt-3.5-turbo") // Updated model name
                .messages(Collections.singletonList(message))
                .maxTokens(1000)
                .n(1)
                .build();

        // Call GPT-3 service using the correct request object
        String response = service.createChatCompletion(completionRequest).getChoices().get(1).toString();
        return response;
    }
}
