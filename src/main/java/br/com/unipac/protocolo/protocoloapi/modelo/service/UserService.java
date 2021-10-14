package br.com.unipac.protocolo.protocoloapi.modelo.service;

import br.com.unipac.protocolo.protocoloapi.modelo.domain.User;

public interface UserService {
    void save(User user);
    User findByUsername(String username);
}
