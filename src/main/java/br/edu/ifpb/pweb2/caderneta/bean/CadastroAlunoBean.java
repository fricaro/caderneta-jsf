package br.edu.ifpb.pweb2.caderneta.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.caderneta.controller.AlunoController;
import br.edu.ifpb.pweb2.caderneta.controller.TurmaController;
import br.edu.ifpb.pweb2.caderneta.model.Aluno;
import br.edu.ifpb.pweb2.caderneta.model.Turma;

@Named(value = "cadAlunoBean")
@ViewScoped
public class CadastroAlunoBean extends GenericCadernetaBean  implements Serializable {
private static final long serialVersionUID = 1L;
	
	@Inject
	private Aluno aluno;
	
	@Inject
	private Turma turma;
	
	@Inject
	private AlunoController controllerAluno;
	
	@Inject
	private TurmaController controllerTurma;
	
	@PostConstruct
	public void init() {
		Aluno alunoFlash = (Aluno) this.getFlash("aluno");
		if(alunoFlash != null)
			this.aluno = alunoFlash;
	}
	
	public String cadastrar() {		
		// Usa o dao para inserir o aluno
		Integer id = aluno.getId();
		controllerAluno.saveOrUpdate(aluno);
		
		this.KeepMessages();
		if(id == null)
			this.addInfoMessage("Aluno cadastrado com sucesso!");
		else
			this.addInfoMessage("Aluno atualizado com sucesso!");
		
		// Limpa objeto do formulário
		aluno = new Aluno();

		// Retorna para página de login
		return "/cadastro/cadastro-aluno.xhtml?faces-redirect=true";
	}
	
	public String matricular() {
		
		return null;
	}
	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
}
