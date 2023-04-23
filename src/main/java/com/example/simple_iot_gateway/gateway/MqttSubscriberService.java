package com.example.simple_iot_gateway.gateway;


import org.eclipse.paho.client.mqttv3.MqttException;
import java.util.Objects;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Service;

@Service
public class MqttSubscriberService implements MqttCallback {
    private MqttClient mqttClient;

    public MqttSubscriberService(MqttClient mqttClient) {
        this.mqttClient = Objects.requireNonNull(mqttClient, "mqttClient must not be null");
    }

    public void subscribe(String topic, int qos) throws MqttException {
        mqttClient.setCallback(this);
        mqttClient.subscribe(topic, qos);
    }

    @Override
    public void connectionLost(Throwable cause) {
        System.out.println("Connection lost: " + cause.getMessage());
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        System.out.println("Message arrived: Topic: " + topic + ", Message: " + new String(message.getPayload()));
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        System.out.println("Delivery complete: " + token.getMessageId());
    }
}
