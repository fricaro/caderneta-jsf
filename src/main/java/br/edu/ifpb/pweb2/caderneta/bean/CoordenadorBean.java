package br.edu.ifpb.pweb2.caderneta.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.caderneta.controller.AlunoController;
import br.edu.ifpb.pweb2.caderneta.controller.DisciplinaController;
import br.edu.ifpb.pweb2.caderneta.controller.ProfessorController;
import br.edu.ifpb.pweb2.caderneta.controller.TurmaController;
import br.edu.ifpb.pweb2.caderneta.model.Disciplina;
import br.edu.ifpb.pweb2.caderneta.model.Professor;
import br.edu.ifpb.pweb2.caderneta.model.Turma;

@Named(value = "coordBean")
@ViewScoped
public class CoordenadorBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Disciplina> disciplinas;
	
	@Inject
	private DisciplinaController disciplinaController;
	
	@Inject
	private ProfessorController professorController;
	
	@Inject
	private AlunoController alunoController;
	
	@Inject
	private TurmaController turmaController;
	
	@PostConstruct
	public void init() {
		if (!disciplinaController.findAll().isEmpty()) {
			this.disciplinas = disciplinaController.findAll();
		} 
	}
	
	public String listarDisciplinas() {
		if (!disciplinaController.findAll().isEmpty()) {
			this.setDisciplinas(disciplinaController.findAll());
		}
		return "/home/coordenador.xhtml?faces-redirect=true";
	}
	
	public String excluir(Disciplina disciplina) {
		disciplinaController.excluir(disciplina);
		return "index?faces-redirect=true";
	}
	
	public String cadastrarProfessorEmDisciplina(Integer idUsuario, Integer idTurma) {
		Professor professor = professorController.find(idUsuario);
		Turma turma = turmaController.find(idTurma);
		turma.setProfessor(professor);
		turmaController.update(turma);
		return null;
	}
	

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

}
