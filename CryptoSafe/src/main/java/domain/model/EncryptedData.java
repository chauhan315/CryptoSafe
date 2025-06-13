package domain.model;

public class EncryptedData {

	private final byte[] encryptedBytes;
	private final byte[] iv;

	public EncryptedData(byte[] encryptedBytes, byte[] iv) {
		this.encryptedBytes = encryptedBytes;
		this.iv = iv;
	}

	public byte[] getEncryptedBytes() {
		return encryptedBytes;
	}

	public byte[] getIv() {
		return iv;
	}

}
