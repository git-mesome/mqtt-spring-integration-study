package io.wisoft.mqtt.outbound;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = {
    "io.wisoft.mqtt.common",
    "io.wisoft.mqtt.outbound"})
public class PublisherApplication {

  public static void main(String[] args) {
    SpringApplication.run(PublisherApplication.class, args);
  }

}
