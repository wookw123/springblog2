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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping("/auth/login")
    public String loginForm(){
        return "/user/loginForm";
    } //메인메뉴 상단 로그인 클릭시

    @GetMapping("/auth/join")
    public String joinForm(){
        return "/user/joinForm";
    } //메인메뉴 상단 회원가입 클릭시

    @GetMapping("/auth/write")
    public String writeForm(){
        return "/post/postWrite";
    } //메인메뉴 상단 글쓰기 클릭시

    @PostMapping("/auth/userJoin")
    public String userJoin(UserDTO userdto){

        //form 에서 넘어온 DTO 데이터를 변환
        User user = userdto.toJoin();

        //userRepository에게 Entity를 DB에 저장하라고함
        userService.Join(user);

        return "redirect:/";
    }

    @PostMapping("/auth/userLogin")
    public void userLogin(UserDTO userDTO , HttpServletResponse response , HttpServletRequest request) throws IOException {

        User user = userDTO.toLogin();

        String username = user.getUsername();
        String password = user.getPassword();

        HttpSession session = request.getSession();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter print = response.getWriter();

        boolean logincheck =  userService.Login(user);

        if (logincheck){//로그인 성공(아이디 비번 일치)
            session.setAttribute("authinfo",user); //session에 authinfo라는 이름으로 user정보 저장
            print.println("<script>alert('로그인 성공'); location.href = '/';</script>");
        }
        else {
            print.println("<script>alert('로그인 실패. 아이디와 비밀번호를 확인하세요'); location.href = '/auth/login';</script>");
        }
    }

    @GetMapping("/auth/logout")
    public String userLogout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }














}
