package controller;

import java.io.File;
import java.time.LocalDateTime;

import config.AppConfig;
import domain.model.EncryptedData;
import domain.model.EntryType;
import domain.model.VaultEntry;
import domain.validation.VaultEntryValidator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import persistence.FileStorageManager;
import service.VaultServiceImpl;
import util.FileEncryptionUtils;

public class AddEntryController {

	private String dynamicEncryptedPath = "data/vault/";
	private EncryptedData encryptedData;

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
	private VaultServiceImpl vaultServiceImpl;

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

	public void handleAddEntry(ActionEvent event) {
		String title = titleField.getText().trim();
		String username = usernameField.getText().trim();
		EntryType type = typeComboBox.getValue();

		if (selectedFile == null) {
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

		if (validate) {
			encryptedData = FileEncryptionUtils.encrpyt(selectedFile);
			entry.setIv(encryptedData.getIv());

			save(entry);
			addEntryToMain(event);
		}

	}

	private void save(VaultEntry entry) {
		vaultServiceImpl = new VaultServiceImpl();
		vaultServiceImpl.addEntry(entry);

		byte[] encryptedBytes = encryptedData.getEncryptedBytes();
		FileStorageManager.saveEncryptedFile(selectedFile, encryptedBytes);

		
	}

	private Stage getStage() {
		return (Stage) titleField.getScene().getWindow();
	}

	
	@SuppressWarnings("unused")
	private void closeWindow() {
		getStage().close();
	}
	
	private void addEntryToMain(ActionEvent event) {
		try {
			Parent mainRoot = FXMLLoader.load(AppConfig.class.getResource("/view/main.fxml"));
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene mainScene = new Scene(mainRoot);
			stage.setScene(mainScene);
			stage.setResizable(true);
			stage.getIcons().add(AppConfig.getAppIcon());
			stage.show();
			 
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
}
