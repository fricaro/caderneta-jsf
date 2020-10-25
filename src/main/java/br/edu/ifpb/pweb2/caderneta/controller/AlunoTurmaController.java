package br.edu.ifpb.pweb2.caderneta.controller;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.edu.ifpb.pweb2.caderneta.dao.AlunoTurmaDAO;
import br.edu.ifpb.pweb2.caderneta.dao.Transactional;
import br.edu.ifpb.pweb2.caderneta.model.Aluno;
import br.edu.ifpb.pweb2.caderneta.model.AlunoTurma;
import br.edu.ifpb.pweb2.caderneta.model.Turma;

public class AlunoTurmaController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private AlunoTurmaDAO alunoTurmaDAO;
	
	@Transactional
	public void excluir(AlunoTurma alunoTurma) {
		alunoTurmaDAO.delete(alunoTurma);
		
	}
	
	@Transactional
	public AlunoTurma update(AlunoTurma alunoTurma) {
		return alunoTurmaDAO.update(alunoTurma);
	}
	
	public void refresh(AlunoTurma alunoTurma) {
		alunoTurmaDAO.refresh(alunoTurma);
	}
	
	public List<AlunoTurma> findAll() {
		return alunoTurmaDAO.findAll();
	}
	
	public AlunoTurma find(Integer id) {
		return alunoTurmaDAO.find(id);
	}
	
	public AlunoTurma getAlunoTurmaByAlunoAndTurma(Aluno aluno, Turma turma) {
		return alunoTurmaDAO.getAlunoTurmaByAlunoAndTurma(aluno, turma);
	}
	
	@Transactional
	public AlunoTurma insert(AlunoTurma alunoTurma) {
		return alunoTurmaDAO.insert(alunoTurma);
	}
	
	@Transactional
	public void saveOrUpdate(AlunoTurma alunoTurma) {
		if (alunoTurma.getId() != null) {
			alunoTurma = alunoTurmaDAO.update(alunoTurma);
		} else {
			alunoTurmaDAO.insert(alunoTurma);
		}
	}

}
