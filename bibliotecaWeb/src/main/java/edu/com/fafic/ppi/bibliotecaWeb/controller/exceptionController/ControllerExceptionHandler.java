package edu.com.fafic.ppi.bibliotecaWeb.controller.exceptionController;

import edu.com.fafic.ppi.bibliotecaWeb.Exception.PadraoException;
import edu.com.fafic.ppi.bibliotecaWeb.domain.exceptions.ObjetoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

import java.time.LocalDate;

@ControllerAdvice

public class ControllerExceptionHandler {

    @ExceptionHandler(ObjetoNaoEncontradoException.class)
    public ResponseEntity<PadraoException> objetoNaoEncontradoException(
            ObjetoNaoEncontradoException ex, HttpServletRequest request
    ){
        return ResponseEntity.status(HttpStatus.OK)
                .body(PadraoException.builder()
                        .erro("Objeto nao encontrado!")
                        .message(ex.getMessage())
                        .path(request.getRequestURI())
                        .status(HttpStatus.NO_CONTENT.value())
                        .timetamp(LocalDate.now())
                        .build());


    }
}
