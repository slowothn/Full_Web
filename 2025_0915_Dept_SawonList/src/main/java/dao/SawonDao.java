package dao;

import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;

public class SawonDao {
	//single-ton 
	static SawonDao single = null;

	//SessionFactory
	SqlSessionFactory factory;
	
	public SawonDao() {
		super();
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	public static SawonDao getInstance() {

		if (single == null)
			single = new SawonDao();

		return single;
	}
	
	
	
}
