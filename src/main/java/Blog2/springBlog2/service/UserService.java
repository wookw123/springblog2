package Blog2.springBlog2.service;

import Blog2.springBlog2.model.User;
import Blog2.springBlog2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

   /* @Autowired
    private PasswordEncoder passwordEncoder;*/

    @Transactional
    public void Join(User user){ //User회원가입
//        String encodedPassword =  passwordEncoder.encode(user.getPassword()); //암호화
//        user.setPassword(encodedPassword);
        userRepository.save(user);//입력받은 정보를 저장
    }












}
