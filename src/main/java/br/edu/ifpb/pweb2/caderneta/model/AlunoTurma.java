package br.edu.ifpb.pweb2.caderneta.model;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class AlunoTurma implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "id_aluno")
	private Aluno aluno;
	
	@ManyToOne
	@JoinColumn(name = "id_turma")
	private Turma turma;
	
	private Integer primeiraNota;
	
	private Integer segundaNota;
	
	private Integer terceiraNota;
	
	private Integer faltas;
	
	public AlunoTurma() {}
	
	
	// G/S
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Integer getPrimeiraNota() {
		return primeiraNota;
	}

	public void setPrimeiraNota(Integer primeiraNota) {
		this.primeiraNota = primeiraNota;
	}

	public Integer getSegundaNota() {
		return segundaNota;
	}

	public void setSegundaNota(Integer segundaNota) {
		this.segundaNota = segundaNota;
	}

	public Integer getTerceiraNota() {
		return terceiraNota;
	}

	public void setTerceiraNota(Integer terceiraNota) {
		this.terceiraNota = terceiraNota;
	}

	public Integer getFaltas() {
		return faltas;
	}

	public void setFaltas(Integer faltas) {
		this.faltas = faltas;
	}

	// hash toS equals
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
		result = prime * result + ((faltas == null) ? 0 : faltas.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((primeiraNota == null) ? 0 : primeiraNota.hashCode());
		result = prime * result + ((segundaNota == null) ? 0 : segundaNota.hashCode());
		result = prime * result + ((terceiraNota == null) ? 0 : terceiraNota.hashCode());
		result = prime * result + ((turma == null) ? 0 : turma.hashCode());
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
		AlunoTurma other = (AlunoTurma) obj;
		if (aluno == null) {
			if (other.aluno != null)
				return false;
		} else if (!aluno.equals(other.aluno))
			return false;
		if (faltas == null) {
			if (other.faltas != null)
				return false;
		} else if (!faltas.equals(other.faltas))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (primeiraNota == null) {
			if (other.primeiraNota != null)
				return false;
		} else if (!primeiraNota.equals(other.primeiraNota))
			return false;
		if (segundaNota == null) {
			if (other.segundaNota != null)
				return false;
		} else if (!segundaNota.equals(other.segundaNota))
			return false;
		if (terceiraNota == null) {
			if (other.terceiraNota != null)
				return false;
		} else if (!terceiraNota.equals(other.terceiraNota))
			return false;
		if (turma == null) {
			if (other.turma != null)
				return false;
		} else if (!turma.equals(other.turma))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AlunoTurma [id=" + id + ", aluno=" + aluno.getNome() + ", turma=" + turma.getDisciplina().getNome() + ", primeiraNota=" + primeiraNota
				+ ", segundaNota=" + segundaNota + ", terceiraNota=" + terceiraNota + ", faltas=" + faltas + "]";
	}	

	
}
