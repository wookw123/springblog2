package Blog2.springBlog2.repository;

import Blog2.springBlog2.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CommentsRepository extends JpaRepository<Comments,Integer> {


    //public Comments

    @Modifying
    @Query(value = "INSERT INTO COMMENTS(user_id , post_id , comment , createDate  , updateDate)" +
            "values(?1,?2,?3,now(),now())" , nativeQuery = true)
    int commentSave(int userid , int postid , String comment);

}
