package br.com.fiap.sonha.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.sonha.beans.UsuarioBEANS;
import br.com.fiap.sonha.dao.UsuarioDAO;

public class UsuarioBO {
	private UsuarioDAO dao = null;
	
	public UsuarioBO() throws ClassNotFoundException, SQLException {
		this.dao = new UsuarioDAO();
	}
	
	public List<UsuarioBEANS> listarUsuarios()  throws SQLException {
		return dao.listarUsuarios();
	}
	
	public UsuarioBEANS selecionarUsuario(int cdUsuario) throws SQLException {
		return dao.selecionarUsuario(cdUsuario);
	}
	
	public void atualizarUsuario(UsuarioBEANS usuario) throws SQLException {
		dao.atualizarUsuario(usuario);
	}
	
	public void deletarUsuario(int cdUsuario)  throws SQLException {
		dao.deletarUsuario(cdUsuario);
	}
	
	public int adicionarUsuario(UsuarioBEANS usuario) throws SQLException {
		return dao.adicionarUsuario(usuario);
	}
	
	public int efetuarLogin(String email, String password) throws SQLException {
		return dao.efetuarLogin(email, password);
	}
	
	public void fecharConexao() throws SQLException {
		dao.fecharConexao();
	}
}
