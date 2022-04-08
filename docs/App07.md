# 07. Тестирование микросервисов

<br/>

Разработать тесты для микросервиса содержащего CRUD REST API и работающего с in memory базой данных h2. Структура h2 должна создаваться с помощью liquibase.




<br/>

```
$ cd apps/app07
```

<br/>


```
$ ./mvnw spring-boot:run
```

<br/>

// Подключиться к базе
http://localhost:8080/h2-console/


<br/>

![Application](/img/app07-pic01.gif?raw=true)


<br/>

**Материалы:**


https://docs.liquibase.com/tools-integrations/springboot/using-springboot-with-maven.html

https://www.youtube.com/watch?v=lBLXthAO5OM

https://www.youtube.com/watch?v=prLt2LHbA8o

https://github.com/sendelufa/lesson-liquibase-start/tree/result