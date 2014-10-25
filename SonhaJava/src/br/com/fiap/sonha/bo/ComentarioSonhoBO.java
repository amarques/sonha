package br.com.fiap.sonha.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.sonha.beans.ComentarioSonhoBEANS;
import br.com.fiap.sonha.dao.ComentarioSonhoDAO;

public class ComentarioSonhoBO {
	private ComentarioSonhoDAO dao = null;	
	
	public ComentarioSonhoBO() throws ClassNotFoundException, SQLException {
		this.dao = new ComentarioSonhoDAO();
	}

	public void adicionarComentario(ComentarioSonhoBEANS comentario) throws SQLException {
		dao.adicionarComentario(comentario);
	}
	
	public List<ComentarioSonhoBEANS> listarComentarios(int cdSonho) throws SQLException {
		return dao.listarComentarios(cdSonho);
	}
	
	public void excluirComentario(int cdComentarioSonho) {
		dao.excluirComentario(cdComentarioSonho);
	}
	
	public void fecharConexao() throws SQLException {
		dao.fecharConexao();
	}
}
