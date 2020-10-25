package br.edu.ifpb.pweb2.caderneta.model;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.inject.Named;

@Named
@Entity
@Named
public class Professor extends Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	private String email;
	
	private String dtype;
	
	@OneToMany(mappedBy = "professor")
	private List<Turma> turmas;
	
	
	public Professor() {}
	
	// GETTERS AND SETTERS
	
	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDtype() {
		return dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}
	
	
	
	// TO STRING, HASHCODE, EQUALS
	
	@Override
	public String toString() {
		return "Professor [id=" + this.getId() + ", nome=" + nome + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getId() == null) ? 0 : this.getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		if (super.getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!this.getId().equals(other.getId()))
			return false;
		return true;
	}
}
