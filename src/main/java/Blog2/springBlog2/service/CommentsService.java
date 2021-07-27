package Blog2.springBlog2.service;

import Blog2.springBlog2.DTO.CommentsDTO;
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
    public void commentWrite(CommentsDTO commentsDTO ){

        commentsRepository.commentSave(commentsDTO.getComentuserid() , commentsDTO.getComentpostid() , commentsDTO.getComentcontent());
    }
}
