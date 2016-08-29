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
import br.com.fiap.entity.Curso;
import br.com.fiap.entity.Escola;

/**
 * simple-webapp / CursoBean.java
 * FIAP / RM30222 - Vagner Panarello
 */


@ManagedBean
@SessionScoped
public class CursoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Curso curso;

	private int status;

	private String nomeEscola;


	public CursoBean() {
		super();
		curso = new Curso();
	}


	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getNomeEscola() {
		return nomeEscola;
	}

	public void setNomeEscola(String nomeEscola) {
		this.nomeEscola = nomeEscola;
	}

	public String cadastrar() {


		try {
			GenericDao<Escola> escolaDao = new GenericDao<Escola>(Escola.class);
			Escola escola = escolaDao.buscarPorNome(this.nomeEscola);


			Dao<Curso> dao = new GenericDao<Curso>(Curso.class);
			
			this.curso.setEscola(escola);
			escola.getCursos().add(this.curso);
			
			dao.adicionar(curso);

			this.status = 1;

			return "cadastro-cursos";
		} catch (Exception e) {
			e.printStackTrace();
			return "falha";
		}
	}

	public List<Curso> listar(){
		Dao<Curso> dao = new GenericDao<Curso>(Curso.class);		
		return dao.listar();
	}
	
public Set<String> getComboBox() {
		
		Set<String> lista = new HashSet<String>();
		
		for(Curso e : this.listar()) {
			lista.add(e.getNome());
		}
		return lista;
	}
}

