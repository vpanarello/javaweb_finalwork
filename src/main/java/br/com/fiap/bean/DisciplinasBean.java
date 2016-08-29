/**
 * 
 */
package br.com.fiap.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.dao.Dao;
import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Curso;
import br.com.fiap.entity.Disciplina;
import br.com.fiap.entity.Professor;

/**
 * simple-webapp / CursoBean.java
 * FIAP / RM30222 - Vagner Panarello
 */


@ManagedBean
@RequestScoped
public class DisciplinasBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Disciplina disciplina;

	private int status;

	private String nomeCurso;
	
	private String nomeProfessor;


	public DisciplinasBean() {
		super();
		disciplina = new Disciplina();
		this.status = 0;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}


	public String cadastrar() {
		try {
			
			GenericDao<Professor> professorDao = new GenericDao<Professor>(Professor.class);
			GenericDao<Curso> cursoDao = new GenericDao<Curso>(Curso.class);
			
			
			Professor professor = professorDao.buscarPorNome(this.nomeProfessor);
			Curso curso = cursoDao.buscarPorNome(this.nomeCurso);

			

			Dao<Disciplina> dao = new GenericDao<Disciplina>(Disciplina.class);
			
			this.disciplina.setCurso(curso);
			this.disciplina.setProfessor(professor);
			
			
			curso.getDisciplinas().add(this.disciplina);
			professor.getDisciplinas().add(this.disciplina);
			
			
			dao.adicionar(disciplina);

			this.status = 1;

			return "cadastro-disciplinas";
		} catch (Exception e) {
			e.printStackTrace();
			return "falha";
		}
	}

	public List<Curso> listar(){
		Dao<Curso> dao = new GenericDao<Curso>(Curso.class);		
		return dao.listar();
	}

}

