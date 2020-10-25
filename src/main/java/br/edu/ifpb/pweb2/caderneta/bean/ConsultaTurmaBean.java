package br.edu.ifpb.pweb2.caderneta.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.caderneta.controller.TurmaController;
import br.edu.ifpb.pweb2.caderneta.model.Aluno;
import br.edu.ifpb.pweb2.caderneta.model.Disciplina;
import br.edu.ifpb.pweb2.caderneta.model.Turma;

@Named(value = "consTurmaBean")
@ViewScoped
public class ConsultaTurmaBean extends GenericCadernetaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Turma> turmas;
	
	private Disciplina disciplina;
	
	@Inject
	private TurmaController controllerTurma;
	
	@PostConstruct
	public void init() {
		Disciplina disciplinaFlash = (Disciplina) this.getFlash("disciplina");
		
		if(disciplinaFlash != null) {
			this.disciplina = disciplinaFlash;
			this.turmas = controllerTurma.findByDisciplina(disciplinaFlash);
		}
		
	}	
	
	public String listarTurmasPorDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
		this.putFlash("disciplina", disciplina);
		this.turmas = controllerTurma.findByDisciplina(disciplina);	
		return "/disciplinas/disciplina.xhtml?faces-redirect=true";
	}
	
	public String excluir(Turma turma) {
		controllerTurma.excluir(turma);
		this.putFlash("disciplina", turma.getDisciplina());
		this.addInfoMessage("Turma excluída com sucesso.");
		return "/disciplinas/disciplina.xhtml?faces-redirect=true";
	}

	public List<Turma> getTurmas() {
		return turmas;
	}


	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}


	public Disciplina getDisciplina() {
		return disciplina;
	}


	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	

}
