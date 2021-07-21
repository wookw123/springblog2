package Blog2.springBlog2.service;

import Blog2.springBlog2.model.Comments;
import Blog2.springBlog2.model.Post;
import Blog2.springBlog2.model.User;
import Blog2.springBlog2.repository.CommentsRepository;
import org.springframework.transaction.annotation.Transactional;

public class CommentsService {

    private final CommentsRepository commentsRepository;

    public CommentsService(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    @Transactional
    public void commentWrite(User user, Post post, Comments comments){
        comments.setUser(user);
        comments.setPost(post);
        commentsRepository.save(comments);
    }
}
