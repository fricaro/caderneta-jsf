package br.edu.ifpb.pweb2.caderneta.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.caderneta.controller.AlunoController;
import br.edu.ifpb.pweb2.caderneta.controller.ProfessorController;
import br.edu.ifpb.pweb2.caderneta.model.Aluno;
import br.edu.ifpb.pweb2.caderneta.model.Professor;
import static java.lang.System.out;


@Named(value = "loginUsuarioBean")
@SessionScoped
public class LoginUsuarioBean extends GenericCadernetaBean  implements Serializable {
private static final long serialVersionUID = 1L;
	
	private String login;
	private String senha;	
	@Inject private AlunoController alunoController;
	@Inject private ProfessorController professorController;
	private Aluno aluno;
	
	@PostConstruct
	public void init() {
		String login = (String) this.getFlash("login");
		if(login != null) this.login = login;
		String senha = (String) this.getFlash("senha");
		if(senha != null) this.senha = senha;
	}
	
	public String logar() {		
		// verificar se os dados são de um aluno 
		this.aluno = alunoController.findByLogin(login);
		Professor professor = professorController.findByLogin(login);
		
		out.println(aluno);
		out.println(professor);
//		// Usa o dao para inserir o aluno
//		Integer id = aluno.getId();
//		alunoController.saveOrUpdate(aluno);
//		
//		this.KeepMessages();
//		if(id == null)
//			this.addInfoMessage("Aluno cadastrado com sucesso!");
//		else
//			this.addInfoMessage("Aluno atualizado com sucesso!");
		
		// Limpa objeto do formulário
//		aluno = new Aluno();
		

		
		if (aluno != null) return "home/aluno?faces-redirect=true";
		else if (professor != null) {
			if (professor.getDtype().equals("Coordenador")) return "home/coordenador?faces-redirect=true";
			else return "home/professor?faces-redirect=true";
		}
		else return "errors/LoginError?faces-redirect=true";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	

}
