package dao;

import java.sql.Connection;

import conexaojdbc.SingleConnection;

public class UserPosDAO {

	private Connection connection;
	
	public UserPosDAO() {
		
		this.connection = SingleConnection.getConnection();
	}

	public Connection getConnection() {
		return connection;
	}

	
}
