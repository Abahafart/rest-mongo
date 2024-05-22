package mx.com.liverpool.application.ports.input;

import mx.com.liverpool.application.generic.ServiceApplication;
import mx.com.liverpool.application.usecases.PersonManagementUseCase;
import mx.com.liverpool.domain.PersonDO;

@ServiceApplication
public class PersonManagementInputPort implements PersonManagementUseCase {

  @Override
  public PersonDO savePerson(PersonDO person) {
    return null;
  }

  @Override
  public PersonDO getById(String id) {
    return null;
  }

  @Override
  public void deletePerson(String id) {

  }
}
