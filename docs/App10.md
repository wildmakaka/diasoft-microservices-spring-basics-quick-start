# 10. Поддержка событийно-ориентированной архитектуры в приложениях Spring Framework (Kafka)

<br/>

Развернуть на своей машине Apache Kafka.

Создать микросервис и подключить к нему библиотеку Spring Cloud Stream. 

В микросервисе реализовать подписчик на топик "demo" Apache Kafka.

Через консоль Apache Kafka отправить собщение в топик "demo". В микросервисе в обработчике вывести в лог полученное сообщение.


<br/>

```
$ cd apps/app08
```

<br/>

```
$ ./mvnw spring-boot:run
```


<br/>

```
// Create a Message
$ kafka-console-producer.sh \
    --broker-list localhost:9092 \
    --topic demo
```



<br/>

![Application](/img/app07-pic10.gif?raw=true)