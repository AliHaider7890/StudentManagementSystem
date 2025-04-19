# StudentManagementSystem
A production-grade Student Management System built with Spring Boot, showcasing enterprise-level practices including security, role management, pagination, and advanced error handling.
User Authentication & Authorization

Role-based access control (ADMIN / USER) using Spring Security

JWT-based secure login system

Password encryption with BCryptPasswordEncoder

Exception Handling

Global exception handling using @ControllerAdvice

Clean and informative error responses for client-side integration

Input Validations

Field-level validation using Hibernate Validator (JSR-303)

Automatic handling of bad requests with descriptive messages

Relational Mapping & Joins

Entity relationships using @OneToMany, @ManyToOne, @ManyToMany

Data integrity and join handling with JPA and custom queries

DTO and Mapping

Data transfer handled with DTOs

Seamless model-to-DTO and DTO-to-model conversions via ModelMapper

Pagination & Searching 🚀

Pageable API endpoints

Dynamic searching and filtering

Optimized queries for performance with large data sets

Clean Architecture

Layered structure: Controller → Service → Repository

Follows SOLID principles

📂 Tech Stack

Java 17

Spring Boot

Spring Data JPA

Spring Security + JWT

MySQL

Hibernate Validator

ModelMapper

Lombok
