package br.edu.ifpb.pweb2.caderneta.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.caderneta.controller.AlunoController;
import br.edu.ifpb.pweb2.caderneta.controller.AlunoTurmaController;
import br.edu.ifpb.pweb2.caderneta.controller.TurmaController;
import br.edu.ifpb.pweb2.caderneta.model.Aluno;
import br.edu.ifpb.pweb2.caderneta.model.AlunoTurma;
import br.edu.ifpb.pweb2.caderneta.model.Turma;

@Named(value = "cadAlunoTurmaBean")
@ViewScoped
public class CadastroAlunoTurmaBean extends GenericCadernetaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Turma turma;
	
	@Inject
	private AlunoTurma alunoTurma;
	
	@Inject
	private AlunoTurmaController controllerAlunoTurma;
	
	@Inject
	private TurmaController controllerTurma;
	
	@Inject
	private AlunoController controllerAluno;
	
	@PostConstruct
	public void init() {
		Turma turmaFlash = (Turma) this.getFlash("turma");
		if(turmaFlash != null) {
			this.turma = turmaFlash;
		}
		
	}
	
	// LOGICA DE NEGOCIO
	
	public String cadastrar() {
		
		Integer id = alunoTurma.getId();
		
		controllerAlunoTurma.saveOrUpdate(alunoTurma);
		
		
		this.KeepMessages();
		if(id == null)
			this.addInfoMessage("Aluno matriculado com sucesso!");
		else
			this.addInfoMessage("Matrícula atualizada com sucesso!");

		alunoTurma = new AlunoTurma();

		return "/alunos/matricula.xhtml?faces-redirect=true";
	}
	
	public String editar(AlunoTurma alunoTurma) {
		this.putFlash("alunoTurma", alunoTurma);
		return "/alunos/matricula.xhtml?faces-redirect=true";
	}
	
	public List<Turma> getTurmaItems() {
		List<Turma> turmas = controllerTurma.findAll();
		return turmas;
	}
	
	public List<Aluno> getAlunoItems() {
		List<Aluno> alunos = controllerAluno.findAll();
		return alunos;
	}
	
	// GETTERS e SETTERS

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public AlunoTurma getAlunoTurma() {
		return alunoTurma;
	}

	public void setAlunoTurma(AlunoTurma alunoTurma) {
		this.alunoTurma = alunoTurma;
	}
	
	

}
