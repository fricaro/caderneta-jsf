package br.edu.ifpb.pweb2.caderneta.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.caderneta.controller.ProfessorController;
import br.edu.ifpb.pweb2.caderneta.model.Professor;
import br.edu.ifpb.pweb2.caderneta.model.Turma;

@Named(value = "professorBean")
@ViewScoped
public class ProfessorBean extends GenericCadernetaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// MODELS
	private Professor professor;
	
	@Inject
	private Turma turma;
	
	// CONTROLLERS
	
	@Inject
	private ProfessorController professorController;
	
	// INIT
	
	@PostConstruct
	public void init() {
		Professor professorFlash = (Professor) this.getFlash("professor");
		if(professorFlash != null)
			this.professor = professorFlash;
	}
	
	// METODOS DO NEGOCIO
	
	public String cadastrar() {
		Integer id = professor.getId();
		professorController.saveOrUpdate(professor);
		
		this.KeepMessages();
		if(id == null)
			this.addInfoMessage("Professor cadastrado com sucesso!");
		else
			this.addInfoMessage("Professor atualizado com sucesso!");

		professor = new Professor();

		return "/cadastro.xhtml?faces-redirect=true";
	}
	
//	public String registrarPresencaAlunosEmAula(List<Integer> idAlunos, Integer idAula) {
//		Aula aula = controllerAula.find(idAula);
//		
////		aula.setPresenca(idAlunos);
//		
//		controllerAula.update(aula);
//		
//		return null;
//	}
	
//	public String registrarAulaEmTurma(Integer idAula, Integer idTurma) {
//		Turma turma = turmaController.find(idTurma);
//		Aula aula = controllerAula.find(idAula);
//		turma.getAulas().add(aula);
//		turmaController.update(turma);
//		return null;
//	}
	
//	public String atribuirNotaEmAluno(Integer nota, Integer idAluno) {
//		Aluno aluno = alunoController.find(idAluno);
//		List<AlunoTurma> alunoTurmas = alunoTurmaController.findAll();
//		for (AlunoTurma at : alunoTurmas) {
//			if (at.getAluno().equals(aluno)) {
//				if (at.getTurma().equals(this.turma)) {
//					notaController.insert(new Nota(nota, at));
//				}
//			}
//		}
//		return null;
//	}
	
	// GETTERS E SETTERS
	
	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
}
