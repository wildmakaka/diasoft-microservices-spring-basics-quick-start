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

=============================

<br/>

http://gitflex.diasoft.ru/FinCore/mavensettings/-/blob/master/developer/settings.xml

<br/>

```
$ cd app05-db
$ sudo rm -rf PGDATA/
$ docker-compose up
```


<br/>

```
$ sudo vi /etc/hosts
```

<br/>

```
***
127.0.0.1 postgres
```

<br/>

```
// Connect
$ PGPASSWORD=pA55w0rd123 psql -U user1 -h postgres -p 5432 -d postgres-db
```

<br/>

```
$ java -version
java version "1.8.0_321"
```

<br/>

```
$ mvn -version
Apache Maven 3.6.3
```

<br/>

```
$ mvn -B archetype:generate -DarchetypeGroupId=ru.diasoft.micro -DarchetypeArtifactId=template-archetype -DarchetypeVersion=RELEASE -DgroupId=ru.diasoft.digitalq -DartifactId=demo -Dversion=1.00.01-SNAPSHOT
```


<br/>

```
$ mvn clean install
```

<br/>

Или


<br/>

**Run -> Run Configurations**

<br/>

![Application](/img/app013-pic01.png?raw=true)


<br/>

![Application](/img/app013-pic01.png?raw=true)

<br/>

```
$ cd /home/marley/projects/dev/diasoft/diasoft-microservices-spring-basics/apps/app13/demo/database/target
```

<br/>

```
$ unzip demo-db-1.00.01-SNAPSHOT
$ cd demo-db-1.00.01-SNAPSHOT
```

<br/>

```
$ chmod +x ./dm.sh
$ ./dm.sh -d -c -i --url=jdbc:postgresql://postgres:5432 --database=postgres-db --schema=example --username=user2 --password=pA55w0rd123 --admin=user1 --adminPassword=pA55w0rd123 --driver=org.postgresql.Driver
```


<br/>


```
.:lib/slf4j-api-1.7.25.jar:lib/jtds-1.3.1.jar:lib/slf4j-simple-1.7.29.jar:lib/liquibase-core-4.2.2.jar:lib/demo-db-1.00.01-SNAPSHOT.jar:lib/database-manager-core-9.05.01-21122301.jar:lib/logback-core-1.2.3.jar:lib/ojdbc8-21.4.0.0.1.jar:lib/jconnect-7.0.jar:lib/postgresql-42.3.2.jar:lib/db2jcc-3.53.71.jar:lib/snakeyaml-1.25.jar:lib/orai18n-21.4.0.0.1.jar
found resource bundle in version/version
Apr 28, 2022 11:16:48 AM ru.diasoft.fa.platform.database.DatabaseManager initVersion
INFO: found resource bundle in version/version
resource bundle version 1.00.01-SNAPSHOT
Apr 28, 2022 11:16:48 AM ru.diasoft.fa.platform.database.DatabaseManager initVersion
INFO: resource bundle version 1.00.01-SNAPSHOT
Locale.getDefault(): en_US
Enabled ChangeLog property:
  dbmanager.schema
  mastername
  dbmanager.database
  dbmanager.password
  dbmanager.url
  dbmanager.adminPassword
  dbmanager.admin
  dbmanager.driver
  dbmanager.username
Apr 28, 2022 11:16:49 AM ru.diasoft.fa.platform.database.PostgreSQLDatabaseManager dropDatabase
INFO: Unable to drop schema 'example' in the database 'postgres-db', because schema does not exist
Apr 28, 2022 11:16:49 AM ru.diasoft.fa.platform.database.PostgreSQLDatabaseManager dropDatabase
SEVERE: Erorr in query: do $$ begin if exists (select * from pg_user where usename = 'user2') then revoke all privileges on database postgres-db from user2; end if; end; $$;
Exception in thread "main" org.postgresql.util.PSQLException: ERROR: syntax error at or near "-"
  Position: 118
	at org.postgresql.core.v3.QueryExecutorImpl.receiveErrorResponse(QueryExecutorImpl.java:2675)
	at org.postgresql.core.v3.QueryExecutorImpl.processResults(QueryExecutorImpl.java:2365)
	at org.postgresql.core.v3.QueryExecutorImpl.execute(QueryExecutorImpl.java:355)
	at org.postgresql.jdbc.PgStatement.executeInternal(PgStatement.java:490)
	at org.postgresql.jdbc.PgStatement.execute(PgStatement.java:408)
	at org.postgresql.jdbc.PgStatement.executeWithFlags(PgStatement.java:329)
	at org.postgresql.jdbc.PgStatement.executeCachedSql(PgStatement.java:315)
	at org.postgresql.jdbc.PgStatement.executeWithFlags(PgStatement.java:291)
	at org.postgresql.jdbc.PgStatement.executeUpdate(PgStatement.java:265)
	at ru.diasoft.fa.platform.database.PostgreSQLDatabaseManager.dropDatabase(PostgreSQLDatabaseManager.java:232)
	at ru.diasoft.fa.platform.database.DatabaseManager.main(DatabaseManager.java:636)
```

