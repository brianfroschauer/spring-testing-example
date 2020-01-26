package com.example.initializr.unit.service.user;

import com.example.initializr.entity.User;
import com.example.initializr.exception.NotFoundException;
import com.example.initializr.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> find() {
        return repository
                .findAll();
    }

    @Override
    public User find(Long id) {
        return repository
                .findById(id)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public User find(String username) {
        return repository
                .findByUsername(username)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public User save(User user) {
        return repository
                .save(user);
    }

    @Override
    public User update(Long id, User user) {
        return repository
                .findById(id)
                .map(old -> {
                    old.setFirstName(user.getFirstName());
                    old.setLastName(user.getLastName());
                    return repository.save(user);
                })
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public void delete(Long id) {
        final User user = find(id);
        repository.delete(user);
    }
}
