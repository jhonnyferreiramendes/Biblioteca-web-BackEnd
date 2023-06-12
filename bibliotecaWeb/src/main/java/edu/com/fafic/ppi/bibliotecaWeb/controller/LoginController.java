package edu.com.fafic.ppi.bibliotecaWeb.controller;


import edu.com.fafic.ppi.bibliotecaWeb.domain.Biblioteca;
import edu.com.fafic.ppi.bibliotecaWeb.domain.Login;
import edu.com.fafic.ppi.bibliotecaWeb.domain.Usuario;
import edu.com.fafic.ppi.bibliotecaWeb.dto.BibliotecaDTO;
import edu.com.fafic.ppi.bibliotecaWeb.dto.LoginDTO;
import edu.com.fafic.ppi.bibliotecaWeb.services.BibliotecaService;
import edu.com.fafic.ppi.bibliotecaWeb.services.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public ResponseEntity login(@RequestBody Login login) {
        try{
            Usuario u = loginService.login(login.getEmail(), login.getSenha());
            return ResponseEntity.ok(u);
        } catch (Exception err){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err.getMessage());
        }

    }

    @PostMapping("/cria/login")
    public ResponseEntity save(@RequestBody LoginDTO loginDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(loginService.save(loginDTO));
    }

    @PutMapping("/editar{login}")
    public ResponseEntity update(@RequestBody Login login) {
        Login loginUPD = loginService.update(login);
        return ResponseEntity.ok().body(login);
    }

    @GetMapping("{login}")
    public ResponseEntity <Login> findById(@PathVariable("login")Long id){
        return ResponseEntity.ok(loginService.findById(id));
    }


    @DeleteMapping("/removerlogin/{id}")
    public ResponseEntity <Login> remover (@PathVariable Long id) {
        loginService.remover(id);
        return ResponseEntity.ok().build();
    }
}
