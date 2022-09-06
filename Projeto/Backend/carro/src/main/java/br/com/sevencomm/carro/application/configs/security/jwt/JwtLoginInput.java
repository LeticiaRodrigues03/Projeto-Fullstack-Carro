package br.com.sevencomm.carro.application.configs.security.jwt;

import lombok.Data;

@Data
class JwtLoginInput {
    private String username;
    private String password;
}