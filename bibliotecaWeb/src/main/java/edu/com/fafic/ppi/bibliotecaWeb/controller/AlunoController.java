/*package edu.com.fafic.ppi.bibliotecaWeb.controller;

import edu.com.fafic.ppi.bibliotecaWeb.domain.Aluno;
import edu.com.fafic.ppi.bibliotecaWeb.domain.Livro;
import edu.com.fafic.ppi.bibliotecaWeb.dto.AlunoDTO;
import edu.com.fafic.ppi.bibliotecaWeb.services.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aluno")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @PostMapping()
    public ResponseEntity saveAluno(@RequestBody AlunoDTO alunoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.save(alunoDTO));
    }

    @GetMapping("/{nome}")
    public ResponseEntity<Aluno> findByNome (@PathVariable("nome") String nome){
        return ResponseEntity.ok(alunoService.findByNome(nome));
    }

}
*/