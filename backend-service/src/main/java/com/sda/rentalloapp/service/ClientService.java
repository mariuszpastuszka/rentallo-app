package com.sda.rentalloapp.service;

import com.sda.rentalloapp.domain.Client;
import com.sda.rentalloapp.exception.WrongClientIdException;
import com.sda.rentalloapp.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client findClientById(Long clientId) {
        return clientRepository.findById(clientId)
                .map(client -> {
                    log.info("found client: [{}]", client);
                    return client;
                })
                .orElseThrow(() -> new WrongClientIdException("No client with id [%d] found".formatted(clientId)));
    }

    public List<Client> findAllClients() {
        log.info("finding all clients");

        var clients = clientRepository.findAll();

        log.info("number of found clients: [{}]", clients.size());
        log.debug("found clients: {}", clients);

        return clients;
    }
}
