package br.com.unipac.protocolo.protocoloapi.modelo.repositorio;

import br.com.unipac.protocolo.protocoloapi.modelo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
