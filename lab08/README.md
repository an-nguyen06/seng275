# Lab 08: Exploratory, Manual, and Scripted Testing

## Overview

Goal: practice non-automated testing techniques on an ATM Simulation System, evaluate both initial releases and regression testing defect fixes.

## Tasks
1. Exploratory Testing: Formulated a high-level test plan and conducted ad-hoc, non-scripted testing on ATM System v1.0, documenting all uncovered issues in `exploratory_testing_report.txt`.
2. Manual Scripted Testing: Systematically executed a predefined test suite against ATM System v1.0 to verify core business logic and expected behavior.
3. Regression Testing & Defect Verification: Re-tested reported issues against ATM System v1.1 to verify bug fixes, track defect resolution lifecycles, and identify potential regression bugs.

## System Under Test (SUT)

The ATM Simulation System includes two releases:
* `ATM System - Lab 1 Version 1.0.jar` (Initial release)
* `ATM System - Lab 1 Version 1.1.jar` (Updated release with bug fixes)

### Pre-Configured Test Credentials
* Card 1: PIN `42` | Accounts: Checking ($100), Savings ($1,000)
* Card 2: PIN `1234` | Accounts: Checking ($100), Money Market ($5,000)

## Repository Structure

```text
├── ATM System - Lab 1 Version 1.0.jar   #executable SUT release v1.0
├── ATM System - Lab 1 Version 1.1.jar   #executable SUT release v1.1
├── exploratory_testing_report.txt       #exploratory testing defect log
└── scripted_testing_report.txt          #scripted test suite execution & regression report