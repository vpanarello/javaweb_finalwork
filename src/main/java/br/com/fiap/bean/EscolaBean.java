/**
 * 
 */
package br.com.fiap.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.dao.Dao;
import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Escola;

/**
 * simple-webapp / EscolaBean.java
 * FIAP / RM30222 - Vagner Panarello
 */

@ManagedBean
@RequestScoped	
public class EscolaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private int status;

	private Escola escola;
	
	
	public EscolaBean() {
		super();
		status = 0;
		escola = new Escola();
		
	}


	public Escola getEscola() {
		return escola;
	}
	public void setEscola(Escola escola) {
		this.escola = escola;
	}
	
	public int getStatus(){
		return this.status;
	}

	public String cadastraEscola() {
		System.out.println("bateu");
		
		try {
			Dao<Escola> dao = new GenericDao<Escola>(Escola.class);
			dao.adicionar(escola);
			
			this.status = 1;
			
			return "cadastro-escola";
		} catch (Exception e) {
			e.printStackTrace();
			return "falha";
		}

	}
	
	public List<Escola> getListaEscolas(){
		Dao<Escola> dao = new GenericDao<Escola>(Escola.class);		
		return dao.listar();
	}
	
	public Set<String> getComboBox() {
		
		Set<String> lista = new HashSet<String>();
		
		for(Escola e : getListaEscolas()) {
			lista.add(e.getNome());
		}
		
		return lista;
	}
}
