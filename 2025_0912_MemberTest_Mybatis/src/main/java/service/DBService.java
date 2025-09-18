package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBService {

	DataSource ds = null;
	
	//single-ton
	static DBService single = null;
	public static DBService getInstance() {
		if(single == null) 
			single = new DBService();
			
		return single;
	}
	
	private DBService() {
		// TODO Auto-generated constructor stub
		
		//JNDI(Java Naming Directory Interface)
		//	  자원 이름으로 탐색해서 interface 얻어내는 기술
		try {
			InitialContext ic = new InitialContext();
			//Context 위치 탐색
			Context context = (Context) ic.lookup("java:comp/env");
			
			//DataSource 자원정보 검색
			ds = (DataSource) context.lookup("jdbc/oracle_test");
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	public Connection getConnection() throws SQLException {
		
		//DBCP 내에 저장된 컨텍션 중 1개를 얻어옴
		return ds.getConnection();
		
	}
	
}
