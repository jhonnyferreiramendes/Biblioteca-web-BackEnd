package edu.com.fafic.ppi.bibliotecaWeb.controller;


import edu.com.fafic.ppi.bibliotecaWeb.domain.Aluno;
import edu.com.fafic.ppi.bibliotecaWeb.domain.Bibliotecario;
import edu.com.fafic.ppi.bibliotecaWeb.domain.Livro;
import edu.com.fafic.ppi.bibliotecaWeb.dto.AlunoDTO;
import edu.com.fafic.ppi.bibliotecaWeb.dto.BibliotecarioDTO;
import edu.com.fafic.ppi.bibliotecaWeb.dto.LivroDTO;
import edu.com.fafic.ppi.bibliotecaWeb.services.AlunoService;
import edu.com.fafic.ppi.bibliotecaWeb.services.BibliotecarioService;
import edu.com.fafic.ppi.bibliotecaWeb.services.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bibliotecario")
@RequiredArgsConstructor

public class BibliotecarioController {

    private final BibliotecarioService bibliotecarioService;
    private final LivroService livroService;
    private final AlunoService alunoService;

    @PostMapping("/criar/bibliotecario")
    public ResponseEntity save(@RequestBody BibliotecarioDTO bibliotecarioDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(bibliotecarioService.save(bibliotecarioDTO));

    }
    @PostMapping("/criar/aluno")
    public ResponseEntity saveAluno(@RequestBody AlunoDTO alunoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.save(alunoDTO));
    }

    @PostMapping("/criar/livro")
    public ResponseEntity saveLivro (@RequestBody LivroDTO livroDTO){
        return ResponseEntity.status(HttpStatus.CREATED).
                body(livroService.saveLivro(livroDTO));
    }
    @GetMapping("/buscar/bibliotecario/{bibliotecario}")
    public ResponseEntity <Bibliotecario> findByNome(@PathVariable("nome")String nome){
        return ResponseEntity.ok(bibliotecarioService.findByNome(nome));
    }
    @GetMapping("/buscar/aluno/{aluno}")
    public ResponseEntity<Aluno> findByNomeAluno (@PathVariable("nome") String nome){
        return ResponseEntity.ok(alunoService.findByNome(nome));
    }

    @GetMapping("/buscar/livro{livro}")
    public ResponseEntity<Livro> findByNomeLivro (@PathVariable("nome") String nome){
        return ResponseEntity.ok(livroService.findByNome(nome));
    }


}
