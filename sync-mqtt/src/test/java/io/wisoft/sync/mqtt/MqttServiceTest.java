package io.wisoft.sync.mqtt;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.MessageChannel;

@SpringBootTest
class MqttServiceTest {

    @Test
    void sendMessage() {
        // Given
        MessageChannel mockChannel = Mockito.mock(MessageChannel.class);
        MqttService mqttService = new MqttService(mockChannel);

        // When
        String testMessage = "Test Message";
        mqttService.sendMessage(testMessage);

        // Then
        verify(mockChannel).send(any());
    }
}