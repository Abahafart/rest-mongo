package mx.com.liverpool.application.ports.input;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.RequiredArgsConstructor;
import mx.com.liverpool.application.generic.ServiceApplication;
import mx.com.liverpool.application.ports.output.PersonManagementOutputPort;
import mx.com.liverpool.application.ports.output.PersonNotificationOutputPort;
import mx.com.liverpool.application.usecases.PersonManagementUseCase;
import mx.com.liverpool.domain.PersonDO;

@ServiceApplication
@RequiredArgsConstructor
public class PersonManagementInputPort implements PersonManagementUseCase {

  private final PersonManagementOutputPort outputPort;
  private final PersonNotificationOutputPort notificationOutputPort;
  private static final Logger log = LoggerFactory.getLogger(PersonManagementInputPort.class);

  @Override
  public PersonDO savePerson(PersonDO person) {
    log.info("Request to save person: {}", person);
    PersonDO personSaved = outputPort.save(person);
    notificationOutputPort.sendNotification(personSaved);
    return personSaved;
  }

  @Override
  public PersonDO getById(String id) {
    return outputPort.getById(id);
  }

  @Override
  public void deletePerson(String id) {
    outputPort.delete(id);
  }
}
