package edu.com.fafic.ppi.bibliotecaWeb.controller;

import edu.com.fafic.ppi.bibliotecaWeb.domain.Aluno;
import edu.com.fafic.ppi.bibliotecaWeb.domain.Biblioteca;
import edu.com.fafic.ppi.bibliotecaWeb.domain.Livro;
import edu.com.fafic.ppi.bibliotecaWeb.dto.BibliotecaDTO;
import edu.com.fafic.ppi.bibliotecaWeb.services.BibliotecaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/biblioteca")
public class BibliotecaController {

    private final BibliotecaService bibliotecaService;

    @PostMapping("/cria/biblioteca")
    public ResponseEntity save(@RequestBody BibliotecaDTO bibliotecaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bibliotecaService.save(bibliotecaDTO));
    }

    @PutMapping("/editar{biblioteca}")
    public ResponseEntity update(@RequestBody Biblioteca biblioteca) {
        Biblioteca bibliotecaUPD = bibliotecaService.update(biblioteca);
        return ResponseEntity.ok().body(biblioteca);
    }

    @GetMapping("/buscarNome/{biblioteca}")
    public ResponseEntity <Biblioteca> findByNomeBiblioteca(@PathVariable("biblioteca")String nome){
        return ResponseEntity.ok(bibliotecaService.findByNome(nome));
    }

    @DeleteMapping("/removerbiblioteca/{id}")
    public ResponseEntity < Biblioteca> removerBibliotecaPeloID (@PathVariable Long id) {
        bibliotecaService.remover(id);
        return ResponseEntity.ok().build();
    }
}
