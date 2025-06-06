# Step 8: UI Design Specification & Component Mapping

**Project**: CryptoSafe – Secure Java Vault  
**Date**: 2025-06-05

---

## 🖥️ Screens Overview

| Screen                | Purpose                                                                 |
|-----------------------|-------------------------------------------------------------------------|
| 🔐 **PIN Entry Screen**   | Authenticate user securely via PIN                                      |
| 🏠 **Dashboard**          | Vault summary, recent entries, export & backup                         |
| 🧾 **Entry List**         | Search, filter, and manage all entries                                 |
| ➕ **Add/Edit Entry**     | Create or update encrypted vault entries                               |
| 📂 **Entry Viewer**       | Decrypt and view contents (notes, credentials, files)                  |
| ⚙️ **Settings**           | Theme selection, PIN management, reset vault                           |

---

## 🧩 JavaFX Component Mapping

### 🔐 PinEntryController.fxml
- `PasswordField pinField`
- `Button loginButton`
- `Label errorLabel`

### 🏠 DashboardController.fxml
- `Label totalEntryCountLabel`
- `ListView<VaultEntry> recentEntryList`
- `Button exportPDFButton`, `backupVaultButton`
- `Button addNewEntryButton`
- `ToggleButton themeToggle` *(Light/Dark mode)*

### 🧾 VaultListController.fxml
- `TableView<VaultEntry> entriesTable`
- `TextField searchField`
- `ComboBox<String> filterTypeComboBox`
- `FlowPane tagChipsPane` *(dynamic filter chips)*
- `Button viewEntryButton`, `editEntryButton`, `deleteEntryButton`

### ➕ EntryFormController.fxml
- `TextField titleTextField`
- `TextArea contentTextArea`
- `ComboBox<String> entryTypeComboBox`
- `TextField tagsTextField`
- `FlowPane tagChipDisplay`
- `Button attachFileButton`
- `Button saveEntryButton`, `cancelButton`
- `ProgressIndicator encryptionProgressBar`

### 📂 EntryViewController.fxml
- `Label entryTitle`, `Label entryType`, `Label tagsLabel`
- `TextArea decryptedDataText`
- `Button closeButton`
- `Button downloadAttachmentButton` *(for file entries only)*

### ⚙️ SettingsController.fxml
- `PasswordField currentPinField`, `PasswordField newPinField`
- `Button updatePinButton`
- `ComboBox<String> themeSelectorComboBox`
- `Button resetVaultButton`, `exportSettingsButton`

---

## 🎨 Optional UI Features Included

| Feature                      | Description                                                             |
|------------------------------|-------------------------------------------------------------------------|
| ✅ **Dark/Light Mode**       | Toggle between light and dark UI themes dynamically                    |
| ✅ **Tag Chips UI**          | Tags shown as colored chips with delete buttons                         |
| ✅ **Animated Transitions**  | Smooth screen navigation using JavaFX animation effects                 |
| ✅ **File Attachment Drag & Drop** | Users can drag files into entry form to attach them            |
| ✅ **Auto-Lock on Inactivity** | After configurable timeout, returns to PIN screen                     |
| ✅ **Status Toasts / Snackbars** | UI feedback for save/delete actions (via Label or FXDialog popups) |

