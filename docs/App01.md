# Создать простейший микросервис используя Spring Boot c REST API GET /greetings по иструкции https://spring.io/guides/gs/rest-service/


<br/>

```
$ cd apps/app01
```

<br/>


```
$ curl https://start.spring.io/starter.zip \
  -d language=java \
  -d javaVersion=11 \
  -d platformVersion=2.6.1 \
  -d dependencies=web \
  -d packaging=jar \
  -d jvmVersion=11 \
  -d groupId=org.javadev \
  -d artifactId=rest-service \
  -d name=rest-service \
  -d description=Spring%20Boot%20Quick%20Start \
  -d packageName=org.javadev.rest-service \
  -o rest-service.zip
```

<br/>

```
$ unzip rest-service.zip -d ./
```

<br/>

```
$ rm rest-service.zip
```

<br/>

```
$ ./mvnw spring-boot:run
```


<br/>

![Application](/img/app01-pic01.png?raw=true)

<br/>

![Application](/img/app02-pic01.png?raw=true)