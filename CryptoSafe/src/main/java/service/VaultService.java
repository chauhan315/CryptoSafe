package service;

import java.util.List;

import domain.model.VaultEntry;

public interface VaultService {
	
	void addEntry(VaultEntry entry);
	List<VaultEntry> getAllEntrie();
	void deleteEntry(VaultEntry entry);
	void updateEntry(VaultEntry entry);
}
