package br.com.sevencomm.carro.domain.models.dtos;

import br.com.sevencomm.carro.domain.models.Curtida;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarroDTO {

    private String nome;
    private String descricao;
    private String tipo;
    private boolean curtido;

}
