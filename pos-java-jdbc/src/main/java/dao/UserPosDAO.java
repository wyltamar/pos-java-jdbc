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
	
	public void create(UserPosJava userPosJava) throws SQLException {
		
		try {
			
			String sql = "insert into userposjava (id,nome,email) values (?,?,?)";
			
			PreparedStatement insert = connection.prepareStatement(sql);
			
			insert.setLong(1, userPosJava.getId());
			insert.setString(2, userPosJava.getNome());
			insert.setString(3, userPosJava.getEmail());
			insert.execute();
			connection.commit(); //salva no banco
			
		} catch (SQLException e) {
			connection.rollback(); // reverte a operação no banco de dados se ocorrer um erro
			e.printStackTrace();
		}
	}

	
}
