package edu.com.fafic.ppi.bibliotecaWeb.controller;


import edu.com.fafic.ppi.bibliotecaWeb.domain.Aluno;
import edu.com.fafic.ppi.bibliotecaWeb.domain.Bibliotecario;
import edu.com.fafic.ppi.bibliotecaWeb.domain.Livro;
import edu.com.fafic.ppi.bibliotecaWeb.domain.Professor;
import edu.com.fafic.ppi.bibliotecaWeb.dto.AlunoDTO;
import edu.com.fafic.ppi.bibliotecaWeb.dto.BibliotecarioDTO;
import edu.com.fafic.ppi.bibliotecaWeb.dto.LivroDTO;
import edu.com.fafic.ppi.bibliotecaWeb.dto.ProfessorDTO;
import edu.com.fafic.ppi.bibliotecaWeb.services.AlunoService;
import edu.com.fafic.ppi.bibliotecaWeb.services.BibliotecarioService;
import edu.com.fafic.ppi.bibliotecaWeb.services.LivroService;
import edu.com.fafic.ppi.bibliotecaWeb.services.ProfessorService;
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
    private final ProfessorService professorService;

    @PostMapping("/criar/bibliotecario")
    public ResponseEntity save(@RequestBody BibliotecarioDTO bibliotecarioDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(bibliotecarioService.save(bibliotecarioDTO));
    }
    @PostMapping("/criar/aluno")
    public ResponseEntity saveAluno(@RequestBody AlunoDTO alunoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.save(alunoDTO));
    }

    @PostMapping("/criar/professor")
    public ResponseEntity saveProfessor(@RequestBody ProfessorDTO professorDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(professorService.save(professorDTO));
    }

    @PostMapping("/criar/livro")
    public ResponseEntity saveLivro (@RequestBody LivroDTO livroDTO){
        return ResponseEntity.status(HttpStatus.CREATED).
                body(livroService.saveLivro(livroDTO));
    }
    @GetMapping("/buscarNome/bibliotecario/{bibliotecario}")
    public ResponseEntity <Bibliotecario> findByNomeBibliotecario(@PathVariable("bibliotecario")String nome){
        return ResponseEntity.ok(bibliotecarioService.findByNome(nome));
    }
    @GetMapping("/buscarNome/aluno/{aluno}")
    public ResponseEntity<Aluno> findByNomeAluno (@PathVariable("aluno") String nome){
        return ResponseEntity.ok(alunoService.findByNome(nome));
    }

    @GetMapping("/buscarNome/professor/{professor}")
    public ResponseEntity<Professor> findByNomeProfessor (@PathVariable("professor") String nome){
        return ResponseEntity.ok(professorService.findByNome(nome));
    }

    @GetMapping("/buscarMatricula/aluno/{aluno}")
    public ResponseEntity<Aluno> findByMatriculaAluno (@PathVariable("aluno") String matricula){
        return ResponseEntity.ok(alunoService.findByMatricula(matricula));
    }

    @GetMapping("/buscarMatricula/professor/{professor}")
    public ResponseEntity<Professor> findByMatriculaProfessor (@PathVariable("professor") String matricula){
        return ResponseEntity.ok(professorService.findByMatricula(matricula));
    }

    @GetMapping("/buscarArea/livro/{livro}")
    public ResponseEntity<Livro> findByAreaLivro (@PathVariable("livro") Enum area){
        return ResponseEntity.ok(livroService.findByArea(area.name()));
    }

    @GetMapping("/buscarIsbn/livro/{livro}")
    public ResponseEntity<Livro> findByIsbnLivro (@PathVariable("livro") String isbn){
        return ResponseEntity.ok(livroService.findByIsbn(isbn));
    }

    @GetMapping("/buscarNome/livro/{livro}")
    public ResponseEntity<Livro> findByNomeOrIsbnLivro (@PathVariable("livro") String nome){
        return ResponseEntity.ok(livroService.findByNome(nome));
    }


}
