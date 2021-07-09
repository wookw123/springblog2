package Blog2.springBlog2.controller;

import Blog2.springBlog2.DTO.UserDTO;
import Blog2.springBlog2.model.User;
import Blog2.springBlog2.repository.UserRepository;
import Blog2.springBlog2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping("/auth/login")
    public String loginForm(){
        return "/user/loginForm";
    }

    @GetMapping("/auth/join")
    public String joinForm(){
        return "/user/joinForm";
    }

    @GetMapping("/auth/write")
    public String writeForm(){
        return "/post/postWrite";
    }

    @PostMapping("/auth/userJoin")
    public String userJoin(UserDTO userdto){

        //form 에서 넘어온 DTO 데이터를 변환
        User user = userdto.toJoin();

        //userRepository에게 Entity를 DB에 저장하라고함
        userService.Join(user);

        return "redirect:/";
    }

    @RequestMapping("/auth/userLogin")
    public String userLogin(UserDTO userDTO){

        User user = userDTO.toLogin();

        String username = user.getUsername();
        String password = user.getPassword();



        return "redirect:/";
    }













}
