# Fake Store API Testing Suite
Automated API test suite for the Fake Store REST API, built for QA and learning purposes. Cover smoke, regression, and knownBug scenarios across core modules: Users, Carts, Products, and Auth.
## Highlights
- Covers complete CRUD testing for **Users**, **Products**, and **Carts**.
- Implements **data-driven** tests using TestNG DataProviders.
- Includes **reusable Request/Response Specifications**.
- Categorized into **Smoke**, **Regression**, and **Known Bug** test suites.

## Tech Stack
- **Language:** Java
- **Framework:** TestNG
- **API Automation:** Rest Assured
- **Build & Dependencies:** Maven
- **Reports:** Surefire Reports
## Test Categories
- **Smoke Tests**:
  Basic endpoint checks ensuring the API is up and functional.
- **Regression Tests**:
  Full validation of flows, including request/response structures and data assertions.
- **Known Bugs**:
  Reproducible test cases for API issues (e.g. empty credentials return 200 instead of 400).
## Project Structure
```text
FakeStore-API-testing-Suite/
└── src/test/java/
    ├── utils/          # Reusable methods, DataProviders
    ├── tests/          # grouped tests (Smoke, Regression, KnownBug)
    ├── models/         # POJOs for serialization/deserialization
    └── services/       # reusable classes to interact with API endpoints       
├── pom.xml             # Maven dependencies
├── testng.xml          # Defines test groups, suite execution, and configuration
├── screenshots         # Screenshots of successful test results
├── reports             # Surefire test reports
```
## Getting Started
### 1. Clone the Repository
```bash
git clone https://github.com/AbdulMannan6643234/FakeStore-API-testing-Suite.git
```
### 2. Navigate to Project
```bash
cd FakeStore-API-testing-Suite
```
### 3. Install dependencies
```bash
mvn clean install
```
### 4. Running Tests
```bash
mvn test -DsuiteXmlFile=testng.xml
```
**5. View reports:** target/surefire-reports/index.html
## Test Results
Smoke Tests: 34/34 Passed

![smoke tests](/screenshots/smoke.png)


Regression Tests: 5/5 Passed

![regression tests](/screenshots/regression.png)


Known Bugs: Intentional test cases highlighting existing API issues, with detailed reports of expected vs. actual behavior.

![knownbugs](/screenshots/knownBugs.png)
