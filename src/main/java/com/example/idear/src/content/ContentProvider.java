package com.example.idear.src.content;

import com.example.idear.src.content.dto.response.GetContentRes;
import com.example.idear.src.content.model.Content;
import com.example.idear.utils.EntityDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContentProvider {
    private final ContentRepository contentRepository;
    public List<GetContentRes> getContentResList(Long queryId){
        List<Content> contentList = contentRepository.findAllByMyQueryId(queryId);

        return EntityDtoMapper.INSTANCE.toContentResList(contentList);
    }
}
