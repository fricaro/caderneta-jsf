package br.edu.ifpb.pweb2.caderneta.dao;

import javax.persistence.NoResultException;

import br.edu.ifpb.pweb2.caderneta.model.Coordenador;

public class CoordenadorDAO extends GenericDAO<Coordenador, Integer> {
	private static final long serialVersionUID = 1L;
	
	public Coordenador findByLogin(String login) {		
		try {			
			return (Coordenador) entityManager
					.createQuery("SELECT object(o) FROM " + entityClass.getSimpleName() + " as o WHERE o.login = :login")
					.setParameter("login", login)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
