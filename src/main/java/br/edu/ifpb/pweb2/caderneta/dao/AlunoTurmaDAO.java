package br.edu.ifpb.pweb2.caderneta.dao;

import javax.persistence.Query;

import br.edu.ifpb.pweb2.caderneta.model.Aluno;
import br.edu.ifpb.pweb2.caderneta.model.AlunoTurma;
import br.edu.ifpb.pweb2.caderneta.model.Turma;

public class AlunoTurmaDAO extends GenericDAO<AlunoTurma, Integer> {
	private static final long serialVersionUID = 1L;
	
	public AlunoTurma getAlunoTurmaByAlunoAndTurma(Aluno aluno, Turma turma) {
		Query q = entityManager.createQuery("SELECT at FROM AlunoTurma AS at WHERE at.aluno = :aluno AND at.turma = :turma");
		q.setParameter("aluno", aluno);
		q.setParameter("turma", turma);
		return (AlunoTurma) q.getSingleResult();
	}

}
