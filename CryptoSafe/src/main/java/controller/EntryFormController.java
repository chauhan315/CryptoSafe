package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyEvent;

public class EntryFormController {
	@FXML
	private PasswordField pinField;

	@FXML
	private Label errorLabel;

	@FXML
	private Button loginButton;

	// Called on each key typed inside the pinField to restrict input
	@FXML
	private void handlePinKeyTyped(KeyEvent event) {
		String character = event.getCharacter();

		// Only allow digits
		if (!character.matches("\\d")) {
			event.consume();
			return;
		}

		// Max length 4
		if (pinField.getText().length() >= 4) {
			event.consume();
		}
	}

	// Called when login button clicked
	@FXML
	private void handleLogin() {
		errorLabel.setText("");

		String pin = pinField.getText();

		if (pin.length() != 4) {
			errorLabel.setText("PIN must be 4 digits.");
			return;
		}

		// TODO: verify PIN against stored hash in SQLite DB
		boolean valid = verifyPin(pin);

		if (valid) {
			// Proceed to main app view
			System.out.println("PIN correct! Proceed to main app...");
			// TODO: load main.fxml or switch scene
		} else {
			errorLabel.setText("Invalid PIN. Try again.");
		}
	}

	// Placeholder: Implement actual verification against DB using BCrypt
	private boolean verifyPin(String pin) {
		// Example: fetch hash from DB, then BCrypt.checkpw(pin, hash)
		// For now, just accept "1234"
		return "1234".equals(pin);
	}
}
