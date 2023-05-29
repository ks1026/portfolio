package action;

//웹상에서 입력한문자열->암호화
//환경설정파일->파일자체를 암호화

import java.io.*;

import javax.crypto.Cipher;//암호화시킬때 필요한 암호객체
import javax.crypto.CipherOutputStream;//암호화시킬 파일

/* 암호화,복암화(옛날방식) before
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
*/

//추가(패딩)
import java.util.Base64;
import java.util.Base64.*;//Decoder(복호화),Encoder(암호화)

public class Crypt{
	
     //파일암호화에 쓰이는 버퍼 크기 지정
    public static final int kBufferSize = 8192;//256->528->1024~
    public static java.security.Key key = null;//키생성
    //키(암호화에 필요로하는 비밀정보)를 만들어서 파일로 저장->공인인증서 처럼
    public static final String defaultkeyfileurl = "defaultkey.key";
  
    /**
    * 비밀키 생성메소드
    * @return void
    * @exception java.io.IOException,java.security.NoSuchAlgorithmException
    */
    //자바의 오버로딩 기법
    public static java.io.File makekey() //setUp()와 기능이 비슷
    throws java.io.IOException,java.security.NoSuchAlgorithmException {
        return makekey(defaultkeyfileurl);
    }

    //앞에서 입력받은 키정보를 가진 파일을 받아서 키의 정보 저장
    public static java.io.File makekey(String filename) 
    throws java.io.IOException,java.security.NoSuchAlgorithmException {
    	//파일객체 생성(현재 폴더에 저장할 파일명)
        java.io.File tempfile = new java.io.File(".",filename);
        //대칭형 암호 -대칭형 암호화(DES 알고리즘 이용)
        //1.암호화에 사용할 키를 생성->KeyGenerator객체->key생성됨
        javax.crypto.KeyGenerator generator = 
        		javax.crypto.KeyGenerator.getInstance("DES");
        //2.초기화시켜주면서 난수를 발생->0~0.9999999 
        //->중복된 값이 가능한 적게 나오게 섞어주는것
        generator.init(new java.security.SecureRandom());
        //---------------------------------------------------------
        java.security.Key key = generator.generateKey();
        //파일에 저장->입출력->객체형태로 저장(본인의 개인정보)계좌이체암호
        ObjectOutputStream out=
        		        new ObjectOutputStream
        		                 (new FileOutputStream(tempfile));
         out.writeObject(key);//각자의 개인정보(공인인증서)
         out.close();
         return tempfile;//파일에 키가 저장
    }

    /**
    * 지정된 비밀키를 가지고 오는 메서드
    * @return Key 비밀키 클래스
    * @exception Exception
    */
    private static java.security.Key getKey() throws Exception {
       if(key!=null) {
    	   return key;//key의 정보가 들어가 있으면 리턴
       }else {//없으면 만들어서 가져와라
    	   return getKey(defaultkeyfileurl);//키이름을 부여 다시 저장
       }
    }

    //없으면 만들어서 가져오는 메서드
    private static java.security.Key getKey(String fileurl) throws Exception {
        if(key==null) {
        	java.io.File file=new java.io.File(fileurl);//defaultkey.key
        	if(!file.exists()) {//키가 존재하지않으면 만들어서 다시 가져옴
        		file=makekey();//파일을 새로 만들고 키도 저장하고
        	}
        	if(file.exists()) {//파일이 존재한다면 객체직렬화를 통해서 불러옴
        		java.io.ObjectInputStream in=
        		   new java.io.ObjectInputStream
        		     (new java.io.FileInputStream(fileurl));
        	   key=(java.security.Key)in.readObject();//<->writeObject(key)
        	   //파일에 저장된 키를 불러오는 코드
        	   System.out.println("새로 생성된 key=>"+key);
        	   in.close();
        	}else {
        	   throw new Exception("암호키객체를 생성할수 없음!");
        	}
        }
        return key;//없는 파일정보를 만들어서 반환
    }

    //문자열 대칭 암호화->id(비밀키 암호화를 희망하는 문자열),반환(암호화된 ID)
    public static String encrypt(String ID) throws Exception {
         //매개변수값이 입력하지 않았다면 처리하지 않음
    	if(ID==null || ID.length()==0) return "";
    	//1.Ciper객체를 생성->byte[] (암호화)
    	//패딩->암호화시킬때 모자란부분->임의의문자열입력
    	//DES,3DES,DES/ECB/PKCS5Padding
    	Cipher cipher=Cipher.getInstance("DES/ECB/PKCS5Padding");
    	//2.Chiper초기화(암호화 옵션,키)
    	cipher.init(Cipher.ENCRYPT_MODE, getKey());//리턴받은 키정보
    	//3.암호화할 문자열->byte[]->암호화->byte[]
    	String test=ID; //UTF-8->한글데이터
    	byte[] inputBytes1=test.getBytes("UTF-8");//암호화되기 전의 byte[]
    	byte[] outputBytes1=cipher.doFinal(inputBytes1);//암호화된 후의 byte[]
    	//4.BASE64Encoder클래스->문자열끝을 보완
    	//BASE64Encoder encoder=new BASE64Encoder();
    	Encoder encoder=Base64.getEncoder();
    	//String outputStr1=encoder.encode(outputBytes1);
    	String outputStr1=encoder.encodeToString(outputBytes1);
    	return outputStr1;
    }

