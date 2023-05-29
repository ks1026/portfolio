package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.MemberDTO;
import model.PaymentInfoDTO;
import model.ProductAllDTO;
import model.ProductAllJoinDTO;
import model.Product_dateDTO;

public class AdminDAO {

	private DBConnectionMgr pool = null;// 1.연결객체선언
	// 공통
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;// select
	private String sql = "";// 실행시킬 SQL구문 저장

	public AdminDAO() { // 생성자
		try {
			pool = DBConnectionMgr.getInstance();
			System.out.println("pool=>" + pool);
		} catch (Exception e) {
			System.out.println("DB접속 오류=>" + e);
		}
	}

	// 메인페이지 6개 여행장소 이미지 데이터 조회
	public List<Map<String, Object>> searchMainImages() {
		List<Map<String, Object>> list = new ArrayList();
		try {
			con = pool.getConnection();
			System.out.println("con->" + con);
			sql = "SELECT PI_NUM, PI_WAY, ROWNUM AS RNUM FROM PRODUCT_IMAGE WHERE P_NUM = 99 ORDER BY PI_NUM";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Map<String, Object> item = new HashMap<String, Object>();
				item.put("pi_num", rs.getInt("pi_num")); // 상품번호
				item.put("pi_way", rs.getString("pi_way")); // 상품이미지경로
				item.put("rnum", rs.getInt("rnum")); // 순번

				list.add(item);
			}
		} catch (Exception e) {
			System.out.println("searchMainImages()에러유발->" + e);
		} finally {// 3.메모리해제
			pool.freeConnection(con, pstmt, rs);
		}
		return list;
	}

	// 이미지명 업데이트
	int updateImageName(String pi_num, String fileName) {
		int check = 0;
		try {
			con = pool.getConnection();
			con.setAutoCommit(false); // 트랜잭션 처리
			sql = "UPDATE PRODUCT_IMAGE SET PI_WAY = ? WHERE PI_NUM = ? AND P_NUM = 99";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, fileName);
			pstmt.setInt(2, Integer.parseInt(pi_num));
			pstmt.executeUpdate();
			con.commit();
			check = 1;
		} catch (Exception e) {
			System.out.println("updateImageName()에러유발->" + e);
		} finally {// 메모리해제
			pool.freeConnection(con, pstmt, rs);
		}
		return check;
	}

}
