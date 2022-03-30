# 03. Создание веб-приложений на Spring Framework

<br/>

Разработать микросервис c RestController'ом содержащим методы обрабатывающие HTTP GET, POST, PUT, DELETE запросы.

<br/>

```
$ cd apps/app03
```

<br/>

```
$ ./mvnw spring-boot:run
```


<br/>

```
// GET ALL
$ curl \
    --header "Content-Type: application/json" \
    --request GET \
    --url http://localhost:8080/apples \
    | jq
```

<br/>

**returns:**

```
[
  {
    "id": "1",
    "text": "First apple"
  },
  {
    "id": "2",
    "text": "Second apple"
  },
  {
    "id": "3",
    "text": "Third apple"
  }
]
```


<br/>

```
// GET BY ID
$ curl \
    --header "Content-Type: application/json" \
    --request GET \
    --url http://localhost:8080/apples/2 \
    | jq
```


<br/>

**returns:**

```
{
  "id": "2",
  "text": "Second apple"
}
```

<br/>

```
// ADD Single
$ curl \
    --data '{
      "text":"Fourth apple"
      }' \
    --header "Content-Type: application/json" \
    --request POST \
    --url http://localhost:8080/apples \
    | jq
```


<br/>

**returns:**

```
{
  "text": "Fourth apple",
  "id": "4"
}
```


<br/>

```
// UPDATE Single
$ curl \
    --data '{
      "text":"Fifth apple"
      }' \
    --header "Content-Type: application/json" \
    --request PUT \
    --url http://localhost:8080/apples/2 \
    | jq
```


<br/>

**returns:**

```
{
  "id": "2",
  "text": "Fifth apple"
}
```


<br/>

```
// DELETE Single
$ curl \
    --header "Content-Type: application/json" \
    --request DELETE \
    --url http://localhost:8080/apples/1 \
    | jq
```


<br/>

**returns:**

```
Nothing
```

<br/>

```
// GET ALL
```

<br/>

**returns:**

```
[
  {
    "id": "2",
    "text": "Fifth apple"
  },
  {
    "id": "3",
    "text": "Third apple"
  },
  {
    "text": "Fourth apple",
    "id": "4"
  }
]
```