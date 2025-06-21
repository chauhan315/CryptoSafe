package service;

import java.util.List;

import domain.model.VaultEntry;
import persistence.VaultRepository;

public class VaultServiceImpl implements VaultService{
	
	VaultRepository vaultRepo = new VaultRepository();

	@Override
	public void addEntry(VaultEntry entry) {
		vaultRepo.save(entry);
	}

	@Override
	public List<VaultEntry> getAllEntrie() {
		return vaultRepo.getAllEntries();
	}

	@Override
	public void deleteEntry(VaultEntry entry) {
		
		
	}

	@Override
	public void updateEntry(VaultEntry entry) {
		
	}

}
