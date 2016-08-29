/**
 * 
 */
package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * simple-webapp / Disciplina.java
 * FIAP / RM30222 - Vagner Panarello
 */

@Entity
@Table(name="Disciplinas")
public class Disciplina {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;

	@Column(name="nome")
	private String nome;
	
	@Column(name="codigo")
	private String codigo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="professor_id")
	private Professor professor;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="curso_id")
	private Curso curso;
	
	@OneToMany(mappedBy="disciplina")
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}


}
