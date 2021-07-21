package Blog2.springBlog2.DTO;

import Blog2.springBlog2.model.Comments;

public class CommentsDTO {
    int userid;
    int postid;
    String content;

    public Comments toWrite(){
        return new Comments(userid,postid,content);
    }

}
