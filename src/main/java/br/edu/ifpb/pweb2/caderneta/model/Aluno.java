package br.edu.ifpb.pweb2.caderneta.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Aluno extends Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// ATTRIBUTES

	private String nome;
	
	private String matricula;
	
	@OneToMany(mappedBy = "aluno")
	private List<AlunoTurma> alunoTurma;
	
	public Aluno() {}
	
	// GETTERS AND SETTERS

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public List<AlunoTurma> getAlunoTurma() {
		return alunoTurma;
	}

	public void setAlunoTurma(List<AlunoTurma> alunoTurma) {
		this.alunoTurma = alunoTurma;
	}
	
	
	// TO STRING, HASHCODE, EQUALS
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getId() == null) ? 0 : this.getId().hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", matricula=" + matricula + ", alunoTurma=" + alunoTurma + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (this.getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!this.getId().equals(other.getId()))
			return false;
		return true;
	}
}
