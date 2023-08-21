package com.sda.rentalloapp.exception;

// TODO: handle exceptions in advisor
public class WrongAddressIdException extends RuntimeException {

    public WrongAddressIdException() {
    }

    public WrongAddressIdException(String message) {
        super(message);
    }

    public WrongAddressIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongAddressIdException(Throwable cause) {
        super(cause);
    }

    public WrongAddressIdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
