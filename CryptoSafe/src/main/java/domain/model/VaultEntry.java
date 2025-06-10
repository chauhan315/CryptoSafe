package domain.model;

import java.time.LocalDateTime;
import java.util.List;

public class VaultEntry {

	private int id;
	private String title;
	private String username;
	private List<Tag> tags;
	private EntryType type;
	private String encryptedFilePath;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public VaultEntry() {
		super();
	}

	public VaultEntry(String title, String username, List<Tag> tags, EntryType type, String encryptedFilePath,
			LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.title = title;
		this.username = username;
		this.tags = tags;
		this.type = type;
		this.encryptedFilePath = encryptedFilePath;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
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

	@Override
	public String toString() {
		return "VaultEntry [id=" + id + ", title=" + title + ", username=" + username + ", tags=" + tags + ", type="
				+ type + ", encryptedFilePath=" + encryptedFilePath + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + "]";
	}

}
