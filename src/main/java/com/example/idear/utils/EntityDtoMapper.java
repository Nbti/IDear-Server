package com.example.idear.utils;

import com.example.idear.src.content.dto.response.ContentRes;
import com.example.idear.src.content.dto.response.GetContentRes;
import com.example.idear.src.content.model.Content;
import org.mapstruct.factory.Mappers;

import java.util.List;

@org.mapstruct.Mapper(componentModel = "spring")
public interface EntityDtoMapper {
    EntityDtoMapper INSTANCE = Mappers.getMapper(EntityDtoMapper.class);

//    @Mapping(target = "user.id", source = "userId")
//    Query toQuery(QueryRes queryRes);

    GetContentRes toContentRes(Content content);
    List<GetContentRes> toContentResList(List<Content> contentList);

}
