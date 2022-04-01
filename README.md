# Bootcamp-Manager

It's a web application for managing bootcamps.

---

## MySQL local DB configuration

Make changes locally on `application.properties` file (*src/main/resources/application.properties*):

- Create a new database locally called `bootcamp`
- Change port (value instead of `8889`)
- Change username (value instead of `root`)
- Change password (value instead of `root`)

```
spring.datasource.url=jdbc:mysql://localhost:8889/bootcamp
spring.datasource.username=root
spring.datasource.password=root
```

**Please do not push these changes to GIT.**

---

## Spring Boot Security

Spring Boot Security out of the box gives you a Login page with authentification. Authentification can be checked by entering:
- URL to login: `http://localhost:8080/` / `http://localhost:8080/login`
- URL to logout: `http://localhost:8080/logout`
- username: `user`
- password: (after you run Spring Boot Application, password will be generated and printed in the console. Look for code line: `Using generated security password: db70d73b-9b2f-4933-b284-db9bf525ec46`, code will be different each time. Whitelabel Error Page indicates taht authentification was successful.)
