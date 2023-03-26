package edu.com.fafic.ppi.bibliotecaWeb.domain;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Embeddable
@Data
public class Contato {

    @Email
    private String email;

    private String telefone;
}
