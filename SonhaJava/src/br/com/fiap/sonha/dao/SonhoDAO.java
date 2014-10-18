package br.com.fiap.sonha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.sonha.beans.SonhoBEANS;
import br.com.fiap.sonha.connection.ConexaoFactory;

public class SonhoDAO {
	private Connection conexao;
	
	public SonhoDAO() throws ClassNotFoundException, SQLException {
		this.conexao = new ConexaoFactory().getConnection();
	}
	
	public void fecharConexao() throws SQLException {
		try {
			conexao.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public int adicionarSonho(SonhoBEANS sonho) throws SQLException {
		String sql = "INSERT INTO T_SONHO (CD_SONHO, DT_CRIACAO, TITULO_SONHO, "
				+ "DESCRICAO_SONHO, CD_USUARIO, SONHO_REALIZADO, CD_CATG_SONHO) "
				+ "VALUES (SONHO_SEQ.NEXTVAL, SYSDATE, ?, ?, ?, ?, ?)";
		int cdSonho = 0;
		PreparedStatement stmt = null;
		try {
			stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, sonho.getTituloSonho());
			stmt.setString(2, sonho.getDescricaoSonho());
			stmt.setInt(3, sonho.getCdUsuario());
			if (sonho.isSonhoRealizado()) {
				stmt.setString(4, "S");	
			}
			else {
				stmt.setString(4, "N");
			}
			stmt.setInt(5, sonho.getCdCategoria());
			stmt.execute();
			
			cdSonho = obterCdSonhoAtual();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			stmt.close();
		}
		return cdSonho;
	}
	
	private int obterCdSonhoAtual() {
		String sql = "SELECT SONHO_SEQ.CURRVAL FROM T_SONHO";
		int cdSonho = 0;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				cdSonho = rs.getInt("CURRVAL");
			}
			rs.close();
			stmt.close();
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
		return cdSonho;
	}
	
	public List<SonhoBEANS> listarSonhos() throws SQLException {
		String sql = "SELECT CD_SONHO, TO_CHAR(DT_CRIACAO, 'dd/MM/yyyy') \"DT_CRIACAO\", "
				+ "TITULO_SONHO, DESCRICAO_SONHO, CD_USUARIO, SONHO_REALIZADO, "
				+ "CD_CATG_SONHO FROM T_SONHO";
		List<SonhoBEANS> listaSonhos = new ArrayList<SonhoBEANS>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				SonhoBEANS sonho = new SonhoBEANS();
				sonho.setCdSonho(rs.getInt("CD_SONHO"));
				sonho.setDtCriacao(rs.getString("DT_CRIACAO"));
				sonho.setCdUsuario(rs.getInt("CD_USUARIO"));
				sonho.setSonhoRealizado(Boolean.parseBoolean(rs.getString("DT_CRIACAO")));
				sonho.setCdCategoria(rs.getInt("CD_CATG_SONHO"));
				sonho.setDescricaoSonho(rs.getString("DESCRICAO_SONHO"));
				sonho.setTituloSonho(rs.getString("TITULO_SONHO"));
				listaSonhos.add(sonho);
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
		return listaSonhos;
	}
	
	public List<SonhoBEANS> listarSonhosPorUsuario(int cdUsuario) throws SQLException {
		String sql = "SELECT CD_SONHO, TO_CHAR(DT_CRIACAO, 'dd/MM/yyyy') \"DT_CRIACAO\", TITULO_SONHO, "
				+ "DESCRICAO_SONHO, CD_USUARIO, SONHO_REALIZADO, CD_CATG_SONHO "
				+ "FROM T_SONHO WHERE CD_USUARIO = ?";
		List<SonhoBEANS> listaSonhos = new ArrayList<SonhoBEANS>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, cdUsuario);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				SonhoBEANS sonho = new SonhoBEANS();
				sonho.setCdSonho(rs.getInt("CD_SONHO"));
				sonho.setDtCriacao(rs.getString("DT_CRIACAO"));
				sonho.setCdUsuario(rs.getInt("CD_USUARIO"));
				sonho.setSonhoRealizado(Boolean.parseBoolean(rs.getString("DT_CRIACAO")));
				sonho.setCdCategoria(rs.getInt("CD_CATG_SONHO"));
				sonho.setDescricaoSonho(rs.getString("DESCRICAO_SONHO"));
				sonho.setTituloSonho(rs.getString("TITULO_SONHO"));
				listaSonhos.add(sonho);
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
		return listaSonhos;
	}
	
	public SonhoBEANS obterSonho(int cdSonho) throws SQLException {
		String sql = "SELECT CD_SONHO, TO_CHAR(DT_CRIACAO, 'dd/MM/yyyy') \"DT_CRIACAO\", "
				+ "TITULO_SONHO, DESCRICAO_SONHO, CD_USUARIO, "
				+ "SONHO_REALIZADO, CD_CATG_SONHO FROM T_SONHO "
				+ "WHERE CD_SONHO = ?";
		SonhoBEANS sonho = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, cdSonho);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				sonho = new SonhoBEANS();
				sonho.setCdSonho(rs.getInt("CD_SONHO"));
				sonho.setDtCriacao(rs.getString("DT_CRIACAO"));
				sonho.setCdUsuario(rs.getInt("CD_USUARIO"));
				sonho.setSonhoRealizado(Boolean.parseBoolean(rs.getString("DT_CRIACAO")));
				sonho.setCdCategoria(rs.getInt("CD_CATG_SONHO"));
				sonho.setDescricaoSonho(rs.getString("DESCRICAO_SONHO"));
				sonho.setTituloSonho(rs.getString("TITULO_SONHO"));
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
		return sonho;
	}
	
	public void deletarSonho(int cdSonho) {
		String sql = "DELETE FROM T_SONHO WHERE CD_SONHO = ?";
		PreparedStatement stmt = null;
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, cdSonho);
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
