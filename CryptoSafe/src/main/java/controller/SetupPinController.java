package controller;

import domain.validation.PINFieldValidation;
import util.EncryptionUtils;
import persistence.PinRepository;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class SetupPinController {

	@FXML
	private PasswordField pinField;

	@FXML
	private PasswordField confirmPinField;

	@FXML
	private Label errorLabel;

	@FXML
	private void handleSubmit(ActionEvent event) {
		if (pinField.getText().equals(confirmPinField.getText())) {
			String hashedCode = EncryptionUtils.createHashPin(pinField.getText());
			PinRepository.insertPIN(hashedCode);
			errorLabel.setText("Hashed value added in H2 db");
			
		} else {
			pinField.clear();
			confirmPinField.clear();
			errorLabel.setText("PINs dont match.");
		}
	}

	
	@FXML
	private void initialize() {
		PINFieldValidation.restrictToFourDigitPIN(pinField);
		PINFieldValidation.restrictToFourDigitPIN(confirmPinField);
	}
}
