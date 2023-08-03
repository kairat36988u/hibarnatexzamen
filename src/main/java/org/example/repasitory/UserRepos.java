package org.example.repasitory;

import org.example.entity.Profile;
import org.example.entity.User;

public interface UserRepos {
    String saveUser(User user);

    User findUserByid(Long id);

    void updateProfile(Long id, Profile profile);

    void delete(Long id);
}
