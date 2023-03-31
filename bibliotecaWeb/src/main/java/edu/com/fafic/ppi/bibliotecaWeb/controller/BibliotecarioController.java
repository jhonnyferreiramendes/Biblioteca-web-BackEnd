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

    @PostMapping()
    public ResponseEntity save(@RequestBody BibliotecarioDTO bibliotecarioDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(bibliotecarioService.save(bibliotecarioDTO));

    }
    @PostMapping("/aluno")
    public ResponseEntity saveAluno(@RequestBody AlunoDTO alunoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.save(alunoDTO));
    }

    @PostMapping("/livro")
    public ResponseEntity saveLivro (@RequestBody LivroDTO livroDTO){
        return ResponseEntity.status(HttpStatus.CREATED).
                body(livroService.saveLivro(livroDTO));
    }
    @GetMapping("/{bibliotecario}")
    public ResponseEntity <Bibliotecario> findByNome(@PathVariable("nome")String nome){
        return ResponseEntity.ok(bibliotecarioService.findByNome(nome));
    }
    @GetMapping("/{aluno}")
    public ResponseEntity<Aluno> findByNomeAluno (@PathVariable("nome") String nome){
        return ResponseEntity.ok(alunoService.findByNome(nome));
    }

    @GetMapping("/{livro}")
    public ResponseEntity<Livro> findByNomeLivro (@PathVariable("nome") String nome){
        return ResponseEntity.ok(livroService.findByNome(nome));
    }


}
