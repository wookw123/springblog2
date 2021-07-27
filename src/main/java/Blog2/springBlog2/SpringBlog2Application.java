package Blog2.springBlog2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication()
public class SpringBlog2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBlog2Application.class, args);
	}


}


