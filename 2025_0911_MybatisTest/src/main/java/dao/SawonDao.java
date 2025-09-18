package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.SawonVo;

public class SawonDao {
	//single-ton : 객체1개만 생성 서비스
	static SawonDao single = null;

	//SessionFactory생성하는 객체
	SqlSessionFactory factory;
	
	private SawonDao() {
		// TODO Auto-generated constructor stub
		//factory는 DB,mapper 정보를 알고 있는 객체
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	public static SawonDao getInstance() {

		if (single == null)
			single = new SawonDao();

		return single;
	}
	
	//조회
	public List<SawonVo> selectList(){
		
		List<SawonVo> list = null;
		
		//1.SqlSession객체정보 얻어오기(Mybatis의 작업 개체)
		SqlSession sqlSession = factory.openSession();
		
		//2.작업수행				namespace.mapper_id
		list = sqlSession.selectList("sawon.sawon_list");
		
		//3.닫기(내부적으로 connection 닫기)
		sqlSession.close();
		
		return list;
	}

	public List<SawonVo> selectListFromDeptno(int deptno) {

		List<SawonVo> list = null;
		
		//1.SqlSession객체정보 얻어오기(Mybatis의 작업 개체)
		SqlSession sqlSession = factory.openSession();
		
		//2.작업수행				namespace.mapper_id, parameter	//mapper 작성해야 함
		list = sqlSession.selectList("sawon.sawon_list_deptno", deptno);
		
		
		//3.닫기(내부적으로 connection 닫기)
		sqlSession.close();
		
		return list;
	}

	public List<SawonVo> selectConditionList(Map<String, Object> map) {
		List<SawonVo> list = null;
		
		//1.SqlSession객체정보 얻어오기(Mybatis의 작업 개체)
		SqlSession sqlSession = factory.openSession();
		
		//2.작업수행				namespace.mapper_id, parameter	//mapper 작성해야 함
		list = sqlSession.selectList("sawon.sawon_list_condition", map);
		
		
		//3.닫기(내부적으로 connection 닫기)
		sqlSession.close();
		
		return list;
	}
	
	
	
}
