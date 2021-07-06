package Blog2.springBlog2.controller;

import Blog2.springBlog2.DTO.userDTO;
import Blog2.springBlog2.model.User;
import Blog2.springBlog2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class userController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("login")
    public String loginForm(){
        return "/user/loginForm";
    }

    @GetMapping("join")
    public String joinForm(){
        return "/user/joinForm";
    }

    @GetMapping("write")
    public String writeForm(){
        return "/post/postWrite";
    }

    @PostMapping("userJoin")
    public String userJoin(userDTO userdto){


        //form 에서 넘어온 DTO 데이터를 변환
        User user = userdto.toEntity();

        //userRepository에게 Entity를 DB에 저장하라고함
        userRepository.save(user);

        return "user/loginForm";
    }


}
