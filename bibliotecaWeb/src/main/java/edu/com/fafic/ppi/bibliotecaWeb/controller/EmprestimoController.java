package edu.com.fafic.ppi.bibliotecaWeb.controller;

import edu.com.fafic.ppi.bibliotecaWeb.dto.BibliotecarioDTO;
import edu.com.fafic.ppi.bibliotecaWeb.dto.EmprestimoDTO;
import edu.com.fafic.ppi.bibliotecaWeb.services.EmprestimoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Emprestimo")
public class EmprestimoController {

    public final EmprestimoService emprestimoService;

    @PostMapping("/criar/bibliotecario")
    public ResponseEntity save(@RequestBody EmprestimoDTO emprestimoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(emprestimoService.saveEmprestimo(emprestimoDTO));
    }

}
