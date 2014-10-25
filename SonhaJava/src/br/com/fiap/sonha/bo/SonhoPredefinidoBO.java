package br.com.fiap.sonha.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.sonha.beans.SonhoPredefinidoBEANS;
import br.com.fiap.sonha.dao.SonhoPredefinidoDAO;

public class SonhoPredefinidoBO {
	private SonhoPredefinidoDAO dao = null;
	
	public SonhoPredefinidoBO() throws ClassNotFoundException, SQLException {
		this.dao = new SonhoPredefinidoDAO();
	}
	
	public List<SonhoPredefinidoBEANS> listarSonhosPredefinidosPorCategoria(int cdCategoriaSonho) throws SQLException {
		return dao.listarSonhosPredefinidosPorCategoria(cdCategoriaSonho);
	}
	
	public void fecharConexao() throws SQLException {
		dao.fecharConexao();
	}
}
