package br.com.sevencomm.carro.domain.servicesImpl;

import br.com.sevencomm.carro.data.repositories.CarroRepository;
import br.com.sevencomm.carro.data.repositories.CurtidaRepository;
import br.com.sevencomm.carro.domain.models.Carro;
import br.com.sevencomm.carro.domain.models.Curtida;
import br.com.sevencomm.carro.domain.models.User;
import br.com.sevencomm.carro.domain.models.dtos.CurtidaDTO;
import br.com.sevencomm.carro.domain.services.CurtidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CurtidaServiceImpl implements CurtidaService {

    @Autowired
    CarroRepository carroRepository;
    @Autowired
    private CurtidaRepository curtidaRepository;

    public List<Curtida> listCurtidas() {
        return curtidaRepository.findAll();
    }

    public List<CurtidaDTO> listCurtidasByCurrentUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();

        return curtidaRepository.findByUserId(currentUser.getId());
    }


    public List<CurtidaDTO> listCurtidaByCarroId(Long carroId) {

        List<Curtida> listCurtida = curtidaRepository.findByCarroId(carroId);
        List<CurtidaDTO> listCurtidDTO = new ArrayList<CurtidaDTO>();

        for (Curtida curtida : listCurtida) {
            listCurtidDTO.add(new CurtidaDTO(
                    curtida.getId(),
                    curtida.getCarro().getId(),
                    curtida.getUser().getId(),
                    curtida.getUser().getUsername()
            ));
            return listCurtidDTO;
        }
        return null;
    }

    public CurtidaDTO curtirCarro(Long carroId) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();

        Optional<Carro> optionalCarro = carroRepository.findById(carroId);

        if (!optionalCarro.isPresent())
            throw new IllegalArgumentException("Carro não existe");

        Carro carro = optionalCarro.get();

        Curtida curtidaCarro = curtidaRepository.findByCarroIdAndUserId(carro.getId(), currentUser.getId());

        if (curtidaCarro != null)
            throw new IllegalArgumentException("Você já curtiu o Carro");

        carro.setQtdCurtida(carro.getQtdCurtida() +1);

        Curtida curtida = new Curtida();

        curtida.setCarro(carro);
        curtida.setUser(currentUser);

        Curtida newCurtida = curtidaRepository.save(curtida);

        CurtidaDTO newCurtidaDTO = new CurtidaDTO();

        newCurtidaDTO.setCurtidaId(newCurtida.getId());
        newCurtidaDTO.setCarroId(newCurtida.getCarro().getId());
        newCurtidaDTO.setUserId(newCurtida.getUser().getId());
        newCurtidaDTO.setUserName(newCurtida.getUser().getUsername());
        newCurtidaDTO.setCurtido(true);
        return newCurtidaDTO;

    }

    @Override
    public void descurtirCarro(Long carroId) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();

        Optional<Carro> optionalCarro = carroRepository.findById(carroId);

        Carro carro = optionalCarro.get();
        carro.setQtdCurtida(carro.getQtdCurtida() -1);

        Curtida curtidaCarro = curtidaRepository.findByCarroIdAndUserId(carro.getId(), currentUser.getId());

        if (curtidaCarro == null)
            throw new IllegalArgumentException("Você ainda não curtiu o carro");

        curtidaRepository.deleteById(curtidaCarro.getId());

    }

}