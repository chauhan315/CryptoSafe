package util;

import org.mindrot.jbcrypt.BCrypt;

public class EncryptionUtils {
	
	public static String createHashPin(String pin) {
		return BCrypt.hashpw(pin, BCrypt.gensalt());
	}
	
	public static Boolean checkHash(String pin, String hashed) {
		return BCrypt.checkpw(pin, hashed);
	}
}
