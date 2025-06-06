CryptoSafe – Secure Java Vault  
Step 2: User Stories and Use Cases  
Date: 2025-06-03

---

## 📌 User Roles
- User (single-user app for now)

---

## ✅ User Stories (Agile Format)

| ID    | As a... | I want to...                         | So that...                                |
|-------|---------|--------------------------------------|--------------------------------------------|
| US-01 | User    | log in using my PIN                  | only I can access the vault                |
| US-02 | User    | add a secure note                    | I can store private information safely     |
| US-03 | User    | save login credentials               | I don’t forget my passwords                |
| US-04 | User    | upload files securely                | I can encrypt and store documents          |
| US-05 | User    | search for items in the vault        | I can quickly find specific data           |
| US-06 | User    | switch between dark and light themes | I can use the app comfortably              |
| US-07 | User    | have the vault auto-lock             | my data stays secure if I leave it open    |
| US-08 | User    | export selected data to PDF          | I can print or keep a non-editable backup  |
| US-09 | User    | delete a vault item permanently      | I can remove outdated sensitive data       |
| US-10 | User    | change my PIN                        | I can update my credentials for security   |
| US-11 | User    | see storage usage summary            | I know how much space my vault is using    |
| US-12 | User    | receive a warning if encryption fails| I know if something went wrong             |

---

## 📘 Use Cases

### ✅ Use Case 1: Login
- **Actor**: User  
- **Precondition**: App is installed and launched  
- **Steps**:
  1. User enters PIN or password  
  2. System verifies using secure hash comparison  
  3. If correct, load vault UI  
- **Postcondition**: User has access to vault dashboard  

---

### ✅ Use Case 2: Add Vault Entry
- **Actor**: User  
- **Precondition**: User is logged in  
- **Steps**:
  1. User clicks “Add Entry”  
  2. Chooses type: text, password, file  
  3. Enters title, tags, content/file  
  4. System encrypts and stores the data  
- **Postcondition**: Entry appears in the vault list  

---

### ✅ Use Case 3: Export Vault Entry
- **Actor**: User  
- **Steps**:
  1. User selects one or more entries  
  2. Clicks "Export"  
  3. Chooses export format: Encrypted archive or PDF  
  4. System prompts for export location  
- **Postcondition**: File saved to disk  

---

### ✅ Use Case 4: Auto Lock Vault
- **Actor**: System  
- **Trigger**: Timeout or app close  
- **Steps**:
  1. System detects inactivity or shutdown  
  2. Saves any unsaved data  
  3. Clears session and returns to login screen  
- **Postcondition**: Vault locked securely