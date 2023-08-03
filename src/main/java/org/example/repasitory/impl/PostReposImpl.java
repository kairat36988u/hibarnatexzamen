package org.example.repasitory.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.config.HibernateConfig;
import org.example.entity.Post;
import org.example.entity.User;
import org.example.repasitory.PostRepos;

import java.util.List;

public class PostReposImpl implements PostRepos {
    private final EntityManagerFactory entityManagerFactory = HibernateConfig.createEntityManagerFactory();
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void savePost(Long userId, Post post) {
        entityManager.getTransaction().begin();
        User user = entityManager.createQuery("""
                        select u from User u where id=:id
                        """, User.class)
                .setParameter("id", userId)
                .getSingleResult();
        post.setUser(user);
        entityManager.persist(post);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Post> getPostByUserId(Long userId) {
        entityManager.getTransaction().begin();
        List<Post> posts = entityManager.createQuery("select p from Post p " +
                        " join User u on p.user.id=u.id " +
                        "where u.id=:userId", Post.class)
                .setParameter("userId", userId)
                .getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return posts;
    }

    @Override
    public Post searchPost(String image) {
        entityManager.getTransaction().begin();
        Post post = entityManager.createQuery("select p from Post p " +
                        "where p.image=:image", Post.class)
                .setParameter("image", image)
                .getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return post;
    }

    @Override
    public void deletePostById(Long id) {
        entityManager.getTransaction().begin();
        Post post = entityManager.find(Post.class, id);
        entityManager.remove(post);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}