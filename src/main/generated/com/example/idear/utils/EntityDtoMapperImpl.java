package com.example.idear.utils;

import com.example.idear.src.content.dto.response.GetContentRes;
import com.example.idear.src.content.model.Content;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-11T07:42:04+0900",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class EntityDtoMapperImpl implements EntityDtoMapper {

    @Override
    public GetContentRes toContentRes(Content content) {
        if ( content == null ) {
            return null;
        }

        GetContentRes getContentRes = new GetContentRes();

        getContentRes.setId( content.getId() );
        getContentRes.setContent( content.getContent() );
        getContentRes.setCreatedAt( content.getCreatedAt() );

        return getContentRes;
    }

    @Override
    public List<GetContentRes> toContentResList(List<Content> contentList) {
        if ( contentList == null ) {
            return null;
        }

        List<GetContentRes> list = new ArrayList<GetContentRes>( contentList.size() );
        for ( Content content : contentList ) {
            list.add( toContentRes( content ) );
        }

        return list;
    }
}
