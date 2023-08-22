package com.sda.rentalloapp.mapper;

import com.sda.rentalloapp.domain.Client;
import com.sda.rentalloapp.dto.ClientDto;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper implements Mapper<Client, ClientDto> {
    @Override
    public ClientDto fromEntityToDto(Client entity) {
        return null;
    }

    @Override
    public Client fromDtoToEntity(ClientDto dto) {
        return null;
    }
}
