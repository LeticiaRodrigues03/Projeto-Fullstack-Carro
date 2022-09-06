package br.com.sevencomm.carro.domain.servicesImpl;

import br.com.sevencomm.carro.domain.models.dtos.SignUpDTO;
import br.com.sevencomm.carro.data.repositories.UserRepository;
import br.com.sevencomm.carro.domain.models.User;
import br.com.sevencomm.carro.domain.services.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> listUsers() {
        return userRepository.findAll();
    }
    public User signUp(SignUpDTO signUpDTO) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        User user = new User();

        user.setNome(signUpDTO.getNome());
        user.setLogin(signUpDTO.getLogin());
        user.setEmail(signUpDTO.getEmail());
        user.setSenha(bCryptPasswordEncoder.encode(signUpDTO.getSenha()));

        User newUser = userRepository.save(user);
        return newUser;
    }

}
