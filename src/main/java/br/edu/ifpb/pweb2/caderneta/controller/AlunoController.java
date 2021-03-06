package br.edu.ifpb.pweb2.caderneta.controller;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.edu.ifpb.pweb2.caderneta.dao.AlunoDAO;
import br.edu.ifpb.pweb2.caderneta.dao.Transactional;
import br.edu.ifpb.pweb2.caderneta.model.Aluno;
import br.edu.ifpb.pweb2.caderneta.model.Turma;

public class AlunoController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private AlunoDAO alunoDAO;
	
	@Transactional
	public void excluir(Aluno aluno) {
		alunoDAO.delete(aluno);
		
	}
	
	@Transactional
	public Aluno update(Aluno aluno) {
		return alunoDAO.update(aluno);
	}
	
	public List<Aluno> findByTurma(Turma turma) {
		return alunoDAO.findByTurma(turma);
	}
	
	public void refresh(Aluno aluno) {
		alunoDAO.refresh(aluno);
	}
	
	public List<Aluno> findAll() {
		return alunoDAO.findAll();
	}
	
	public Aluno find(Integer id) {
		return alunoDAO.find(id);
	}
	
	@Transactional
	public Aluno insert(Aluno aluno) {
		return alunoDAO.insert(aluno);
	}
	
	@Transactional
	public void saveOrUpdate(Aluno aluno) {
		if (aluno.getId() != null) {
			aluno = alunoDAO.update(aluno);
		} else {
			alunoDAO.insert(aluno);
		}
	}

	public Aluno findByLogin(String login) {
		return alunoDAO.findByLogin(login);
	}

}
