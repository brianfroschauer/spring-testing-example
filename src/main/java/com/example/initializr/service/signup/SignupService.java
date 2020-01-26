package com.example.initializr.unit.service.signup;

import com.example.initializr.entity.User;

public interface SignupService {

    /**
     * Sign up the provided {@param user}.
     * @param user to be registered.
     *
     * @return the registered user.
     */
    User signup(User user);
}
