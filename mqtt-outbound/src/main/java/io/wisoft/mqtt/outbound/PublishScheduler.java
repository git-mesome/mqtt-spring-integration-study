package io.wisoft.mqtt.outbound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PublishScheduler {

  private final MessagePublisher sender;

  @Autowired
  public PublishScheduler(MessagePublisher sender) {
    this.sender = sender;
  }

  @Scheduled(fixedRate = 1000) // 1초마다 실행
  public void sendPeriodMessage() {
    sender.sendMessage("주기적으로 보내는 메시지");
  }
}
