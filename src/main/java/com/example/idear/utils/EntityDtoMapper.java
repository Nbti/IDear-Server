package com.example.idear.utils;

import com.example.idear.src.query.dto.response.QueryRes;
import com.example.idear.src.query.model.Query;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper(componentModel = "spring")
public interface EntityDtoMapper {
    EntityDtoMapper INSTANCE = Mappers.getMapper(EntityDtoMapper.class);

    @Mapping(target = "userId", source = "user.id")
    QueryRes toQueryRes(Query query);

    @Mapping(target = "user.id", source = "userId")
    Query toQuery(QueryRes queryRes);
}
