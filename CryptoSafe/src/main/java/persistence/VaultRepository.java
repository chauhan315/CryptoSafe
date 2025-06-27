package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.model.EntryType;
import domain.model.VaultEntry;

public class VaultRepository {
	
	private String title;
	private String username;
	private EntryType type;
	private String encryptedFilePath;
	private String createdAt;
	private String updatedAt;
	private byte[] iv;
	
	
	
	private static final String DB_URL = "jdbc:h2:file:./data/metadataDB";
	
	public static void createMetaDataTable() {

		
		try(Connection conn = DriverManager.getConnection(DB_URL);
				Statement stmnt = conn.createStatement()){
			
			String sql = "CREATE TABLE IF NOT EXISTS vault_entries (" +
				    "id INT PRIMARY KEY AUTO_INCREMENT, " +
				    "title VARCHAR(255) NOT NULL, " +
				    "username VARCHAR(255) NOT NULL, " +
				    "entry_type VARCHAR(255) NOT NULL, " +
				    "encrypted_file_path VARCHAR(255) NOT NULL, " +
				    "created_at TIMESTAMP, " +
				    "updated_at TIMESTAMP, " +
				    "iv VARBINARY(16)" +
				    ")";
			
			stmnt.execute(sql);
			
		} catch (SQLException e) {
			
			System.out.println(e + "from createMetaDataTable");
		}
	}

	public void save(VaultEntry entry) {
		title = entry.getTitle();
		username = entry.getUsername();
		type = entry.getType();
		encryptedFilePath = entry.getEncryptedFilePath();
		createdAt = entry.getCreatedAt().toString();
		updatedAt = entry.getUpdatedAt().toString();
		iv = entry.getIv();
		
		createMetaDataTable();
		
		try(Connection conn = DriverManager.getConnection(DB_URL)){
			String sql = "INSERT INTO vault_entries (title, username,"
					+ "entry_type, encrypted_file_path, created_at, "
					+ "updated_at, iv) VALUES (?,?,?,?,?,?,?)";
			
			PreparedStatement pstmnt = conn.prepareStatement(sql);
			
			pstmnt.setString(1, title);
			pstmnt.setString(2, username);
			pstmnt.setString(3, type.name());
			pstmnt.setString(4, encryptedFilePath);
			pstmnt.setString(5, createdAt);
			pstmnt.setString(6, updatedAt);
			pstmnt.setBytes(7, iv);
			
			pstmnt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<VaultEntry> getAllEntries() {
		List<VaultEntry> entries = new ArrayList<>();
		String sql = "SELECT * FROM vault_entries";
		
		try(Connection conn = DriverManager.getConnection(DB_URL);
				PreparedStatement pstmnt = conn.prepareStatement(sql);
				ResultSet rs = pstmnt.executeQuery()){
			
			while(rs.next()) {
				VaultEntry entry = new VaultEntry();
				entry.setTitle(rs.getString("title"));
	            entry.setUsername(rs.getString("username"));
	            entry.setType(EntryType.valueOf(rs.getString("entry_type")));
	            entry.setEncryptedFilePath(rs.getString("encrypted_file_path"));
	            entry.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
	            entry.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
	            entry.setIv(rs.getBytes("iv"));
	            
	            entries.add(entry);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return entries;
		
	}
}
