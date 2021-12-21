package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

			String sql = "insert into userposjava (nome,email) values (?,?)";

			PreparedStatement insert = connection.prepareStatement(sql);

			insert.setString(1, userPosJava.getNome());
			insert.setString(2, userPosJava.getEmail());
			insert.execute();
			connection.commit(); // salva no banco

		} catch (SQLException e) {
			connection.rollback(); // reverte a operação no banco de dados se ocorrer um erro
			e.printStackTrace();
		}
	}

	public List<UserPosJava> read() {

		List<UserPosJava> list = new ArrayList<UserPosJava>();
		try {

			String sql = "select * from userposjava";

			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultado = statement.executeQuery();

			while (resultado.next()) {
				UserPosJava userPosJava = new UserPosJava();

				userPosJava.setId(resultado.getLong("id"));
				userPosJava.setNome(resultado.getString("nome"));
				userPosJava.setEmail(resultado.getString("email"));

				list.add(userPosJava);
			}

		} catch (Exception e) {
		}
		return list;

	}

	public UserPosJava find(Long id) {

		UserPosJava userPosJava = new UserPosJava();
		try {

			String sql = "select * from userposjava where id = "+id;

			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultado = statement.executeQuery();

			while (resultado.next()) { //retorna um ou nenhum ojeto
				

				userPosJava.setId(resultado.getLong("id"));
				userPosJava.setNome(resultado.getString("nome"));
				userPosJava.setEmail(resultado.getString("email"));

			}

		} catch (Exception e) {
		}
		return userPosJava;

	}
	
	public void update(UserPosJava userPosJava) throws SQLException {
		
		try {
		
			String sql = "update userposjava set nome = ?, email = ? where id ="+userPosJava.getId();
			
			PreparedStatement update = connection.prepareStatement(sql);
			
			update.setString(1, userPosJava.getNome());
			update.setString(2, userPosJava.getEmail());
			update.executeUpdate();
			connection.commit();
			
		}catch(Exception e) {
			
			connection.rollback();
		
			e.printStackTrace();
		}
	}
	
	public void delete(Long id) {
		
		try {
			
			String sql = "delete from userposjava where id = "+ id;
			PreparedStatement delete = connection.prepareStatement(sql);
			delete.execute();
			connection.commit();
			
			
		}catch(Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}

}
