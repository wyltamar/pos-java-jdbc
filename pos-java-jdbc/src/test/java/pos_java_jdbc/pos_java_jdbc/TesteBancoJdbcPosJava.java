package pos_java_jdbc.pos_java_jdbc;

import java.sql.SQLException;

import org.junit.Test;

import dao.UserPosDAO;
import model.UserPosJava;

public class TesteBancoJdbcPosJava {
	
	@Test
	public void initBanco() {
		UserPosDAO userPosDAO = new UserPosDAO();
		UserPosJava userPosJava = new UserPosJava();
		
		userPosJava.setId(5L);
		userPosJava.setNome("Junior da Silva");
		userPosJava.setEmail("juniorsilva@gmail.com");
		
		try {
			userPosDAO.create(userPosJava);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
