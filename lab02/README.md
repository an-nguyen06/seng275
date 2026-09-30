# Lab 02: Test-Driven Development (TDD)

## Overview

The objective of this lab is to practice Test-Driven Development (TDD) using the Red-Green-Refactor workflow in Java with JUnit 5.

## Quick summary of what to do:
Part-1:
1. Read over the description of the Rectangle class you’ve been asked to create. Pay
particular attention to what objects of type Rectangle need to do and try to notice
elements of the design that have been left up to you.
2. Use a Test-Driven Development method to first design tests for the Rectangle class (in
RectangleTest.java), then write your code for the class itself (in Rectangle.java).
Continue the TDD cycle until the class and tests are complete.
3. Commit your changes using Git and push the commits to GitLab.
Part-2:
1. Read over the problem statement for AddMyAlphas.
2. Use the TDD approach to complete the requirements for the problem statement.
3. Submit link for the repo on BrightSpace.

## Lab structure
```text
├── src/
│   ├── Rectangle.java         #rectangle object implementation
│   └── AddMyAlphas.java       #string calculator implementation
└── tests/
    ├── RectangleTest.java     #unit tests for Rectangle functionality
    └── AddMyAlphasTest.java   #TDD test cases for AddMyAlphas kata