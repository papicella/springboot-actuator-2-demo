<h2>Pivotal Cloud Foundry Apps Manager Actuator Integration Demo </h2>

![alt tag](https://image.ibb.co/b5izL7/Screen_Shot_2018_03_04_at_9_00_42_PM.png)

The application.yml exposes all methods and is totally unsecure so you would not want to do this in a production application

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
      show-details: true
  endpoints:
    web:
      expose: '*'
      enabled: true
    jmx:
      expose: '*'
      enabled: true
```

<hr />
<i>
Pas Apicella [papicella at pivotal.io] is a Senior Platform Architect at Pivotal Australia
</i>