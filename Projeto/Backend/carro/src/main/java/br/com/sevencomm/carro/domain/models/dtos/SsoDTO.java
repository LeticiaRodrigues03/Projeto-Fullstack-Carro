package br.com.sevencomm.carro.domain.models.dtos;

import br.com.sevencomm.carro.domain.models.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class SsoDTO {
    // token jwt
    private String access_token;
    private User me;

    public static SsoDTO create(User user, String token) {
        SsoDTO dto = new SsoDTO();
        dto.access_token = token;
        dto.me = user;
        dto.me.setSenha(null);
        return dto;
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper m = new ObjectMapper();
        return m.writeValueAsString(this);
    }
}
