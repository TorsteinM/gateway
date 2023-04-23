package com.example.simple_iot_gateway.gateway;

import java.util.Objects;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mqtt")
public class MqttController {

    private MqttPublisherService mqttPublisherService;
    private MqttSubscriberService mqttSubscriberService;

    public MqttController(MqttPublisherService mqttPublisherService, MqttSubscriberService mqttSubscriberService) {
        this.mqttPublisherService = Objects.requireNonNull(mqttPublisherService, "mqttPublisherService must not be null");
        this.mqttSubscriberService = Objects.requireNonNull(mqttSubscriberService, "mqttSubscriberService must not be null");
    }

    @GetMapping("/publish")
    public String publish(@RequestParam String topic, @RequestParam String payload) {
        try {
            mqttPublisherService.publish(topic, payload, 1);
            return "Message published successfully";
        } catch (MqttException e) {
            e.printStackTrace();
            return "Error publishing message: " + e.getMessage();
        }
    }

    @GetMapping("/subscribe")
    public String subscribe(@RequestParam String topic) {
        try {
            mqttSubscriberService.subscribe(topic, 1);
            return "Subscribed to topic: " + topic;
        } catch (MqttException e) {
            e.printStackTrace();
            return "Error subscribing to topic: " + e.getMessage();
        }
    }
}