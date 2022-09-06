package br.com.sevencomm.carro.domain.services;

import br.com.sevencomm.carro.domain.models.dtos.SignUpDTO;
import br.com.sevencomm.carro.domain.models.User;

import java.util.List;

public interface UserService {
    List<User> listUsers();
    User signUp(SignUpDTO signUpDTO);
}
