package mx.com.liverpool.framework.output.mongo.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import mx.com.liverpool.domain.PersonDO;
import mx.com.liverpool.domain.request.PersonRequest;
import mx.com.liverpool.domain.response.PersonResponse;
import mx.com.liverpool.framework.config.MappingConfig;
import mx.com.liverpool.framework.output.GenericMapper;
import mx.com.liverpool.framework.output.mongo.data.PersonEntity;

@Mapper(config = MappingConfig.class)
public interface PersonMapper extends GenericMapper<PersonDO, PersonRequest, PersonResponse, PersonEntity> {

//  @Override
//  @Mapping(target = "id", ignore = true)
//  PersonEntity fromModelToEntity(PersonDO model);
//
//  @Override
//  @Mapping(target = "id", ignore = true)
//  PersonDO fromEntityToModel(PersonEntity entity);
}
