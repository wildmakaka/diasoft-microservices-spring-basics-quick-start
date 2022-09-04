# 07. Тестирование микросервисов

<br/>

Разработать тесты для микросервиса содержащего CRUD REST API и работающего с in memory базой данных h2. Структура h2 должна создаваться с помощью liquibase.


<br/>

## Вариант 1 (Интеграционные Rest тесты)

<br/>

```
$ cd apps/app07/v1
```

<br/>


```
$ ./mvnw spring-boot:run
```

<br/>


```
$ mvn test
```

<br/>

![Application](/img/app07-pic02.gif?raw=true)


<br/>


### Запуск приложения из IDE


<br/>

![Application](/img/app07-pic01.gif?raw=true)



<br/>

```
// Подключиться к базе можно  
http://localhost:8080/h2-console/
```


<br/>

## Вариант 2 (Unit тесты)


<br/>

```
$ cd apps/app07/v2
```

<br/>


```
$ ./mvnw spring-boot:run
```


<br/>

**Материалы:**


https://docs.liquibase.com/tools-integrations/springboot/using-springboot-with-maven.html

https://www.youtube.com/watch?v=lBLXthAO5OM

https://www.youtube.com/watch?v=prLt2LHbA8o

https://github.com/sendelufa/lesson-liquibase-start/tree/result
