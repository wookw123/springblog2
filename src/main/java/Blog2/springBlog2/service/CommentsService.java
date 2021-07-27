package Blog2.springBlog2.service;

import Blog2.springBlog2.model.Comments;
import Blog2.springBlog2.model.Post;
import Blog2.springBlog2.model.User;
import Blog2.springBlog2.repository.CommentsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentsService {

    private final CommentsRepository commentsRepository;

    public CommentsService(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    @Transactional
    public void commentWrite(User user, Post post, Comments comments){
        comments.setUser(user);
        comments.setPost(post);
        System.out.println(user.toString() + "--------코멘트 유저정보--------");

        System.out.println(post.toString() + "--------코멘트 글정보--------");
        commentsRepository.save(comments);
    }
}
