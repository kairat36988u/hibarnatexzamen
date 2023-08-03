package org.example.repasitory.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.config.HibernateConfig;
import org.example.entity.Comment;
import org.example.entity.Post;
import org.example.entity.User;
import org.example.repasitory.CommetRepos;

import java.util.List;

public class CommentReposImpl implements CommetRepos {
    private final EntityManagerFactory entityManagerFactory = HibernateConfig.createEntityManagerFactory();
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void saveComment(Long postID, Long userId, Comment comment) {
        entityManager.getTransaction().begin();

        try {
            User user = entityManager.createQuery("select u from User u " +
                            "where u.id=:userId", User.class)
                    .setParameter("userId", userId)
                    .getSingleResult();

            List<Post> posts = entityManager.createQuery("select p from Post p " +
                            "where p.id=:postId", Post.class)
                    .setParameter("postId", postID)
                    .getResultList();

            comment.setUser(user);
            comment.setPost(posts);

            entityManager.persist(comment);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Failed to save comment", e);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Comment> findCommentByPostId(Long postId) {
        entityManager.getTransaction().begin();
        List<Comment> comments = entityManager.createQuery("select c from Comment  c " +
                                " join c.post p where p.id=:postId",
                        Comment.class)
                .setParameter("postId", postId)
                .getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return comments;
    }
    @Override
    public void updateComment(Long id, String text) {
        entityManager.getTransaction().begin();
        Comment comment = entityManager.createQuery("select c from Comment c " +
                        "where c.id=:id", Comment.class)
                .setParameter("id", id)
                .getSingleResult();
        comment.setText(text);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteComment(Comment comment) {
        entityManager.getTransaction().begin();
        Comment comment1 = entityManager.createQuery("select c from Comment c " +
                        "where c=:comment", Comment.class)
                .setParameter("comment", comment)
                .getSingleResult();
        entityManager.remove(comment1);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
