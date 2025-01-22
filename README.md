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
4. Run the application:
   ```bash
   java PasswordManager
   ```
### Usage
- **Launch the application:**
The program starts with a menu offering the following options:

   Add a new password

   Retrieve a password

   Delete a password

   Show all accounts

   Exit

Follow prompts to add, retrieve, delete, or view accounts.
Passwords are stored encrypted in passwords.txt and decrypted only when retrieve

### Example
#### Adding a Password
   ```bash
   Enter account name: google
   Enter password: mysecurepassword
   Password saved successfully!
   ```
#### Stored in passwords.txt
   ```bash
   google:uFVZL1ExUlRDdzYzTmJ0OA==
   ```
#### Retrieving a Password
   ```bash
   Enter account name to retrieve password: google
   Password for google: mysecurepassword
   ```
#### Deleting a Password
   ```bash
   Enter account name to delete: google
   Account deleted successfully!
   ```
### Security Features
#### AES Encryption:
Passwords are encrypted before storage and decrypted only when needed.
#### File-Based Storage:
Passwords are saved in a local file (passwords.txt) for simplicity and portability.

### Limitations
1.No GUI interface; it's a command-line tool.

2.The encryption key is hardcoded and should be securely managed.

3.No user authentication to access the application.

### Future Enhancements
1.Add a graphical user interface (GUI) for ease of use.

2.Implement user authentication for added security.

3.Use a secure database instead of a text file for password storage.

4.Add features for password generation and validation.
