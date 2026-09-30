# Lab 07: Design by Contract & Property-Based Testing

## Overview

The pimary goal of this lab: explore two advanced software quality assurance techniques:
1. Design by Contract: Enforcing preconditions, postconditions, and class invariants directly in code.
2. Property-Based Testing: Generating large volumes of randomized inputs across input domains using Jqwik.

## Tasks
1. Design by Contract (`BankAccount.java`): Implement robust contract checks using public method preconditions (exceptions), internal postconditions (`assert`), and class state invariants (`invariant()`).
2. Property Testing (`ColoursTest.java`): Write property-based tests for `Colours.rgbBytesToInt()` to verify RGB byte-packing across generated integer inputs.
3. Property Testing (`LeapYearTest.java`): Generate constrained integer ranges using `@Provide` and custom `Arbitrary` filters (e.g., multiples of 400, 100, 4) to test leap year logic.
4. Property Testing (`PalindromeTest.java`): Test `Palindrome.isPalindrome()` using constrained string/character generators (`@AlphaChars`, `@UniqueElements`, `@Size`).

## Requirements & Environment

* Testing Frameworks: JUnit 5 & Jqwik (`net.jqwik:jqwik:1.8.+`)
* Assertion Library: AssertJ (`org.assertj.core.api.Assertions`)

## Lab Structure

```text
├── src/
│   ├── BankAccount.java       #bank account implementation with DbC assertions/invariants
│   ├── Colours.java           #RGB color packing utility
│   ├── LeapYear.java          #leap year evaluation utility
│   └── Palindrome.java        #palindrome verification utility
└── test/
    ├── BankAccountTest.java   #unit tests for contract violation checks
    ├── ColoursTest.java       #Jqwik property tests for color conversion
    ├── LeapYearTest.java      #Jqwik property tests for leap year rules
    └── PalindromeTest.java    #Jqwik property tests for palindrome logic