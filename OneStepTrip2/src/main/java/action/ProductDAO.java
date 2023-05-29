package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.MemberDTO;
import model.PaymentInfoDTO;
import model.ProductAllDTO;
import model.ProductAllJoinDTO;
import model.Product_dateDTO;

public class ProductDAO {

	private DBConnectionMgr pool = null;// 1.연결객체선언
	// 공통
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;// select
	private String sql = "";// 실행시킬 SQL구문 저장

	public ProductDAO() { // 생성자
		try {
			pool = DBConnectionMgr.getInstance();
			System.out.println("pool=>" + pool);
		} catch (Exception e) {
			System.out.println("DB접속 오류=>" + e);
		}
	}

	// 여행상품에 대한 정보를 뿌려줄 메서드
	public List<ProductAllDTO> searchProduct(int start, int end) {
		List<ProductAllDTO> list = new ArrayList();
		try {
			con = pool.getConnection();
			System.out.println("con->" + con);
			sql = "SELECT p.P_NUM, p.P_NAME, p.P_CONTENT, p.P_DATE, p.P_READCOUNT, p.P_PRICE, pi.PI_NUM, pi.PI_WAY \r\n"
					+ "FROM PRODUCT p\r\n"
					+ "INNER JOIN PRODUCT_IMAGE pi ON p.P_NUM = pi.P_NUM WHERE p.P_NUM BETWEEN "+ start +" AND "+ end; 
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductAllDTO pdto = new ProductAllDTO();
				pdto.setP_num(rs.getInt("p_num")); // 상품번호 i
				pdto.setP_name(rs.getString("p_name")); // 상품이름  i
				pdto.setP_content(rs.getString("p_content")); // 상품내용 
				pdto.setP_date(rs.getString("p_date")); // 등록일 
				pdto.setP_readcount(rs.getInt("p_readcount")); // 조회수 
				pdto.setP_price(rs.getInt("p_price")); // 가격 
				pdto.setPi_way(rs.getString("pi_way")); // 상품이미지경로
				
				list.add(pdto);
			}
		} catch (Exception e) {
			System.out.println("searchProduct()에러유발->" + e);
		} finally {// 3.메모리해제
			pool.freeConnection(con, pstmt, rs);
		}
		return list;
	}
	
		// 여행상품 상세보기에 대한 메서드
		public ProductAllDTO DetailProduct(int p_num) {
			ProductAllDTO pdto = null;
			try {
				con = pool.getConnection();
				System.out.println("con->" + con);
				sql = "SELECT p.P_NUM, p.P_NAME, p.P_CONTENT, p.P_DATE, p.P_READCOUNT, p.P_PRICE, pi.PI_NUM, pi.PI_WAY \r\n"
						+ "FROM PRODUCT p\r\n"
						+ "INNER JOIN PRODUCT_IMAGE pi ON p.P_NUM = pi.P_NUM WHERE p.P_NUM=?"; 
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, p_num);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					pdto = new ProductAllDTO();
					pdto.setP_num(rs.getInt("p_num")); // 상품번호 i
					pdto.setP_name(rs.getString("p_name")); // 상품이름  i
					pdto.setP_content(rs.getString("p_content")); // 상품내용 
					pdto.setP_date(rs.getString("p_date")); // 등록일 
					pdto.setP_readcount(rs.getInt("p_readcount")); // 조회수 
					pdto.setP_price(rs.getInt("p_price")); // 가격 
					pdto.setPi_way(rs.getString("pi_way")); // 상품이미지경로
					
				}
			} catch (Exception e) {
				System.out.println("DetailProduct()에러유발->" + e);
			} finally {// 3.메모리해제
				pool.freeConnection(con, pstmt, rs);
			}
			return pdto;
		}
		
		//여행상품에 대한 날짜를 조회해오는 메서드
		List<Product_dateDTO> dateProduct(int p_num) {
			List<Product_dateDTO> pdate= new ArrayList();
			try {
				con = pool.getConnection();
				System.out.println("con123->" + con);
				sql = "select pd_num, p_num, SUBSTR(PD_DATE, 0, 4) || '-' || SUBSTR(PD_DATE, 5, 2) || '-' || SUBSTR(PD_DATE, 7, 2) AS PD_DATE from Product_date where p_num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, p_num);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Product_dateDTO pdto = new Product_dateDTO();
					pdto.setPd_num(rs.getInt("pd_num")); //상품날짜에대한 pk번호
					pdto.setP_num(rs.getInt("p_num")); // 상품번호
					pdto.setPd_date(rs.getString("pd_date"));  //상품날짜
					pdate.add(pdto);
				}
			} catch (Exception e) {
				System.out.println("dateProduct()에러유발->" + e);
			} finally {// 3.메모리해제
				pool.freeConnection(con, pstmt, rs);
			}
		return pdate;
		
		}
		
		//장바구니테이블 데이터 입력
		public int BasketInsert(String id, int p_num){
			int check=0; //성공유무
			
			int pb_num = 0; //장바구니번호를 넣을 변수
			try {
				con = pool.getConnection();
				//장바구니 번호 조회
				sql = "select nvl(max(pb_num),0)+1 as max_num from ProductBasket";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					pb_num = rs.getInt("max_num");
					System.out.println("pb_num->" + pb_num);
				}
				//장바구니번호,회원아이디,상품번호 넣기
				con.setAutoCommit(false); //트랜잭션 처리
				sql = "insert into ProductBasket(pb_num, m_id, p_num) values(?,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, pb_num);
				pstmt.setString(2, id);
				pstmt.setInt(3, p_num);
				pstmt.executeUpdate();
				con.commit();
				check = 1;
			} catch (Exception e) {
				System.out.println("BasketInsert()에러유발->" + e);
			} finally {// 3.메모리해제
				pool.freeConnection(con, pstmt, rs);
			}
			return check;
		}
	

		//한 회원에 대한 여행상품 조회
		public List<ProductAllDTO> searchBasket(String m_id) {
			List<ProductAllDTO> list = new ArrayList();
			int p_num = 0; //회원이 선택한 상품번호를 담을 변수
			try {
				con = pool.getConnection();
				System.out.println("con1->" + con);
				sql = "select DISTINCT p_num from ProductBasket where m_id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, m_id);
				rs = pstmt.executeQuery(); // 2
				while(rs.next()) {
					p_num = rs.getInt("p_num");
					System.out.println("p_num=>" + p_num);
					if(p_num > 0) {
						String sql2="SELECT p.P_NUM, p.P_NAME, p.P_CONTENT, p.P_DATE, p.P_READCOUNT, p.P_PRICE, pi.PI_NUM, pi.PI_WAY\r\n"
								+ "FROM PRODUCT p INNER JOIN PRODUCT_IMAGE pi ON p.P_NUM = pi.P_NUM WHERE p.P_NUM=?";
						pstmt = con.prepareStatement(sql2);
						pstmt.setInt(1, p_num);
						ResultSet rs2 = pstmt.executeQuery();
						while(rs2.next()) {	
							ProductAllDTO pdto = new ProductAllDTO();
							pdto.setP_num(rs2.getInt("p_num")); // 상품번호 i
							pdto.setP_name(rs2.getString("p_name")); // 상품이름  i
							pdto.setP_content(rs2.getString("p_content")); // 상품내용 
							pdto.setP_date(rs2.getString("p_date")); // 등록일 
							pdto.setP_readcount(rs2.getInt("p_readcount")); // 조회수 
							pdto.setP_price(rs2.getInt("p_price")); // 가격 
							pdto.setPi_way(rs2.getString("pi_way")); // 상품이미지경로
							list.add(pdto);
						}
					}
				}
			} catch (Exception e) {
				System.out.println("searchBasket()에러유발->" + e);
			} finally {// 3.메모리해제
				pool.freeConnection(con, pstmt, rs);
			}
			return list;
		}
		
		//한 회원에 대한 여행상품 조회 (날짜 포함)
		public List<ProductAllJoinDTO> searchBasketDate(String m_id) {
			List<ProductAllJoinDTO> list = new ArrayList();
			int p_num = 0; //회원이 선택한 상품번호를 담을 변수
			try {
				con = pool.getConnection();
				System.out.println("con1->" + con);
				sql = "select DISTINCT p_num from ProductBasket where m_id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, m_id);
				rs = pstmt.executeQuery(); // 2
				while(rs.next()) {
					p_num = rs.getInt("p_num");
					System.out.println("p_num=>" + p_num);
					if(p_num > 0) {
						String sql2 = "SELECT ? AS M_ID\r\n"
								+ "     , MAX(R.P_NUM) AS P_NUM\r\n"
								+ "     , MAX(R.P_NAME) AS P_NAME\r\n"
								+ "     , CASE \r\n"
								+ "	     WHEN MAX(R.PI_NUM) BETWEEN 1 AND 6 THEN CONCAT('asia/', MAX(R.PI_WAY)) \r\n"
								+ "	     WHEN MAX(R.PI_NUM) BETWEEN 7 AND 12 THEN CONCAT('europe/', MAX(R.PI_WAY)) \r\n"
								+ "	     WHEN MAX(R.PI_NUM) BETWEEN 13 AND 14 THEN CONCAT('oceania/', MAX(R.PI_WAY)) \r\n"
								+ "	     WHEN MAX(R.PI_NUM) BETWEEN 15 AND 16 THEN CONCAT('northAmerica/', MAX(R.PI_WAY)) \r\n"
								+ "       END AS PI_WAY\r\n"
								+ "     , MIN(R.PD_DATE) AS S_DATE\r\n"
								+ "     , MAX(R.PD_DATE) AS E_DATE\r\n"
								+ "     , 1 AS PERSON_CNT\r\n"
								+ "     , MAX(P_PRICE) AS P_PRICE\r\n"
								+ "  FROM (\r\n"
								+ "  	SELECT p.P_NUM, p.P_NAME, p.P_CONTENT, p.P_DATE, p.P_READCOUNT, p.P_PRICE, pi.PI_NUM, pi.PI_WAY\r\n"
								+ "	     , pd.PD_DATE \r\n"
								+ "	  FROM PRODUCT p \r\n"
								+ "	  INNER JOIN PRODUCT_IMAGE pi \r\n"
								+ "	  ON p.P_NUM = pi.P_NUM\r\n"
								+ "	  LEFT OUTER JOIN PRODUCT_DATE pd \r\n"
								+ "	  ON p.P_NUM = pd.P_NUM \r\n"
								+ "	 WHERE p.P_NUM = ?\r\n"
								+ "  ) R\r\n";
						pstmt = con.prepareStatement(sql2);
						pstmt.setString(1, m_id); // 회원아이디
						pstmt.setInt(2, p_num); // 상품번호
						ResultSet rs2 = pstmt.executeQuery();
						while(rs2.next()) {	
							ProductAllJoinDTO pdto = new ProductAllJoinDTO();
							pdto.setM_id(rs2.getString("m_id")); // 회원아이디 
							pdto.setP_num(rs2.getInt("p_num")); // 상품번호 i
							pdto.setP_name(rs2.getString("p_name")); // 상품이름  i
							pdto.setPi_way(rs2.getString("pi_way")); // 상품이미지경로
							pdto.setS_date(rs2.getString("s_date")); // 출발일 
							pdto.setE_date(rs2.getString("e_date")); // 종료일
							pdto.setP_price(rs2.getInt("p_price")); // 결제금액 
							list.add(pdto);
						}
					}
				}
			} catch (Exception e) {
				System.out.println("searchBasket()에러유발->" + e);
			} finally {// 3.메모리해제
				pool.freeConnection(con, pstmt, rs);
			}
			return list;
		}
		
		// 장바구니에서 삭제 
		public int BasketDelete(String id, int p_num){
			int check=0; //성공유무
			
			int pb_num = 0; //장바구니번호를 넣을 변수
			try {
				con = pool.getConnection();
				con.setAutoCommit(false); //트랜잭션 처리
				sql = "delete from ProductBasket where m_id=? and p_num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setInt(2, p_num);
				pstmt.executeUpdate();
				con.commit();
				check = 1;
			} catch (Exception e) {
				System.out.println("BasketDelete()에러유발->" + e);
			} finally {// 3.메모리해제
				pool.freeConnection(con, pstmt, rs);
			}
			return check;
		}
		
		
		//결제정보 데이터 입력
		public int insertPay(String m_id, int total, String payment){
			int check=0; //성공유무
			ProductAllJoinDTO pdto = null;
			int pay_num = 0; //결제번호
			String pay_refund="N";//환불유무
			
			try {
				List<ProductAllJoinDTO> pAlldto = searchBasketDate(m_id);//한회원에 대한 상품정보(날짜포함)
				for(int i = 0; i < pAlldto.size(); i++) {
					pdto = pAlldto.get(i);
					
					con = pool.getConnection();
					//결제테이블 pk번호 조회
					sql = "select nvl(max(pay_num),0)+1 as pay_num from PaymentInfo";
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();
					while(rs.next()) {
						pay_num = rs.getInt("pay_num");
						System.out.println("pb_num->" + pay_num);
					}
					//insert
					con.setAutoCommit(false); //트랜잭션 처리
					sql = "insert into PaymentInfo(pay_num, p_num, m_id, pay_date, pay_price,pay_payment,pay_paydate,pay_refund) values(?,?,?,?,?,?,sysdate,?)";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, pay_num); //결제번호
					pstmt.setInt(2, pdto.getP_num());//상품번호
					pstmt.setString(3, m_id);//회원아이디
					pstmt.setString(4, pdto.getS_date());//상품날짜(시작일)
					pstmt.setInt(5, total);//결제금액
					pstmt.setString(6, payment);//결제수단
					pstmt.setString(7, pay_refund);//결제일자
					pstmt.executeUpdate();
					con.commit();
					check = 1;
				}	
			} catch (Exception e) {
				System.out.println("insertPay()에러유발->" + e);
			} finally {// 3.메모리해제
				pool.freeConnection(con, pstmt, rs);
			}
			return check;
		}
		
		
		//결제정보 데이터 조회
		List<PaymentInfoDTO>payInfo(String m_id){
			List<PaymentInfoDTO> list = new ArrayList();
			try {
				sql = "SELECT pi.pay_num, pi.p_num, pi.m_id, pi.pay_date, pi.pay_price, pi.pay_payment, pi.pay_paydate, pi.pay_refund, p.p_name\r\n"
						+ "FROM PAYMENTINFO pi LEFT OUTER JOIN PRODUCT p \r\n"
						+ "ON pi.P_NUM  = p.P_NUM where pi.m_id=?";
				con = pool.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, m_id);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					PaymentInfoDTO pdto = new PaymentInfoDTO();
					pdto.setPay_num(rs.getInt("pay_num"));//결제번호
					pdto.setP_num(rs.getInt("p_num"));//상품번호
					pdto.setM_id(rs.getString("m_id"));//회원아이디
					pdto.setPay_date(rs.getString("pay_date"));//상품날짜
					pdto.setPay_price(rs.getInt("pay_price"));//결제금액
					pdto.setPay_payment(rs.getString("pay_payment"));//결제수단
					pdto.setPay_paydate(rs.getString("pay_paydate"));//결제일자
					pdto.setPay_refund(rs.getString("pay_refund"));//환불유무
					pdto.setP_name(rs.getString("p_name"));//상품명
					list.add(pdto);
				}
			} catch (Exception e) {
				System.out.println("payInfo()에러유발->" + e);
			} finally {// 3.메모리해제
				pool.freeConnection(con, pstmt, rs);
			}
			return list;
		}
			
		
		//결제정보데이터삭제
		int deletePaymentInfo(String m_id) {
			int check = 0;//결제 데이터 삭제 성공유무
			try {
				con = pool.getConnection();
				con.setAutoCommit(false); //트랜잭션 처리
				sql = "delete from PaymentInfo where m_id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, m_id);
				pstmt.executeUpdate();
				con.commit();
				check=1;
			} catch (Exception e) {
				System.out.println("deletePaymentInfo()에러유발->" + e);
			} finally {// 메모리해제
				pool.freeConnection(con, pstmt, rs);
			}
			return check;
		}
		
		
		
		
		
}
