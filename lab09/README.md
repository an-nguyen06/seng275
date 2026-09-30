# Lab 09: REST API Testing

This lab practices REST API testing with Postman and JSON Server. It covers CRUD requests (`GET`, `POST`, `PUT`, `PATCH`, and `DELETE`) and Postman response tests for status codes and response data.

## Quick Start

Requirements: Node.js with npm and Postman.

From this directory, start the mock API:

```sh
npx json-server courses.json --port 3000
```

Use these endpoints in Postman:

- `http://localhost:3000/students`
- `http://localhost:3000/courses`
- `http://localhost:3000/instructors`

Add automated checks in Postman's Scripts → Post-response tab using `pm.test()`.

## Data Files

- `courses.json`: Mock API data for students, courses, and instructors.
- `students.json`: Separate sample dataset containing students.