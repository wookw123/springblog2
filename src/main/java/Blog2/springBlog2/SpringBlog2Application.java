package Blog2.springBlog2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication()
public class SpringBlog2Application {

	public static void main(String[] args) {

		passwordenc("1111");
		//SpringApplication.run(SpringBlog2Application.class, args);
	}

	public static String passwordenc(String str){
		String MD5 = "";

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			System.out.println(md+"++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println(md.toString());
			md.update(str.getBytes());
			byte byteData[] =  md.digest();
//			for (int i = 0; i <= byteData.length; i++){
//				System.out.println(byteData[i] + "::::");
//			}
			StringBuffer sb  = new StringBuffer();

			for(int i = 0; i <byteData.length; i++){
				sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
			}

			MD5 = sb.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			MD5 = null;
		}
		return MD5;
	}

}
