# Selenium Automated Testing Project


## Overview

This project is a learning exercise in automated testing using Selenium. The tested website is: [herbals.lv](http://www.herbals.lv).

The project includes a suite of automated tests to validate various functionalities of the website.

## Features

- **Page Testing**: Validation of key website pages.
- **Form Testing**: Verification of form input functionalities.
- **Feature Testing**: Testing different functionalities including adding items to the cart, registration, and more.

## Project Structure
The project is organized into several directories, each serving a specific purpose:

- **utils**:
Contains utility classes that provide common functionalities used across the test suite.

**AssertionUtils**

Provides utility methods for assertions used in tests.

**CheckHttpStatus**

Provides a method to check the HTTP status code of a given URL.

**DriverProvider**

Manages the WebDriver instance used in tests.

**ExplicitWaitsReturnWebElm**

Provides methods for explicit waits for various WebElement states.

**ProductSectionProductsWebElementsCollectorToList**

Collects URLs of product elements from a section with pagination support.
