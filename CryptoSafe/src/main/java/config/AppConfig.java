package config;

import java.io.File;

import javafx.scene.image.Image;

public class AppConfig {

	private static final String APP_ICON_PATH = "/resources/app_icon.png";
	private static final String DB_FILE_PATH = "data/cryptosafePIN.mv.db";

	public static boolean isFirstLaunch() {
		File dbFile = new File(DB_FILE_PATH);
		return !dbFile.exists();
	}

	public static Image getAppIcon() {
		Image icon = new Image(AppConfig.class.getResourceAsStream(APP_ICON_PATH));
		return icon;
	}
	

}
