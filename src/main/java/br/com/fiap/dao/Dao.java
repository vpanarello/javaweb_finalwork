/**
 * 
 */
package br.com.fiap.dao;

import java.util.List;

/**
 * simple-webapp / Dao.java
 * FIAP / RM30222 - Vagner Panarello
 */
public interface Dao<T> {
	void adicionar(T entidade);
	 List<T> listar();
	 T buscar(int id); 

}
