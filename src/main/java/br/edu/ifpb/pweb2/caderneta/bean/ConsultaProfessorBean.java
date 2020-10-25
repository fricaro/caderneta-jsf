package br.edu.ifpb.pweb2.caderneta.bean;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.caderneta.controller.ProfessorController;
import br.edu.ifpb.pweb2.caderneta.model.Professor;

@Named(value = "consProfBean")
@ViewScoped
public class ConsultaProfessorBean extends GenericCadernetaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private List<Professor> professores;
	
	@Inject
	private ProfessorController controllerProfessor;

	@PostConstruct
	public void init() {
		if (id == null) {
			professores = controllerProfessor.findAll();
		} else {
			professores = Collections.singletonList(controllerProfessor.find(id));
		}
	}
	
	public String excluir(Professor professor) {
		controllerProfessor.excluir(professor);
		this.addInfoMessage("Professor excluído com sucesso!");
		this.init();
		return null;
	}
	
	public String editar(Professor professor) {
		this.putFlash("professor", professor);
		return "cadastro?faces-redirect=true";
	}
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

}
