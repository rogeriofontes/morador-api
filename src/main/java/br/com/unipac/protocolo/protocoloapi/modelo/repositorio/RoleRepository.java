package br.com.unipac.protocolo.protocoloapi.modelo.repositorio;

import br.com.unipac.protocolo.protocoloapi.modelo.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
