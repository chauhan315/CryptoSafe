package domain.validation;

import domain.model.VaultEntry;

public class VaultEntryValidator {

	public Boolean validate(VaultEntry entry) {

		if (entry.getCreatedAt() != null && entry.getTitle() != null && entry.getType() != null
				&& entry.getUpdatedAt() != null && entry.getUsername() != null) {
			return true;
		}

		return false;
	}
}
