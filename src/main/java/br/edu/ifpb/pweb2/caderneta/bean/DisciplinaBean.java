package br.edu.ifpb.pweb2.caderneta.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.caderneta.controller.DisciplinaController;
import br.edu.ifpb.pweb2.caderneta.controller.TurmaController;
import br.edu.ifpb.pweb2.caderneta.model.Disciplina;
import br.edu.ifpb.pweb2.caderneta.model.Professor;
import br.edu.ifpb.pweb2.caderneta.model.Turma;

@Named(value = "disciplinaBean")
@ViewScoped
public class DisciplinaBean extends GenericCadernetaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Disciplina disciplina;
	
	@Inject
	private DisciplinaController controllerDisciplina;
	
	@Inject
	private TurmaController controllerTurma;
	
	@PostConstruct
	public void init() {
		Disciplina disciplinaFlash = (Disciplina) this.getFlash("disciplina");
		if(disciplinaFlash != null)
			this.disciplina = disciplinaFlash;
	}
	
	public Disciplina getDisciplina() {
		return disciplina;
	}
	
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	public String cadastrar() {
		
		Integer id = disciplina.getId();
		
		controllerDisciplina.saveOrUpdate(disciplina);
		
		this.KeepMessages();
		if(id == null)
			this.addInfoMessage("Disciplina cadastrada com sucesso!");
		else
			this.addInfoMessage("Disciplina atualizada com sucesso!");

		disciplina = new Disciplina();

		return "/cadastro/cadastro-disciplina.xhtml?faces-redirect=true";
	}
	
	public String editar(Disciplina disciplina) {
		this.putFlash("disciplina", disciplina);
		return "/cadastro/cadastro-disciplina.xhtml?faces-redirect=true";
	}
	
	public String excluir(Disciplina disciplina) {
		controllerDisciplina.excluir(disciplina);
		return null;
	}
	
	public String visualizar(Disciplina disciplina) {
		this.putFlash("disciplina", disciplina);
		return "/detalhes/disciplina.xhtml?faces-redirect=true";
	}
	
	public String adicionarProfessor(Turma turma, Professor professor) {
		turma.setProfessor(professor);
		controllerTurma.update(turma);
		return null;
	}

}
