package com.example.idear.src.content;

import com.example.idear.src.content.dto.response.GetContentRes;
import com.example.idear.src.content.model.Content;
import com.example.idear.utils.EntityDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContentProvider {
    private final ContentRepository contentRepository;
    public List<GetContentRes> getContentResList(Long queryId){
        List<Content> contentList = contentRepository.findAllByMyQueryId(queryId);

        return EntityDtoMapper.INSTANCE.toContentResList(contentList);
    }
    public GetContentRes getContentRes(Long contentId){
         Optional<Content> contentOptional = contentRepository.findById(contentId);
         Content content = contentOptional.get();
         GetContentRes contentRes = new GetContentRes();
         contentRes.setContent(content.getContent());
         contentRes.setId(content.getId());
         contentRes.setCreatedAt(content.getCreatedAt());
         return contentRes;
    }
}
