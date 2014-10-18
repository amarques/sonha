package br.com.fiap.sonha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.sonha.beans.CategoriaSonhoBEANS;
import br.com.fiap.sonha.connection.ConexaoFactory;

public class CategoriaSonhoDAO {
	private Connection conexao;

	public CategoriaSonhoDAO() throws ClassNotFoundException, SQLException {
		this.conexao = new ConexaoFactory().getConnection();
	}
	
	public void fecharConexao() throws SQLException {
		try {
			conexao.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<CategoriaSonhoBEANS> listarCategorias() throws SQLException {
		String sql = "SELECT CD_CATG_SONHO, NM_CATG_SONHO FROM T_CATG_SONHO";
		List<CategoriaSonhoBEANS> listaCategorias = new ArrayList<CategoriaSonhoBEANS>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				CategoriaSonhoBEANS categoria = new CategoriaSonhoBEANS();
				categoria.setCdCatgegoria(rs.getInt("CD_CATG_SONHO"));
				categoria.setNomeCategoria(rs.getString("NM_CATG_SONHO"));
				listaCategorias.add(categoria);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			rs.close();
			stmt.close();
		}
		return listaCategorias;
	}
	
	public CategoriaSonhoBEANS obterCategoria(int cdCategoria) throws SQLException {
		String sql = "SELECT CD_CATG_SONHO, NM_CATG_SONHO, DS_CATG_SONHO FROM T_CATG_SONHO WHERE CD_CATG_SONHO = ?";
		CategoriaSonhoBEANS categoria = null;
		PreparedStatement stmt = conexao.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		try {
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				categoria = new CategoriaSonhoBEANS();
				categoria.setCdCatgegoria(rs.getInt("CD_CATG_SONHO"));
				categoria.setNomeCategoria(rs.getString("NM_CATG_SONHO"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			rs.close();
			stmt.close();
		}
		return categoria;
	}
}
