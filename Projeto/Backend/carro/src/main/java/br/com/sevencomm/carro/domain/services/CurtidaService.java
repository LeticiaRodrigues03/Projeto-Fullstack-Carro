package br.com.sevencomm.carro.domain.services;

import br.com.sevencomm.carro.domain.models.Curtida;
import br.com.sevencomm.carro.domain.models.dtos.CurtidaDTO;


import java.util.List;

public interface CurtidaService {
      List<CurtidaDTO> listCurtidasByCurrentUser();
      List<Curtida> listCurtidas();
      CurtidaDTO curtirCarro(Long carroId);
      void descurtirCarro(Long carroId);
      List<CurtidaDTO> listCurtidaByCarroId(Long carroId);
}
