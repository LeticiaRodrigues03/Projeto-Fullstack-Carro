package br.com.sevencomm.carro.data.repositories;

import br.com.sevencomm.carro.domain.models.Curtida;
import br.com.sevencomm.carro.domain.models.dtos.CurtidaDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurtidaRepository extends JpaRepository<Curtida, Long> {

    List<Curtida> findByCarroId(Long carroId);
    List<CurtidaDTO> findByUserId(Long userId);
    Curtida findByCarroIdAndUserId(Long carroId, Long userId);
}
