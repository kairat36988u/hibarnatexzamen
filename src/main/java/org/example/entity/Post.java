package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="posts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "post_generator")
    @SequenceGenerator(
            name="post_generator",
            sequenceName ="post_seq_generator",
            allocationSize = 1
    )
    private Long id;
    private String image;
    private String description;
    private String created;
    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH,
//            CascadeType.REMOVE
    })
    private User user;
    @ManyToMany(mappedBy = "post",cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.REMOVE
    })
    private List<Comment> comment;

    public Post(String image, String description, String created) {
        this.image = image;
        this.description = description;
        this.created = created;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", created='" + created + '\'';
    }
}