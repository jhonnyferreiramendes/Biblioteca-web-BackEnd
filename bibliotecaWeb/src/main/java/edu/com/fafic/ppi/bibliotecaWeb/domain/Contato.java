package edu.com.fafic.ppi.bibliotecaWeb.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.Email;
import lombok.Data;

@Embeddable
@Data
public class Contato {

    @Email
    private String email;

    private String telefone;
}
