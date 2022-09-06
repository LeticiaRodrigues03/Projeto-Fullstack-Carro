package br.com.sevencomm.carro.api.controllers;

import br.com.sevencomm.carro.domain.models.Curtida;
import br.com.sevencomm.carro.domain.models.dtos.CurtidaDTO;
import br.com.sevencomm.carro.domain.services.CurtidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curtida")
public class CurtidaController {

    @Autowired
    CurtidaService curtidaService;

    @GetMapping("/list-curtidas")
    public ResponseEntity<Object> listCurtidas() {
        try {
            List<Curtida> curtida = curtidaService.listCurtidas();
            return ResponseEntity.ok(curtida);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/list-user-curtida-carro")
    public ResponseEntity<Object> listCurtidaByCarroId(@RequestParam Long carroId) {
        try {
            List<CurtidaDTO> curtida = curtidaService.listCurtidaByCarroId(carroId);
            return ResponseEntity.ok(curtida);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/list-curtidas-currentUser")
    public ResponseEntity<Object> listCurtidasByCurrentUser() {
        try {
            List<CurtidaDTO> curtidaDTO = curtidaService.listCurtidasByCurrentUser();
            return ResponseEntity.ok(curtidaDTO);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/add-curtida")
    public ResponseEntity<Object> curtirCarro(@RequestBody Long carroId) {
        try {
            CurtidaDTO curtida = curtidaService.curtirCarro(carroId);
            return ResponseEntity.ok(curtida);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/remover-curtida")
    public ResponseEntity<Object> descurtirCarro(@RequestBody Long carroId) {
        try {
            curtidaService.descurtirCarro(carroId);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

}
