package pos_java_jdbc.pos_java_jdbc;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import dao.UserPosDAO;
import model.UserPosJava;

public class TesteBancoJdbcPosJava {
	
	@Test
	public void initBanco() {
		UserPosDAO userPosDAO = new UserPosDAO();
		UserPosJava userPosJava = new UserPosJava();
		
		userPosJava.setNome("Inserido com sequencia2");
		userPosJava.setEmail("sequencia2@gmail.com");
		
		try {
			userPosDAO.create(userPosJava);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initListar() {
		UserPosDAO userPosDAO = new UserPosDAO();
		
		List<UserPosJava> list = userPosDAO.read();
		
		for (UserPosJava userPosJava : list) {
			System.out.println(userPosJava);
		}
	}
	
	@Test
	public void initFind() {
		
		UserPosDAO userPosDAO = new UserPosDAO();
		
		UserPosJava userPosJava = userPosDAO.find(2L);
		
		System.out.println(userPosJava);
				
	}
	
	@Test
	public void initUpdate() {
		UserPosDAO userPosDAO = new UserPosDAO(); 		
		
		try {
			UserPosJava  userPosJava = userPosDAO.find(2L);
			
			userPosJava.setNome("Jo�o Francisco");
			userPosJava.setEmail("jfranc@gamil.com");
			userPosDAO.update(userPosJava);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initDelete() {
		try {
			
			UserPosDAO userPosDAO = new UserPosDAO();
			userPosDAO.delete(7L);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
