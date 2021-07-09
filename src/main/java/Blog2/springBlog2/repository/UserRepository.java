package Blog2.springBlog2.repository;

import Blog2.springBlog2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User , Integer> {


    //Optional<User> findByName(String name);

}
