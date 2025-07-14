# 📚 Spring Boot Learning Repository

Welcome to my **Spring Boot Learning Repository**!  
This is a structured and evolving documentation hub where I consolidate everything I’m learning about **Spring Boot**
and its surrounding ecosystem — from foundational concepts to enterprise-grade features.

Whether you're just getting started or looking to deepen your Spring expertise, this repository includes:

✅ Practical Implementations  
📄 Real-World Use Cases  
🔗 Official References & Guides  
🎯 Backend Architecture Best Practices

> 🧑‍💻 I'm building this to eventually master Spring Boot and become a backend software architect.

---

## ✅ Learning Progress Checklist

> ℹ️ This list is **driven by real learning** — I only check topics off **after I understand and implement them**, with
> references from the "Learning Resources" section.

> ℹ️ This list is **driven by real learning** — I only check topics off **after I understand and implement them**, with
> references from the "Learning Resources" section.

Below is my personal study tracker showing what I’ve already implemented and documented. More topics will be added as I
progress.

---

### 🌱 Core Spring Boot Concepts

- [x] **Spring Boot Fundamentals** – Auto-config, `@SpringBootApplication`, starter dependencies
- [x] **Spring AOP** – Aspect-oriented programming with `@Aspect`
- [x] **JDBC with JdbcTemplate** – Direct database access
- [x] **Spring Data JPA** – Repository pattern, relationships, pagination, and sorting
- [x] **JPQL & Native Queries** – Custom queries via JPQL, Criteria API, Named queries
- [x] **Auditing in JPA** – Auto-managed timestamps with `@CreatedDate`, `@LastModifiedDate`

---

### 🔐 Security & Validation

- [x] **Spring Security Basics** – AuthN/AuthZ, form login, CSRF, session management
- [x] **BCrypt Password Encoding**
- [x] **Input Validation** – `@Valid`, Hibernate Validator, and custom validators
- [x] **Custom Constraint Annotations** – Reusable field-level validation logic

---

### ⚙️ Configuration & Environment Handling

- [x] **@ConfigurationProperties** – Strongly typed config properties
- [x] **Global Exception Handling** – Using `@ControllerAdvice`
- [x] **Spring Profiles** – Multi-environment setup (`dev`, `prod`, etc.)

---

### 🧹 Server-Side UI & Forms

- [x] **Thymeleaf Integration** – With Spring MVC
- [x] **CSRF Token Configuration**
- [x] **Form Data Binding & Validation** – Clean binding of form fields to DTOs

---

### 📚 Domain Layer Implementation

- [x] **Classroom CRUD** – Domain-driven design example
- [x] **Student Management System** – Add, update, delete operations

---

### 🌐 RESTful API & Hypermedia

- [x] **REST API Development** – With `@RestController`, DTOs, and service layers
- [x] **HATEOAS + HAL Explorer**
- [x] **Data REST Customization** – Using `@RepositoryRestResource(exported = false)`

- [x] **REST API Development** – With `@RestController`, DTOs, and service layers
- [x] **HATEOAS + HAL Explorer**
- [x] **Data REST Customization** – Using `@RepositoryRestResource(exported = false)`

---

### 🧪 Observability & Monitoring

- [x] **Spring Boot Actuator** – Health checks and metrics
- [x] **Spring Boot Admin** – Real-time monitoring

---

### ☁️ Cloud Deployment (AWS)

- [x] **AWS Elastic Beanstalk** – Deployment and scaling Spring Boot apps
- [x] **AWS RDS Integration** – Connecting Spring Boot with managed relational databases
  – Health checks and metrics
- [x] **Spring Boot Admin** – Real-time monitoring

## 📦 Project Commands

```bash
# Build the project without running tests
mvn clean install -Dmaven.test.skip=true

# Run with a specific Spring profile
mvn spring-boot:run -Dspring-boot.run.profiles=prod
```

---

## 🔗 Learning Resources (With Clear Purpose)

A collection of **official documentation, guides, and tutorials** I've used while learning each section. Every resource
below is chosen for its **clarity, depth, and direct relation** to the respective Spring Boot feature.

### 🔐 Spring Security

For implementing login/authentication, protecting routes, CSRF, and password handling:

- [Thymeleaf + Spring Security](https://www.thymeleaf.org/doc/articles/springsecurity.html)
- [Spring Security 7 Migration Guide](https://docs.spring.io/spring-security/reference/migration-7/configuration.html)
- [Custom Authentication Provider – Baeldung](https://www.baeldung.com/spring-security-authentication-provider)
- [Method-Level Security – Baeldung](https://www.baeldung.com/spring-security-method-security)

### 📏 Validation

For validating form inputs, building reusable validators, and applying field-level constraints:

- [Spring Form Validation Guide](https://spring.io/guides/gs/validating-form-input)
- [Hibernate Validator (JSR 380)](https://hibernate.org/validator/)
- [Custom Validation – Baeldung](https://www.baeldung.com/spring-mvc-custom-validator)
- [Custom Field Validation – Medium](https://medium.com/@bereketberhe27/spring-boot-custom-validation-7af89a64f805)

### 🧹 Spring Data JPA

To learn how to persist entities, create query methods, and customize database access:

- [Spring Data JPA Docs](https://spring.io/projects/spring-data-jpa)
- [JPA Query Methods Reference](https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html)
- [JPQL & Native Queries – Baeldung](https://www.baeldung.com/spring-data-jpa-query)
- [Named Queries – Medium](https://medium.com/@arslan.ahmed.shaikh/custom-named-queries-in-spring-data-jpa-a-practical-guide-91bc7270512d)
- [Pagination & Sorting](https://www.baeldung.com/spring-data-jpa-pagination-sorting)

### 🔍 Auditing

To enable auto-logging of created/updated timestamps and users:

- [Spring Data JPA Auditing Docs](https://docs.spring.io/spring-data/jpa/reference/auditing.html)

### ☁️ REST Clients & Service Integration

For calling external REST APIs from Spring Boot using Feign clients:

- [OpenFeign – Official Docs](https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/)
- [Feign Client – Spring.io](https://spring.io/projects/spring-cloud-openfeign)
- [Baeldung Feign Client Guide](https://www.baeldung.com/spring-cloud-openfeign)

### 🔗 Spring Boot Actuator

To monitor and expose application health, metrics, and environment:

- [Spring Boot Actuator Docs](https://docs.spring.io/spring-boot/reference/actuator/enabling.html)
- [Actuator Guide – Baeldung](https://www.baeldung.com/spring-boot-actuators)
- [Spring Actuator Starter Guide](https://spring.io/guides/gs/actuator-service)

### 🎛 Spring Boot Admin

For real-time monitoring dashboards of Spring Boot applications:

- [Spring Boot Admin (GitHub)](https://github.com/codecentric/spring-boot-admin)

### ☁️ AWS Deployment & IAM

To manage instance profiles when deploying to AWS Elastic Beanstalk:

- [Managing Elastic Beanstalk IAM Profiles](https://docs.aws.amazon.com/elasticbeanstalk/latest/dg/iam-instanceprofile.html)

---

> Made with ❤️ by a self-taught backend developer on a journey toward becoming a software architect.