    //codeID->복호화를 희망하는 문자열,String->복호화된 ID
    public static String decrypt(String codedID) throws Exception{
    	  //매개변수값이 입력하지 않았다면 처리하지 않음
    	if(codedID==null || codedID.length()==0) return "";
    	//1.Ciper객체를 생성->byte[] (암호화)
    	//패딩->암호화시킬때 모자란부분->임의의문자열입력
    	//DES,3DES,DES/ECB/PKCS5Padding
    	Cipher cipher=Cipher.getInstance("DES/ECB/PKCS5Padding");
    	//2.Chiper초기화(암호화 옵션,키)
    	cipher.init(Cipher.DECRYPT_MODE, getKey());//리턴받은 키정보
    	//3.암호화할 문자열->byte[]->암호화->byte[]
    	//4.BASE64Encoder클래스->문자열끝을 보완
    	//BASE64Decoder decoder=new BASE64Decoder();
        Decoder decoder=Base64.getDecoder();
        
    	//byte[] inputBytes1=decoder.decodeBuffer(codedID);//암호화된 상태
    	byte[] inputBytes1=decoder.decode(codedID);
    	
        byte[] outputBytes2=cipher.doFinal(inputBytes1);//복호화 byte[]
    	String strResult=new String(outputBytes2,"UTF-8");
    	return strResult;
    }

    //파일대칭 암호화->infile(암호화을 희망하는 파일명->원본파일 jdbc.properties),
    //outfile(암호화된 파일명)->ktest.properites생성
    //CipherOutputStream->출력스트림
    public static void encryptFile(String infile, String outfile) throws Exception {
    	//1.cipher객체를 생성
    	Cipher cipher=Cipher.getInstance("DES/ECB/PKCS5Padding");
    	//2.Chiper초기화(암호화 옵션,키)
    	cipher.init(Cipher.ENCRYPT_MODE, getKey());//공인인증서
    	//3.암호화을 희망하는 파일명->FileInputStream(원본파일)
    	//dboracle.properties
    	FileInputStream in=new FileInputStream(infile);//
    	FileOutputStream fileOut=
    			           new FileOutputStream(outfile);//새로암호화된 파일명
    	//4.cipher객체->암호화시킬 파일생성(암호화시킬 파일객체,cipher객체명)
    	CipherOutputStream out=
    			new CipherOutputStream(fileOut,cipher);
    	//문자열 한라인->암호화
    	byte[] buffer=new byte[kBufferSize];//파일의 내용
    	//원본파일->byte[]->암호화시키는 파일에 담아주는 작업
    	int length;
    	while((length=in.read(buffer))!=-1)
    		out.write(buffer,0,length);//배열,0,배열크기까지
    	in.close();
    	out.close();//암호화해서 파일에 출력할 내용이 더이상 없다면 종료
    }

    //infile(복호화를 희망하는 파일명)->암호화된 파일,outfile(새로 복호화된 파일명)
    public static void decryptFile(String infile, String outfile) throws Exception {
      Cipher cipher=Cipher.getInstance("DES/ECB/PKCS5Padding");
    	//2.Chiper초기화(암호화 옵션,키)
    	cipher.init(Cipher.DECRYPT_MODE, getKey());
    	//3.복호화을 희망하는 파일명->FileInputStream(암호화된 파일명)
    	FileInputStream in=new FileInputStream(infile);
    	FileOutputStream fileOut=
    			           new FileOutputStream(outfile);//복호화된 파일명
    	//4.cipher객체->복호화시킬 파일생성(파일객체,cipher객체명)
    	CipherOutputStream out=
    			new CipherOutputStream(fileOut,cipher);
    	//파일에 암호화시킬 내용을 출력
    	byte[] buffer=new byte[kBufferSize];
    	int length;
    	while((length=in.read(buffer))!=-1)
    		out.write(buffer,0,length);//배열,0,배열크기까지
    	in.close();
    	out.close();
    }

    public static void main(String[] ars) throws Exception {
        if(ars.length < 2) {
            System.out.println("USE : java com.crypto.Crypto [-d  -e  -fd  -fe] [text  inputfilename outputfilename]");
            System.exit(0);
        }

        if(ars[0].equals("-d"))
            System.out.println(Crypt.decrypt(ars[1]));

        if(ars[0].equals("-e"))
            System.out.println(Crypt.encrypt(ars[1]));

        if(ars[0].equals("-fd"))
            Crypt.decryptFile(ars[1], ars[2]);

        if(ars[0].equals("-fe"))
            Crypt.encryptFile(ars[1], ars[2]);
    }
}


