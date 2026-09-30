# Lab 03: Domain & Specification Testing

## Overview

The primary goal of this lab is to understand and apply Domain Testing (boundary analysis, equivalence partitioning, ON/OFF/IN/OUT points) and Specification Testing (black-box testing based on requirements) using JUnit 5 and parameterized tests.

## Tasks
1. Boundary & Domain Testing: Identify boundary points (ON/OFF) and equivalence classes for conditional logic in `Boundary.java`.
2. Specification Testing & Bug Reporting Test UUTs based purely on specification comments (`Specification.java`), verify against real implementations, and log discovered defects in `tests/bug_report.txt`.
3. Roman Numerals Converter: Implement a robust Roman numeral converter with validation for invalid inputs (e.g., `XXXX`, `ABC`, `VV`, `DD`, lowercase, empty string) along with comprehensive equivalence partition tests.
4. GameBoard (CatchMeIfYouCan Create a $6 \times 6$ matrix game board class with boundary test cases for valid $[0, 5]$ coordinates and out-of-bounds error handling.

## Repository Structure

```text
├── src/
│   ├── Boundary.java          #source methods for domain testing
│   ├── Specification.java     #black-box UUT implementations
│   ├── RomanNumeral.java      #improved Roman numeral converter & validator
│   ├── GameBoard.java         #6x6 GameBoard matrix implementation
│   └── implementation.txt     #reference UUT source code
└── tests/
    ├── BoundaryTest.java      #boundary & domain test suite
    ├── SpecificationTest.java #specification-based test suite
    ├── RomanNumeralTest.java  #equivalence partition tests for Roman Numerals
    ├── GameBoardTest.java     #good/bad weather & boundary tests for GameBoard
    └── bug_report.txt         #formal bug report for Specification UUT