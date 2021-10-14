package br.com.unipac.protocolo.protocoloapi.modelo.service;

public interface SecurityService {
    boolean isAuthenticated();
    void autoLogin(String username, String password);
}
