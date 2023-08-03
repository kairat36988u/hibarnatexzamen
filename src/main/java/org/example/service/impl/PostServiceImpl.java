package org.example.service.impl;

import org.example.entity.Post;
import org.example.repasitory.PostRepos;
import org.example.repasitory.impl.PostReposImpl;
import org.example.service.PostService;
import org.example.service.ProfileService;

import java.util.List;

public class PostServiceImpl implements PostService {
    PostRepos postRepos=new PostReposImpl();
    @Override
    public void savePost(Long userId, Post post) {
        postRepos.savePost(userId, post);
    }

    @Override
    public List<Post> getPostByUserId(Long userId) {
        return postRepos.getPostByUserId(userId);
    }

    @Override
    public Post searchPost(String image) {
        return postRepos.searchPost(image);
    }

    @Override
    public void deletePostById(Long id) {
        postRepos.deletePostById(id);
    }
}
