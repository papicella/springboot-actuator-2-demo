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

## To Secure all endpoints

- Add Spring security dependency 

```
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
```

- Add username/password for the endpoints using HTTP Basic Authentication

```
spring:
  application:
    name: PCFSpringBootActuatorDemo
  jpa:
    hibernate:
      ddl-auto: update
  security:
    user:
      name: pas
      password: apples
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

- Repackage and re-push to Pivotal Cloud Foundry and access as follows assuming username = "pas" and password = "apples"

```
pasapicella@pas-macbook:~$ http -a pas:apples http://springboot-actuator-appsmanager-fantastic-lion.cfapps.io/actuator/health
HTTP/1.1 200 OK
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Connection: keep-alive
Content-Length: 183
Content-Type: application/vnd.spring-boot.actuator.v2+json;charset=UTF-8
Date: Tue, 27 Mar 2018 11:11:47 GMT
Expires: 0
Pragma: no-cache
Set-Cookie: JSESSIONID=27B4BFC79BAECFA9DCC946DF11C5AC5B; Path=/; HttpOnly
Set-Cookie: __VCAP_ID__=6a5a1770-71af-4fb2-5249-45bd; Path=/; HttpOnly
X-Content-Type-Options: nosniff
X-Frame-Options: DENY
X-Vcap-Request-Id: 2eb94269-3143-454b-5dd7-317e83d2f076
X-Xss-Protection: 1; mode=block

{
    "details": {
        "db": {
            "details": {
                "database": "H2",
                "hello": 1
            },
            "status": "UP"
        },
        "diskSpace": {
            "details": {
                "free": 906502144,
                "threshold": 10485760,
                "total": 1073741824
            },
            "status": "UP"
        }
    },
    "status": "UP"
}
```

<hr />
<i>
Pas Apicella [papicella at pivotal.io] is a Senior Platform Architect at Pivotal Australia
</i>