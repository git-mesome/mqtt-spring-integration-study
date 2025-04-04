# MQTT Integration Project

## 개요
이 프로젝트는 Spring Boot와 Spring Integration을 사용하여 MQTT 메시지를 송수신하는 애플리케이션입니다. 이 애플리케이션은 MQTT 브로커와 통신하여 메시지를 게시하고 수신합니다.

## 패키지 구조
- `io.wisoft.mqtt.config`: 공통 설정 파일을 포함합니다.
- `io.wisoft.mqtt.receiver`: MQTT 메시지를 수신하는 기능을 포함합니다.
- `io.wisoft.mqtt.sender`: MQTT 메시지를 게시하는 기능을 포함합니다.

## 주요 클래스
### `MqttMessagePublisher`
MQTT 메시지를 게시하는 클래스입니다.

```java
@Component
public class MqttMessagePublisher {
  // 코드 생략
}
```

### `MqttPublisherApplication`
Spring Boot 애플리케이션의 진입점입니다.
```java
@SpringBootApplication
public class MqttPublisherApplication {
  // 코드 생략
}
```
### `MqttMessagePublisherScheduler`
주기적으로 MQTT 메시지를 게시하는 스케줄러 클래스입니다.
```java
@Component
public class MqttMessagePublisherScheduler {
  // 코드 생략
}
```
## 빌드 및 실행

- Java 21
- Gradle

```bash
./gradlew build
```


```bash
./gradlew bootRun
```

이 프로젝트는 다음과 같은 주요 의존성을 사용합니다:

- Spring Boot
- Spring Integration MQTT

## 라이선스
이 프로젝트는 MIT 라이선스를 따릅니다. 자세한 내용은 LICENSE 파일을 참조하세요.