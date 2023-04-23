package com.example.simple_iot_gateway.gateway;

import org.eclipse.paho.client.mqttv3.MqttException;
import java.util.Objects;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Service;

@Service
public class MqttPublisherService {
    private MqttClient mqttClient;

    public MqttPublisherService(MqttClient mqttClient) {
        this.mqttClient = Objects.requireNonNull(mqttClient, "mqttClient must not be null");
    }
    public void publish(String topic, String payload, int qos) throws MqttException {
        MqttMessage message = new MqttMessage(payload.getBytes());
        message.setQos(qos);
        mqttClient.publish(topic, message);
    }
}