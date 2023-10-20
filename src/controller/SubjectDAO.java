package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.SubjectVO;

public class SubjectDAO {

	public void getSubjectTotalList() throws Exception {
		String sql = "select * from subject order by no";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SubjectVO sVo = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("일련번호\t학과번호\t학과명");

			while (rs.next()) {
				sVo = new SubjectVO();
				sVo.setNo(rs.getInt("no"));
				sVo.setS_num(rs.getString("s_num"));
				sVo.setS_name(rs.getString("s_name"));

				System.out.println(sVo.getNo() + "\t" + sVo.getS_num() + "\t" + sVo.getS_name());
			}

		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (con != null) {
				con.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}

		}

	}

	public void setSubjectRegiste(SubjectVO svo) throws Exception {
		String sql = "insert into subject(s_num, s_name) values(?, ?)";

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, svo.getS_num());
			pstmt.setString(2, svo.getS_name());

			int i = pstmt.executeUpdate();

			if (i == 1) {
				System.out.println(svo.getS_name() + " 학과 등록 완료.");
				System.out.println("학과 등록 성공!!!");
			} else {
				System.out.println("학과 등록 실패!!!");
			}

		} catch (SQLException e) {
			System.out.println("e=[" + e + "]");
		} catch (Exception e) {
			System.out.println("e=[" + e + "]");
		} finally {
			if (con != null) {
				con.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}

		}
	}

	public void setSubjectUpdate(SubjectVO svo) throws Exception {
		String sql = "update subject set s_num=?, s_name=? where no=?";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, svo.getS_num());
			pstmt.setString(2, svo.getS_name());
			pstmt.setInt(3, svo.getNo());

			int i = pstmt.executeUpdate();

			if (i == 1) {
				System.out.println(svo.getS_name() + " 학과 수정 완료.");
				System.out.println("학과 수정 성공!!!");
			} else {
				System.out.println("학과 수정 실패!!!");
			}
		} catch (SQLException e) {
			System.out.println("e=[" + e + "]");
		} catch (Exception e) {
			System.out.println("e=[" + e + "]");
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}

	}

	public void setSubjectDelete(int no) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from subject where no = ?");
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				System.out.println("학과 삭제 완료.");
				System.out.println("학과 삭제 성공!!!");
			} else {
				System.out.println("학과 삭제 실패!!!");
			}
		} catch (SQLException e) {
			System.out.println("e=[" + e + "]");
		} catch (Exception e) {
			System.out.println("e=[" + e + "]");
		} finally {
			try {
				// 데이터베이스와의 연결에 사용되었던 오브젝트를 해제
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
	}

}
