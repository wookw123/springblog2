package Blog2.springBlog2.service;

import Blog2.springBlog2.model.User;
import Blog2.springBlog2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public void Join(User user){
        userRepository.save(user);//입력받은 정보를 저장
    }


}
