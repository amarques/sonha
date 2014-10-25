package br.com.fiap.sonha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.sonha.beans.SonhoPredefinidoBEANS;
import br.com.fiap.sonha.connection.ConexaoFactory;

public class SonhoPredefinidoDAO {
	private Connection conexao;

	public SonhoPredefinidoDAO() throws ClassNotFoundException, SQLException {
		this.conexao = new ConexaoFactory().getConnection();
	}
	
	public void fecharConexao() throws SQLException {
		try {
			conexao.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<SonhoPredefinidoBEANS> listarSonhosPredefinidosPorCategoria(
			int cdCategoriaSonho) throws SQLException {
		String sql = "SELECT CD_SONHO_PREDEF, TITULO_SONHO_PREDEF, DESCRICAO_SONHO_PREDEF, CD_CATG_SONHO FROM T_SONHO_PREDEF WHERE CD_CATG_SONHO = ?";
		List<SonhoPredefinidoBEANS> listaSonhosPredefinidos = new ArrayList<SonhoPredefinidoBEANS>();
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, cdCategoriaSonho);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				SonhoPredefinidoBEANS sonhoPredefinido = new SonhoPredefinidoBEANS();
				sonhoPredefinido.setCdSonhoPredefinido(rs
						.getInt("CD_SONHO_PREDEF"));
				sonhoPredefinido.setTituloSonhoPredefinido(rs
						.getString("TITULO_SONHO_PREDEF"));
				sonhoPredefinido.setDescricaoSonhoPredefinido(rs
						.getString("DESCRICAO_SONHO_PREDEF"));
				sonhoPredefinido.setCdCategoriaSonhoPredefinido(rs
						.getInt("CD_CATG_SONHO"));
				listaSonhosPredefinidos.add(sonhoPredefinido);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				conexao.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return listaSonhosPredefinidos;
	}

	public SonhoPredefinidoBEANS obterSonhoPredefinido(int cdSonhoPredefinido) {
		String sql = "SELECT CD_SONHO_PREDEF, TITULO_SONHO_PREDEF, DESCRICAO_SONHO_PREDEF, CD_CATG_SONHO FROM T_SONHO_PREDEF WHERE CD_SONHO_PREDEF = ?";
		SonhoPredefinidoBEANS sonhoPredefinido = null;
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, cdSonhoPredefinido);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
			    sonhoPredefinido = new SonhoPredefinidoBEANS();
				sonhoPredefinido.setCdSonhoPredefinido(rs
						.getInt("CD_SONHO_PREDEF"));
				sonhoPredefinido.setTituloSonhoPredefinido(rs
						.getString("TITULO_SONHO_PREDEF"));
				sonhoPredefinido.setDescricaoSonhoPredefinido(rs
						.getString("DESCRICAO_SONHO_PREDEF"));
				sonhoPredefinido.setCdCategoriaSonhoPredefinido(rs
						.getInt("CD_CATG_SONHO"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				conexao.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return sonhoPredefinido;
	}
}
