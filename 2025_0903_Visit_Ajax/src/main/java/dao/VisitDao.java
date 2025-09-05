package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.vo.VisitVo;
import service.DBService;

//DAO(Data Access Object)
// : CRUD 처리 객체

//다양한 객체에게서 처리요청을 받기 때문에 싱글톤으로  생성

public class VisitDao {

	//single-ton
	static VisitDao single = null;

	public static VisitDao getInstance() {
		if (single == null)
			single = new VisitDao();

		return single;
	}

	private VisitDao() {

	}
	
	//조회
	public List<VisitVo> selectList() {

		List<VisitVo> list = new ArrayList<VisitVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

											//최신순으로 정렬
		String sql = "select * from visit order by idx desc";

		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement 얻기
			pstmt = conn.prepareStatement(sql);

			//3.ResultSet 얻기
			rs = pstmt.executeQuery();

			//레코드값을 VO로 포장후 list에 넣기
			while (rs.next()) {
				VisitVo vo = new VisitVo();

				//rs가 가리키는 레코드값을 vo에 넣기
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setContent(rs.getString("content"));
				vo.setPwd(rs.getString("pwd"));
				vo.setIp(rs.getString("ip"));
				vo.setRegdate(rs.getString("regdate"));	//날짜형도 String으로 받기
				
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			//alt+shift+z
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}

	
	//추가
	public int insert(VisitVo vo) {

		int res = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		//															   1, 2, 3, 4 <- pstmt parameter index
		String sql = "insert into visit values( seq_visit_idx.nextVal, ?, ?, ?, ?, sysdate )";

		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement얻기
			pstmt = conn.prepareStatement(sql);

			//3.PrepareStatement Parameter설정 (이 부분만 바꿔서 실행)
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getIp());

			//4.DB Insert (DML 명령에서는 처리된 행수가 return 됨 : insert는 무조건 1리턴)
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return res;
	}

	
	
	
	//삭제 템플릿
	public int delete(int idx) {

		int res = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

												// 1 <- pstmt parameter index
		String sql = "delete from visit  where idx=?";

		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement얻기
			pstmt = conn.prepareStatement(sql);

			//3.PrepareStatement Parameter설정
			pstmt.setInt(1, idx);

			//4.DB delete
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return res;
	}

	//idx 에 해당하는 1건 데이터 조회
	public VisitVo selectOne(int idx) {

		VisitVo vo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from visit where idx=?";

		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement얻기
			pstmt = conn.prepareStatement(sql);

			//3.PrepareStatement Parameter설정
			pstmt.setInt(1, idx);

			//3.ResultSet 얻어오기
			rs = pstmt.executeQuery();

			if (rs.next()) {

				vo = new VisitVo();
				//rs가 가리키는 레코드값을 vo에 넣는다
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setContent(rs.getString("content"));
				vo.setPwd(rs.getString("pwd"));
				vo.setIp(rs.getString("ip"));
				vo.setRegdate(rs.getString("regdate"));

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return vo;
	}

	public int update(VisitVo vo) {

		int res = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		//									1		  2		3	4			  5	 <- pstmt parameter index
		String sql = "update visit set name=?,content=?,pwd=?,ip=?  where idx=?";

		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement얻기
			pstmt = conn.prepareStatement(sql);

			//3.PrepareStatement Parameter설정
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getIp());
			pstmt.setInt(5, vo.getIdx());
			
			
			//4.DB update
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return res;
	}
	
	
}
