package br.com.fiap.sonha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.sonha.beans.ComentarioSonhoBEANS;
import br.com.fiap.sonha.connection.ConexaoFactory;

public class ComentarioSonhoDAO {
	private Connection conexao;

	public ComentarioSonhoDAO() throws ClassNotFoundException, SQLException {
		this.conexao = new ConexaoFactory().getConnection();
	}

	public void fecharConexao() throws SQLException {
		try {
			conexao.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int adicionarComentario(ComentarioSonhoBEANS comentario)
			throws SQLException {
		String sql = "INSERT INTO T_COMENTARIO_SONHO (CD_COMENTARIO_SONHO, "
				+ "DT_CRIACAO_COMENTARIO, COMENTARIO_SONHO, CD_SONHO, CD_USUARIO) "
				+ "VALUES (COMENTARIO_SONHO_SEQ.NEXTVAL, SYSDATE, ?, ?, ?)";
		int cdComentarioSonho = 0;
		PreparedStatement stmt = null;
		try {
			stmt = conexao.prepareStatement(sql);

			stmt.setString(1, comentario.getComentario());
			stmt.setInt(2, comentario.getCdSonho());
			stmt.setInt(3, comentario.getCdUsuario());

			stmt.execute();
			cdComentarioSonho = obterCdComentarioSonhoAtual();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return cdComentarioSonho;
	}

	private int obterCdComentarioSonhoAtual() {
		String sql = "SELECT COMENTARIO_SONHO_SEQ.CURRVAL FROM T_COMENTARIO_SONHO";
		int cdComentarioSonho = 0;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				cdComentarioSonho = rs.getInt("CURRVAL");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return cdComentarioSonho;
	}

	public List<ComentarioSonhoBEANS> listarComentarios(int cdSonho)
			throws SQLException {
		String sql = "SELECT CD_COMENTARIO_SONHO, TO_CHAR(DT_CRIACAO_COMENTARIO, 'dd/MM/yyyy'), COMENTARIO_SONHO, CD_SONHO, CD_USUARIO FROM T_COMENTARIO_SONHO WHERE CD_SONHO = ?";
		List<ComentarioSonhoBEANS> listaComentarios = new ArrayList<ComentarioSonhoBEANS>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, cdSonho);
			rs = stmt.executeQuery();

			while (rs.next()) {
				ComentarioSonhoBEANS comentario = new ComentarioSonhoBEANS();
				comentario.setCdComentario(rs.getInt("CD_COMENTARIO_SONHO"));
				comentario.setCdSonho(rs.getInt("CD_SONHO"));
				comentario.setCdUsuario(rs.getInt("CD_USUARIO"));
				comentario.setComentario(rs.getString("COMENTARIO_SONHO"));
				listaComentarios.add(comentario);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return listaComentarios;
	}

	public void excluirComentario(int cdComentarioSonho) {
		String sql = "DELETE FROM T_COMENTARIO_SONHO WHERE CD_COMENTARIO_SONHO = ?";
		PreparedStatement stmt = null;
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, cdComentarioSonho);
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

}
