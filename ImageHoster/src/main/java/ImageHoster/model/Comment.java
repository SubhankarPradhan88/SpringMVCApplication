package ImageHoster.model;


import javax.persistence.*;
import java.util.Date;

//@Entity annotation specifies that the corresponding class is a JPA entity
@Entity
// The table that will be created to store the comment in the DB
@Table(name = "comment")

public class Comment {
    //@Id annotation specifies that the corresponding attribute is a primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "comment_id")
    private Integer commentId;

    @Column(name = "text")
    private String text;

    @Column(name = "createddate")
    private Date createdDate;

    // Relation between the comments and user is "many to one"
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    // Relation between the comments and Image is "many to one"
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "image_id")
    private Image image;

    public Comment() {}
    // Declaring the constructor
    public Comment(Integer commentId, String text, Date createdDate, User user, Image image) {
        this.commentId = commentId;
        this.text = text;
        this.createdDate = createdDate;
        this.user = user;
        this.image = image;
    }

    // Getters and setters for Comment model class
    public Integer getCommentId() {
        return commentId;
    }
    public void setCommentId(Integer comment_id) {
        this.commentId = commentId;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Image getImage() {
        return image;
    }
    public void setImage(Image image) {
        this.image = image;
    }
}
