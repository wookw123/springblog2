package Blog2.springBlog2.repository;

import Blog2.springBlog2.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments,Integer> {


    //public Comments

}
