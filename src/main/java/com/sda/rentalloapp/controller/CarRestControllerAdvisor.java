package com.sda.rentalloapp.controller;

import com.sda.rentalloapp.dto.ResponseDto;
import com.sda.rentalloapp.exception.WrongCarIdException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class CarRestControllerAdvisor {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(WrongCarIdException.class)
    public ResponseDto handleCarNotFoundException(WrongCarIdException exc) {
        String path = ServletUriComponentsBuilder.fromCurrentRequest()
                .build()
                .getPath();


        return ResponseDto.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .error("Not found")
                .message(exc.getMessage())
                .path(path)
                .build();
    }
}
