package org.example.service;

import org.example.entity.Profile;

public interface ProfileService {
    void saveProfile(Long userId, Profile profile);

    Profile findProfileByUserId(long id);

    void deleteProfileByUserId(Long id);
}
