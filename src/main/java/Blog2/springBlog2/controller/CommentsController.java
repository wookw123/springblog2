package Blog2.springBlog2.controller;

import Blog2.springBlog2.DTO.CommentsDTO;
import Blog2.springBlog2.service.CommentsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class CommentsController {

    private final CommentsService commentsService;

    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @PostMapping("/auth/commentswrite")
    public String  commentwrite(CommentsDTO commentsDTO) {

        //response.setCharacterEncoding("UTF-8");
        //response.setContentType("text/html; charset=UTF-8");
        //PrintWriter print = response.getWriter();
        commentsService.commentWrite(commentsDTO );
        return "redirect:/post/" + commentsDTO.getComentpostid();

    }

}
