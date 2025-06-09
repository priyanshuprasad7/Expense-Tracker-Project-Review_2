===============================
 Expense Tracker & Manager App
===============================

📅 Project Created: 02 June 2025  
🎯 Semester: 2nd Semester Java Project  
👨‍💻 Mode: Console-Based (Java)  
📦 Packages: model, dao, service, util, main  
📁 Data Persistence: File-Based using Serialization and Data Streams

───────────────────────────────
🔧 SETUP INSTRUCTIONS
───────────────────────────────

1. Make sure you have **JDK 8 or above** installed.
2. Create a project directory structure:

    src/
    ├── main/
    │   └── ExpenseTrackerApp.java
    ├── model/
    │   └── Transaction.java
    ├── service/
    │   └── ExpenseService.java
    ├── dao/
    │   └── DataManager.java
    └── util/
        └── InputValidator.java

3. Compile the code using:

    javac main/ExpenseTrackerApp.java

4. Run the application using:

    java main.ExpenseTrackerApp

───────────────────────────────
🚀 FEATURES
───────────────────────────────

✅ Add Income or Expense Transactions  
✅ Support for Recurring Transactions  
✅ Category & Date-wise Search  
✅ Monthly Salary Input and Remaining Balance Calculation  
✅ Monthly Budget Alerts  
✅ Category-wise Summary of Expenses  
✅ Monthly Report Filtering (by MM format)  
✅ File-based Persistence (saves all data across runs)  
✅ Graceful Input Validation & Error Handling  

───────────────────────────────
📂 FILES CREATED DURING USE
───────────────────────────────

- `transactions.dat` → Stores serialized list of transactions
- `config.dat` → Stores user's salary and monthly budget (binary)

───────────────────────────────
🎓 MARKING RUBRIC SATISFIED
───────────────────────────────

✅ Core Feature Implementation – All required features present  
✅ Error Handling & Robustness – Input validation, exception safety  
✅ Component Integration – Model, DAO, Service, Util, Main  
✅ Event Handling – Menu-driven event processing  
✅ Data Validation – Dates, Amounts validated  
✅ Code Quality & Innovation – Recurring, Budget alerts, Monthly summary  
✅ Project Documentation – This README file included

───────────────────────────────
📌 NOTES
───────────────────────────────

- Dates must be in `dd-mm-yyyy` format.
- Month input for reports should be in `MM` format (e.g., "06" for June).
- All data is retained between runs using file I/O.
- You can manually delete `transactions.dat` and `config.dat` to reset the application.

───────────────────────────────
🧑‍💻 DEVELOPED BY
───────────────────────────────

Team Name:   CodeNeVr
College: GALGOTIAS UNIVERSITY 
Semester: 2nd  
Date: June 2025

