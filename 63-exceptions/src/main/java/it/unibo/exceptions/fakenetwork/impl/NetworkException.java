package it.unibo.exceptions.fakenetwork.impl;

import java.io.IOException;
import java.util.Objects;

public class NetworkException extends IOException {

    public NetworkException() {
        super("Network error: no response");
    }

    public NetworkException(String message) {
        super(message);
        Objects.requireNonNull(message);
    }
    
}
