# Lab 01: Getting started

## Overview

Objective: install and configure a few software that will be used throughout the labs
and ensure that everything's ready for the weeks to come; get some practice writing
some basic tests. 

## Quick summary of what to do:
1. Install Java, IntelliJ IDEA Ultimate and Git on your system if they are not already there.
2. Clone your lab01 repository from https://gitlab.csc.uvic.ca, and open it in IntelliJ.
3. Write some basic unit tests using the JUnit testing framework.

The lab includes unit tests written for the utility method `ArrayUtils.isSorted()`, which checks whether a given array of integers is sorted in ascending order.

## Lab Structure

```text
├── src/
│   └── Main.java
│   └── ArrayUtils.java         #contains static utility method isSorted()
└── test/
    └── ArrayUtilsTest.java     #unit tests verifying ArrayUtils using JUnit 5