package util;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import domain.model.EncryptedData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

public class FileEncryptionUtils {

	private static final String KEY_FILE_PATH = "data/crypto.key";
	private static SecretKey secretKey;
	private static byte[] iv;

	public static void initializeKeyAndIV() {
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

	public static EncryptedData encrpyt(File inputFile) {
		initializeKeyAndIV();

		try {
			// Read all the file data in bytes
			byte[] fileBytes = Files.readAllBytes(inputFile.toPath());

			// Generate IV per new file
			byte[] fileIV = new byte[16];
			SecureRandom random = new SecureRandom();
			random.nextBytes(fileBytes);
			IvParameterSpec ivSpec = new IvParameterSpec(fileIV);

			// Setup AES Cipher
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);

			// Encrypt data
			byte[] encrptedBytes = cipher.doFinal(fileIV);

			// Return encrypted data and iv
			return new EncryptedData(encrptedBytes, fileIV);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}
