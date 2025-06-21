package controller;

import java.util.List;

import config.AppConfig;
import domain.model.VaultEntry;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import service.VaultService;
import service.VaultServiceImpl;

public class MainController {
	
	VaultService vaultService = new VaultServiceImpl();
	List<VaultEntry> entries = vaultService.getAllEntrie();

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
}
