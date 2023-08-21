package com.sda.rentalloapp.repository;

import com.sda.rentalloapp.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
