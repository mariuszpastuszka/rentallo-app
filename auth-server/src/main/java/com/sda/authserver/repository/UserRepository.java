package com.sda.authserver.repository;

import com.sda.authserver.domain.SecurityUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<SecurityUser, Long> {
    SecurityUser findByUsername(String username);
}
