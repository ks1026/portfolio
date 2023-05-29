package action;

import java.sql.*;
import java.util.*;

import model.*;

public class MemberDAO {

	private DBConnectionMgr pool=null;//1.연결객체선언
	//공통
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;//select
	private String sql="";//실행시킬 SQL구문 저장
	
	
	public MemberDAO() {
		try {
			pool=DBConnectionMgr.getInstance();
			System.out.println("pool=>"+pool);
		}catch(Exception e) {
		   System.out.println("DB접속 오류=>"+e);	
		}
	}
	
	//1)회원가입
		public boolean memberInsert(MemberDTO mem) {
			boolean check = false; //회원가입 성공유무
			try {
				con = pool.getConnection();
				con.setAutoCommit(false); //트랜잭션 처리
				sql = "insert into Member values(?,?,?,?,?,?,?,0)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, mem.getM_id().trim());
				pstmt.setString(2, mem.getM_passwd());
				pstmt.setString(3, mem.getM_name());
				pstmt.setString(4, mem.getM_email());
				pstmt.setString(5, mem.getM_address()); 
				pstmt.setString(6, mem.getM_zipcode()); 
				pstmt.setString(7, mem.getM_phone());
				int insert = pstmt.executeUpdate();
				con.commit();//mysql인경우에는 생략
				System.out.println("insert=>" + insert);
				if(insert>0) {// if(insert==1){
					check= true; //데이터성공확인	
					sql ="insert into MemberLogin values(?,?,0)";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, mem.getM_id().trim());
					pstmt.setString(2, mem.getM_passwd());
					pstmt.executeUpdate();
					con.commit();
				}
			} catch (Exception e) {
				System.out.println("memberInsert에러유발=>" + e);
			} finally {//메모리해제
				pool.freeConnection(con,pstmt);
			}
			return check;
		}
		
		//2) ID체크 
		public boolean memberIdCheck(String id) {
			boolean check = false; //ID체크 결과 
			try {
				con = pool.getConnection();
				con.setAutoCommit(false); //트랜잭션 처리
				sql = "select m_id from Member where m_id = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id.trim());
			    rs = pstmt.executeQuery();
			    if(rs.next()) {
			    	check = true;
			    } else {
			    	check = false;
			    }
			} catch (Exception e) {
				System.out.println("memberIdCheck에러유발=>" + e);
			} finally {//메모리해제
				pool.freeConnection(con,pstmt);
			}
			return check;
		}
		
		//3)로그인
		public boolean loginCheck(String id, String passwd) {
			//1.DB연결
			boolean check = false;
			//2.sql실행->결과
			try {
				con = pool.getConnection();
				System.out.println("con=>" + con);
				sql = "select m_id from MemberLogin where m_id=? and m_passwd=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, passwd);
				rs = pstmt.executeQuery();
				check = rs.next(); //데이터가 존재한다면 true or없으면 false 
				System.out.println("check=>" + check);
			} catch (Exception e) { 
				System.out.println("loginCheck()실행에러유발=>" + e);
			} finally {//메모리해제
				pool.freeConnection(con,pstmt,rs);
			}
			return check;
		}

		//회원찾기
		public MemberDTO searchMember(String m_id) {
			MemberDTO mdto = null;
			try {
				con = pool.getConnection();
				System.out.println("con->" + con);
				sql = "select * from Member where m_id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, m_id);
				rs = pstmt.executeQuery();
					if(rs.next()) {
						mdto = new MemberDTO();
						mdto.setM_id(rs.getString("m_id"));
						mdto.setM_passwd(rs.getString("m_passwd"));
						mdto.setM_name(rs.getString("m_name"));
						mdto.setM_phone(rs.getString("m_phone"));
						mdto.setM_zipcode(rs.getString("m_zipcode"));
						mdto.setM_address(rs.getString("m_address"));
						mdto.setM_email(rs.getString("m_email"));
						mdto.setM_point(rs.getInt("m_point"));
					}
				}catch (Exception e) {
					System.out.println("searchMember()에러유발->" + e);
				} finally {//3.메모리해제
					pool.freeConnection(con,pstmt,rs);
				}
				return mdto;
		}
		
		//회원수정
		public boolean memberUpdate(MemberDTO mdto) {
			boolean check = false; //회원수정 성공유무
			try {
				con = pool.getConnection();
				con.setAutoCommit(false);//값을넣을때 트랜잭션 처리
				sql = "Update Member set m_passwd=?, m_name=?, m_email=?, m_address=?,"
						+ "m_zipcode=?, m_phone=?, m_point=? where m_id=?";
				System.out.println("id=>" + mdto.getM_id());
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, mdto.getM_passwd());
				pstmt.setString(2, mdto.getM_name());
				pstmt.setString(3, mdto.getM_email());
				pstmt.setString(4, mdto.getM_address());
				pstmt.setString(5, mdto.getM_zipcode());
				pstmt.setString(6, mdto.getM_phone());
				pstmt.setInt(7, mdto.getM_point());
				pstmt.setString(8, mdto.getM_id());
				int update = pstmt.executeUpdate();
				System.out.println("update(데이터생성유무)=>" + update);
				con.commit();
				if(update > 0) {
					check = true;
					sql ="Update MemberLogin set m_passwd=?, m_point=? where m_id=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, mdto.getM_passwd());
					pstmt.setInt(7, mdto.getM_point());
					pstmt.setString(3, mdto.getM_id());
					pstmt.executeUpdate();
					con.commit();
				}
			} catch (Exception e) {
				System.out.println("memberUpdate에러유발->" + e);
			} finally {
				pool.freeConnection(con, pstmt);
			}
			return check;
		}
	
		//회원탈퇴 
		private int memberInfoAllDelete(String m_id) {
			int result=0;
			try {
				System.out.println("memberDelete의 m_id=>" + m_id);
				con = pool.getConnection();
				con.setAutoCommit(false);
				
				String[] tableNames = {"CouponInfo", "Community", "ProductBasket"};
				
				for(int i = 0; i < tableNames.length; i++) {
					sql="delete from " + tableNames[i] + " where m_id=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, m_id);
					pstmt.executeUpdate();
				}
				
				con.commit();//실제 테이블반영
				result = 1;
				
			} catch (Exception e) {
				System.out.println("memberInfoAllDelete()에러유발=>" + e);
				result = 0;
				
			} finally {
				pool.freeConnection(con,pstmt,rs);
				result = 1;
			} 
			return result;
		}
	
		//회원탈퇴 최종 수정 9월 14일
		public int memberDelete(String m_id) {
			int delete=0;
			try {
				
				int result = memberInfoAllDelete(m_id);
				if(result > 0) {
					System.out.println("memberDelete의 m_id=>" + m_id);
					con = pool.getConnection();
					con.setAutoCommit(false);
					sql="delete from MemberLogin where m_id=?";
				
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, m_id);
					delete = pstmt.executeUpdate();
					System.out.println("delete(회원탈퇴성공유무)=>" + delete); //1
					con.commit();//실제 테이블반영 
					
					if(delete > 0) {
						sql="delete from Member where m_id=?";
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, m_id);
						pstmt.executeUpdate();
						con.commit();
					}
				}
				
			} catch (Exception e) {
				System.out.println("memberDelete()에러유발=>" + e);
			} finally {
				pool.freeConnection(con,pstmt,rs);
			} 
			return delete;
		}
		
		
		

		//id찾기
		public String idSearch(String m_name, String m_email) {
			String m_id = ""; 
			try {
				con = pool.getConnection();
				System.out.println("con->" + con);
				sql = "select m_id from Member where m_name=? and m_email=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, m_name);
				pstmt.setString(2, m_email);
				rs = pstmt.executeQuery();
					if(rs.next()) {
					m_id	= rs.getString("m_id");
					}
				}catch (Exception e) {
					System.out.println("idSearch()에러유발->" + e);
				} finally {//3.메모리해제
					pool.freeConnection(con,pstmt,rs);
				}
				return m_id;
		}
		
		//비밀번호찾기
		public boolean passwdSearch(String m_name, String m_id) {
			boolean m_passwd = false; 
			try {
				con = pool.getConnection();
				System.out.println("con->" + con);
				sql = "select m_passwd from Member where m_name=? and m_id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, m_name);
				pstmt.setString(2, m_id);
				rs = pstmt.executeQuery();
					if(rs.next()) {
					String passwd = rs.getString("m_passwd");
					 if(passwd!=null) {
						 m_passwd = true;
					 }
					}
				}catch (Exception e) {
					System.out.println("passwdSearch()에러유발->" + e);
				} finally {//3.메모리해제
					pool.freeConnection(con,pstmt,rs);
				}
				return m_passwd;
		}
		
		//새 비밀번호로 수정하기
		public boolean passwdUpdate(String m_passwd, String m_id) {
			boolean passwdUpdatecheck = false; //회원 비밀번호 수정 성공유무
			try {
				con = pool.getConnection();
				con.setAutoCommit(false);//값을넣을때 트랜잭션 처리
				sql = "Update MemberLogin set m_passwd=? where m_id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, m_passwd);
				pstmt.setString(2, m_id);
				int update = pstmt.executeUpdate();
				System.out.println("passwdupdate(데이터수정)=>" + update);
				con.commit();
				if(update > 0) {
					passwdUpdatecheck = true;
					sql ="Update Member set m_passwd=? where m_id=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, m_passwd);
					pstmt.setString(2, m_id);
					pstmt.executeUpdate();
					con.commit();
				}
			} catch (Exception e) {
				System.out.println("passwdUpdate에러유발->" + e);
			} finally {
				pool.freeConnection(con, pstmt);
			}
			return passwdUpdatecheck;
		}
		
		
}	
	