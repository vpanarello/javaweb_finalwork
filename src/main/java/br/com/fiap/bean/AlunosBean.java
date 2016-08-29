/**
 * 
 */
package br.com.fiap.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.fiap.dao.Dao;
import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Curso;


/**
 * simple-webapp / CursoBean.java
 * FIAP / RM30222 - Vagner Panarello
 */


@ManagedBean
@SessionScoped
public class AlunosBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Aluno aluno;

	private int status;

	private String nomeCurso;


	public AlunosBean() {
		super();
		this.status = 0;
		this.aluno = new Aluno();
		this.nomeCurso = "";
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
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

	public String cadastrar() {

		try {
			GenericDao<Curso> cursoDao = new GenericDao<Curso>(Curso.class);
			Curso curso = cursoDao.buscarPorNome(this.nomeCurso);


			Dao<Aluno> dao = new GenericDao<Aluno>(Aluno.class);

			this.aluno.setCurso(curso);
			curso.getAlunos().add(this.aluno);


			dao.adicionar(this.aluno);

			this.status = 1;

			return "cadastro-alunos";
		} catch (Exception e) {
			e.printStackTrace();
			return "falha";
		}
	}

	public List<Aluno> listar(){
		Dao<Aluno> dao = new GenericDao<Aluno>(Aluno.class);		
		return dao.listar();
	}

	public Set<String> getComboBox() {

		Set<String> lista = new HashSet<String>();

		for(Aluno var : this.listar()) {
			lista.add(var.getNome());
		}
		return lista;
	}
}

