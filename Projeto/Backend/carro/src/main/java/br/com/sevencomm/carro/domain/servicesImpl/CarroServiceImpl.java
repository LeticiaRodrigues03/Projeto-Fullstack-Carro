package br.com.sevencomm.carro.domain.servicesImpl;

import br.com.sevencomm.carro.data.repositories.CarroRepository;
import br.com.sevencomm.carro.domain.models.Carro;
import br.com.sevencomm.carro.domain.models.User;
import br.com.sevencomm.carro.domain.models.dtos.CarroDTO;
import br.com.sevencomm.carro.domain.services.CarroService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroServiceImpl implements CarroService {

    private CarroRepository carroRepository;

    public CarroServiceImpl(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    public List<Carro> listCarros() {
        return carroRepository.findAll();
    }

    public List<CarroDTO> listCarrosByCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();

        return carroRepository.findByUserId(currentUser.getId());
    }

    public Carro addCarro(CarroDTO carroDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();

        Carro carro = new Carro();
        carro.setNome(carroDTO.getNome());
        carro.setDescricao(carroDTO.getDescricao());
        carro.setTipo(carroDTO.getTipo());
        carro.setUser(currentUser);

        Carro newCarro = carroRepository.save(carro);
        return newCarro;
    }
}
