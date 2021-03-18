package edu.eci.ieti.taskplannerapi.persistence;

public class PersistenseException extends Exception {

    private String message;

    public PersistenseException(String message) {
        this.message  = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
