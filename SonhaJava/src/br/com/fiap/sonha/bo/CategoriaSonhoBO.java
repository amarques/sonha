package br.com.fiap.sonha.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.sonha.beans.CategoriaSonhoBEANS;
import br.com.fiap.sonha.dao.CategoriaSonhoDAO;

public class CategoriaSonhoBO {
	private CategoriaSonhoDAO dao = null;
	
	public CategoriaSonhoBO() throws ClassNotFoundException, SQLException {
		this.dao = new CategoriaSonhoDAO();
	}
	
	public List<CategoriaSonhoBEANS> listarCategorias() throws SQLException {
		return dao.listarCategorias();
	}
	
	public CategoriaSonhoBEANS obterCategoria(int cdCategoria) throws SQLException {
		return dao.obterCategoria(cdCategoria);
	}
	
	public void fecharConexao() throws SQLException {
		dao.fecharConexao();
	}
}
