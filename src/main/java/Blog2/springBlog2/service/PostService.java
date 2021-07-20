package Blog2.springBlog2.service;


import Blog2.springBlog2.model.Post;
import Blog2.springBlog2.model.User;
import Blog2.springBlog2.repository.CommentRepository;
import Blog2.springBlog2.repository.PostRepository;
import Blog2.springBlog2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public PostService(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }



    @Transactional(readOnly = true)
    public Page<Post> Postlist(Pageable pageable){ //글목록
        return postRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Post postDetail(int id){
        return postRepository.findById(id).orElseThrow(()->{
                return new IllegalArgumentException("글 상세보기 실패 : ID를 찾을수 없음");
        });
    }

    @Transactional
    public void postWrite(Post post , User user){
        post.setUser(user);
        postRepository.save(post);
    }














}
