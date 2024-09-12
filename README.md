
ATM System Design

P. Sreya Tejaswi



Overview

This ATM system is designed for 5 specific users, allowing them to perform various actions on their respective accounts. The system supports three types of accounts:

- Savings Account
- Current Account
- Fixed Deposit Account

Available Actions:
1. View Balance 
2. Withdraw Money  
3. Deposit Money

Each user's balance is updated in real time after performing any transaction.

Code Explanation

Interface: `Account_details`
- Each user has a **unique account number** and **PIN**.
- The user information is collected and **verified** against the database.



Class: `checkDetails`
- Implements the `Account_details` interface to validate the user credentials against the ATM database.
- Function: `getDetails`  
  - Collects user details and verifies them using the predefined database.
  - It first checks if the **account number** exists. If valid, it then verifies the **PIN** using an `if-else` conditional structure.
  - If the details are correct, the account status is returned to the main class.

Class: `money`
- This class helps calculate the **amount** required for the user, whether it’s for withdrawal or deposit.
- It also determines the denominations.
- The final total amount is returned to the main class.



Main Class: `ATM`
- Handles the operations for the 5 default users, ensuring their bank balance is updated accordingly.
- The process follows these steps:
  1. User Authentication:  
     - The system collects the user’s account number and PIN.
     - The `checkDetails` class validates the user details. 
     - If the details are incorrect, an invalid message is displayed, and the user is prompted to try again (up to 5 times).
     - After 5 failed attempts, the user is locked out, and an **“Invalid Account”** message is displayed.

  2. Account Access:
     - Once authenticated, the user selects the account type and proceeds with the desired action (view balance, withdraw, deposit).
     - A default balance of Rs.10,000 is assigned to all accounts at the start.

  3. Transactions:  
     - The `money` class processes the user’s transaction, determining the denominations for the withdrawal or deposit.
     - If the withdrawal amount exceeds the balance, an alert is displayed.
     - If the transaction is successful, the user's balance is updated in the system.

  4. Repeat Option:  
     - After a transaction, the user is prompted to either continue working with their account or exit.

---

Initial ATM Database:

| User  | Account Number | PIN   | Account Type    | Initial Balance |
|-------|----------------|-------|-----------------|-----------------|
| User1 | 12345          | 23456 | Savings         | Rs.10000        |
| User2 | 23456          | 34567 | Current         | Rs.10000        |
| User3 | 34567          | 45678 | Fixed Deposit   | Rs.10000        |
| User4 | 45678          | 56789 | Savings         | Rs.10000        |
| User5 | 56789          | 67891 | Current         | Rs.10000        |



Key Java Concepts:
- Encapsulation  
- Inheritance 
- Array for Customer Data 
- Multiple Object Creation


How OOPs Concepts are Integrated in the Solution

1.Class and Object Structure: 
   - We created different classes and interfaces to store data and interact with the ATM system.
   
2. Encapsulation: 
   - Each class has its own methods, ensuring that only relevant data can be accessed.
   
3. Reusability & Readability: 
   - OOPs helped us structure the code in a **modular** and **easy-to-understand** manner.
   - Encapsulation also ensures that customer details are secure and inaccessible by other class methods.
   
4. Interface Implementation: 
   - The `getDetails` interface was used in the `checkDetails` class to handle user authentication.
   
5. Money Class Functionality:  
   - The `money` class helps in managing denominations and amounts for transactions.
  
->The user can input invalid data for only three times.
