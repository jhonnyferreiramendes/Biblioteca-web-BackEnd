package edu.com.fafic.ppi.bibliotecaWeb.controller;

import edu.com.fafic.ppi.bibliotecaWeb.dto.BibliotecaDTO;
import edu.com.fafic.ppi.bibliotecaWeb.services.BibliotecaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Biblioteca")
public class BibliotecaController {

    private final BibliotecaService bibliotecaService;

    @PostMapping("/cria/biblioteca")
    public ResponseEntity save (@RequestBody BibliotecaDTO bibliotecaDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(bibliotecaService.save(bibliotecaDTO));
    }


}
