package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import db.vo.MemberVo;
import service.MyBatisConnector;

public class MemberDao {
	
	//팩토리 추가
	SqlSessionFactory factory;

	//single-ton
	static MemberDao single = null;

	public static MemberDao getInstance() {

		if (single == null)
			single = new MemberDao();

		return single;
	}

	private MemberDao() {
		//팩토리 연결
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	public List<MemberVo> selectList() {

		List<MemberVo> list = null;

		//1.sqlsession 받아오기
		SqlSession sqlSession = factory.openSession();
		
		//2.수행
		list = sqlSession.selectList("member.member_list");
		
		//3.닫기
		sqlSession.close();
		
		return list;
	}
	
	
	
	// mem_idx -> selectOne
	public MemberVo selectOne(int mem_idx) {

		MemberVo vo = null;

		SqlSession sqlSession = factory.openSession();
		
		vo = sqlSession.selectOne("member.member_one_mem_idx", mem_idx);
		
		sqlSession.close();

		return vo;
	}
	
	
	// mem_id -> selectOne
	public MemberVo selectOne(String mem_id) {

		MemberVo vo = null;

		SqlSession sqlSession = factory.openSession();
		
		vo = sqlSession.selectOne("member.member_one_mem_id", mem_id);
		
		sqlSession.close();

		return vo;
	}
	

	//map으로 조회
	public List<MemberVo> selectList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<MemberVo> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("member.member_list_condition", map);
		
		sqlSession.close();
		
		return list;
	}
	
	

	//추가
	public int insert(MemberVo vo) {

		int res = 0;
																		//  1  2  3  4  5  6  7
		//String sql = "insert into member values( seq_member_mem_idx.nextVal, ?, ?, ?, ?, ?, ?, ?, sysdate, '일반' )";	//sql문에 ;넣지 않도록 주의

		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.insert("member.member_insert", vo);
		
		sqlSession.close();

		return res;
	}
	
	

	public int delete(int idx) {

		int res = 0;

		//String sql = "delete from member where mem_idx=?";

		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.delete("member.member_delete", idx);
		
		sqlSession.close();

		return res;
	}

	public int update(MemberVo vo) {

		int res = 0;
 
//		수정날짜를 넣고 싶으면 새 컬럼이 존재한다고 칠 때 mem_redate=sysdate로 넣으면 됨.
		//String sql = "update member set mem_name=?, mem_id=?, mem_pwd=?,mem_email=?,mem_zipcode=?,mem_addr=?,mem_ip=?,mem_grade=? where mem_idx=?";

		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.update("member.member_update", vo);
		
		sqlSession.close();

		return res;
	}

	
	
	
	
}
