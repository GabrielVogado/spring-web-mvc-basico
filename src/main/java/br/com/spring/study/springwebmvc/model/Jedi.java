package br.com.spring.study.springwebmvc.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Jedi {

    @NotBlank
    @NotNull
    private  String lastName;

    @NotBlank
    @NotNull
    private  String name;

    public Jedi(final String name, final String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Jedi() {
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
