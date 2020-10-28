package br.edu.ifpb.pweb2.caderneta.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.edu.ifpb.pweb2.caderneta.DTO.AlunoDashboard;
import br.edu.ifpb.pweb2.caderneta.model.Aluno;
import br.edu.ifpb.pweb2.caderneta.model.Turma;

import javax.inject.Inject;

@Named(value = "alunoDashboardBean")
@ViewScoped
public class AlunoDashboardBean extends GenericCadernetaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject LoginUsuarioBean usuario;
	private List<AlunoDashboard> disciplinas;
	
	@PostConstruct
	public void init() {
		if (usuario != null)
			this.disciplinas = getTurmaByIdAluno();
	}
	
	public List<AlunoDashboard> getTurmaByIdAluno() {
		Aluno aluno = usuario.getAluno();
		List<AlunoDashboard> dashboard = new ArrayList<>();
		aluno.getAlunoTurma().forEach((alunoTurma) -> {
			AlunoDashboard ad = new AlunoDashboard();
			Turma t = alunoTurma.getTurma();
			ad.setFaltas(alunoTurma.getFaltas().toString());
			ad.setNomeDisciplina(t.getDisciplina().getNome());
			ad.setNomeProfessor(t.getProfessor().getNome());
			ad.setNota1(alunoTurma.getPrimeiraNota().toString());
			ad.setNota2(alunoTurma.getSegundaNota().toString());
			ad.setNota3(alunoTurma.getTerceiraNota().toString());
			dashboard.add(ad);
		});
		return dashboard;
	}
	
	public LoginUsuarioBean getUsuario() {
		return usuario;
	}

	public List<AlunoDashboard> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<AlunoDashboard> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public void setUsuario(LoginUsuarioBean usuario) {
		this.usuario = usuario;
	}
	
	
}