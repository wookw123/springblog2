package Blog2.springBlog2.DTO;

import Blog2.springBlog2.model.Post;
import Blog2.springBlog2.model.User;

public class PostDTO {

    private String title;
    private String content;
    private String slug;
    private User username;

    public PostDTO(String title, String content, String slug, User username) {
        this.title = title;
        this.content = content;
        this.slug = title;
        this.username = username;
    }

    public Post toWrite(){
        return new Post(title,content,username,slug);
    }
}
