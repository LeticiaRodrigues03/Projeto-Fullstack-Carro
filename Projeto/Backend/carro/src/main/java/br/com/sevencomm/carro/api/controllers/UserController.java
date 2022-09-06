package br.com.sevencomm.carro.api.controllers;

import br.com.sevencomm.carro.domain.models.dtos.SignUpDTO;
import br.com.sevencomm.carro.domain.models.User;
import br.com.sevencomm.carro.domain.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list-users")
    public ResponseEntity<Object> listsUsers() {
        try {
            List<User> user = userService.listUsers();
            return ResponseEntity.ok(user);
        }catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

    }

    @PostMapping("sign-up")
    public ResponseEntity<Object> SignUp(@RequestBody SignUpDTO signUpDTO) {
        try {
            User user = userService.signUp(signUpDTO);
            return ResponseEntity.ok(user);
        }catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
