package mx.com.liverpool.framework.output.mongo.repository;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.com.liverpool.application.ports.output.PersonManagementOutputPort;
import mx.com.liverpool.domain.PersonDO;
import mx.com.liverpool.domain.exception.InformationNotFoundException;
import mx.com.liverpool.framework.output.mongo.data.PersonEntity;
import mx.com.liverpool.framework.output.mongo.mappers.PersonMapper;
import mx.com.liverpool.framework.output.mongo.repository.jpa.PersonManagementRepository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class PersonManagementMongoAdapter implements PersonManagementOutputPort {

  private final PersonManagementRepository managementRepository;
  private final PersonMapper personMapper;

  @Override
  public PersonDO save(PersonDO model) {
    PersonEntity entity = personMapper.fromModelToEntity(model);
    managementRepository.save(entity);
    return personMapper.fromEntityToModel(entity);
  }

  @Override
  public PersonDO getById(String id) {
    PersonEntity personEntity = managementRepository.findById(id).orElseThrow(() ->
        new InformationNotFoundException(String.format("Information not found with id %s", id)));
    return personMapper.fromEntityToModel(personEntity);
  }

  @Override
  public void delete(String id) {
    managementRepository.findById(id).ifPresent(entity -> {
      managementRepository.delete(entity);
      log.info("Deleted person with id {}", id);
    });
  }
}
