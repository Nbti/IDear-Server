package com.example.idear.src.content;

import com.example.idear.src.content.model.Content;
import com.example.idear.src.query.model.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContentService {
    private final ContentRepository contentRepository;
    public void saveContent(String message, Query queryCreated){
        Content content = Content.builder()
                .content(message)
                .query(queryCreated)
                .build();

        contentRepository.save(content);
    }
}
