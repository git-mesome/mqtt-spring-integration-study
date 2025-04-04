package io.wisoft.mqtt.common;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.messaging.MessageChannel;

@Configuration
public class MqttCommonConfig {

  private static final String MQTT_BROKER_URL = "tcp://broker.emqx.io:1883";
  //  private static final String MQTT_BROKER_URL = "tcp://localhost:1883";

  @Bean
  public DefaultMqttPahoClientFactory clientFactory() {
    DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
    MqttConnectOptions options = new MqttConnectOptions();
    options.setServerURIs(new String[]{MQTT_BROKER_URL});
    factory.setConnectionOptions(options);
    return factory;
  }

  @Bean
  public MessageChannel mqttInputChannel() {
    return new DirectChannel();
  }

  @Bean
  public MessageChannel mqttOutboundChannel() {
    return new DirectChannel();
  }


}
