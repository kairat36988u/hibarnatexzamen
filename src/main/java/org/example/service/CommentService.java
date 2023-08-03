package org.example.service;

import org.example.entity.Comment;


import java.util.List;

public interface CommentService {

    void saveComment(Long postID, Long userId, Comment comment);

    List<Comment> findCommentByPostId(Long postId);

    void updateComment(Long id, String text);

    void deleteComment(Comment comment);
}
