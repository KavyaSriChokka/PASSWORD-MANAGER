# PASSWORD-MANAGER

### Overview
   The Password Manager is a Java-based application that securely stores and retrieves passwords for various accounts. It uses AES encryption to ensure that passwords are stored securely and are only decrypted when retrieved.
   
### Features
- **1.Add Password**:
Encrypts and stores passwords securely.
- **2.Retrieve Password**:
Decrypts and displays stored passwords when requested.
- **3.Delete Password**:
Removes an account and its password from storage.
- **4.Show All Accounts**:
Displays a list of all stored account names without revealing passwords.
- **5.Secure Encryption**:
Uses AES (Advanced Encryption Standard) for secure password management.

### Technologies Used

- Java: Core programming language.
- AES Encryption: For secure password storage and retrieval.
- File I/O: To store passwords persistently in a file (passwords.txt).

### File Structure
- AESUtil.java:
Handles encryption and decryption of passwords using AES.
- PasswordManager.java:
Main application file with functionality for adding, retrieving, deleting, and displaying accounts.
- passwords.txt:
Stores encrypted passwords in the format accountName:encryptedPassword.

### How to Run
- **Prerequisites**
1. Java Development Kit (JDK) installed (version 8 or later).
2. A text editor or an IDE (e.g., IntelliJ IDEA, Eclipse).
- **Steps**
1. Clone or download the project files.
2. Open the project in your IDE.
3. Compile the Java files:
 ```bash
javac AESUtil.java PasswordManager.java
```
