package pos_java_jdbc.pos_java_jdbc;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import dao.UserPosDAO;
import model.BeanUserFone;
import model.Telefone;
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
			
			userPosJava.setNome("João Francisco");
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
	
	@Test
	public void initInsertTelefone() {
		
		try {
			
			Telefone telefone = new Telefone();
			telefone.setNumero("(83) 9 9962-3971");
			telefone.setTipo("Residencial");
			telefone.setUsuarioId(6L);
			
			UserPosDAO userPosDAO = new UserPosDAO();
			userPosDAO.createTelefone(telefone);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testaCarregaFonesUser() {
		
		UserPosDAO userPosDAO = new UserPosDAO();
		
		List<BeanUserFone> beanUserFones = userPosDAO.listUserFone(1L);
		
		for (BeanUserFone beanUserFone : beanUserFones) {
			System.out.println(beanUserFone);
			System.out.println("------------------------------------");
		}
	}
	
	@Test
	public void testeDeleteUserFone() {
		
		UserPosDAO dao = new UserPosDAO();
		dao.deleFonesPorUser(10L);
	}

	/*CONCLUSÃO DO MÓDULO 21 DO CURSO JAVAWEB */
}
