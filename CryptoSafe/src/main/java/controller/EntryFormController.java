package controller;

import java.io.IOException;

import config.AppConfig;
import domain.validation.PINFieldValidation;
import util.EncryptionUtils;
import persistence.PinRepository;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class EntryFormController {
	@FXML
	private PasswordField pinField;

	@FXML
	private Label errorLabel;

	@FXML
	private Button loginButton;

	@FXML
	public void initialize() {
		PINFieldValidation.restrictToFourDigitPIN(pinField);
	}

	@FXML
	private void handleLogin(ActionEvent event) {
		String pin = pinField.getText();
		String hashed = PinRepository.getHash();
		
		if(!EncryptionUtils.checkHash(pin, hashed)) {
			errorLabel.setText("PIN is wrong!!");
			pinField.clear();
			return;
		} 
		
		entryFormToMain(event);
	}
	
	private void entryFormToMain(ActionEvent event) {
		try {
			Parent mainRoot = FXMLLoader.load(AppConfig.class.getResource("/view/main.fxml"));
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene main = new Scene(mainRoot);
			stage.setScene(main);
			stage.setResizable(true);
			stage.getIcons().add(AppConfig.getAppIcon());
			stage.show();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	
}
