# Demo Spring Boot + Kotlin

Just a demo to check out whether Spring Boot + Kotlin can serve as a main programming framework.

## Showcases

- Dependency Injection
- Mapping of data (Json) to program code
- Testcontainers for simple testing
- Database access / querying and mapping
- Migrations
- ...

## Developing

The best IDE is of course Intellij IDEA (says Claudemiro), but any IDE will do. VcCode also is pretty nice.

### How to run tests


```
$ ./gradlew test
2024-07-23T08:36:52.424+02:00  INFO 3603 --- [SpaceshelfDemo] [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2024-07-23T08:36:52.425+02:00  INFO 3603 --- [SpaceshelfDemo] [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
2024-07-23T08:36:52.575+02:00  INFO 3603 --- [SpaceshelfDemo] [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-2 - Shutdown initiated...
2024-07-23T08:36:52.619+02:00  INFO 3603 --- [SpaceshelfDemo] [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-2 - Shutdown completed.

BUILD SUCCESSFUL in 5s
5 actionable tasks: 2 executed, 3 up-to-date

```

### How to start development

```
$ docker compose up     ## to start postgres
$ ./gradlew bootRun     ## to start spring boot
```


Then run a curl command:
```
$ curl -X POST --location "http://localhost:8080/webhooks/on-create-order" \
    -H "Content-Type: application/json" \
    -d '{
          "id": 820982911946154508,
          "admin_graphql_api_id": "gid://shopify/Order/820982911946154508"
        }'
```

or if you are using Intellij IDEA

open the file src/main/resources/test.http an dthe click on the play button.


Important: Spring Boot reloads automatically when you make changes in the code.
So the dev-experience is instant!


