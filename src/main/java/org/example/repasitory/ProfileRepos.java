package org.example.repasitory;

import org.example.entity.Profile;

public interface ProfileRepos {
    void saveProfile(Long userId, Profile profile);

    Profile findProfileByUserId(long id);

    void deleteProfileByUserId(Long id);
}
