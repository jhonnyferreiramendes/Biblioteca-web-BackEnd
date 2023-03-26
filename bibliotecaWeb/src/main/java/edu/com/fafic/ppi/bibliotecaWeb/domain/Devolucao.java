package edu.com.fafic.ppi.bibliotecaWeb.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


import java.time.LocalDateTime;


@Data
@Embeddable

public class Devolucao {


    @NotBlank
    private LocalDateTime dataDevolucao;

    @NotBlank
    private Boolean devolvido;



}
