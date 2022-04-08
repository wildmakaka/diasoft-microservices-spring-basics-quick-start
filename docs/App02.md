# 02. Аспектно-ориентированное программирование в Spring

<br/>

1. Создать простейший микросервис с REST API GET /greetings. 

2. В микросервисе создать AOP-аспект для логирования входящих и исходящих параметров REST API. Подключить аспект к контроллеру и продемонстрировать логирование через этот аспект.

<br/>

```
$ cd apps/app02
```

<br/>

```
$ ./mvnw spring-boot:run
```

<br/>


```
$ curl localhost:8080/greeting?name=WebMakaka
{"id":3,"content":"Hello, WebMakaka!"}
```

<br/>


```
2022-03-29 02:26:45.253  INFO 103781 --- [nio-8080-exec-1] org.javadev.restservice.LoggingAspect    : 
 Входящее значение: "WebMakaka"
2022-03-29 02:26:45.282  INFO 103781 --- [nio-8080-exec-1] org.javadev.restservice.LoggingAspect    : 
 Возвращенное значение : {
  "id" : 1,
  "content" : "Hello, WebMakaka!"
}
```


<br/>

![Application](/img/app02-pic01.png?raw=true)

