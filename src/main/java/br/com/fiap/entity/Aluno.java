/**
 * 
 */
package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * simple-webapp / Aluno.java
 * FIAP / RM30222 - Vagner Panarello
 */

@Entity
@Table(name="alunos")
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="nome")
	private String nome;
		
	@Column(name="matricula")
	private String matricula;
	
	@Column(name="nota_01")
	private float projeto01;
	
	@Column(name="nota_02")
	private float atividadePratica;
	
	@Column(name="nota_03")
	private float projeto02;
	
	@ManyToOne
	@JoinColumn(name="curso_id")
	private Curso curso;
	
	@OneToMany(mappedBy="aluno")
	private List<Notas> notas;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Notas> getNotas() {
		return notas;
	}

	public void setNotas(List<Notas> notas) {
		this.notas = notas;
	}
	
}
