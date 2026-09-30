# Lab 10: Integration & Database Testing

## Overview

The goal of this lab: practice Integration Testing by testing the interface between Java application logic and persistent database storage. Instead of deploying a full disk-based production database, tests are executed against a lightweight H2 in-memory database managed by Spring Boot.

## Tasks
1. CRUD Operations Testing (`DatabaseTest.java`):
   * `createTest()`: Verify entity creation via `StudentRepository.save()`.
   * `findByLastNameTest()`: Test custom repository query methods with multiple records.
   * `deleteTest()`: Validate entity removal and verify deletion in the database.
   * `updateTest()`: Ensure state modification (e.g., updating `activeStatus` from `1` to `0`) persists correctly.
2. Custom SQL Queries & Sorting:
   * `findAllActiveStudentsTest()`: Test custom `@Query` annotations filtering active students (`activeStatus = 1`).
   * `sortedFirstNamesTest()`: Implement a custom `@Query` using SQL `ORDER BY` to retrieve students sorted by first name.

## Requirements & Environment

* Framework: Spring Boot (`@Autowired`, `@DataJpaTest`)
* Database: H2 In-Memory Database
* Build Tool: Gradle

## Lab Structure

```text
├── src/
│   ├── main/java/.../data/
│   │   ├── Student.java           #student entity model with @Id generation
│   │   └── StudentRepository.java #jpa repository interface & custom @Query definitions
│   └── test/java/.../
│       └── DatabaseTest.java      #integration test suite for H2 database operations
└── build.gradle                   #gradle dependencies and configuration