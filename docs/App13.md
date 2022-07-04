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
$ cd app-db
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
// Connect check
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

**database/src/marin/resources/1.00.01.xml**

<br/>

```xml
<?xml version="1.0" encoding="UTF-8"?>
<databaseChangeLog xmlns="http://www.liquibase.org/xml/ns/dbchangelog"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:ext="http://www.liquibase.org/xml/ns/dbchangelog-ext"
	xsi:schemaLocation="http://www.liquibase.org/xml/ns/dbchangelog http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-3.0.xsd
        http://www.liquibase.org/xml/ns/dbchangelog-ext http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-ext.xsd">
	
    <property name="autoIncrement" value="false" dbms="postgresql,mssql,oracle"/>
    <property name="autoIncrement" value="true" dbms="h2"/>

    <changeSet id="1.0.1-createVerificationTable" author="Marley" context="update" runInTransaction="false" objectQuotingStrategy="QUOTE_ONLY_RESERVED_WORDS">
        <preConditions onFail="MARK_RAN">
            <not>
                <tableExists tableName="sms_verification" />
            </not>
        </preConditions>

        <createSequence sequenceName="sms_verification_verificationid_seq" incrementBy="1" startValue="1" />

        <createTable tableName="sms_verification">
            <column name="verificationid" type="NUMERIC(19,0)" autoIncrement="${autoIncrement}" defaultValueSequenceNext="sms_verification_verificationid_seq">
                <constraints primaryKey="true" nullable="false"/>
            </column>
            <column name="processguid" type="VARCHAR(50)">
                <constraints nullable="false"/>
            </column>
            <column name="phonenumber" type="VARCHAR(50)">
                <constraints nullable="false"/>
            </column>
            <column name="secretcode" type="VARCHAR(50)">
                <constraints nullable="false"/>
            </column>
            <column name="status" type="VARCHAR(50)">
                <constraints nullable="false"/>
            </column>
        </createTable>

        <createIndex tableName="sms_verification" indexName="k01_sms_verification" unique="true">
            <column name="processguid"/>
        </createIndex>
        <createIndex tableName="sms_verification" indexName="k02_sms_verification" unique="true">
            <column name="secretcode" />
            <column name="status" />
        </createIndex>

        <comment>Creation of Test table </comment>

    </changeSet>
		
</databaseChangeLog>
```


<br/>

### Подключить к микросервису плагин для генерации кода по модулю DQHakaTutor версии 1.01.00 и сгенерировать код.

<br/>

**service/src/main/pom.xml**

```xml
<executions>
***
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
***
```

<br/>

```
$ cd demo/

$ mvn clean install -Dmaven.test.skip=true
// $ mvn clean install
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

### Пролить данные в базу

```
$ cd database/target
```

<br/>

```
$ unzip demo-db-1.00.01-SNAPSHOT.zip
$ cd demo-db-1.00.01-SNAPSHOT
```

<br/>

```
$ chmod +x ./dm.sh
$ ./dm.sh -d -c -i --url=jdbc:postgresql://postgres:5432 --database=postgresdb --schema=public --username=user1 --password=pA55w0rd123 --admin=admin1 --adminPassword=pA55w0rd123 --driver=org.postgresql.Driver
```


<!-- <br/>

![Application](/img/app013-pic03.png?raw=true) -->


<br/>

```
$ ./dm.sh -u --url=jdbc:postgresql://postgres:5432 --database=postgresdb --schema=public --username=user1 --password=pA55w0rd123 --admin=admin1 --adminPassword=pA55w0rd123 --driver=org.postgresql.Driver
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
  Name  | Owner 
--------+-------
 public | user1
(1 row)
```

<br/>

```
=> SET search_path TO public;
```

<br/>


```
postgresdb=> \dt
               List of relations
 Schema |         Name          | Type  | Owner 
--------+-----------------------+-------+-------
 public | auto_pk_support       | table | user1
 public | databasechangelog     | table | user1
 public | databasechangeloglock | table | user1
 public | rights_policyset      | table | user1
 public | sms_verification      | table | user1
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


<!-- 

```
$ cd service/
$ mvn spring-boot:run -P dev
``` -->

<br/>

### Запуск Тестов


<br/>

```
$ mvn test -Dtest="ru.diasoft.micro.repository.SmsVerificationRepositoryTest#smsVerificationCreateTest" -am -DfailIfNoTests=false
```

<br/>

```
$ mvn test -Dtest="ru.diasoft.micro.service.SmsVerificationServiceTest" -am -DfailIfNoTests=false
```

<br/>

### Запуск Приложения


<br/>

```
$ cd demo/
$ mvn package
// $ mvn package -Dmaven.test.skip=true
$ cd service/target
$ java -jar ./demo-1.00.01-SNAPSHOT.jar
// $ java -jar ./demo-1.00.01-SNAPSHOT.jar -Dspring.profiles.active=dev

```

<br/>

```
http://localhost:7081/swagger-ui/
```

<br/>

```
// POST
$ curl -X POST "http://localhost:7081/v1/sms-verification" -H "accept: */*" -H "Content-Type: application/json" -d "{\"PhoneNumber\":\"5555552\"}"
```

<br/>

```
# SELECT * FROM sms_verification;
```

<br/>

```
// GET
$ curl -X GET "http://localhost:7081/v1/sms-verification" -H "accept: */*" -H "Content-Type: application/json" -d "{\"Code\":\"5584\",\"ProcessGUID\":\"48dc48b4-e5a7-45e8-b13f-41a576418209\"}"
```

<br/>

### Пришлось создавать топики руками

```
$ kafka-topics.sh --zookeeper localhost:2181 --create --partitions 3     --replication-factor 2 --topic dq-mdp-audit-json-events-in

smsVerificationCreatedPublish
smsVerificationDeliveredSubscribe
dq-mdp-versions-object-versions-in
dq-mdp-audit-json-events-in
```

<br/>

???

sms-verification-created



<br/>

```
// Receive a Message
$ kafka-console-consumer.sh \
    --bootstrap-server localhost:9092 \
    --topic sms-verification-created \
    --from-beginning

^C
```


<br/>

```
// Receive a Message
$ kafka-console-consumer.sh \
    --bootstrap-server localhost:9092 \
    --topic sms-verification-delivered \
    --from-beginning

^C
```

<br/>

```
{"guid":"57ab1698-d089-4f71-b15a-0a132e55af97","phoneNumber":"1000","code":"2256"}
{"guid":"3a979430-b81e-4488-bd10-87b9cdd65e12","phoneNumber":"1000","code":"5404"}
{"guid":"31ec18db-c359-44a6-b748-e9a2f313f5e3","phoneNumber":"string","code":"3053"}
{"guid":"7010867a-38f5-4869-8dd3-3fae0d504212","phoneNumber":"5555555","code":"2761"}
```

