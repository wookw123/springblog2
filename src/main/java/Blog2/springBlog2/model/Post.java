package Blog2.springBlog2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Post {

    public Post() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false,length = 100)
    private String title;

    @Column(nullable = false, length = 100)
    private String slug;

    @Column(nullable = false , length = 500)
    private String content;

    @OneToMany(mappedBy = "post" , fetch = FetchType.EAGER,cascade = CascadeType.ALL) //연관관계의 주인은 post이다
    @JsonIgnore
    @OrderBy("id desc") //id기준으로 내림차순 정렬
    private List<Comments> comments;

    @CreationTimestamp
    private Timestamp createDate;

    @CreationTimestamp
    private Timestamp updateDate;




   @JsonIgnoreProperties({"post"})
    public Post(String title, String content, String slug) {
        this.title = title;
        this.content = content;
        this.slug = slug;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", user=" + user +
                ", title='" + title + '\'' +
                ", slug='" + slug + '\'' +
                ", content='" + content + '\'' +
                ", comments=" + comments +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }
}
