package app;

import java.io.IOException;

import config.AppConfig;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CryptoSafeApp extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			FXMLLoader loader = new FXMLLoader(AppConfig.class.getResource("/view/entry_form.fxml"));
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
