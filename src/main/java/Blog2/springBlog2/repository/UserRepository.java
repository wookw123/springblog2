package Blog2.springBlog2.repository;

import Blog2.springBlog2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , Integer> {

}
