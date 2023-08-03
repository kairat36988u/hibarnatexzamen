package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="comments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "comment_generator")
    @SequenceGenerator(
            name="comment_generator",
            sequenceName ="comment_seq_generator",
            allocationSize = 1
    )
    private Long id;
    private String text;
    @Column(name = "comment_date")
    private Date commentDate;
    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.REMOVE
    })
    private User user;
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.REMOVE
    })
    private List<Post> post;

    public Comment(String text, Date commentDate) {
        this.text = text;
        this.commentDate = commentDate;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", commentDate=" + commentDate +
                '}';
    }
}