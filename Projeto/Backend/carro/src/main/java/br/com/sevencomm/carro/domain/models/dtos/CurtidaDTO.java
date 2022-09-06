package br.com.sevencomm.carro.domain.models.dtos;

import br.com.sevencomm.carro.domain.models.Carro;
import br.com.sevencomm.carro.domain.models.Curtida;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurtidaDTO {

    private Long curtidaId;
    private Long carroId;
    private Long userId;
    private String userName;
    private boolean curtido;

    public CurtidaDTO(Long curtidaId, Long id, Long id1, String username) {
    }
}
