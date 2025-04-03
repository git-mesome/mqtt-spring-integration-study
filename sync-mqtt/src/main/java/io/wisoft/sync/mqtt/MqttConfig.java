package io.wisoft.sync.mqtt;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.messaging.MessageChannel;

@Configuration
public class MqttConfig {

  private static final String MQTT_BROKER_URL = "tcp://broker.emqx.io:1883";
  //  private static final String MQTT_BROKER_URL = "tcp://localhost:1883";
  private static final String MQTT_TOPIC = "/greet";

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
  public IntegrationFlow inboundFlow() {
    return IntegrationFlow
        .from(new MqttPahoMessageDrivenChannelAdapter("mqttReceiverClient", clientFactory(),
            MQTT_TOPIC))
        .channel(mqttInputChannel())
        .handle(m -> System.out.println("Received: " + m.getPayload()))
        .get();
  }

  @Bean
  public MessageChannel mqttOutboundChannel() {
    return new DirectChannel();
  }

  @Bean
  public IntegrationFlow outboundFlow() {
    return IntegrationFlow
        .from(mqttOutboundChannel())
        .handle(new MqttPahoMessageHandler("mqttSenderClient", clientFactory()) {{
          setDefaultTopic(MQTT_TOPIC);
          setAsync(false);
          setDefaultQos(1);
        }})
        .get();
  }
}
