package com.home.mapper;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TestMapper {
    ADto toA(BDto bDto);
    BDto toB(ADto aDto);
}
