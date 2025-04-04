package io.wisoft.mqtt.outbound;

import io.wisoft.mqtt.common.MqttCommonConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;

@Configuration
public class PublisherConfig {

  private static final String MQTT_TOPIC = "/greet";

  @Bean
  public IntegrationFlow publishFlow(MqttCommonConfig commonConfig) {
    return IntegrationFlow
        .from(commonConfig.mqttOutboundChannel())
        .handle(new MqttPahoMessageHandler("mqttSenderClient", commonConfig.clientFactory()) {{
          setDefaultTopic(MQTT_TOPIC);
          setAsync(false);
          setDefaultQos(1);
        }})
        .get();
  }
}