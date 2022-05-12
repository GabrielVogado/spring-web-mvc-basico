package br.com.spring.study.springwebmvc.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "jedi")
@Data
public class Jedi {

    @Id
    @Column(name = "id_jedi")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Size(min = 3, max = 10, message = "Sobrenome deve conter entre 3 e 10 caracteres")
    @NotBlank(message = "Sobrenome não pode estar em branco")
    @NotEmpty
    @Column(name = "last_name")
    private String lastName;
    @NotNull
    @NotEmpty
    @NotBlank(message = "Nome não pode estar em branco")
    @Column(name = "name")
    private String name;

    public Jedi(final String name, final String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Jedi() {
    }

}
