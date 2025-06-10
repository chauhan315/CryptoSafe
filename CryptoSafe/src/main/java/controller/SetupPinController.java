package controller;

import java.io.IOException;

import config.AppConfig;
import domain.validation.PINFieldValidation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import persistence.PinRepository;
import util.EncryptionUtils;

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
			
			setUpPinToEntryForm(event);

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
	
	private void setUpPinToEntryForm(ActionEvent event) {
		try {
            Parent entryFormRoot = FXMLLoader.load(AppConfig.class.getResource("/view/entry_form.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene entryForm = new Scene(entryFormRoot);
            stage.setScene(entryForm);
            stage.setResizable(false);
            stage.getIcons().add(AppConfig.getAppIcon());
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
	}
}
