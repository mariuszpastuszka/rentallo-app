package com.sda.rentalloapp.mapper;

public interface Mapper<E, D> {

    D fromEntityToDto(E entity);

    E fromDtoToEntity(D dto);
}
