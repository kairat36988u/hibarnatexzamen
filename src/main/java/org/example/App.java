package org.example;


import org.example.config.HibernateConfig;
import org.example.entity.Comment;
import org.example.entity.Post;
import org.example.entity.Profile;
import org.example.entity.User;
import org.example.enums.Gender;
import org.example.service.CommentService;
import org.example.service.PostService;
import org.example.service.ProfileService;
import org.example.service.UserService;
import org.example.service.impl.CommentServiceImpl;
import org.example.service.impl.PostServiceImpl;
import org.example.service.impl.ProfileServiceImpl;
import org.example.service.impl.UserServiceImpl;

import java.sql.Date;
import java.util.Scanner;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        HibernateConfig.createEntityManagerFactory();
        UserService userService = new UserServiceImpl();
        PostService postService = new PostServiceImpl();
        CommentService commentService = new CommentServiceImpl();
        ProfileService profileService = new ProfileServiceImpl();
        User user =new User("Nur","N@gmail.com","1604");
        Date date= Date.valueOf("2000-01-01");
        Profile profile=new Profile("Kairat Nurdinov", date, Gender.MALE, "User1 bio");
        Profile profile2=new Profile("Keldibek  Orozbekov", date,Gender.MALE, "User2 bio");
        Post post = new Post("Photo","comment1","2023-08-1-02");
        Post post2 = new Post("PhotoMountains","comment2","2023-08-1-03");
        Date date3= Date.valueOf("2023-08-05");
        Comment comment1 = new Comment("Good job",date3);

                    userService.saveUser(user);
//                    userService.updateProfile(1L, profile);
//                    userService.delete(3L);
//                    System.out.println(userService.findUserByid(2L));

//                    profileService.saveProfile(1L, profile);
//                    System.out.println(profileService.findProfileByUserId(3L));
//                    profileService.deleteProfileByUserId(1L);

//                    postService.savePost(2L, post);
//                    postService.getPostByUserId(1L).forEach(System.out::println);
//                    System.out.println(postService.searchPost("Photo"));
//                    postService.deletePostById(1L);

//                    commentService.saveComment(2L, 2L, comment1);
//                    commentService.findCommentByPostId(2L).forEach(System.out::println);
//                    commentService.updateComment(1L, "Well done!");
//                    commentService.deleteComment(comment1);


    }
}
