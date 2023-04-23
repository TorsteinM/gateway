# gateway
A small IoT gateway project for exploring programming, edge communication, and web-based user interaction.


## AI assisted learning
Alot of the code is generated by AI, as to explore and learn.

# Java/Spring
Spring framework is used to explore and learn how the decorators are used.

## Notable use of decorations

### @Configuration and @Bean
The connection to he mqtt broker is handled by the MqttConfiguration class, where the @Bean decorator of the method creates a singleton object. This singleton object is then @autowired in wherever needed. Not entirely sure if @Bean always returns a singleton, atleast it seems to do so within the @Configuration.

### @Service and @Autowired
Publish and Subscribe are implemented as services in their own classes, where both of them has the mqttClient singleton autowired into them. These are basic implementations of the mqtt pubsub-model.

### Web endpoints: @RestController
The services are then exposed as REST endpoints in the MqttController class. Both of the service objects are autowired in. They expose REST endpoints that handle requests at /mqtt/publish and /mqtt/subscribe. 


# petite-vue
petite-vue is used as a lightweight frontend, so that the view will update upon changes.