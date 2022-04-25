# 13. Итоговое задание

<br/>

**Проектная работа:**

1. Создать новый микросервис "demo" с помощью Maven-архетипа.

2. Подключить к микросервису плагин для генерации кода по модулю DQHakaTutor версии 1.01.00 и сгенерировать код.

3. Реализовать методы GET v1/sms-verification и POST/sms-verification.

4. Написать Unit-тесты на функционал.

5. Создать микросервис ServiceDiscovery, используя spring-cloud-starter-netflix-eureka-server.

6. Создать микросервис  API Gateway, используя spring-cloud-starter-gateway.

7. Микросервис "demo" при старте должен зарегистрироваться в ServiceDiscovery.

8. Продемонстрировать вызов методов GET v1/sms-verification и POST/sms-verification микросервиса "demo" через API Gateway.

<br/>

```
$ mvn -B archetype:generate -DarchetypeGroupId=ru.diasoft.micro -DarchetypeArtifactId=template-archetype -DarchetypeVersion=RELEASE -DgroupId=ru.diasoft.micro  -DartifactId=demo -Dversion=1.01.01-SNAPSHOT

```


```
$ cd apps/app08
```

<br/>

```
$ ./mvnw spring-boot:run
```

