package br.marcelo.universidade.service;

import br.marcelo.universidade.exception.ResourceNotFoundException;
import br.marcelo.universidade.model.Professor;
import br.marcelo.universidade.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public Professor createProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public Professor getProfessorById(UUID id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Professor não encontrado com o ID: " + id));
    }

    public List<Professor> getAllProfessores() {
        return professorRepository.findAll();
    }

    public void deleteProfessor(UUID id) {
        if (!professorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Professor não encontrado com o ID: " + id);
        }
        professorRepository.deleteById(id);
    }

    public Professor updateProfessor(UUID id, Professor professorAtualizado) {
        Professor professorExistente = getProfessorById(id);

        // Atualiza os campos
        professorExistente.setNomeCompleto(professorAtualizado.getNomeCompleto());
        professorExistente.setCpf(professorAtualizado.getCpf());
        professorExistente.setEmailInstitucional(professorAtualizado.getEmailInstitucional());
        professorExistente.setTelefone(professorAtualizado.getTelefone());
        professorExistente.setTitulacao(professorAtualizado.getTitulacao());
        professorExistente.setAreaDeAtuacao(professorAtualizado.getAreaDeAtuacao());
        professorExistente.setRegimeTrabalho(professorAtualizado.getRegimeTrabalho());

        return professorRepository.save(professorExistente);
    }
}