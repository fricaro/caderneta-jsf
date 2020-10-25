package br.edu.ifpb.pweb2.caderneta.bean;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.caderneta.controller.AlunoTurmaController;
import br.edu.ifpb.pweb2.caderneta.model.Aluno;
import br.edu.ifpb.pweb2.caderneta.model.AlunoTurma;
import br.edu.ifpb.pweb2.caderneta.model.Turma;

@Named(value = "consAlunoTurmaBean")
@ViewScoped
public class ConsultaAlunoTurmaBean extends GenericCadernetaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private List<AlunoTurma> alunoTurmas;
	
	@Inject
	private AlunoTurmaController controllerAlunoTurma;

	@PostConstruct
	public void init() {
		if (id == null) {
			alunoTurmas = controllerAlunoTurma.findAll();
		} else {
			alunoTurmas = Collections.singletonList(controllerAlunoTurma.find(id));
		}
	}
	
	public String excluir(Aluno aluno, Turma turma) {
		AlunoTurma at = controllerAlunoTurma.getAlunoTurmaByAlunoAndTurma(aluno, turma);
		controllerAlunoTurma.excluir(at);
		putFlash("turma", turma);
		this.addInfoMessage("Aluno removido da turma com sucesso!");
		this.init();
		return "/detalhes/turma.xhtml?faces-redirect=true";
	}
	
	public String editar(AlunoTurma alunoTurma) {
		this.putFlash("alunoTurma", alunoTurma);
		return "/cadastro/matricular-aluno.xhtml?faces-redirect=true";
	}
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<AlunoTurma> getAlunoTurmas() {
		return alunoTurmas;
	}

	public void setAlunoTurmas(List<AlunoTurma> alunoTurmas) {
		this.alunoTurmas = alunoTurmas;
	}

}
