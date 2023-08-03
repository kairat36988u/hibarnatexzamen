package org.example.service.impl;


import org.example.entity.Comment;
import org.example.repasitory.CommetRepos;
import org.example.repasitory.impl.CommentReposImpl;
import org.example.service.CommentService;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    CommetRepos commetRepos=new CommentReposImpl();
    @Override
    public void saveComment(Long postID, Long userId, Comment comment) {
        commetRepos.saveComment(postID, userId, comment);
    }

    @Override
    public List<Comment> findCommentByPostId(Long postId) {
        return commetRepos.findCommentByPostId(postId);
    }

    @Override
    public void updateComment(Long id, String text) {
        commetRepos.updateComment(id, text);
    }

    @Override
    public void deleteComment(Comment comment) {
        commetRepos.deleteComment(comment);
    }
}
