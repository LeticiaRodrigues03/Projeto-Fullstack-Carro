package br.com.sevencomm.carro.data.repositories;

import br.com.sevencomm.carro.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByLogin(String username);
}
