package org.example.service.impl;

import org.example.entity.Profile;
import org.example.repasitory.ProfileRepos;
import org.example.repasitory.impl.ProfileReposImpl;
import org.example.service.ProfileService;

public class ProfileServiceImpl implements ProfileService {
    ProfileRepos profileRepos=new ProfileReposImpl();
    @Override
    public void saveProfile(Long userId, Profile profile) {
        profileRepos.saveProfile(userId, profile);
    }

    @Override
    public Profile findProfileByUserId(long id) {
        return profileRepos.findProfileByUserId(id);
    }

    @Override
    public void deleteProfileByUserId(Long id) {
        profileRepos.deleteProfileByUserId(id);
    }
}
