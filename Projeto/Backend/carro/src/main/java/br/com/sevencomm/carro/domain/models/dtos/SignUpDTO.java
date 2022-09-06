package br.com.sevencomm.carro.domain.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDTO {

    private String nome;
    private String login;
    private String email;
    private String senha;

}
