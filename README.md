# Application social network utilizing business intelligence based on fuzzy logic

This is a robust full-stack application featuring a **Fuzzy Control Language** business logic, **React** frontend, a **Java Spring Boot** backend, and a **Microsoft SQL Server 2019** database.

It's primary focus is demonstrating a work of a prcatical social network application by
creating better user experience by recommending user more relevant or hotter posts based on engagement and the total amount of likes/dislikes.
Heart of the application is [social_feed.fcl](https://github.com/marko-rankovic-26/drustvena-mreza-ai/blob/master/backend/src/main/resources/fuzzy/social_feed.fcl) 
script written in **FCL** (Fuzzy Control Language) which outputs relevancy of each post which are then sorted on the server and returned to client as a response.

---

## Technologies utilized

| Layer | Technology |
| :--- | :--- |
| **Frontend** | React.js (Hooks, Axios) |
| **Backend** | Java Spring Boot |
| **Business logic** | Fuzzy Control Language |
| **Database** | Microsoft SQL Server 2019 |
| **Build Tool** | Gradle |

---

## Installation & Running
Prerequisites
- JDK 17+

- Node.js & npm

- MS SQL Server 2019 instance running on port 1433

- [jFuzzyLogic](https://jfuzzylogic.sourceforge.net/html/index.html) Java library

## Step 1: Database (Microsoft SQL server)
Create a new SQL database by running [forum.sql](https://github.com/marko-rankovic-26/drustvena-mreza-ai/blob/master/forum.sql) srcipt from DBMS.

## Step 2: Backend (Spring Boot)
Place `jFuzzyLogic.jar` inside `backend/libs` directory.

From the `/backend` directory:

Bash
```
./gradlew bootRun
```

Or run [DiplomskiApplication.java](https://github.com/marko-rankovic-26/drustvena-mreza-ai/blob/master/backend/src/main/java/com/forum/diplomski/DiplomskiApplication.java) from Java IDE.

## Step 3: Frontend (React)
From the `/frontend` directory:

Bash
```
cd src
npm install
npm start
```

## Troubleshooting
- Connection Refused: Ensure "TCP/IP" is enabled in your SQL Server Configuration Manager under Network Configuration and the default TCP port is set to 1433.

- SSL Errors: If you encounter PKIX path errors, ensure trustServerCertificate=true is present in the connection string.
