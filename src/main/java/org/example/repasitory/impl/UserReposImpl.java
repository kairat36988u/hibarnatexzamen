package org.example.repasitory.impl;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.config.HibernateConfig;
import org.example.entity.Profile;
import org.example.entity.User;
import org.example.repasitory.UserRepos;
public class UserReposImpl implements UserRepos {
    private final EntityManagerFactory entityManagerFactory = HibernateConfig.createEntityManagerFactory();
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public String saveUser(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully saved!!!";
    }

    @Override
    public User findUserByid(Long id) {
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return user;
    }

    @Override
    public void updateProfile(Long id, Profile profile) {
        entityManager.getTransaction().begin();
        User user = entityManager.createQuery("select u from User u " +
                        "where u.id=:userId", User.class)
                .setParameter("userId", id)
                .getSingleResult();

        System.out.println("user.getProfile().getId() = " + user.getProfile().getId());

        entityManager.createQuery("""
                update Profile  set
                fullName = :n,
                bio = :b,
                dateOfBirth = :d,
                gender = :g
                where id = :i
                """)
                .setParameter("n", profile.getFullName())
                .setParameter("b", profile.getBio())
                .setParameter("d", profile.getDateOfBirth())
                .setParameter("g", profile.getGender())
                .setParameter("i", user.getProfile().getId())
                .executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void delete(Long id) {
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}