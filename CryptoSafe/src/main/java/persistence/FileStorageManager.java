package persistence;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import exception.VaultException;

public class FileStorageManager {

	private static final String VAULT_DIR = "data/vault";

	static {
		File vaultDir = new File(VAULT_DIR);
		if (!vaultDir.exists())
			vaultDir.mkdirs();
	}

	public static void saveEncryptedFile(File selectedFile, byte[] encryptedBytes) {

		File targetFile = new File(VAULT_DIR, selectedFile.getName());

		try (FileOutputStream fos = new FileOutputStream(targetFile)) {
			fos.write(encryptedBytes);

		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
