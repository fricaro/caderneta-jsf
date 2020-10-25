package br.edu.ifpb.pweb2.caderneta.dao;

import java.util.List;

import br.edu.ifpb.pweb2.caderneta.model.Disciplina;
import br.edu.ifpb.pweb2.caderneta.model.Turma;

public class TurmaDAO extends GenericDAO<Turma, Integer> {
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	public List<Turma> findByDisciplina(Disciplina disciplina) {
		return entityManager
				.createQuery("SELECT turma FROM " + entityClass.getSimpleName() + " AS turma WHERE turma.disciplina.id = :id")
				.setParameter("id", disciplina.getId())
				.getResultList();
	}

}
