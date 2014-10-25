package br.com.fiap.sonha.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.sonha.beans.SonhoBEANS;
import br.com.fiap.sonha.dao.SonhoDAO;

public class SonhoBO {
	private SonhoDAO dao = null;
	
	public SonhoBO() throws ClassNotFoundException, SQLException {
		this.dao = new SonhoDAO();
	}
	
	public int adicionarSonho(SonhoBEANS sonho) throws SQLException {
		return dao.adicionarSonho(sonho);
	}
	
	public List<SonhoBEANS> listarSonhos() throws SQLException {
		return dao.listarSonhos();
	}
	
	public List<SonhoBEANS> listarSonhosPorUsuario(int cdUsuario) throws SQLException {
		return dao.listarSonhosPorUsuario(cdUsuario);
	}
	
	public SonhoBEANS obterSonho(int cdSonho) throws SQLException {
		return dao.obterSonho(cdSonho);
	}
	
	public void fecharConexao() throws SQLException {
		dao.fecharConexao();
	}
}
