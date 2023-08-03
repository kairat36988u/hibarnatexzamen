package org.example.repasitory;

import org.example.entity.Post;

import java.util.List;

public interface PostRepos {

    void savePost(Long userId, Post post);

    List<Post> getPostByUserId(Long userId);

    Post searchPost(String image);

    void deletePostById(Long id);
}
