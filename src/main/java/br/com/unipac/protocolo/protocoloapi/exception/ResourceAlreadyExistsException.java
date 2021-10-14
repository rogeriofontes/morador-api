package br.com.unipac.protocolo.protocoloapi.exception;

public class ResourceAlreadyExistsException extends Exception {
    public ResourceAlreadyExistsException() {
    }

    public ResourceAlreadyExistsException(String msg) {
        super(msg);
    }
}
