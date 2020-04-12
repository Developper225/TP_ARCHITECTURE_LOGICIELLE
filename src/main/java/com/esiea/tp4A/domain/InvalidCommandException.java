package com.esiea.tp4A.domain;

class InvalidCommandException extends RuntimeException {
    InvalidCommandException(String text) {
        super(text);
    }
}
