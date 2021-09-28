package br.com.unipac.morador.moradorapi.modelo.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_moradores")
public class Morador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column(name = "full_name") //fullName
    private String nome;
    private String email;
    private Integer idade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Moderador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", idade=" + idade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Morador morador = (Morador) o;
        return Objects.equals(id, morador.id) && Objects.equals(nome, morador.nome) && Objects.equals(email, morador.email) && Objects.equals(idade, morador.idade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, idade);
    }
}