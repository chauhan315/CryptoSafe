# Step 9: Architecture Layer Mapping & Service Planning

**Project**: CryptoSafe – Secure Java Vault  
**Date**: 2025-06-05

---

## 🏗️ Layered Architecture (Clean Architecture for JavaFX Desktop App)

```
                +------------------------------+
                |        Presentation Layer    | ← JavaFX Controllers & Views
                +------------------------------+
                        ↓ (via ViewModel)
                +------------------------------+
                |       Application Layer      | ← Service Interfaces / Use Cases
                +------------------------------+
                        ↓
                +------------------------------+
                |       Domain Layer           | ← Core Business Logic (POJOs, Enums, Rules)
                +------------------------------+
                        ↓
                +------------------------------+
                |     Persistence Layer        | ← VaultManager, DAOs, File IO, Encryption
                +------------------------------+
```

---

## 🧠 Layer Responsibilities

| Layer              | Responsibilities                                                                 |
|-------------------|------------------------------------------------------------------------------------|
| **Presentation**   | UI logic (JavaFX), FXML controllers, user events, data binding                    |
| **Application**    | Service orchestration, use-case logic, mediates between UI and domain             |
| **Domain**         | VaultEntry models, validation, rule enforcement, tag/type classification          |
| **Persistence**    | File read/write, encryption (AES/GCM), secure storage, export/backup management   |

---

## 🔧 Core Services

| Service               | Responsibilities                                                           |
|------------------------|----------------------------------------------------------------------------|
| `VaultService`         | Add/edit/delete/search entries; encrypt/decrypt data                       |
| `AuthenticationService`| Verify PIN, hash with bcrypt, manage session timeouts                      |
| `BackupService`        | Generate/export backup; restore vault safely                               |
| `SettingsService`      | Manage app settings like theme, timeout, PIN changes                       |
| `EncryptionUtils`      | AES encryption/decryption helper class                                     |
| `FileStorageManager`   | Save/load vault file, manage attachments securely                          |

---

## 🔐 Security Integration

- **PIN is hashed with bcrypt** and stored in settings JSON.
- **Vault entries are encrypted with AES/GCM** using a derived key from PIN.
- **Auto-lock on timeout** with inactivity detection at the JavaFX event level.
- **File attachments** are encrypted separately and stored in a structured directory.

---

## 🔄 Data Flow (Add Entry Use Case)

```
User → EntryFormController → VaultService.addEntry()  
      → Domain (VaultEntry validation)  
      → Persistence (encrypt + save to JSON)  
      → Controller reloads entries list
```

---

## ✅ Decisions

- Follows **Clean Architecture** for testability and modularity
- Will separate `VaultEntry`, `Settings`, `Tag`, and `Type` as **POJOs** in domain
- All services will be **interface-driven** for future Spring or DI integration
- All encryption handled **transparently** in persistence layer
