package mx.com.liverpool.framework.input.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import mx.com.liverpool.application.usecases.PersonManagementUseCase;
import mx.com.liverpool.domain.PersonDO;
import mx.com.liverpool.domain.request.PersonRequest;
import mx.com.liverpool.domain.response.PersonResponse;
import mx.com.liverpool.framework.output.mongo.mappers.PersonMapper;

@RestController
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonController {

  private final PersonManagementUseCase useCase;
  private final PersonMapper personMapper;

  @PostMapping
  public PersonResponse createPerson(@RequestBody PersonRequest personRequest) {
    PersonDO personDO = personMapper.fromRequestToModel(personRequest);
    return personMapper.fromModelToResponse(useCase.savePerson(personDO));
  }

}
