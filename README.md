# Bootcamp-Manager

It's a web application for managing bootcamps.

---

## MySQL local DB configuration

Make changes locally on `application.properties` file (*src/main/resources/application.properties*):

- Change port (value instead of `8889`)
- Change username (value instead of `root`)
- Change password (value instead of `root`)

```
spring.datasource.url=jdbc:mysql://localhost:8889/bootcamp
spring.datasource.username=root
spring.datasource.password=root
```

**Please do not push these changes to GIT.**
