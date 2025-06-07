package app;

import java.io.IOException;

import config.AppConfig;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CryptoSafeApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader;
		
		try {
			if (AppConfig.isFirstLaunch()) {
				loader = new FXMLLoader(AppConfig.class.getResource("/view/setup_pin.fxml")); // First-time PIN setup
			} else {
				loader = new FXMLLoader(AppConfig.class.getResource("/view/login.fxml")); // Normal login
			}
			Scene scene = new Scene(loader.load());
			scene.getStylesheets().add(AppConfig.class.getResource("/resources/styles.css").toExternalForm());

			primaryStage.setTitle("CryptoVault - Secure Vault");
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(AppConfig.getAppIcon());
			primaryStage.setResizable(true);
			primaryStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);
	}

}
