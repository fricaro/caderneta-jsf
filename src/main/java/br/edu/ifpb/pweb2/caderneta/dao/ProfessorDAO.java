package br.edu.ifpb.pweb2.caderneta.dao;

import javax.persistence.NoResultException;

import br.edu.ifpb.pweb2.caderneta.model.Professor;

public class ProfessorDAO extends GenericDAO<Professor, Integer> {
	private static final long serialVersionUID = 1L;

	public Professor findByLogin(String login) {		
		try {			
			return (Professor) entityManager
					.createQuery("SELECT object(o) FROM " + entityClass.getSimpleName() + " as o WHERE o.login = :login")
					.setParameter("login", login)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
