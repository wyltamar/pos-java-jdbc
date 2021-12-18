package pos_java_jdbc.pos_java_jdbc;

import conexaojdbc.SingleConnection;

public class TesteBancoJdbc {
	
	
	public void initBanco() {
		SingleConnection.getConnection();
	}

}
