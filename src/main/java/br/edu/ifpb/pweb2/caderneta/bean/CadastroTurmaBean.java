package br.edu.ifpb.pweb2.caderneta.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.caderneta.controller.DisciplinaController;
import br.edu.ifpb.pweb2.caderneta.controller.ProfessorController;
import br.edu.ifpb.pweb2.caderneta.controller.TurmaController;
import br.edu.ifpb.pweb2.caderneta.model.Disciplina;
import br.edu.ifpb.pweb2.caderneta.model.Professor;
import br.edu.ifpb.pweb2.caderneta.model.Turma;

@Named(value = "cadTurmaBean")
@ViewScoped
public class CadastroTurmaBean extends GenericCadernetaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Turma turma;
	
	@Inject
	private TurmaController controllerTurma;
	
	@Inject
	private ProfessorController controllerProfessor;
	
	@Inject
	private DisciplinaController controllerDisciplina;
	
	@PostConstruct
	public void init() {
		Turma turmaFlash = (Turma) this.getFlash("turma");
		if(turmaFlash != null) {
			this.turma = turmaFlash;
		}
	}
	
	// LOGICA DE NEGOCIO
	
	public String cadastrar() {
		
		Integer id = turma.getId();
		
		controllerTurma.saveOrUpdate(turma);
		
		
		this.KeepMessages();
		if(id == null)
			this.addInfoMessage("Turma cadastrada com sucesso!");
		else
			this.addInfoMessage("Turma atualizada com sucesso!");

		turma = new Turma();

		return "/turmas/cadastro.xhtml?faces-redirect=true";
	}
	
	public String editar(Turma turma) {
		this.putFlash("turma", turma);
		return "/turmas/cadastro.xhtml?faces-redirect=true";
	}
	
	public List<Professor> getProfessorItems() {
		List<Professor> professores = controllerProfessor.findAll();
		return professores;
	}
	
	public List<Disciplina> getDisciplinaItems() {
		List<Disciplina> disciplinas = controllerDisciplina.findAll();
		return disciplinas;
	}
	
	// GETTERS e SETTERS

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	

}
