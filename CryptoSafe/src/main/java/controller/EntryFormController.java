package controller;

import domain.validation.PINFieldValidation;
import util.EncryptionUtils;
import persistence.PinRepository;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

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
		
		if(EncryptionUtils.checkHash(pin, hashed)) {
			errorLabel.setText("true");
		} else {
			errorLabel.setText("false");
		}
	}

	
}
