package Moutinho.ApiCrud.repository;

import Moutinho.ApiCrud.domain.UnidadeMedida.UnidadeMedida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnidadeDeMedidaRepository extends JpaRepository<UnidadeMedida, Long> {
}
