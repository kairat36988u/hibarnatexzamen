package org.example.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.enums.Gender;

import java.util.Date;

@Entity
@Table(name="profiles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "profile_generator")
    @SequenceGenerator(
            name="profile_generator",
            sequenceName ="profile_seq_generator",
            allocationSize = 1
    )
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name="date_of_birth")
    private Date dateOfBirth;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String bio;
    @OneToOne(mappedBy = "profile",cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.REMOVE
    })
    private User user;

    public Profile(String fullName, Date dateOfBirth, Gender gender, String bio) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                ", bio='" + bio + '\'' +
                '}';
    }
}