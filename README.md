# Bootcamp-Manager

It's a web application for managing bootcamps.

---

## Stack

- Java 11
- Maven
- Spring Boot Web
- Spring Boot Data JPA
- Spring Boot Security
- Spring Boot Dev Tools
- MySQL
- Thymeleaf
- Bootstrap
- JUnit
- Log4j
- Lombok
- jQuery
- JS
- CSS
- HTML

---

## UML use case diagram

- [UML Use Case Diagram](https://drive.google.com/file/d/1eRUpW3hdi2KLrTivJaAsVuUPQJUQfOD-/view?usp=sharing)

---

## DB diagram

- [DB diagram](https://drive.google.com/file/d/1T20BFAoDww8ZI9-7hZ4Ugren5qwBBcWn/view?usp=sharing)

---

## UI prototypes

- [ADMIN prototype](https://drive.google.com/file/d/1d2NyOrZ2WMDcww2ioYTxg_9lY8-HGfIw/view?usp=sharing)
- [LECTURER prototype](https://drive.google.com/file/d/1Y0YNEjnWQB8fD4N7Thf8SiOwKnxWXqeO/view?usp=sharing)
- [STUDENT prototype](https://drive.google.com/file/d/1lPl_bx7ggvmbotvgcN-p42WIf-ktes3d/view?usp=sharing)

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

> Please do not push these changes to GIT
> 
> `aplication.properties` file added to `.gitignore` file 

---

## Testing authentication

- Add `admin`, `lecturer` or `student` data to DB

> `enabled` field: 
> 
> `1` - user will have access to the system
> 
> `0` - user will not have access to the system

> `roles` field: 
> 
> `ROLE_ADMIN` - user will be able to login with admin rights
> 
> `ROLE_LECTURER` - user will be able to login with lecturer rights
> > 
> `ROLE_STUDENT` - ser will be able to login with student rights

- Go to `http://localhost:8080/login` or `http://localhost:8080/`
- Enter `email` and `password`

> `is_trainer` field for lecturers table: 
> 
> `0` or `1` - field should not be null (no logic implemented yet for setting this value)

---

## Spring Boot DevTools

Please make 2 changes in Intellij IDEA Preferences to make Spring Boot DevTools working:
- `Preferences/Build, Execution, Deployment/Compiler/Build Project automatically`(tick this checkbox)
- `Preferences/Advanced Settings/Allow auto-make to start even if developed application is currently running` (tick this checkbox under Compiler separator)

---

~~## Spring Boot Security~~

~~Spring Boot Security out of the box gives you a Login page with authentification. Authentification can be checked by entering:~~
~~- URL to login: `http://localhost:8080/` / `http://localhost:8080/login`~~
~~- URL to logout: `http://localhost:8080/logout`~~
~~- username: `user`~~
~~- password: (after you run Spring Boot Application, password will be generated and printed in the console. Look for code line: `Using generated security password: db70d73b-9b2f-4933-b284-db9bf525ec46`, password will be different each time. Whitelabel Error Page indicates that authentification was successful.)~~

---

