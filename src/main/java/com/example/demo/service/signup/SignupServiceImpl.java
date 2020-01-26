package com.example.demo.service.signup;

import com.example.demo.entity.User;
import com.example.demo.exception.AlreadyExistsException;
import com.example.demo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignupServiceImpl implements SignupService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public SignupServiceImpl(UserRepository repository,
                             PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public User signup(User user) {
        validate(user.getUsername());
        user.setPassword(encode(user.getPassword()));
        return repository.save(user);
    }

    /**
     * Throw an AlreadyExistsException if the provided {@param username} already exists.
     * @param username to be found.
     */
    private void validate(String username) {
        repository
                .findByUsername(username)
                .ifPresent(user -> { throw new AlreadyExistsException(); });
    }

    /**
     * Encode the provided {@param password}.
     *
     * @param password to by encoded.
     * @return the encoded password.
     */
    private String encode(String password) {
        return encoder.encode(password);
    }
}
