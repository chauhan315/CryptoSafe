package controller;

import java.io.File;
import java.util.List;

import config.AppConfig;
import domain.model.VaultEntry;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import service.VaultService;
import service.VaultServiceImpl;
import util.FileEncryptionUtils;

public class MainController {
	
	private static final String exportPath = "data/export";
	
	VaultService vaultService;
	
	@FXML
	private TableView<VaultEntry> vaultTable;
	
	@FXML
	private TableColumn<VaultEntry, String> titleColumn;
	
	@FXML
	private TableColumn<VaultEntry, String> usernameColumn;
	
	@FXML
	private TableColumn<VaultEntry, String> typeColumn;
	
	@FXML
	public void initialize() {
		vaultService = new VaultServiceImpl();
		List<VaultEntry> entries = vaultService.getAllEntrie();
		
		titleColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitle()));
		usernameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUsername()));
		typeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getType().toString()));
		
		vaultTable.getItems().setAll(entries);
	}

	@FXML
	private void handleSearch(ActionEvent event) {
		
		System.out.println("Search button clicked!");
	}

	@FXML
	private void handleAddEntry(ActionEvent event) {
		
		
		try {
			Parent addEntryRoot = FXMLLoader.load(AppConfig.class.getResource("/view/add_entry.fxml"));
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene addEntry = new Scene(addEntryRoot);
			stage.setScene(addEntry);
			stage.setResizable(true);
			stage.getIcons().add(AppConfig.getAppIcon());
			stage.show();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@FXML
	private void handleEditEntry(ActionEvent event) {

	}

	@FXML
	private void handleDeleteEntry(ActionEvent event) {

	}

	@FXML
	private void handleBackup(ActionEvent event) {

	}
	
	@FXML
	private void logout(ActionEvent event) {
		
	}
	
	@FXML
	private void handleExportEntry(ActionEvent event) {
		VaultEntry selectedEntry = vaultTable.getSelectionModel().getSelectedItem();
		
		if(selectedEntry == null) {
			showError("Please select a file first");
			return;
		}
		
		File encryptedFile = new File(selectedEntry.getEncryptedFilePath());
		
		File exportDir = new File(exportPath);
		if(!exportDir.exists()) exportDir.mkdirs();
		
		String fileName = encryptedFile.getName();
		File outputFile = new File(exportDir, fileName);
		
		try {
			File decryptedFile = FileEncryptionUtils.decrypt(encryptedFile, selectedEntry.getIv(), outputFile);
			showInfo("File Exported Succesfully to : " + decryptedFile.getAbsolutePath());
		} catch (Exception e) {
			showError("Export Failed: "+ e.getMessage());
		}
		
		
	}
	
	private void showError(String message) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}
	
	private void showInfo(String message) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Info");
		alert.setContentText(message);
		alert.setHeaderText(null);
		alert.showAndWait();
	}
}
