# 04. Работа с базой данных

<br/>

Разработать микросервис содержащий CRUD REST API и работающий с in memory базой данных h2. Работа с репозиторием должна осуществляться из сервиса (специализированного класса с аннотацией @Service). В контроллере не должно быть dependency injection репозитория.


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
// ADD USERS
$ curl \
    --data '
      [
          {
          "name":"Webmakaka2",
          "address":"Moscow2"
        },{
          "name":"Webmakaka3",
          "address":"Moscow3"
        }
      ]' \
    --header "Content-Type: application/json" \
    --request POST \
    --url http://localhost:8080/addUsers \
    | jq
```

<br/>

```
// GET ALL
$ curl \
    --header "Content-Type: application/json" \
    --request GET \
    --url http://localhost:8080/users \
    | jq
```

<br/>

**Returns:**

<br/>

```
[
  {
    "id": 1,
    "name": "Webmakaka1",
    "address": "Moscow1"
  },
  {
    "id": 2,
    "name": "Webmakaka2",
    "address": "Moscow2"
  },
  {
    "id": 3,
    "name": "Webmakaka3",
    "address": "Moscow3"
  }
]
```


<br/>

```
// GET BY ID
$ curl \
    --header "Content-Type: application/json" \
    --request GET \
    --url http://localhost:8080/user/2 \
    | jq
```

<br/>

**Returns:**

<br/>

```
{
  "id": 2,
  "name": "Webmakaka2",
  "address": "Moscow2"
}
```

<br/>

```
// UPDATE USER
$ curl \
    --data '
        {
          "id": 1,
          "name":"Webmakaka4",
          "address":"Moscow4"
        }' \
    --header "Content-Type: application/json" \
    --request PUT \
    --url http://localhost:8080/updateUser \
    | jq
```

<br/>

```
// DELETE USER
$ curl \
    --header "Content-Type: application/json" \
    --request DELETE \
    --url http://localhost:8080/user/3
```


<br/>

```
// GET ALL
$ curl \
    --header "Content-Type: application/json" \
    --request GET \
    --url http://localhost:8080/users \
    | jq
```

<br/>

**Returns:**

<br/>

```
[
  {
    "id": 1,
    "name": "Webmakaka4",
    "address": "Moscow4"
  },
  {
    "id": 2,
    "name": "Webmakaka2",
    "address": "Moscow2"
  }
]
```