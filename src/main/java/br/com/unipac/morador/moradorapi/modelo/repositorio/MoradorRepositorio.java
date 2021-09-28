package br.com.unipac.morador.moradorapi.modelo.repositorio;

import br.com.unipac.morador.moradorapi.modelo.domain.Morador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoradorRepositorio extends JpaRepository<Morador, Long> {
}
