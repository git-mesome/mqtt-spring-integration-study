package io.wisoft.mqtt.outbound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
public class MessagePublisher {

  private final MessageChannel mqttOutboundChannel;

  @Autowired
  public MessagePublisher(@Qualifier("mqttOutboundChannel") MessageChannel mqttOutboundChannel) {
    this.mqttOutboundChannel = mqttOutboundChannel;
  }


  public void sendMessage(String payload) {
    Message<String> message = MessageBuilder.withPayload(payload).build();
    mqttOutboundChannel.send(message);
  }
}