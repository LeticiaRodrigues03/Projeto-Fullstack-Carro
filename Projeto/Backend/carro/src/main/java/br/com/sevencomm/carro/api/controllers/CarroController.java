package br.com.sevencomm.carro.api.controllers;

import br.com.sevencomm.carro.domain.models.Carro;
import br.com.sevencomm.carro.domain.models.dtos.CarroDTO;
import br.com.sevencomm.carro.domain.services.CarroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carro")
public class CarroController {

    private CarroService carroService;

    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping("list-carros")
    public ResponseEntity<Object> listCarros() {
        try {
            List<Carro> carro = carroService.listCarros();
            return ResponseEntity.ok(carro);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("list-carros-currentUser")
    public ResponseEntity<Object> listCarrosByCurrentUser() {
        try {
            List<CarroDTO> carroDTO = carroService.listCarrosByCurrentUser();
            return ResponseEntity.ok(carroDTO);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("add-carro")
    public ResponseEntity<Object> addCarro(@RequestBody CarroDTO carroDTO) {
        try {
            Carro carro = carroService.addCarro(carroDTO);
            return ResponseEntity.ok(carro);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

}
