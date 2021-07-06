package Blog2.springBlog2.repository;

import Blog2.springBlog2.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {
}
