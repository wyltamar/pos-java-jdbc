package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexaojdbc.SingleConnection;
import model.UserPosJava;

public class UserPosDAO {

	private Connection connection;
	
	public UserPosDAO() {
		
		this.connection = SingleConnection.getConnection();
	}

	public Connection getConnection() {
		return connection;
	}
	
	public void create(UserPosJava userPosJava) {
		
		try {
			
			String sql = "insert into userposjava (id,nome,email) value (?,?,?)";
			
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setLong(1, 3);
			insert.setString(2, "Pedro Lucas");
			insert.setString(3, "pedro@gmail.com");
			insert.execute();
			connection.commit(); //salva no banco
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
}
