/*package edu.com.fafic.ppi.bibliotecaWeb.controller;

import edu.com.fafic.ppi.bibliotecaWeb.domain.Livro;
import edu.com.fafic.ppi.bibliotecaWeb.dto.LivroDTO;
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

    @PostMapping()
    public ResponseEntity save (@RequestBody LivroDTO livroDTO){
        return ResponseEntity.status(HttpStatus.CREATED).
                body(livroService.saveLivro(livroDTO));
    }


    @GetMapping("/{nome}")
    public ResponseEntity<Livro> findByNome (@PathVariable("nome") String nome){
        return ResponseEntity.ok(livroService.findByNome(nome));
    }

}
*/