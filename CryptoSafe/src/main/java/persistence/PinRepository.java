package persistence;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PinRepository {

	private static final String DB_URL = "jdbc:h2:file:./data/cryptosafePIN";

	public static void initializeDatabaseAndCreateFile() {
		File data = new File("data");
		if(!data.exists()) {
			data.mkdir();
			
			try (Connection conn = DriverManager.getConnection(DB_URL); 
					Statement stmnt = conn.createStatement()) {

				String sql = "CREATE TABLE IF NOT EXISTS pin_store (" + 
						"id INT PRIMARY KEY AUTO_INCREMENT, " +
						"hashed_pin VARCHAR(255) NOT NULL)";

				stmnt.execute(sql);

			} catch (SQLException e) {

				System.out.println(e.getMessage() + "from initDB");
			}
		}

		

	}

	public static void insertPIN(String hashed_pin) {

		initializeDatabaseAndCreateFile();

		String sql = "INSERT INTO pin_store (hashed_pin) VALUES (?)";

		try (Connection conn = DriverManager.getConnection(DB_URL);
				PreparedStatement pstmnt = conn.prepareStatement(sql)) {

			pstmnt.setString(1, hashed_pin);
			pstmnt.executeUpdate();

		} catch (Exception e) {

			System.out.println(e.getMessage() + "from insert");
		}
	}
	
	public static String getHash() {
		
		String hashed = null;
		
		String sql = "SELECT hashed_pin FROM pin_store LIMIT 1";
		
		try (Connection conn = DriverManager.getConnection(DB_URL);
				Statement stmnt = conn.createStatement()) {

			ResultSet rs = stmnt.executeQuery(sql);
			
			if(rs.next()) {
				hashed = rs.getString("hashed_pin");
			}

		} catch (Exception e) {

			System.out.println(e.getMessage() + "from gethash");
		}
		return hashed;
	}

}
