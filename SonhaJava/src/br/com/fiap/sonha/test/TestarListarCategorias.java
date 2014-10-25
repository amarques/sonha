package br.com.fiap.sonha.test;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.sonha.beans.CategoriaSonhoBEANS;
import br.com.fiap.sonha.bo.CategoriaSonhoBO;

public class TestarListarCategorias {
	public static void main(String[] args) {
		
		
		try {
			CategoriaSonhoBO bo = new CategoriaSonhoBO();
			
			List<CategoriaSonhoBEANS> listaCategorias = bo.listarCategorias();
			for (CategoriaSonhoBEANS categoria: listaCategorias) {
				System.out.println("Código da Categoria: " + categoria.getCdCatgegoria());
				System.out.println("Nome da Categoria: " + categoria.getNomeCategoria());
				System.out.println("============================================================");
			}
			bo.fecharConexao();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
