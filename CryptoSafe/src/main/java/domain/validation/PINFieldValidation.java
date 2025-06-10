package domain.validation;

import java.util.function.UnaryOperator;

import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;

public class PINFieldValidation {
	
	public static void restrictToFourDigitPIN(TextField textField) {
        UnaryOperator<Change> pinFilter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d{0,4}")) {
                return change; 
            } else {
                return null; 
            }
        };
        textField.setTextFormatter(new TextFormatter<>(pinFilter));
    }
}
