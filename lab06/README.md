# Lab 06: Mocking & Test Doubles with Mockito

## Overview

The goal of this lab is to test classes in isolation by replacing external dependencies with Test Doubles (Dummies, Stubs, Mocks, and Spies) using Mockito and fluent assertions with AssertJ.

## Tasks
1. Invoice Filter (`InvoiceFilterTest.java`): Isolate `InvoiceFilter` from `IssuedInvoices` using Mockito test doubles. Stub methods (`when(...).thenReturn(...)`) to simulate low-value invoice filtering and verify interaction expectations (`verify(...)`, `verifyNoMoreInteractions(...)`).
2. Todo Application (`TodoApplicationTest.java`): Test `TodoApplication` in isolation by mocking its dependent service objects. Verify methods like `addTodo`, `retrieveTodos`, and `completeAllTodos` using argument matchers and interaction verification.

## Requirements & Environment

* **Mocking Framework:** Mockito (`mockito-core`, `mockito-junit-jupiter`)
* **Assertion Library:** AssertJ (`org.assertj.core.api.Assertions`)


## Lab Structure

```text
├── src/
│   ├── Invoice.java           # Invoice data model
│   ├── InvoiceFilter.java     # Class under test (filters low-value invoices)
│   ├── IssuedInvoices.java    # Dependency interface for invoice retrieval
│   ├── Person.java            # User entity for TODO app
│   ├── Todo.java              # TODO item data model
│   ├── TodoService.java       # Dependency interface for managing TODOs
│   └── TodoApplication.java   # Class under test (multi-user TODO manager)
└── test/
    ├── InvoiceFilterTest.java # Unit tests for InvoiceFilter using Mockito
    └── TodoApplicationTest.java# Unit tests for TodoApplication using Mockito