package br.edu.ifpb.pweb2.caderneta.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.inject.Inject;


import br.edu.ifpb.pweb2.caderneta.DTO.ProfessorDashboard;
import br.edu.ifpb.pweb2.caderneta.controller.AlunoTurmaController;
import br.edu.ifpb.pweb2.caderneta.controller.AulaController;
import br.edu.ifpb.pweb2.caderneta.controller.TurmaController;
import br.edu.ifpb.pweb2.caderneta.model.AlunoTurma;
import br.edu.ifpb.pweb2.caderneta.model.Aula;
import br.edu.ifpb.pweb2.caderneta.model.Professor;
import br.edu.ifpb.pweb2.caderneta.model.Turma;
import static java.lang.System.out;

@Named(value = "professorDashboardBean")
@SessionScoped
public class ProfessorDashboardBean extends GenericCadernetaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject LoginUsuarioBean usuario;
	@Inject AlunoTurmaController alunoTurmaController;
	@Inject AulaController aulaController;
	@Inject TurmaController turmaController;
	private List<ProfessorDashboard> turmas;
	private Turma turmaExibida;
	private AlunoTurma alunoExibido;
	private Aula aulaParaRegistrar;

	@PostConstruct
	public void init() {
		if (usuario != null) {
			this.turmas = getTurmaByIdProfessor();
		}
	}
	
	public List<ProfessorDashboard> getTurmaByIdProfessor() {
		Professor professor = usuario.getProfessor();
		List<ProfessorDashboard> dashboard = new ArrayList<>();
		professor.getTurmas().forEach((turma) -> {
			ProfessorDashboard pd = new ProfessorDashboard();
			pd.setCodigo(turma.getCodigo());
			pd.setNomeCurso(turma.getDisciplina().getCurso());
			pd.setNomeDisciplina(turma.getDisciplina().getNome());
			pd.setTurma(turma);
			dashboard.add(pd);
		});
		return dashboard;
	}
	
	public String visualizarTurma(Turma turma) {
		this.turmaExibida = turma;
		return "/professor/turma.xhtml?faces-redirect=true";
	}
	
	public String visualizarAluno(AlunoTurma alunoTurma) {
		this.alunoExibido = alunoTurma;
		return "/professor/aluno.xhtml?faces-redirect=true";
	}
	
	public String atualizarNotasAluno() {
		if (alunoExibido != null) {
			alunoTurmaController.saveOrUpdate(alunoExibido);
		}
		return "/professor/turma.xhtml?faces-redirect=true";
	}
	
	public int totalAulasRegistradas() {
		if (turmaExibida != null) {
			return this.turmaExibida.getAulas().size();
		} else return 0;
	}
	
	
	public String irParaRegistrarAula() {
		this.aulaParaRegistrar = new Aula();
		return "/professor/aula.xhtml?faces-redirect=true";
	}
	
	public String registrarAula() {
		if (aulaParaRegistrar != null) {			
			this.aulaParaRegistrar.setTurma(turmaExibida);
			this.turmaExibida.getAulas().add(aulaParaRegistrar);
			aulaController.saveOrUpdate(aulaParaRegistrar);
		}
		return "/professor/turma.xhtml?faces-redirect=true";
	}
	
	public double calcularFrequencia(Integer faltasDoAluno) {
		if (faltasDoAluno == null) {
			return 100;
		}
		return (1 - (double) faltasDoAluno/(double) totalAulasRegistradas()) * 100;
	}
	
	public String calcularFrequenciaEmString(Integer faltasDoAluno) {
		double percentage = this.calcularFrequencia(faltasDoAluno);
		return String.format("%1.01f", percentage);
	}
	
	public String fecharNotas() {
		if (this.turmaExibida != null) {			
			this.turmaExibida.setNotasEncerradas(true);
			turmaController.saveOrUpdate(turmaExibida);
		}
		return "/professor/turma.xhtml?faces-redirect=true";
	}
	
	
	public String calcularStatus(AlunoTurma alunoTurma) {
		if (this.turmaExibida.getNotasEncerradas() == false) {
			return "PENDENTE";
		} else if (this.calcularFrequencia(alunoTurma.getFaltas()) < 75) {
			return "REPROVADO POR FALTA";
		} else {
			Integer nota1 = alunoTurma.getPrimeiraNota() == null? 0 : alunoTurma.getPrimeiraNota();
			Integer nota2 = alunoTurma.getSegundaNota() == null? 0 : alunoTurma.getSegundaNota();
			Integer nota3 = alunoTurma.getTerceiraNota() == null? 0 : alunoTurma.getTerceiraNota();
			Double notaFinal = ((double)nota1+ (double)nota2+ (double)nota3)/3;
			if (notaFinal >= 7) return "APROVADO";
			else return "REPROVADO POR NOTA";
		}
	}
	
	// Get e Set
	
	public LoginUsuarioBean getUsuario() {
		return usuario;
	}

	public void setUsuario(LoginUsuarioBean usuario) {
		this.usuario = usuario;
	}

	public List<ProfessorDashboard> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<ProfessorDashboard> turmas) {
		this.turmas = turmas;
	}

	public Turma getTurmaExibida() {
		return turmaExibida;
	}

	public void setTurmaExibida(Turma turmaExibida) {
		this.turmaExibida = turmaExibida;
	}

	public AlunoTurma getAlunoExibido() {
		return alunoExibido;
	}

	public void setAlunoExibido(AlunoTurma alunoExibido) {
		this.alunoExibido = alunoExibido;
	}

	public Aula getAulaParaRegistrar() {
		return aulaParaRegistrar;
	}

	public void setAulaParaRegistrar(Aula aulaParaRegistrar) {
		this.aulaParaRegistrar = aulaParaRegistrar;
	}
	
	
}
