package br.edu.ifpb.pweb2.caderneta.DTO;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.edu.ifpb.pweb2.caderneta.model.Turma;

@Named(value = "professorDashboard")
@ViewScoped
public class ProfessorDashboard implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String codigo;
	private String nomeDisciplina;
	private String nomeCurso;
	private Turma turma;
	
	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public ProfessorDashboard() {}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	
	
}
