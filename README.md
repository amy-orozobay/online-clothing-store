# Online Clothing Store

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)  
*UI and API Test Automation Framework for [AutomationExercise.com](https://automationexercise.com/) using Java, Selenium, RestAssured, and Cucumber BDD.*

---

## 🧪 **Project Overview**
- **Goal**: End-to-end testing of UI (Selenium) and API (RestAssured) with BDD (Cucumber) and CI/CD (Jenkins).
- **Team**:
    - Amy Orozobay (https://github.com/amy-orozobay)
    - Shevket Dzhaparov (https://github.com/)
    - Teammate 3 (https://github.com/)
- **Scope**:
    - **UI Tests**: Login, product search, cart, checkout.
    - **API Tests**: CRUD operations, validation.
    - **Reports**: Cucumber HTML/JSON reports + Jenkins integration.

---

## 🛠️ **Tech Stack**
| Category       | Tools                                                                 |
|----------------|-----------------------------------------------------------------------|
| Language       | Java 11+                                                             |
| UI Automation  | Selenium WebDriver 4.x                                               |
| API Automation | RestAssured                                                          |
| BDD Framework  | Cucumber 7.x                                                         |
| Test Runner    | JUnit 5                                                              |
| Build Tool     | Maven                                                                |
| Reporting      | Cucumber Reports, Allure                                             |
| CI/CD          | Jenkins                                                              |
| Version Control| Git/GitHub                                                           |

---

## 🚀 **Setup Guide**

### 🔹 **Prerequisites**
- Java JDK 11+
- Maven 3.8+
- Chrome/Firefox browser
- IDE (IntelliJ/Eclipse)
- Git

### 🔹 **How to Get the Project**
Clone:  
`git clone https://github.com/amy-orozobay/online-clothing-store.git
`
### 🔹 **Get Access to Push**
- send your github to repo admin @amy-orozobay to add you via:
GitHub Settings → Collaborators → Add People. 
- Accept the email invitation.

### 📂 Project Structure
```
online-clothing-store/  
├── src/ 
│   ├── main/
│       ├── java
│       ├── resources
│   ├── test/
│       ├── java
│       ├── resources
├── pom.xml
└── README.md
```
### 🤝 Collaboration Rules
 Never work on main directly, create separate branch, work on it, push, PR

### 🔹 Pull Requests (PRs)
Before creating a PR:  
Run all tests locally: mvn clean test.    
Ensure your branch is updated with main.  
PR Title:  
[Type]: Brief Description (e.g., [FEATURE]: Add login tests).

**Review Process:**  
At least 2 teammates must approve before merging.  
Fix any merge conflicts in your branch.

**Merging to Main**  
Merging happens only after 2 teammates reviewed and approved the merged.  
Squash commits: Use "Squash and Merge" in GitHub to keep history clean.

### 📊 Reporting
Cucumber Reports:
Generated in target/cucumber-reports/.

Jenkins:
Configure job to publish reports after each run.