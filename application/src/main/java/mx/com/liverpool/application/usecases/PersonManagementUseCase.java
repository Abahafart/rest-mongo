package mx.com.liverpool.application.usecases;

import mx.com.liverpool.domain.PersonDO;

public interface PersonManagementUseCase {

  PersonDO savePerson(PersonDO person);
  PersonDO getById(String id);
  void deletePerson(String id);

}
