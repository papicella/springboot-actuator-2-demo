<h2>Pivotal Cloud Foundry Apps Manager Actuator Integration Demo </h2>

![alt tag](https://image.ibb.co/d7Ecym/apps_manager_spring_1.png)

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