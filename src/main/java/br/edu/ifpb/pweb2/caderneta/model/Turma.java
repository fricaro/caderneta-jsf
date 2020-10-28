package br.edu.ifpb.pweb2.caderneta.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Turma implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String codigo;
	
	private Boolean notasEncerradas;
	
	@ManyToOne
	@JoinColumn(name = "id_disciplina")
	private Disciplina disciplina;
	
	@ManyToOne
	@JoinColumn(name = "id_professor")
	private Professor professor;
	
	@OneToMany(mappedBy = "turma")
	private List<AlunoTurma> alunoTurma;
	
	@OneToMany(mappedBy = "turma")
	private List<Aula> aulas;
	
	public Turma() {}
	
	// GETTERS AND SETTERS
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public List<AlunoTurma> getAlunoTurma() {
		return alunoTurma;
	}

	public void setAlunoTurma(List<AlunoTurma> alunoTurma) {
		this.alunoTurma = alunoTurma;
	}
	
	public List<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	public Boolean getNotasEncerradas() {
		return notasEncerradas;
	}

	public void setNotasEncerradas(Boolean notasEncerradas) {
		this.notasEncerradas = notasEncerradas;
	}
	
	// TO STRING, HASHCODE, EQUALS

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alunoTurma == null) ? 0 : alunoTurma.hashCode());
		result = prime * result + ((aulas == null) ? 0 : aulas.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((disciplina == null) ? 0 : disciplina.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((notasEncerradas == null) ? 0 : notasEncerradas.hashCode());
		result = prime * result + ((professor == null) ? 0 : professor.hashCode());
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
		Turma other = (Turma) obj;
		if (alunoTurma == null) {
			if (other.alunoTurma != null)
				return false;
		} else if (!alunoTurma.equals(other.alunoTurma))
			return false;
		if (aulas == null) {
			if (other.aulas != null)
				return false;
		} else if (!aulas.equals(other.aulas))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (disciplina == null) {
			if (other.disciplina != null)
				return false;
		} else if (!disciplina.equals(other.disciplina))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (notasEncerradas == null) {
			if (other.notasEncerradas != null)
				return false;
		} else if (!notasEncerradas.equals(other.notasEncerradas))
			return false;
		if (professor == null) {
			if (other.professor != null)
				return false;
		} else if (!professor.equals(other.professor))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Turma [id=" + id + ", codigo=" + codigo + ", disciplina=" + ", notasEncerradas=" + notasEncerradas + disciplina + ", professor=" + professor.getNome()
				+ ", alunoTurma=" + alunoTurma + ", aulas=" + aulas.size() + "]";
	}	
}
