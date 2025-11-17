package br.marcelo.universidade.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nomeCompleto;
    private String matricula;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carteira_id", referencedColumnName = "id")
    private CarteiraEstudante carteira;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor orientador;

    @ManyToMany(mappedBy = "alunosAtendidos")
    @JsonIgnore
    private List<Funcionario> funcionariosAtendimento;

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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public CarteiraEstudante getCarteira() {
        return carteira;
    }

    public void setCarteira(CarteiraEstudante carteira) {
        this.carteira = carteira;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Professor getOrientador() {
        return orientador;
    }

    public void setOrientador(Professor orientador) {
        this.orientador = orientador;
    }

    public List<Funcionario> getFuncionariosAtendimento() {
        return funcionariosAtendimento;
    }

    public void setFuncionariosAtendimento(List<Funcionario> funcionariosAtendimento) {
        this.funcionariosAtendimento = funcionariosAtendimento;
    }
}