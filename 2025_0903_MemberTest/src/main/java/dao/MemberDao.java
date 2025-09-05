package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.vo.MemberVo;
import service.DBService;

public class MemberDao {

	//single-ton
	static MemberDao single = null;

	public static MemberDao getInstance() {

		if (single == null)
			single = new MemberDao();

		return single;
	}

	private MemberDao() {

	}
	
	public List<MemberVo> selectList() {

		List<MemberVo> list = new ArrayList<MemberVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from member";

		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement얻기
			pstmt = conn.prepareStatement(sql);

			//3.ResultSet 얻어오기
			rs = pstmt.executeQuery();

			//레코드값을 VO포장후 list넣는다
			while (rs.next()) {

				MemberVo vo = new MemberVo();
				//rs가 가리키는 레코드값을 vo에 넣는다
				vo.setMem_idx(rs.getInt("mem_idx"));
				vo.setMem_name(rs.getString("mem_name"));
				vo.setMem_id(rs.getString("mem_id"));
				vo.setMem_pwd(rs.getString("mem_pwd"));
				vo.setMem_email(rs.getString("mem_email"));
				vo.setMem_zipcode(rs.getString("mem_zipcode"));
				vo.setMem_addr(rs.getString("mem_addr"));
				vo.setMem_ip(rs.getString("mem_ip"));
				vo.setMem_regdate(rs.getString("mem_regdate"));
				vo.setMem_grade(rs.getString("mem_grade"));
				
				

				list.add(vo);
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

		return list;
	}
	
	// mem_idx -> selectOne
	public MemberVo selectOne(int mem_idx) {

		MemberVo vo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from member where mem_idx=?";

		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement얻기
			pstmt = conn.prepareStatement(sql);

			//3.PrepareStatement Parameter설정
			pstmt.setInt(1, mem_idx);

			//3.ResultSet 얻어오기
			rs = pstmt.executeQuery();

			if (rs.next()) {

				vo = new MemberVo();
				//rs가 가리키는 레코드값을 vo에 넣는다
				vo.setMem_idx(rs.getInt("mem_idx"));
				vo.setMem_name(rs.getString("mem_name"));
				vo.setMem_id(rs.getString("mem_id"));
				vo.setMem_pwd(rs.getString("mem_pwd"));
				vo.setMem_email(rs.getString("mem_email"));
				vo.setMem_zipcode(rs.getString("mem_zipcode"));
				vo.setMem_addr(rs.getString("mem_addr"));
				vo.setMem_ip(rs.getString("mem_ip"));
				vo.setMem_regdate(rs.getString("mem_regdate"));
				vo.setMem_grade(rs.getString("mem_grade"));

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
	
	
	// mem_id -> selectOne
	public MemberVo selectOne(String mem_id) {

		MemberVo vo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from member where mem_id=?";

		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement얻기
			pstmt = conn.prepareStatement(sql);

			//3.PrepareStatement Parameter설정
			pstmt.setString(1, mem_id);

			//3.ResultSet 얻어오기
			rs = pstmt.executeQuery();

			if (rs.next()) {

				vo = new MemberVo();
				//rs가 가리키는 레코드값을 vo에 넣는다
				vo.setMem_idx(rs.getInt("mem_idx"));
				vo.setMem_name(rs.getString("mem_name"));
				vo.setMem_id(rs.getString("mem_id"));
				vo.setMem_pwd(rs.getString("mem_pwd"));
				vo.setMem_email(rs.getString("mem_email"));
				vo.setMem_zipcode(rs.getString("mem_zipcode"));
				vo.setMem_addr(rs.getString("mem_addr"));
				vo.setMem_ip(rs.getString("mem_ip"));
				vo.setMem_regdate(rs.getString("mem_regdate"));
				vo.setMem_grade(rs.getString("mem_grade"));

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

	//추가
	public int insert(MemberVo vo) {

		int res = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
																		//  1  2  3  4  5  6  7
		String sql = "insert into member values( seq_member_mem_idx.nextVal, ?, ?, ?, ?, ?, ?, ?, sysdate, '일반' )";	//sql문에 ;넣지 않도록 주의

		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement얻기
			pstmt = conn.prepareStatement(sql);

			//3.PrepareStatement Parameter설정
			pstmt.setString(1, vo.getMem_name());
			pstmt.setString(2, vo.getMem_id());
			pstmt.setString(3, vo.getMem_pwd());
			pstmt.setString(4, vo.getMem_email());
			pstmt.setString(5, vo.getMem_zipcode());
			pstmt.setString(6, vo.getMem_addr());
			pstmt.setString(7, vo.getMem_ip());

			//4.DB Insert
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

	public int delete(int idx) {

		int res = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "delete from member where mem_idx=?";

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

	public int update(MemberVo vo) {

		int res = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
//		수정날짜를 넣고 싶으면 새 컬럼이 존재한다고 칠 때 mem_redate=sysdate로 넣으면 됨.
		String sql = "update member set mem_name=?, mem_id=?, mem_pwd=?,mem_email=?,mem_zipcode=?,mem_addr=?,mem_ip=?,mem_grade=? where mem_idx=?";

		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement얻기
			pstmt = conn.prepareStatement(sql);

			//3.PrepareStatement Parameter설정
			pstmt.setString(1, vo.getMem_name());
			pstmt.setString(2, vo.getMem_id());
			pstmt.setString(3, vo.getMem_pwd());
			pstmt.setString(4, vo.getMem_email());
			pstmt.setString(5, vo.getMem_zipcode());
			pstmt.setString(6, vo.getMem_addr());
			pstmt.setString(7, vo.getMem_ip());
			pstmt.setString(8, vo.getMem_grade());
			pstmt.setInt(9, vo.getMem_idx());
			
			
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
