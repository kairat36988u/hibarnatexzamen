package org.example.service.impl;

import org.example.entity.Profile;
import org.example.entity.User;
import org.example.repasitory.UserRepos;
import org.example.repasitory.impl.UserReposImpl;
import org.example.service.UserService;

public class UserServiceImpl implements UserService {
    UserRepos userRepos=new UserReposImpl();
    @Override
    public String saveUser(User user) {
        return userRepos.saveUser(user);
    }

    @Override
    public User findUserByid(Long id) {
        return userRepos.findUserByid(id);
    }

    @Override
    public void updateProfile(Long id, Profile profile) {
        userRepos.updateProfile(id, profile);
    }

    @Override
    public void delete(Long id) {
        userRepos.delete(id);
    }
}
