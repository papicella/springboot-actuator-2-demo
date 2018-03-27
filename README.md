<h2>Pivotal Cloud Foundry Apps Manager Spring Boot 2.0 Actuator Integration Demo </h2>

![alt tag](https://image.ibb.co/b5izL7/Screen_Shot_2018_03_04_at_9_00_42_PM.png)

The application.yml exposes all methods and is totally unsecured so you would not want to do this in a production application

```
spring:
  application:
    name: PCFSpringBootActuatorDemo
  jpa:
    hibernate:
      ddl-auto: update
management:
  endpoint:
    health:
      enabled: true
      show-details: when_authorized
  endpoints:
    web:
      exposure:
        include: '*'
    jmx:
      exposure:
        include: '*'
```

<hr />
<i>
Pas Apicella [papicella at pivotal.io] is a Senior Platform Architect at Pivotal Australia
</i>