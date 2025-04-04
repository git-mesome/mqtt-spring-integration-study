package io.wisoft.mqtt.inbound;

import io.wisoft.mqtt.common.MqttCommonConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;

@Configuration
public class SubscribeConfig {

  private static final String MQTT_TOPIC = "/greet";

  @Bean
  public IntegrationFlow subscribeFlow(MqttCommonConfig commonConfig) {
    return IntegrationFlow
        .from(new MqttPahoMessageDrivenChannelAdapter("mqttReceiverClient", commonConfig.clientFactory(),
            MQTT_TOPIC))
        .channel(commonConfig.mqttInputChannel())
        .handle(m -> System.out.println("Received: " + m.getPayload()))
        .get();
  }

}
