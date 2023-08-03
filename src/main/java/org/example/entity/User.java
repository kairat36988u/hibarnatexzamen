package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "user_generator")
    @SequenceGenerator(
            name = "user_generator",
            sequenceName = "user_seq_generator",
            allocationSize = 1
    )
    private Long id;
    private String username;
    private String email;
    private String password;
    @OneToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.REMOVE
    }
    )
    private Profile profile;
    @OneToMany(mappedBy = "user",cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.REMOVE
    })
    private List<Comment> comment;
    @OneToMany(mappedBy = "user",cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.REMOVE
    })
    private List<Post> post;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", profile=" + profile +
                '}';
    }
}