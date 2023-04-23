# gateway
A small IoT gateway project for exploring programming, edge communication, and web-based user interaction.


## AI assisted learning
Alot of the code is generated by AI, as to explore and learn.

# Java/Spring
Spring framework is used to explore and learn how the decorators are used.

## Notable use of decorations

### @Configuration and @Bean
The connection to he mqtt broker is handled by the `MqttConfiguration` class, where the @Bean decorator of the method creates a singleton object. This singleton object is then injected wherever needed.

### @Service and @Autowired
Publish and Subscribe are implemented as services in their own classes, where both of them has the mqttClient singleton autowired into them. These are basic implementations of the mqtt pubsub-model.

### Web Endpoints: @RestController
The `MqttController` class exposes REST endpoints for the services. Both service objects are autowired. The `/mqtt/publish` and `/mqtt/subscribe` endpoints handle requests.


# petite-vue
petite-vue is used as a lightweight frontend, so that the view will update upon changes.
