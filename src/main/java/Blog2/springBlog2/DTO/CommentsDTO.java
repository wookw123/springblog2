package Blog2.springBlog2.DTO;

import Blog2.springBlog2.model.Comments;

public class CommentsDTO {
    private int userid;
    private int postid;
    private String content;

    @Override
    public String toString() {
        return "CommentsDTO{" +
                "userid=" + userid +
                ", postid=" + postid +
                ", content='" + content + '\'' +
                '}';
    }

    public Comments toWrite(){
        return new Comments(userid,postid,content);
    }

}
