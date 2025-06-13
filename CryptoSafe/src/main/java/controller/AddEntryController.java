package controller;

import java.io.File;
import java.time.LocalDateTime;

import domain.model.EntryType;
import domain.model.VaultEntry;
import domain.validation.VaultEntryValidator;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AddEntryController {
	
	private String dynamicEncryptedPath = "data/vault/";

	@FXML
	private TextField titleField;

	@FXML
	private TextField usernameField;

	@FXML
	private ComboBox<EntryType> typeComboBox;

	@FXML
	private Label fileNameLabel;

	@FXML
	private Label errorLabel;

	private File selectedFile;
	private VaultEntryValidator vaultEntryValidator;

	@FXML
	public void initialize() {
		typeComboBox.getItems().setAll(EntryType.values());
	}

	@FXML
	public void handleChooseFile() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Select File");
		File file = fileChooser.showOpenDialog(getStage());

		if (file != null) {
			selectedFile = file;
			fileNameLabel.setText(file.getName());
		}
	}

	public void handleAddEntry() {
		String title = titleField.getText().trim();
		String username = usernameField.getText().trim();
		EntryType type = typeComboBox.getValue();

		if (selectedFile != null) {
			errorLabel.setText("Please choose a file");
			return;
		}

		VaultEntry entry = new VaultEntry();
		entry.setTitle(title);
		entry.setUsername(username);
		entry.setType(type);
		entry.setCreatedAt(LocalDateTime.now());
		entry.setUpdatedAt(LocalDateTime.now());
		entry.setEncryptedFilePath(dynamicEncryptedPath.concat(fileNameLabel.getText()));
		
		vaultEntryValidator = new VaultEntryValidator();
		Boolean validate = vaultEntryValidator.validate(entry);

	}

	private Stage getStage() {
		return (Stage) titleField.getScene().getWindow();
	}

	private void closeWindow() {
		getStage().close();
	}
}
