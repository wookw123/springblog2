package Blog2.springBlog2.service;

import Blog2.springBlog2.model.User;
import Blog2.springBlog2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

   /* @Autowired
    private PasswordEncoder passwordEncoder;*/

    //MD5 암호화 하기
    public static String passwordenc(String str){
        String MD5 = "";

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            md.update(str.getBytes());
            byte byteData[] =  md.digest();
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

    @Transactional
    public void Join(User user) { //User회원가입
        String password = user.getPassword();
        String encpassword = passwordenc(password);
        user.setPassword(encpassword);
        userRepository.save(user);//입력받은 정보를 저장
    }

    @Transactional
    public String JoinCheck(String username){
        User user;
        user = userRepository.userinfo(username);
        if(user != null) { //이미 가입한 회원이 있을때
            return "ok";
        }
        else{
            return "no"; //가입한 회원이 없을때
        }
    }

    @Transactional
    public boolean Login(User user){

        String password = user.getPassword();
        String encpassword = passwordenc(password);

       user =  userRepository.login(user.getUsername(),encpassword);

       if (user != null){
           return true;
       }
        return false;
    }

    @Transactional
    public void userUpdate(User user) {
        String password = user.getPassword();
        String encpassword = passwordenc(password);
        user.setPassword(encpassword);
        userRepository.save(user);
        // userRepository.
    }





}
