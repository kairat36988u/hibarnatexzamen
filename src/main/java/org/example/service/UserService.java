package org.example.service;

import org.example.entity.Profile;
import org.example.entity.User;

public interface UserService {
    String saveUser(User user);

    User findUserByid(Long id);

    void updateProfile(Long id, Profile profile);

    void delete(Long id);

}
