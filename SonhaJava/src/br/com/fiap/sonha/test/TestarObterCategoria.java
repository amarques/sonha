package br.com.fiap.sonha.test;

import java.sql.SQLException;

import br.com.fiap.sonha.beans.CategoriaSonhoBEANS;
import br.com.fiap.sonha.bo.CategoriaSonhoBO;

public class TestarObterCategoria {

	public static void main(String[] args) {

			try {
				CategoriaSonhoBO categoriaSonhoBO = new CategoriaSonhoBO();
				int cdCategoria = 7;
				CategoriaSonhoBEANS categoria = categoriaSonhoBO.obterCategoria(cdCategoria);
				System.out.println("Código da Categoria: " + categoria.getCdCatgegoria());
				System.out.println("Descrição da Categoria: " + categoria.getNomeCategoria());
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
	}

}
