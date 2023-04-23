package com.example.simple_iot_gateway.gateway;


import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("classpath:secret.properties")
public class MqttConfiguration {

    @Value("${mqtt.broker.url}")
    String serverURI;
    @Value("${mqtt.username}")
    String clientId;
    @Value("${mqtt.password}")
    String clientPass;

    @Bean
    public MqttClient mqttClient() throws Exception {
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