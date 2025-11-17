package br.marcelo.universidade.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nomeCompleto;
    private String cargo;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    @ManyToMany(mappedBy = "equipeSuporte")
    @JsonIgnore
    private List<Professor> professoresParceiros;

    @ManyToMany
    @JoinTable(name = "aluno_funcionario", joinColumns = @JoinColumn(name = "funcionario_id"), inverseJoinColumns = @JoinColumn(name = "aluno_id"))
    private List<Aluno> alunosAtendidos;

    // Getters e Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Professor> getProfessoresParceiros() {
        return professoresParceiros;
    }

    public void setProfessoresParceiros(List<Professor> professoresParceiros) {
        this.professoresParceiros = professoresParceiros;
    }

    public List<Aluno> getAlunosAtendidos() {
        return alunosAtendidos;
    }

    public void setAlunosAtendidos(List<Aluno> alunosAtendidos) {
        this.alunosAtendidos = alunosAtendidos;
    }
}