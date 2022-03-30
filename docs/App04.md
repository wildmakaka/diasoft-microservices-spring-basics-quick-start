# 04. Работа с базой данных

<br/>

Разработать микросервис содержащий CRUD REST API и работающий с in memory базой данных h2. Работа с репозиторием должна осуществляться из сервиса (специализированного класса с аннотацией @Service). В контроллере не должно быть dependency injection репозитория.

<br/>

### Запуск h2

<br/>

http://h2database.com/html/main.html

<br/>

```
$ cd ~/tmp
$ wget https://github.com/h2database/h2database/releases/download/version-2.1.210/h2-2022-01-17.zip
$ unzip h2-2022-01-17.zip
$ cd h2/bin/
$ chmod +x ./h2.sh
$ ./h2.sh
```

<br/>

**Connect**

<br/>

http://127.0.1.1:8082/


<br/>

### Запуск приложения

<br/>

```
$ cd apps/app04
```

<br/>

```
$ ./mvnw spring-boot:run
```







<br/>

https://github.com/techbulletinprime/spring-boot-crud-jpa-h2