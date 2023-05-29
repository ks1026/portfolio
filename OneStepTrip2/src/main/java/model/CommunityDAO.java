package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//ArrayList,HashTable,,
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import action.DBConnectionMgr;

public class CommunityDAO {
	private DBConnectionMgr pool=null;
	//공통
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;//select
	private String sql="";//실행시킬 SQL구문
	
	//2.생성자를  통해서 연결
	public CommunityDAO() {
		try {
			pool=DBConnectionMgr.getInstance();
			System.out.println("pool=>"+pool);
		}catch(Exception e) {
		System.out.println("DB접속 오류=>"+e);	
		}
	}
	//3.메서드 작성(페이징 처리를 위한 메서드)
	public int getArticleCount() {//getMemberCount()
		int x=0;//총 레코드수
		try {
			con=pool.getConnection();
			System.out.println("con=>"+con);
			sql="select count(*) from community";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				x=rs.getInt(1);//여기서는 필드명X
			}
		}catch(Exception e) {
			System.out.println("getArticleCount() 에러유발=>"+e);
		}finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return x;
	}
	
	//1.검색어에 해당되는 총 레코드수를 구하는 메서드(검색분야,검색어)
	public int getArticleSearchCount(String search,String searchtext) {
		int x=0;//총 레코드수
		try {
			con=pool.getConnection();
			System.out.println("con=>"+con);
			//-------------------------------------
			if(search==null || search=="") {//검색분야 선택X
				sql="select count(*) from community";
			}else {//검색분야(작성자,제목,제목+본문)
				if(search.equals("c_subject_c_content")) {//제목+본문 선택한경우
					sql="select count(*) from community where c_subject like '%"+
							searchtext+"%' or c_content like '%"+searchtext+"%' ";
				}else {//제목 or 작성자 -> 매개변수를 이용해서 하나의 sql통합
					sql="select count(*) from community where "+search+" like '%"+
							searchtext+"%' ";
				}
			}
			System.out.println("getArticleSearchCount 검색sql=>"+sql);
			//-------------------------------------
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				x=rs.getInt(1);//여기서는 필드명X
			}
		}catch(Exception e) {
			System.out.println("getArticleSearchCount() 에러유발=>"+e);
		}finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return x;
	}
	
	
	//2.글목록보기에 대한 메서드구현
	public List<CommunityDTO> getArticles(int start,int end){
		List<CommunityDTO> articleList=null;
		
		try {
			con=pool.getConnection();
			sql = "SELECT * "
					+ "  FROM ( "
					+ "  	SELECT rownum AS RNUM, C_NUM, M_ID, C_SUBJECT, C_CONTENT, C_DATE, C_READCOUNT, REF, RE_LEVEL, RE_STEP  "
					+ "	  FROM ( "
					+ "	  	select * "
					+ "		  from community "
					+ "		  order by ref desc,re_step  "
					+ "	  ) "
					+ "  ) "
					+ " WHERE RNUM >= ? AND RNUM <= ? ";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);//불러와서 담을 갯수
			rs=pstmt.executeQuery();
			if(rs.next()) {//보여주는 결과가 있다면
				System.out.println("???????????");
				articleList=new ArrayList(end);//end갯수만큼 데이터담을공간생성
				do {
					CommunityDTO article=makeArticleFromResult();	
					articleList.add(article);
				}while(rs.next());
			}
		}catch(Exception e) {
			System.out.println("getArticles 에러유발=>"+e);
		}finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return articleList;
	}
	
	//(2) 검색어에 따른 레코드의 범위지정에 대한 메서드
	public List<CommunityDTO>getBoardArticles
							(int start,int end,String search,String searchtext){
		List<CommunityDTO> articleList=null;
		
		try {
			con=pool.getConnection();
			//----------------------------------------------------------------
			if(search==null || search=="") {
				sql="SELECT *\r\n"
						+ "  FROM (\r\n"
						+ "  	SELECT rownum AS RNUM, C_NUM, M_ID, C_SUBJECT, C_CONTENT, C_DATE, C_READCOUNT, REF, RE_LEVEL, RE_STEP  \r\n"
						+ "	  FROM (\r\n"
						+ "	  	select * \r\n"
						+ "		  from community \r\n"
						+ "		  order by ref desc,re_step  \r\n"
						+ "	  )\r\n"
						+ "  )\r\n"
						+ " WHERE rnum >= ? AND rnum <= ?";
			}else {//제목+본문
				if(search.equals("c_subject_c_content")) {//제목+본문 선택한경우
//					sql="select * from community where c_subject like '%"+
//							searchtext+"%' or c_content like '%"+searchtext+"%' order by ref desc,re_step limit ?,?";
					
					sql = "SELECT *\r\n"
							+ "  FROM (\r\n"
							+ "  	SELECT rownum AS RNUM, C_NUM, M_ID, C_SUBJECT, C_CONTENT, C_DATE, C_READCOUNT, REF, RE_LEVEL, RE_STEP  \r\n"
							+ "	  FROM (\r\n"
							+ "	  	select * \r\n"
							+ "		  from community \r\n"
							+ "		  WHERE C_SUBJECT LIKE '%"  + searchtext  + "%' OR c_content LIKE '%" + searchtext + "%'\r\n"
							+ "		  order by ref desc,re_step  \r\n"
							+ "	  )\r\n"
							+ "  )\r\n"
							+ " WHERE rnum >= ? AND rnum <= ?";
				}else {//제목 or 작성자 -> 매개변수를 이용해서 하나의 sql통합
//					sql="select * from community where "+search+" like '%"+
//							searchtext+"%' order by ref desc,re_step limit ?,?";
					
					sql = "SELECT *\r\n"
							+ "  FROM (\r\n"
							+ "  	SELECT rownum AS RNUM, C_NUM, M_ID, C_SUBJECT, C_CONTENT, C_DATE, C_READCOUNT, REF, RE_LEVEL, RE_STEP  \r\n"
							+ "	  FROM (\r\n"
							+ "	  	select * \r\n"
							+ "		  from community \r\n"
							+ "		  WHERE " + search + " LIKE '%" + searchtext + "%'\r\n"
							+ "		  order by ref desc,re_step  \r\n"
							+ "	  )\r\n"
							+ "  )\r\n"
							+ " WHERE rnum >= ? AND rnum <= ? ";
				}
			}
			System.out.println("getBoardArticles()의 sql=>"+sql);
			//----------------------------------------------------------------
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs=pstmt.executeQuery();
			if(rs.next()) {//보여주는 결과가 있다면
				articleList=new ArrayList(end);
				do {
					CommunityDTO article=new CommunityDTO();
					article.setC_num(rs.getInt("c_num"));
					article.setM_id(rs.getString("m_id"));
					article.setC_subject(rs.getString("c_subject"));
					article.setDate(rs.getDate("c_date"));
					article.setC_readcount(rs.getInt("c_readcount"));
					article.setRef(rs.getInt("ref"));
					article.setRe_step(rs.getInt("re_step"));
					article.setRe_level(rs.getInt("re_level"));
					article.setC_content(rs.getString("c_content"));
					//추가
					articleList.add(article);
				}while(rs.next());
			}
		}catch(Exception e) {
			System.out.println("getBoardArticles 에러유발=>"+e);
		}finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return articleList;
	}
	//-------------------------------------------------
	//(3)페이징 처리 계산 정리해주는 메서드(ListAction)
	public Hashtable pageList(String pageNum,int count) {
		//1. 페이징 처리결과를 저장할 Hashtable객체를 선언 
		
				Hashtable<String,Integer>pgList=new Hashtable<String,Integer>();
		
				int pageSize=10;
				int blockSize=10;
				
				//게시판을 맨 처음 실행시키면 무조건 1페이지부터 출력->가장 최근의 글부터
				if(pageNum==null){
					pageNum="1";//default(무조건 처음에는 1페이지부터 보여줘야하기때문)
				}
				int currentPage=Integer.parseInt(pageNum);
             
				int startRow=(currentPage-1)*pageSize+1;
				int endRow=currentPage*pageSize;
				
				System.out.println("startRow : " + startRow);
				System.out.println("endRow : " + endRow);
				
				int number=0;//페이지별로 시작하는 맨처음에 나오는게시물번호
				System.out.println("현재 레코드수(count)=>"+count);
				
				List<CommunityDTO> articleList=null;//화면에 출력할 레코드를 저장할변수
				
				CommunityDAO dbPro=new CommunityDAO();
				count=dbPro.getArticleCount();//select count(*) from community;
				System.out.println("현재 레코드수(count)=>"+count);
				if(count>0){					//첫번째레코드번호,불러올갯수
					articleList=dbPro.getArticles(startRow, pageSize);
					System.out.println("ListAction의 articleList=>"+articleList);//null
				}
				number=count-(currentPage-1)*pageSize;
				System.out.println("페이지별로 number=>"+number);
				
				//총페이지수,시작,종료페이지 계산->list.jsp에서 이미 코딩
				//모델1에서의 list.jsp에서 복사해온다.
				//1.총페이지수 구하기
				//						122/10=12.2+122%10=>1 12.2+1.0=13.2=13
				int pageCount=count/pageSize+(count%pageSize==0?0:1);	
				//																		=>count%pageSize가 0이 떨어지면 0 아니면 1
				//2.시작페이지
				int startPage=0;
				if(currentPage%blockSize!=0){//1~9,11~19,21~29(10의배수X경우)
					startPage=currentPage/blockSize*blockSize+1;//경계선때문
				}else{//10%10=0(10,20,30,40,,)
									//((10/10)-1)*10+1=1 ,2->11
					startPage=((currentPage/blockSize)-1)*blockSize+1;
				}
				//3.종료페이지
				int endPage=startPage+blockSize-1;//1+10-1=10,2+10-1=11
				System.out.println
				      ("startPage=>"+startPage+",endPage=>"+endPage);
				//4.블럭별로 구분해서 링크 걸어서 출력()
				if(endPage > pageCount) endPage=pageCount;//마지막=총페이지수
				//페이징 처리에 대한 계산결과=>Hashtable,HashMap
				//ListAction에 전달->메모리에 저장,공유->list.jsp로 전달
				pgList.put("pageSize", pageSize);//<->pgList.get(키명)
				pgList.put("blockSize", blockSize);
				pgList.put("currentPage", currentPage);
				pgList.put("startRow", startRow);
				pgList.put("endRow", endRow);
				pgList.put("count", count);
				pgList.put("number", number);
				pgList.put("startPage", startPage);
				pgList.put("endPage", endPage);
				pgList.put("pageCount", pageCount);
				
				return pgList;//ListAction에게 리턴해준다.
	}
	
	//게시판에 글쓰기 및 답변달기
	//insert into board values(?,?,,,)
	public void insertArticle(CommunityDTO article) {
		//1.article->신규글인지 답변글인지(기존 게시물번호)인지 확인
		int c_num=article.getC_num();//0->신규글<->0이 아닌경우(양수) 답변글
		int ref=article.getRef();
		int re_step=article.getRe_step();
		int re_level=article.getRe_level();
		int number=0;//데이터를 저장하기위한 게시물번호(=New)
		try {
			con=pool.getConnection();
			sql="select max(c_num) from community"; // 글번호 
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {//데이터가 있다면
				number=rs.getInt(1)+1;//최대값+1
			}else {
				number=1;//테이블에 한개의 데이터가 없다면 최초 1부여
			}
			//답변글이라면
			if(c_num!=0) {
				//같은 그룹번호를 가지고 있으면서 나보다 step값이 큰 게시물을 찾아서 step하나 증가
				sql="update community set re_step=re_step+1 where ref=? and re_step>?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, ref);
				pstmt.setInt(2, re_step);
				int update=pstmt.executeUpdate();
				//1 성공(댓글만들어지는 위치)  0 실패
				System.out.println("댓글수정유무(update)=>"+update);
				//답변글
				re_step=re_step+1;
				re_level=re_level+1;
			}else {//신규글이라면 c_num=0
				ref=number;
				re_step=0;//답변순서X
				re_level=0;//답변X
			}
		
			sql="insert into community(c_num,m_id,c_subject,ref,re_step,re_level,c_content,c_date,c_readcount)values((select NVL(max(c_num), 0)+1 from community),?,?,?,?,?,?,sysdate,0)";
			System.out.println("article.getC_num()=->" + article.getC_num());
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, article.getM_id());
			pstmt.setString(2, article.getC_subject());
			pstmt.setInt(3, ref);//최대값+1
			pstmt.setInt(4, re_step);//0
			pstmt.setInt(5, re_level);//0
			pstmt.setString(6, article.getC_content());

			int insert=pstmt.executeUpdate();
			System.out.println("insert : " + insert);
			System.out.println("게시판의 글쓰기성공유무(insert)=>"+insert);//1 or 0
			
		}catch(Exception e) {
			System.out.println("insertArticle()메서드 에러유발=>"+e);
		}finally {
			pool.freeConnection(con, pstmt, rs);
		}
	}//insertArticle
	//글 상세보기->소스코드를 적게 사용하는 방법을 선택
	//select * from board where num=1;
	//update board set readcount=readcount+1 where num=1;//1번게시물 조회수증가
	//public MemberDTO getMember(String id){~}
	
	public CommunityDTO getArticle(int c_num) {
		CommunityDTO article=null;
		try {
			con=pool.getConnection();
			sql="update community set c_readcount=c_readcount+1 where c_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, c_num);
			int update=pstmt.executeUpdate();
			System.out.println("조회수 증가유무(update)=>"+update);
			
			sql="select * from community where c_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, c_num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {//레코드가 최소 만족1개이상 존재한다면
				article=makeArticleFromResult();
			}
		}catch(Exception e) {
			System.out.println("getArticle 에러유발=>"+e);
		}finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return article;//content.jsp에서 받아서 출력->NullPointerException
	}
	//접근지정자가 private가 되는 경우=>외부에서 호출X 내부 클래스사용O
	private CommunityDTO makeArticleFromResult()throws Exception {
		CommunityDTO article=new CommunityDTO();
		article.setC_num(rs.getInt("c_num"));
		article.setM_id(rs.getString("m_id"));//부적합한 열입니다.
		article.setC_subject(rs.getString("c_subject"));
		article.setDate(rs.getDate("c_date"));//작성날짜
		article.setC_readcount(rs.getInt("c_readcount"));//조회수 defalut=0
		article.setRef(rs.getInt("ref"));//그룹번호->신규글,답변글 묶어줌
		article.setRe_step(rs.getInt("re_step"));//답변글 나오는순서
		article.setRe_level(rs.getInt("re_level"));//들여쓰기 유무
		article.setC_content(rs.getString("c_content"));//글내용
		return article;
	}
	//select * from board where num=3;
	//글수정
	//1)수정할 데이터를 찾을 메서드 필요
	public CommunityDTO updateGetArticle(int c_num) {
		CommunityDTO article=null;
		try {
			con=pool.getConnection();
			sql="select * from community where c_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, c_num);
			rs=pstmt.executeQuery();
			if(rs.next()) {//레코드가 최소 만족1개이상 존재한다면
				article=makeArticleFromResult();
			}
		}catch(Exception e) {
			System.out.println("updateGetArticle() 에러유발=>"+e);
		}finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return article;//updateForm.jsp에서 반환받기
	}
	//2)수정시켜주는 메서드 작성->본인확인->회원탈퇴(암호를 비교=>탈퇴)
	public int updateArticle(CommunityDTO article, String idKey) {
		int x = -1;// 게시물의 수정유무
		String m_id;//id값을 담을 변수
		try {
			con = pool.getConnection();
			sql = "select m_id from community where c_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, article.getC_num());
			rs = pstmt.executeQuery();
					
			if (rs.next()) {// 데이터가 있다면
				m_id = rs.getString("m_id");
				if (idKey.equals(m_id)) {
					sql = "update community set m_id=?,c_subject=?,";
					sql += "c_content=? where c_num=? ";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, article.getM_id());
					pstmt.setString(2, article.getC_subject());
					pstmt.setString(3, article.getC_content());
					pstmt.setInt(4, article.getC_num());
					int update = pstmt.executeUpdate();
					System.out.println("게시판의 글수정성공유무(update)=>" + update);
					x = 1;// 글수정성공
				} else {
					x = 0;// 수정실패;
				}
			}
		} catch (Exception e) {
			System.out.println("updateArticle()메서드 에러유발=>" + e);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return x;
	}
	
	//글삭제
	public int deleteArticle(int c_num,String c_passwd, String m_id) {
		String c_dbpaswd = "";// DB상에서 찾은 암호를 저장할 변수
		int x = 0;// 게시물의 삭제유무

		try {
			con = pool.getConnection();
			sql = "select m_passwd from Member where m_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m_id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				c_dbpaswd = rs.getString("m_passwd");
				System.out.println("c_dbpaswd=>" + c_dbpaswd);

				if (c_dbpaswd.equals(c_passwd)) {
					sql = "delete from community where c_num=? ";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, c_num);
					int delete = pstmt.executeUpdate();
					System.out.println("게시판의 글삭제성공유무(delete)=>" + delete);// 1 or 0
					x = 1;// 글삭제성공
				} else {
					x = 0;// 삭제실패;
				}
			}
		} catch (Exception e) {
			System.out.println("deleteArticle()메서드 에러유발=>" + e);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return x;
	}
	
	//게시글의 조회수가 높은사람에게 point 증가
		public int updatePoint(String m_id) {
			int x = 0; //포인트증가 성공유무
			int point = 0; //포인트를 담을 그릇
			System.out.println("m_id : " + m_id);
			try {
				con = pool.getConnection();
				sql ="select m_point from MemberLogin where m_id=?";
				pstmt= con.prepareStatement(sql);
				pstmt.setString(1, m_id);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					point = rs.getInt("m_point");
					point++;
					sql="update MemberLogin set m_point=? where m_id=?";
					pstmt= con.prepareStatement(sql);
					pstmt.setInt(1, point);
					pstmt.setString(2, m_id);
					pstmt.executeUpdate();
					
					sql="update Member set m_point=? where m_id=?";
					pstmt= con.prepareStatement(sql);
					pstmt.setInt(1, point);
					pstmt.setString(2, m_id);
					pstmt.executeUpdate();
					x = 1;
					con.commit();
				}
				
			} catch (Exception e) {
				System.out.println("updatePoint()메서드 에러유발=>" + e);
			} finally {
				pool.freeConnection(con, pstmt, rs);
			}
			return x;
		}
}
	
	
	
	
	
	

