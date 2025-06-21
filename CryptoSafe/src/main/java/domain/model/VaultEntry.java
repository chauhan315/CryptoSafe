package domain.model;

import java.time.LocalDateTime;
import java.util.Arrays;

public class VaultEntry {

	private int id;
	private String title;
	private String username;
	private EntryType type;
	private String encryptedFilePath;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private byte[] iv;

	public VaultEntry() {
		super();
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public EntryType getType() {
		return type;
	}

	public void setType(EntryType type) {
		this.type = type;
	}

	public String getEncryptedFilePath() {
		return encryptedFilePath;
	}

	public void setEncryptedFilePath(String encryptedFilePath) {
		this.encryptedFilePath = encryptedFilePath;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}


	public byte[] getIv() {
		return iv;
	}


	public void setIv(byte[] iv) {
		this.iv = iv;
	}


	@Override
	public String toString() {
		return "VaultEntry [id=" + id + ", title=" + title + ", username=" + username + ", type=" + type
				+ ", encryptedFilePath=" + encryptedFilePath + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", iv=" + Arrays.toString(iv) + "]";
	}

	
}
