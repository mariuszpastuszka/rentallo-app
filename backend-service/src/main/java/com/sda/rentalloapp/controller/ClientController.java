package com.sda.rentalloapp.controller;

import com.sda.rentalloapp.dto.ClientDto;
import com.sda.rentalloapp.mapper.ClientMapper;
import com.sda.rentalloapp.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/clients")
@CrossOrigin("*")
public class ClientController {

    private final ClientService clientService;

    private final ClientMapper clientMapper;

    public ClientController(ClientService clientService, ClientMapper clientMapper) {
        this.clientService = clientService;
        this.clientMapper = clientMapper;
    }

    @GetMapping
    public List<ClientDto> findAllClients() {
        log.info("finding all clients");
        return clientService.findAllClients()
                .stream()
                .map(clientMapper::fromEntityToDto)
                .toList();
    }
}
