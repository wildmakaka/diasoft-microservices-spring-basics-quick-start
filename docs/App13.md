# 13. Итоговое задание

<br/>

**Проектная работа:**

1. Создать новый микросервис "demo" с помощью Maven-архетипа.

2. Подключить к микросервису плагин для генерации кода по модулю DQHakaTutor версии 1.01.00 и сгенерировать код.

3. Реализовать методы GET v1/sms-verification и POST/sms-verification.

4. Написать Unit-тесты на функционал.

5. Создать микросервис ServiceDiscovery, используя spring-cloud-starter-netflix-eureka-server.

6. Создать микросервис API Gateway, используя spring-cloud-starter-gateway.

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
$ PGPASSWORD=pA55w0rd123 psql -U admin1 -h postgres -p 5432 -d postgresdb
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
$ cd demo/

$ mvn clean install
// $ mvn clean install -Dmaven.test.skip=true
```

<!--

<br/>

Или


<br/>

**Run -> Run Configurations**

<br/>

![Application](/img/app013-pic01.png?raw=true)


<br/>

![Application](/img/app013-pic01.png?raw=true)

-->

<br/>

```
$ cd database/target
```

<br/>

```
$ unzip demo-db-1.00.01-SNAPSHOT
$ cd demo-db-1.00.01-SNAPSHOT
```

<br/>

```
$ chmod +x ./dm.sh
$ ./dm.sh -d -c -i --url=jdbc:postgresql://postgres:5432 --database=postgresdb --schema=example --username=user1 --password=pA55w0rd123 --admin=admin1 --adminPassword=pA55w0rd123 --driver=org.postgresql.Driver
```


<!-- <br/>

![Application](/img/app013-pic03.png?raw=true) -->


<br/>

```
$ ./dm.sh -u --url=jdbc:postgresql://postgres:5432 --database=postgresdb --schema=example --username=user1 --password=pA55w0rd123 --admin=admin1 --adminPassword=pA55w0rd123 --driver=org.postgresql.Driver
```


<!-- <br/>

![Application](/img/app013-pic04.png?raw=true) -->

<br/>

```
$ PGPASSWORD=pA55w0rd123 psql -U user1 -h postgres -p 5432 -d postgresdb
```

<br/>

```
postgresdb=> \dn
 List of schemas
  Name   | Owner  
---------+--------
 example | user1
 public  | admin1

```

<br/>

```
=> SET search_path TO example;
```

<br/>


```
postgresdb=> \dt
                List of relations
 Schema  |         Name          | Type  | Owner 
---------+-----------------------+-------+-------
 example | auto_pk_support       | table | user1
 example | databasechangelog     | table | user1
 example | databasechangeloglock | table | user1
 example | rights_policyset      | table | user1
 example | sms_verification      | table | user1
(5 rows)
```


<br/>

```
postgresdb=> SELECT filename, exectype FROM databasechangelog;
          filename           | exectype 
-----------------------------+----------
 permission/permission.1.xml | EXECUTED
 mdpid/0.0.0.xml             | EXECUTED
 mdpid/0.0.0.xml             | EXECUTED
 1.00.01/1.00.01.xml         | EXECUTED
(4 rows)
```

<br/>

### Подключить к микросервису плагин для генерации кода по модулю DQHakaTutor версии 1.01.00 и сгенерировать код.

```xml
<executions>
    <execution>
        <id>Generate REST Controller by Q.Archer</id>
        <!-- DQCodeGen+Q.Archer https://conf.diasoft.ru/pages/viewpage.action?pageId=121474970 -->
        <goals>
            <goal>qarcher</goal>
        </goals>
        <configuration>
            <skip>false</skip>
            <qarcherService>http://dsagregator2:8030</qarcherService>
            <targetPackage>ru.diasoft.digitalq</targetPackage>
            <qarcherModuleName>DQ Hackathon Tutorial</qarcherModuleName>
            <!--    -->
            <qarcherVersion>1.01.00</qarcherVersion>
            <!--    -->
            <restApi>${dqcodegen.rest.api}</restApi>
            <restModuleSplit>true</restModuleSplit>
            <useZonedDateTime>true</useZonedDateTime>
            <useReactiveApi>false</useReactiveApi>
            <useJsonNodeType>true</useJsonNodeType>
            <useResponseDTO>true</useResponseDTO>
            <generateCrud>true</generateCrud>
            <crudAudit>true</crudAudit>
        </configuration>
    </execution>
```

<br/>


```
$ mvn clean install -Dmaven.test.skip=true
```


<br/>



<br/>

### Запуск


<br/>

```
$ mvn clean install -Dmaven.test.skip=true -P dev
```

<br/>

```
localhost:7081/swagger-ui.html
```

POST

GET

Вводим processGuid и еще что-то из базы