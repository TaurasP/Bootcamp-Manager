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

- [UML Use Case Diagram](https://drive.google.com/file/d/1-VAKYnnf2r4ChuVijbJe0vcClGy9ODPb/view?usp=sharing)

---

## DB diagram

- [DB diagram](https://drive.google.com/file/d/18E37xIysjoBIvGrfJKQ801s0y7cp6FmL/view?usp=sharing)

---

## UI prototypes

- [ADMIN prototype](https://drive.google.com/file/d/1Mi_P7OgGSE3V6lX_2NQPicCDrWw6TcpW/view?usp=sharing)
- [LECTURER prototype](https://drive.google.com/file/d/1xjy97FvxPdrtMqnnl4R5LCsx5DyZ7ssm/view?usp=sharing)
- [STUDENT prototype](https://drive.google.com/file/d/1YKynQzmpWRdqqeSpiTVIGRs8J2LTV_CF/view?usp=sharing)

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

> If `application.properties` file is not excluded - run command `git rm --cached -r src/main/resources/application.properties` on terminal (could be done from Intellij IDEA's terminal)
> 
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


