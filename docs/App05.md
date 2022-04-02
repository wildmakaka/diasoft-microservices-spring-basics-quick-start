# 05. Создание и обновление структуры базы данных

<br/>

Подключить в микросервис работающий со Spring Data JPA создание структуры БД с помощью liquibase. Скрипты должны создать структуру таблиц в СУБД Postgres.


<br/>

### Подготовка базы


<br/>

```
$ sudo vi /etc/hosts
```

<br/>

```
127.0.0.1 postgres
```

<br/>

```
$ sudo apt install -y postgresql-client-common postgresql-client
```

<br/>

```
$ cd app05-db
$ docker-compose up
```


<br/>

```
// Connect
$ PGPASSWORD=pA55w0rd123 psql -U user1 -h postgres -p 5432 -d postgres-db
```

<br/>

### Запуск приложения

<br/>

```
$ cd apps/app05
```

<br/>

```
$ mvn clean package
$ mvn liquibase:update

// $ mvn liquibase:rollback -Dliquibase.rollbackCount=1
```


<br/>

```
postgres-db-# \dt
               List of relations
 Schema |         Name          | Type  | Owner 
--------+-----------------------+-------+-------
 public | databasechangelog     | table | user1
 public | databasechangeloglock | table | user1
 public | users                 | table | user1
(3 rows)
```

<br/>

```
$ ./mvnw spring-boot:run
```


<br/>

```
// ADD USER
$ curl \
    --data '{
      "name":"Webmakaka1",
      "address":"Moscow1"
      }' \
    --header "Content-Type: application/json" \
    --request POST \
    --url http://localhost:8080/addUser \
    | jq
```

<br/>

```
// Connect
$ PGPASSWORD=pA55w0rd123 psql -U user1 -h postgres -p 5432 -d postgres-db
```

<br/>

```
postgres-db=# select * from users;
  id  |    name    | address 
------+------------+---------
 1000 | Webmakaka1 | Moscow1
(1 row)
```

<br/>

```
postgres-db=# select * from databasechangelog;
postgres-db=# select author, filename, exectype from databasechangelog;
  author   |                  filename                   | exectype 
-----------+---------------------------------------------+----------
 webmakaka | src/main/resources/sql/db.changelog-1.0.sql | EXECUTED
(1 row)
```

<br/>

**Материалы:**

https://www.youtube.com/watch?v=uegLZi7-sGc&list=LL