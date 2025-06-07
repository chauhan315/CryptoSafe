package config;

import javafx.scene.image.Image;

public class AppConfig {
	
	private static final String APP_ICON_PATH = "/resources/app_icon.png";
	
	public static Image getAppIcon() {
		Image icon = new Image(AppConfig.class.getResourceAsStream(APP_ICON_PATH));
		
		return icon;
	}

}
