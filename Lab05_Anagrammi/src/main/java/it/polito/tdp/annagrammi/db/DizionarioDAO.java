package it.polito.tdp.annagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DizionarioDAO {
	
	public List<String> getParole(){
		
		String sql = "SELECT * "
				+ "FROM parola "
				+ "ORDER BY nome";

		List<String> result = new ArrayList<String>();

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String s = rs.getString("nome");
				
				result.add(s);
			}

			rs.close();
			st.close();
			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		}

		return result;
		
		
		
	}
	
	

}
