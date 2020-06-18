package it.Trilogia.thefridgemobile.implementation.exception;

public class IdUsedException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private final int newId;

    public IdUsedException( int id ) {
        this.newId = id + 1;
    }

    /**
     * @return the newId
     */
    public int getNewId() {
        return newId;
    }
}
