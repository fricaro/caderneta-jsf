package br.edu.ifpb.pweb2.caderneta.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.caderneta.controller.AlunoController;
import br.edu.ifpb.pweb2.caderneta.model.Aluno;
import br.edu.ifpb.pweb2.caderneta.model.Turma;

@Named(value = "consAlunoBean")
@ViewScoped
public class ConsultaAlunoBean extends GenericCadernetaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Turma turma;
	
	private List<Aluno> alunos;
	
	@Inject
	private AlunoController controllerAluno;

	@PostConstruct
	public void init() {
		Turma turmaFlash = (Turma) this.getFlash("turma");
		
		if(turmaFlash != null) {
			this.turma = turmaFlash;
			this.alunos = controllerAluno.findByTurma(turmaFlash);
		}
		
	}
	
	public String listarAlunosPorTurma(Turma turma) {
		this.turma = turma;
		this.putFlash("turma", turma);
		this.alunos = controllerAluno.findByTurma(turma);
		return "/detalhes/turma.xhtml?faces-redirect=true";
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
}
