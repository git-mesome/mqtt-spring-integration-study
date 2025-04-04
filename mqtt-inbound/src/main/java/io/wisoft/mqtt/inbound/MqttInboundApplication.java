package io.wisoft.mqtt.inbound;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
    "io.wisoft.mqtt.common",
    "io.wisoft.mqtt.inbound"})
public class MqttInboundApplication {

  public static void main(String[] args) {
    SpringApplication.run(MqttInboundApplication.class, args);
  }

}
