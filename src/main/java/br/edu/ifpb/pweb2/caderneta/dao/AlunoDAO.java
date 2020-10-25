package br.edu.ifpb.pweb2.caderneta.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.ifpb.pweb2.caderneta.model.Aluno;

public class AlunoDAO extends GenericDAO<Aluno, Integer> {
	private static final long serialVersionUID = 1L;

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
