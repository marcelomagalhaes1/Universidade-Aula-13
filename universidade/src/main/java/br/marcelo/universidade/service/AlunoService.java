package br.marcelo.universidade.service;

import br.marcelo.universidade.exception.ResourceNotFoundException;
import br.marcelo.universidade.model.Aluno;
import br.marcelo.universidade.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno createAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno getAlunoById(UUID id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado com o ID: " + id));
    }

    public List<Aluno> getAllAlunos() {
        return alunoRepository.findAll();
    }
}