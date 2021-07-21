package Blog2.springBlog2.controller;

import Blog2.springBlog2.DTO.CommentsDTO;
import Blog2.springBlog2.model.Comments;
import Blog2.springBlog2.model.Post;
import Blog2.springBlog2.model.User;
import Blog2.springBlog2.service.CommentsService;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

public class CommentsController {

    private final CommentsService commentsService;

    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @PostMapping("/auth/commentswrite")
    public String commentwrite(CommentsDTO commentsDTO , HttpSession session){
        System.out.println("댓글 컨트롤러 진입 ------------------------------");
        User user = (User) session.getAttribute("userinfo");
        Post post = (Post) session.getAttribute("post");
        Comments comments = commentsDTO.toWrite();

        commentsService.commentWrite(user,post,comments);
        return "";
    }

}
