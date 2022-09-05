# 07. Тестирование микросервисов

<br/>

Разработать тесты для микросервиса содержащего CRUD REST API и работающего с in memory базой данных h2. Структура h2 должна создаваться с помощью liquibase.


<br/>

## Вариант 1

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

![Application](/img/app07-pic01.gif?raw=true)


<br/>


### Запуск приложения из IDE


<br/>

![Application](/img/app07-pic02.gif?raw=true)



<br/>

```
// Подключиться к базе можно  
http://localhost:8080/h2-console/
```


<br/>

## Вариант 2 (MockMvc)


<br/>

```
$ cd apps/app07/v2
```

<br/>

Из linux консоли не запускается! Из IDE норм. 


<br/>

**UserControllerTests**

![Application](/img/app07-pic03.gif?raw=true)


<br/>

**UserServiceTests**

![Application](/img/app07-pic04.gif?raw=true)


<br/>

**Материалы:**


https://docs.liquibase.com/tools-integrations/springboot/using-springboot-with-maven.html

https://www.youtube.com/watch?v=lBLXthAO5OM

https://www.youtube.com/watch?v=prLt2LHbA8o

https://github.com/sendelufa/lesson-liquibase-start/tree/result


https://habr.com/ru/post/527330/


https://github.com/mscharhag/blog-examples/blob/master/mockmvc-testing/src/test/java/com/mscharhag/mockmvc/ProductControllerTest.java


https://github.com/ramram43210/Java_2021/blob/main/Java_2021/SpringBoot_Junit_Mockito/SpringBootDemo/src/test/java/com/ram/service/impl/UserServiceImplTest.java