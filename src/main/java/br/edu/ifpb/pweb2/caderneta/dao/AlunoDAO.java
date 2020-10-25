package br.edu.ifpb.pweb2.caderneta.dao;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.ifpb.pweb2.caderneta.model.Aluno;
import br.edu.ifpb.pweb2.caderneta.model.Turma;

public class AlunoDAO extends GenericDAO<Aluno, Integer> {
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	public List<Aluno> findByTurma(Turma turma) {
		return entityManager
				.createQuery("SELECT aluno FROM " + entityClass.getSimpleName() + 
						" AS aluno JOIN FETCH aluno.alunoTurma AS at WHERE at.turma.id = :id")
				.setParameter("id", turma.getId())
				.getResultList();
	}

	public Aluno findByLogin(String login) {		
		try {			
			return (Aluno) entityManager
					.createQuery("SELECT object(o) FROM " + entityClass.getSimpleName() + " as o WHERE o.login = :login")
					.setParameter("login", login)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
