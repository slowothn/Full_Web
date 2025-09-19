package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.DeptVo;

public class DeptDao {
	//Mybatis 인터페이스 필요
	SqlSessionFactory factory;
	
	//single-ton
	static DeptDao single = null;

	public static DeptDao getInstance() {

		if (single == null)
			single = new DeptDao();

		return single;
	}

	private DeptDao() {
		//싱글톤이므로 private 생성자 안에 factory
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	public List<DeptVo> selectList(){
		List<DeptVo> list = null;
		
		//1.작업객체 얻어오기
		SqlSession sqlSession = factory.openSession();
		
		//2.작업 수행
		list = sqlSession.selectList("dept.dept_list");
		
		//3.sqlSession close
		sqlSession.close();
		
		return list;
	}
	
}
