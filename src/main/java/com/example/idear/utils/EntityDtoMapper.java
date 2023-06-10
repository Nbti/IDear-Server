package com.example.idear.utils;

import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper(componentModel = "spring")
public interface EntityDtoMapper {
    EntityDtoMapper INSTANCE = Mappers.getMapper(EntityDtoMapper.class);

//    @Mapping(target = "user.id", source = "userId")
//    Query toQuery(QueryRes queryRes);
}
