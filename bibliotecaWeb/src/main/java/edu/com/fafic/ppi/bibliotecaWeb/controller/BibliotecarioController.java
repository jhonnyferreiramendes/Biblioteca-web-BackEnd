package edu.com.fafic.ppi.bibliotecaWeb.controller;


import edu.com.fafic.ppi.bibliotecaWeb.domain.*;
import edu.com.fafic.ppi.bibliotecaWeb.dto.*;
import edu.com.fafic.ppi.bibliotecaWeb.services.*;
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
    private final EmprestimoService emprestimoService;
    private final DevolucaoService devolucaoService;


    @PostMapping("/criar/bibliotecario")
    public ResponseEntity saveBibliotecario(@RequestBody BibliotecarioDTO bibliotecarioDTO){
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
    @PostMapping("/criar/emprestimo")
    public ResponseEntity saveEmprestimo(@RequestBody EmprestimoDTO emprestimoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(emprestimoService.saveEmprestimo(emprestimoDTO));
    }

    @PostMapping("/criar/devolucao")
    public ResponseEntity saveDevolucao(@RequestBody DevolucaoDTO devolucaoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(devolucaoService.saveDevolucao(devolucaoDTO));
    }

    @PutMapping("/editar/bibliotecario")
    public ResponseEntity updateBibliotecario(@RequestBody Bibliotecario bibliotecario){
        Bibliotecario bibliotecarioUPD = bibliotecarioService.update(bibliotecario);
        return ResponseEntity.ok().body(bibliotecario);
    }

    @PutMapping("editar/livro")
    public ResponseEntity updateLivro(@RequestBody Livro livro){
        Livro livroUPD = livroService.update(livro);
        return ResponseEntity.ok().body(livro);
    }

    @PutMapping("editar/aluno")
    public ResponseEntity updateAluno(@RequestBody Aluno aluno){
        Aluno alunoUPD = alunoService.update(aluno);
        return ResponseEntity.ok().body(aluno);
    }

    @PutMapping("editar/professor")
    public ResponseEntity updateProfessor(@RequestBody Professor professor){
        Professor professorUPD = professorService.update(professor);
        return ResponseEntity.ok().body(professor);
    }

    @PutMapping("editar/emprestimo")
    public ResponseEntity updateEmprestimo(@RequestBody Emprestimo emprestimo){
        Emprestimo emprestimoUPD = emprestimoService.update(emprestimo);
        return ResponseEntity.ok().body(emprestimo);
    }

    @PutMapping("editar/devolucao")
    public ResponseEntity updateProfessor(@RequestBody Devolucao devolucao){
        Devolucao devolucaoUPD = devolucaoService.update(devolucao);
        return ResponseEntity.ok().body(devolucao);
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

    @GetMapping("/buscarEmprestimo/Emprestimo/{emprestimo}")
    public ResponseEntity<Emprestimo> findByEmprestimoID(@PathVariable("emprestimo") Long id){
        return ResponseEntity.ok(emprestimoService.findById(id));
    }

    @GetMapping("/buscarDevolucao/Devolucao/{devolucao}")
    public ResponseEntity<Devolucao> findByDevolucaoID(@PathVariable("devolucao") Long id){
        return ResponseEntity.ok(devolucaoService.findById(id));
    }

    @DeleteMapping("/removerLivro/{isbn}")
    public ResponseEntity <Livro> removerLivroPorIsbn (@PathVariable String isbn) {
        livroService.remover(isbn);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/removerLivro2/{isbn}")
    public ResponseEntity <Livro> remover2 (@PathVariable String isbn) {
        livroService.remover(isbn);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/removerAluno/{matricula}")
    public ResponseEntity <Aluno> removerAlunoPorMatricula (@PathVariable String matricula) {
        alunoService.remover(matricula);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/removerProfessor/{matricula}")
    public ResponseEntity <Professor> removerProfessorPorMatricula (@PathVariable String matricula) {
        professorService.remover(matricula);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/removerBibliotecario/{cib}")
    public ResponseEntity <Bibliotecario> removerBibliotecarioPorCib (@PathVariable String cib) {
        bibliotecarioService.remover(cib);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/removerEmprestimo/{id}")
    public ResponseEntity <Emprestimo> removerEmprestimoPorId (@PathVariable Long id) {
        emprestimoService.remover(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/removerDevolucao/{id}")
    public ResponseEntity <Devolucao> removerDevolucaoPorId (@PathVariable Long id) {
        devolucaoService.remover(id);
        return ResponseEntity.ok().build();
    }

}
