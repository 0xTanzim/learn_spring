## 📚 Java Spring Boot Learning Repository

Welcome to my **Spring Boot Learning Repository**!
This repository is a structured knowledge base where I document and consolidate everything I’m learning about **Spring
Boot and its surrounding ecosystem**.

This includes:

* ✅ Practical implementations
* 📄 Real-world use cases
* 📚 References to official docs and tutorials
* 🎯 Enterprise backend development principles

Whether you're revisiting core Spring concepts or diving deep into advanced topics like security, data access, and
architecture, this repo is continuously evolving as I grow toward mastering backend systems and software architecture.

---

## ✅ Learning Checklist

This checklist represents what I’ve actively studied, implemented, and documented so far:

### 🌿 Core Spring Boot Concepts

* [x] **Spring Boot Fundamentals** – Auto-configuration, `@SpringBootApplication`, starter dependencies
* [x] **Spring AOP** – Cross-cutting concerns via `@Aspect`
* [x] **JDBC** – Manual DB access using `JdbcTemplate`
* [x] **Spring Data JPA** – Repositories, entity relationships, paging & sorting
* [x] **Custom Queries** – JPQL, Criteria API, Named and Native Queries
* [x] **Spring Data JPA Auditing** – Auto-managed timestamps and users

### 🔐 Security & Validation

* [x] **Spring Security** – AuthN, AuthZ, CSRF, form login, remember-me
* [x] **Password Hashing** – Secure storage using BCrypt
* [x] **Input Validation** – `@Valid`, Bean Validation (Hibernate), and custom validators
* [x] **Custom Constraint Annotation** – Reusable field-level validation

### 🛠 Configuration & Error Handling

* [x] **@ConfigurationProperties** – Externalized typed config
* [x] **Exception Handling** – Global error handling with `@ControllerAdvice`
* [x] **Spring Profiles** – Environment-specific config (`dev`, `prod`, `test`)

### 🧩 Presentation & UI

* [x] **Thymeleaf** – Server-side rendering with Spring MVC
* [x] **CSRF Protection** – Configuring CSRF tokens in forms
* [x] **Form Binding & Validation** – Binding POJOs to form inputs

### 🧪 Domain Features Implemented

* [x] **Classroom CRUD** – Domain-driven design for classrooms
* [x] **Student Management** – Add/update/delete student records

### 🌐 REST & Hypermedia APIs

* [x] **Building REST APIs** – With `@RestController`, DTOs, and HATEOAS
* [x] **HAL Explorer Integration**
* [x] **`@RepositoryRestResource(exported = false)`** – Hide REST endpoints

---

## 🔗 Learning Resources & Documentation

### 🔐 Spring Security

* [Spring Security + Thymeleaf](https://www.thymeleaf.org/doc/articles/springsecurity.html)
* [Spring Security 7 Migration Guide](https://docs.spring.io/spring-security/reference/migration-7/configuration.html)
* [Custom Authentication Provider – Baeldung](https://www.baeldung.com/spring-security-authentication-provider)
* [Method-Level Security – Baeldung](https://www.baeldung.com/spring-security-method-security)

---

### 🧾 Validation

* [Form Validation – Spring Guide](https://spring.io/guides/gs/validating-form-input)
* [Hibernate Validator (JSR 380)](https://hibernate.org/validator/)
* [Custom Validator – Baeldung](https://www.baeldung.com/spring-mvc-custom-validator)
* [Custom Validation – Medium](https://medium.com/@bereketberhe27/spring-boot-custom-validation-7af89a64f805)

---

### 🧩 Spring Data JPA

* [Spring Data JPA Official Docs](https://spring.io/projects/spring-data-jpa)
* [JPA Query Methods](https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html)
* [JPQL & Native Queries – Baeldung](https://www.baeldung.com/spring-data-jpa-query)
* [Named Queries – Medium](https://medium.com/@arslan.ahmed.shaikh/custom-named-queries-in-spring-data-jpa-a-practical-guide-91bc7270512d)
* [Pagination & Sorting](https://www.baeldung.com/spring-data-jpa-pagination-sorting)

---

### 🕵️ Auditing

* [Spring Data Auditing Docs](https://docs.spring.io/spring-data/jpa/reference/auditing.html)

---

### 📡 Calling REST Services

* [Spring Cloud OpenFeign Docs](https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/)
* [Feign Client – Spring.io](https://spring.io/projects/spring-cloud-openfeign)
* [Baeldung Feign Guide](https://www.baeldung.com/spring-cloud-openfeign)

---

### 📦 Spring Boot Starter Data REST

The `spring-boot-starter-data-rest` auto-exposes repository-based REST APIs. It uses Spring MVC + HATEOAS to provide
HAL-compliant endpoints.

* [Spring Data REST Overview](https://spring.io/projects/spring-data-rest)
* [HAL Explorer UI](https://github.com/toedter/hal-explorer)
* [Disable Endpoint Exposure](https://docs.spring.io/spring-data/rest/docs/current/reference/html/#projections-excerpts)

---

## 🧪 Testing & Profiles

### 🔍 Testing

### 🧬 Profiles & Configuration

* [ ] `application-dev.yml`, `application-prod.yml`
* [ ] Logging with `logback-spring.xml` per profile
* [ ] Conditional Beans with `@Profile`

## 🧠 Future Topics to Learn

* [ ] Spring WebFlux (Reactive)
* [ ] Spring Batch
* [ ] Kafka with Spring Boot
* [ ] Redis Caching
* [ ] Integration with PostgreSQL/MySQL in containers
* [ ] Using Flyway or Liquibase for DB migrations
* [ ] OpenAPI/Swagger documentation
