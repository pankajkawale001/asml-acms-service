package com.asml.acms.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.asml.acms.dto.HelloWorldDTO;
import com.asml.acms.entity.HelloWorldEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface HelloWorldMapper {

	HelloWorldMapper INSTANCE = Mappers.getMapper(HelloWorldMapper.class);

	HelloWorldEntity mapHelloWorldDTOHelloWorldEntity(HelloWorldDTO userDTO);

	HelloWorldDTO mapHelloWorldToHelloWorldDTO(HelloWorldEntity user);

}
