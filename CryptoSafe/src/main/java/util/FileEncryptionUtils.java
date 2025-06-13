package util;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import domain.model.EncryptedData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.crypto.KeyGenerator;

public class FileEncryptionUtils {

	private static final String KEY_FILE_PATH = "data/crypto.key";
	private static SecretKey secretKey;
	private static byte[] iv;

	public void initializeKeyAndIV() {
		File keyFile = new File(KEY_FILE_PATH);

		if (keyFile.exists()) {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(keyFile))) {
				byte[] keyBytes = (byte[]) ois.readObject();
				secretKey = new SecretKeySpec(keyBytes, "AES");

			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			try {
				// Generate a new Key with 128 bits
				KeyGenerator keyGen = KeyGenerator.getInstance("AES");
				keyGen.init(128);
				secretKey = keyGen.generateKey();

				// Store the key
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(keyFile));
				oos.writeObject(secretKey.getEncoded());

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public EncryptedData encrpyt(File inputFile) {
		initializeKeyAndIV();
		
		
	}
}
