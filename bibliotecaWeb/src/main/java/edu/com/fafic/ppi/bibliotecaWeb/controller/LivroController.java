package edu.com.fafic.ppi.bibliotecaWeb.controller;

import edu.com.fafic.ppi.bibliotecaWeb.domain.Livro;
import edu.com.fafic.ppi.bibliotecaWeb.services.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livro")
@RequiredArgsConstructor
public class LivroController {

    private final LivroService livroService;

    @PostMapping
    public ResponseEntity save (@RequestBody Livro livro){
        return ResponseEntity.status(HttpStatus.CREATED).
                body(livroService.save(livro));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Livro> findById (@PathVariable("id") long id){
        return ResponseEntity.ok(livroService.findById(id));
    }

}
