package org.example.repasitory.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.config.HibernateConfig;
import org.example.entity.Profile;
import org.example.entity.User;
import org.example.repasitory.ProfileRepos;

public class ProfileReposImpl implements ProfileRepos {
    private final EntityManagerFactory entityManagerFactory= HibernateConfig.createEntityManagerFactory();
    private final EntityManager entityManager=entityManagerFactory.createEntityManager();

    @Override
    public void saveProfile(Long userId, Profile profile) {
        entityManager.getTransaction().begin();
        User userId1 = entityManager.createQuery("select u from User  u" +
                        " where u.id=:userId", User.class)
                .setParameter("userId", userId)
                .getSingleResult();
        entityManager.persist(profile);
        userId1.setProfile(profile);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Profile findProfileByUserId(long id) {
        entityManager.getTransaction().begin();
        Profile profile = entityManager.find(Profile.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return profile;
    }

    @Override
    public void deleteProfileByUserId(Long id) {
        entityManager.getTransaction().begin();
        Profile profile = entityManager.createQuery("select p from Profile p " +
                        " join User u on p.user.id=u.id " +
                        "where u.id=:userId", Profile.class)
                .setParameter("userId", id)
                .getSingleResult();
        entityManager.remove(profile);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
