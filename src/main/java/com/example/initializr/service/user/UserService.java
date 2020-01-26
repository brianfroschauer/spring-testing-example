package com.example.initializr.unit.service.user;

import com.example.initializr.entity.User;

import java.util.List;

public interface UserService {

    /**
     * Find all users.
     *
     * @return all users or an empty list if there are no users.
     */
    List<User> find();

    /**
     * Find the user with the provided id.
     *
     * @param id of the user to be found.
     * @return the user found.
     */
    User find(Long id);

    /**
     * Find the user with the provided {@param username}.
     *
     * @param username of the user to be found.
     * @return the user found.
     */
    User find(String username);

    /**
     * Persist the provided {@param user}.
     *
     * @param user to be persisted.
     * @return the persisted user with.
     */
    User save(User user);

    /**
     * Update the provided {@param user}.
     *
     * @param id of the user to be updated.
     * @param user to be updated.
     * @return the updated user.
     */
    User update(Long id, User user);

    /**
     * Delete the provided user.
     *
     * @param id of the user to be found.
     */
    void delete(Long id);
}
