# Lab 05: Automated Web Testing with Selenium


## Overview

The  goal of this lab is to introduce Automated Web Application Testing using Java, JUnit 5, and the Selenium WebDriver framework.

## Tasks
1. Selenium Environment Setup: Configure local `ChromeDriver` / `GeckoDriver` executables to allow programmatic browser automation.
2. Google Search Tests (`GoogleTest.java`): Verify core search functionality, element visibility (`By.name`, `By.xpath`), text input simulation (`sendKeys`), and explicit waits (`WebDriverWait`).
3. UVic Web Tests (`UVicTest.java`): Implement web tests for the UVic website, including search navigation, page interactions, and DOM element assertions.
4. Standards & Compliance Testing: Perform automated web accessibility/compliance checks.

## Requirements & Environment

* Browser Automation: Selenium Java (`4.2.+`) & Selenium Chrome Driver (`4.3.0`)
* Browser & Driver: Google Chrome with matching `chromedriver` executable stored in `driver/`

## Repository Structure

```text
├── driver/
│   └── chromedriver-win64/
│       └── chromedriver.exe   # Local ChromeDriver binary
└── src/
    ├── GoogleTest.java        # Initial Selenium web tests for Google
    └── UVicTest.java          # Lab exercise web tests for uvic.ca
