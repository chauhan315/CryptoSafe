CryptoSafe – Secure Java Vault
Step 1: Requirements Document
Date: 2025-06-03

---

📌 Project Summary:
CryptoSafe is a JavaFX-based secure desktop application that allows users to store and manage private information such as passwords, personal notes, and sensitive documents using local AES-256 encryption. Data is stored offline and protected by a master password or PIN, ensuring security and privacy without internet dependency.

🎯 Objective:
To provide a secure, user-friendly desktop solution for managing sensitive personal data with modern encryption standards, polished GUI, and offline data storage.

✅ Functional Requirements:
| ID    | Feature              | Description                                                                 |
|-------|----------------------|-----------------------------------------------------------------------------|
| FR-01 | User Authentication  | Login using a master PIN or password stored securely (hashed with salt)     |
| FR-02 | Vault Entry Management | Add/edit/delete entries: passwords, notes, or documents                   |
| FR-03 | File Encryption      | Securely store uploaded files using AES-256                                 |
| FR-04 | Search Functionality | Search vault entries by title, tag, or type                                |
| FR-05 | Auto Lock            | Automatically lock vault after inactivity or on app close                  |
| FR-06 | Dark Mode            | Toggle between light and dark themes                                       |
| FR-07 | Export               | Export selected vault entries (PDF or encrypted archive)                   |
| FR-08 | Settings Panel       | Change PIN, configure timeout, view storage info                           |

⚙️ Non-Functional Requirements:
| ID     | Area         | Description                                                                      |
|--------|--------------|----------------------------------------------------------------------------------|
| NFR-01 | Security      | Use AES-256 encryption and SHA-512 for secure storage and authentication         |
| NFR-02 | Usability     | UI should be responsive, user-friendly, and intuitive                            |
| NFR-03 | Portability   | App should run on Windows, macOS, and Linux with minimal setup                   |
| NFR-04 | Performance   | Handle up to 500+ entries without lag                                            |
| NFR-05 | Offline Access| App functions entirely without internet connection                              |
| NFR-06 | Responsiveness| Auto-resize and adjust to various screen resolutions                             |

🧑‍💼 Target Users:
- Privacy-conscious individuals
- Freelancers or small business owners managing sensitive client data
- Non-tech-savvy users who need secure yet simple tools

🚫 Out of Scope (for MVP):
- Cloud sync or remote backup
- Multi-user accounts
- Biometric authentication (e.g., fingerprint)
- Mobile versions