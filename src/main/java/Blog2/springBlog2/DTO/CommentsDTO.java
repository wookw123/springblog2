package Blog2.springBlog2.DTO;

import Blog2.springBlog2.model.Comments;

public class CommentsDTO {
    private int comentuserid;
    private int comentpostid;
    private String comentcontent;

    public int getComentuserid() {
        return comentuserid;
    }

    public void setComentuserid(int comentuserid) {
        this.comentuserid = comentuserid;
    }

    public int getComentpostid() {
        return comentpostid;
    }

    public void setComentpostid(int comentpostid) {
        this.comentpostid = comentpostid;
    }

    public String getComentcontent() {
        return comentcontent;
    }

    public void setComentcontent(String comentcontent) {
        this.comentcontent = comentcontent;
    }

    public CommentsDTO(int comentuserid, int comentpostid, String comentcontent) {
        this.comentuserid = comentuserid;
        this.comentpostid = comentpostid;
        this.comentcontent = comentcontent;
    }

    @Override
    public String toString() {
        return "CommentsDTO{" +
                "userid=" + comentuserid +
                ", postid=" + comentpostid +
                ", content='" + comentcontent + '\'' +
                '}';
    }

    public Comments toWrite(){
        return new Comments(comentuserid,comentpostid,comentcontent);
    }

}
