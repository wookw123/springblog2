package Blog2.springBlog2.repository;

import Blog2.springBlog2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.BufferedReader;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User , Integer> {


    //Optional<User> findByName(String name);

    @Query(value = "SELECT * FROM user where username = ? AND password = ?" ,nativeQuery = true)
    public User login(String username , String password);

    @Query(value = "SELECT * FROM user where username = ?" ,nativeQuery = true)
    public User userinfo(String username);





}
