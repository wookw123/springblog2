package Blog2.springBlog2.DTO;

import Blog2.springBlog2.model.Post;
import Blog2.springBlog2.model.User;

public class PostDTO {

    private String title;
    private String content;
    private String slug;


    @Override
    public String toString() {
        return "PostDTO{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", slug='" + slug + '\'' +
                '}';
    }

    public PostDTO(String title, String content, String slug) {
        this.title = title;
        this.content = content;
        this.slug = title;

    }

    public Post toWrite(){
        return new Post(title,content,slug);
    }
}
