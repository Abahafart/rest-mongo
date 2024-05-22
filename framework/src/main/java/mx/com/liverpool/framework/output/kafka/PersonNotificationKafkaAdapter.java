package mx.com.liverpool.framework.output.kafka;

import static mx.com.liverpool.framework.output.kafka.constants.KafkaConstants.HEADER_MESSAGE_KEY;
import static mx.com.liverpool.framework.output.kafka.constants.KafkaConstants.STREAM_NOTIFICATION_DONE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.liverpool.application.ports.output.PersonNotificationOutputPort;
import mx.com.liverpool.domain.PersonDO;

@Component
@RequiredArgsConstructor
public class PersonNotificationKafkaAdapter implements PersonNotificationOutputPort {

  private static final Logger log = LoggerFactory.getLogger(PersonNotificationKafkaAdapter.class);
  private final StreamBridge streamBridge;

  @Override
  public void sendNotification(PersonDO personDO) {
    log.info("Send information to notification.done {}", personDO);
    Message<PersonDO> message = MessageBuilder.withPayload(personDO)
        .setHeader(HEADER_MESSAGE_KEY, personDO.getId())
        .build();
    streamBridge.send(STREAM_NOTIFICATION_DONE, message);
    log.info("Notification sent");
  }
}
