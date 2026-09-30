# Lab 04: Coverage & Mutation Testing

## Overview

Objective: evaluate and improve test suite thoroughness using advanced testing metrics, specifically Line Coverage, Branch Coverage (including MC/DC principles), and Mutation Testing with PITest

## Tasks
1. Line & Branch Coverage: Implement test suites for `ArrayUtils`, `CollectionUtils`, `Splitting`, and `WordUtilities` to achieve 100% line and branch coverage in IntelliJ.
2. Tracing & Condition Analysis: Enable branch coverage tracing to verify all conditional paths and short-circuit evaluations.
3. Mutation Testing (PITest): Run PITest mutation analysis, kill surviving mutants, and improve test quality to catch code modifications.

## Requirements & Environment

* Mutation Testing Plugin: PITest (`pitest-junit5-plugin:1.2.1`)
* IDE: IntelliJ IDEA (with Run with Coverage enabled)

## Lab Structure

```text
├── src/
│   ├── ArrayUtils.java         #utility methods (indexOf, etc.)
│   ├── CollectionUtils.java    #collection helper methods
│   ├── Splitting.java          #array/Collection splitting logic
│   └── WordUtilities.java      #string and word processing utilities
└── test/
    ├── ArrayUtilsTest.java     #unit tests for ArrayUtils
    ├── CollectionUtilsTest.java#unit tests for CollectionUtils
    ├── SplittingTest.java      #unit tests for Splitting
    └── WordUtilitiesTest.java  #unit tests for WordUtilities