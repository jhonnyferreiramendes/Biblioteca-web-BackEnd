package edu.com.fafic.ppi.bibliotecaWeb.services;


import edu.com.fafic.ppi.bibliotecaWeb.domain.Emprestimo;
import edu.com.fafic.ppi.bibliotecaWeb.domain.Livro;
import edu.com.fafic.ppi.bibliotecaWeb.domain.Login;
import edu.com.fafic.ppi.bibliotecaWeb.domain.Usuario;
import edu.com.fafic.ppi.bibliotecaWeb.domain.exceptions.ObjetoNaoEncontradoException;
import edu.com.fafic.ppi.bibliotecaWeb.dto.LoginDTO;
import edu.com.fafic.ppi.bibliotecaWeb.repositories.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class LoginService {

    private final LoginRepository loginRepository;


    public Usuario login (String email, String senha){
        return loginRepository.getByLogin(email, senha).orElseThrow(()->new ObjetoNaoEncontradoException("Usuario não encontrado"));
    }


    public Login save(LoginDTO loginDTO){
        var login = new Login(
                loginDTO.getEmail(),
                loginDTO.getSenha());
        return loginRepository.save(login);
    }

    public Login findById(Long id) {
        return loginRepository.findById(id).orElseThrow(
                () -> new ObjetoNaoEncontradoException
                        (" ' " + id + " ' não existe na base de dados"));
    }

    public void remover(Long id){
        Login login = loginRepository.findById(id).orElseThrow(()-> new ObjetoNaoEncontradoException("Login nao encontrado!"));
        loginRepository.delete(login);
    }

    public Login update (Login login){
        return loginRepository.save(login);
    }
}
