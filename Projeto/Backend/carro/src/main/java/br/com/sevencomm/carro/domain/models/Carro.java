package br.com.sevencomm.carro.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String descricao;
    private String tipo;
    private int qtdCurtida = 0;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
