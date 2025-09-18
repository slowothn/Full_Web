package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import db.vo.VisitVo;
import service.MyBatisConnector;

//DAO(Data Access Object)
// : CRUD 처리 객체

//다양한 객체에게서 처리요청을 받기 때문에 싱글톤으로  생성

public class VisitDao {
	// factory 추가
	SqlSessionFactory factory;

	// single-ton
	static VisitDao single = null;

	public static VisitDao getInstance() {
		if (single == null)
			single = new VisitDao();

		return single;
	}

	private VisitDao() {
		// MyBatisConnector로 factory(db,mapper 정보있음) 연결
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	// 조회
	public List<VisitVo> selectList() {

		List<VisitVo> list = null;

		// 1.작업객체 얻어오기
		SqlSession sqlSession = factory.openSession();

		// 2.작업수행 "namespace.mapper_id"
		list = sqlSession.selectList("visit.visit_list");

		// 3. 닫기
		sqlSession.close();

		return list;
	}
	
	// map으로 조회하기
	public List<VisitVo> selectList(Map<String, Object> map) {
			
		List<VisitVo> list = null;

		// 1.작업객체 얻어오기
		SqlSession sqlSession = factory.openSession();

		// 2.작업수행 "namespace.mapper_id"
		list = sqlSession.selectList("visit.visit_list_condition",map);

		// 3. 닫기
		sqlSession.close();

		return list;
	}
	
	

	// 추가
	public int insert(VisitVo vo) {

		int res = 0; // 처리된 행수

		// 1, 2, 3, 4 <- pstmt parameter index
		//String sql = "insert into visit values( seq_visit_idx.nextVal, ?, ?, ?, ?, sysdate )";

		// 1. 작업객체 얻어오기
		SqlSession sqlSession = factory.openSession(true);

		// 2. 작업 수행
		res = sqlSession.insert("visit.visit_insert", vo);

		// Transaction(DML에 적용(DB내용이 바뀌면)) log에 저장된 작업을 commit해야 DB에 적용됨
		// 2-1.
		// sqlSession.commit(); //DB 적용 -> openSession(true)로 설정하면 auto commit)
		// sqlSession.rollback(); //취소

		// 3. 닫기
		sqlSession.close();

		return res;
	}

	// 삭제 템플릿
	public int delete(int idx) {

		int res = 0;

		// 1. 작업객체 얻어오기 (auto commit)
		SqlSession sqlSession = factory.openSession(true);

		// 2. 작업 수행			"namespace.mapper_id", parameter
		res = sqlSession.delete("visit.visit_delete", idx);

		// 3. 닫기
		sqlSession.close();

		return res;
	}

	// idx 에 해당하는 1건 데이터 조회
	public VisitVo selectOne(int idx) {

		VisitVo vo = null;


		//1.작업객체 얻기
		SqlSession sqlSession = factory.openSession(true);
		
		//2.작업수행
		vo = sqlSession.selectOne("visit.visit_one", idx);
		
		//3.닫기
		sqlSession.close();

		return vo;
	}

	public int update(VisitVo vo) {

		int res = 0;

		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.update("visit_update", vo);

		return res;
	}

	

	//connection을 얻어오려고 DBService 사용 -> DBService 삭제해도 됨
	
}
