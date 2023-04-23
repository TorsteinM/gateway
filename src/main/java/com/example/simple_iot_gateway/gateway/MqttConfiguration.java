package com.example.simple_iot_gateway.gateway;


import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttConfiguration {

    @Bean
    public MqttClient mqttClient() throws Exception {
        String serverURI = "tcp://192.168.0.56:1883";
        String clientId = "mqtt";
        String clientPass = "mqtt!pass";
        MqttClient mqttClient = new MqttClient(serverURI, clientId);
        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        options.setConnectionTimeout(30);
        options.setPassword(clientPass.toCharArray());
        mqttClient.connect(options);
        return mqttClient;
    }
}