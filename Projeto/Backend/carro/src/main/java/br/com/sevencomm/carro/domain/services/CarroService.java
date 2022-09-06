package br.com.sevencomm.carro.domain.services;

import br.com.sevencomm.carro.domain.models.Carro;
import br.com.sevencomm.carro.domain.models.dtos.CarroDTO;

import java.util.List;

public interface CarroService {
    List<Carro> listCarros();
    List<CarroDTO> listCarrosByCurrentUser();
    Carro addCarro(CarroDTO carroDTO);
}
