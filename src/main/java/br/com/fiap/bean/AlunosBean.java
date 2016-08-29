/**
 * 
 */
package br.com.fiap.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import br.com.fiap.dao.Dao;
import br.com.fiap.dao.DefinedAlunosDao;
import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Curso;
import br.com.fiap.entity.Disciplina;
import br.com.fiap.entity.Notas;


/**
 * simple-webapp / CursoBean.java
 * FIAP / RM30222 - Vagner Panarello
 */


@ManagedBean
@RequestScoped
public class AlunosBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Aluno aluno;
	
	private int currentAlunoId;

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

	public List<Aluno> getListar(){
		Dao<Aluno> dao = new GenericDao<Aluno>(Aluno.class);		
		return dao.listar();
	}

	public Set<String> getComboBox() {

		Set<String> lista = new HashSet<String>();

		for(Aluno var : this.getListar()) {
			lista.add(var.getNome());
		}
		return lista;
	}
	
	
	public void onload(String value){
		System.out.println("bateu " + value);
		
		this.currentAlunoId = Integer.parseInt(value);
		Dao<Aluno> dao = new GenericDao<Aluno>(Aluno.class);
		this.aluno = dao.buscar(currentAlunoId);
	}
	
	public List<Notas> getNotas(){
		DefinedAlunosDao dao = new DefinedAlunosDao(Aluno.class);
		
		return dao.buscaNotasPorAlunoId(currentAlunoId);
	}
	
	
}

