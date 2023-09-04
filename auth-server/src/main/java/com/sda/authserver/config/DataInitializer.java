package com.sda.authserver.config;

import com.sda.authserver.domain.SecurityUser;
import com.sda.authserver.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements ApplicationRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(ApplicationArguments args) {
        userRepository.save(new SecurityUser("maniek", passwordEncoder.encode("password"), "ROLE_ADMIN"));
        userRepository.save(new SecurityUser("olaf", passwordEncoder.encode("password"), "ROLE_USER"));
    }
}
