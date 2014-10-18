package br.com.fiap.sonha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.sonha.beans.UsuarioBEANS;
import br.com.fiap.sonha.connection.ConexaoFactory;

public class UsuarioDAO {
	private Connection conexao;

	public UsuarioDAO() throws ClassNotFoundException, SQLException {
		this.conexao = new ConexaoFactory().getConnection();
	}

	public void fecharConexao() throws SQLException {
		try {
			conexao.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int adicionarUsuario(UsuarioBEANS usuario) throws SQLException {
		String sql = "INSERT INTO T_USUARIO (CD_USUARIO, NOME_USUARIO, EMAIL, SENHA) "
				+ "VALUES (USUARIO_SEQ.NEXTVAL, ?, ?, ?)";
		//String sql = "INSERT INTO T_USUARIO (CD_USUARIO, NOME_USUARIO, EMAIL, SENHA, DT_NASCIMENTO)"
			//	+ "VALUES (USUARIO_SEQ.NEXTVAL, ?, ?, ?, TO_DATE(?, 'dd/MM/yyyy'))";
		int cdUsuario = 0;
		PreparedStatement stmt = null;
		try {
			stmt = conexao.prepareStatement(sql);

			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getPassword());
			//stmt.setString(4, usuario.getDtNascimento());
			stmt.execute();

			cdUsuario = obterCdUsuarioAtual();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			stmt.close();
		}
		return cdUsuario;
	}

	private int obterCdUsuarioAtual() {
		String sql = "SELECT USUARIO_SEQ.CURRVAL FROM T_USUARIO";
		int cdUsuario = 0;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				cdUsuario = rs.getInt("CURRVAL");
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
		return cdUsuario;
	}

	public List<UsuarioBEANS> listarUsuarios() throws SQLException {
		String sql = "SELECT CD_USUARIO, SOBRENOME_USUARIO, NOME_USUARIO FROM T_USUARIO";
		List<UsuarioBEANS> listaUsuarios = new ArrayList<UsuarioBEANS>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				UsuarioBEANS usuario = new UsuarioBEANS();
				usuario.setNome(rs.getString("NOME_USUARIO"));
				usuario.setSobrenome(rs.getString("SOBRENOME_USUARIO"));
				listaUsuarios.add(usuario);
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
		return listaUsuarios;
	}

	// New class

	public int efetuarLogin(String email, String password) throws SQLException {
		String sql = "SELECT CD_USUARIO FROM T_USUARIO WHERE EMAIL = ? AND SENHA = ?";
		int cdUsuario = 0;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, email);
			stmt.setString(2, password);
			rs = stmt.executeQuery();

			while (rs.next()) {
				cdUsuario = rs.getInt("CD_USUARIO");
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
		return cdUsuario;
	}

	public UsuarioBEANS selecionarUsuario(int cdUsuario) throws SQLException {
		String sql = "SELECT SOBRENOME_USUARIO, NOME_USUARIO, EMAIL, SENHA FROM T_USUARIO WHERE CD_USUARIO = ?";
		UsuarioBEANS usuario = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, cdUsuario);
			rs = stmt.executeQuery();

			while (rs.next()) {
				usuario = new UsuarioBEANS();
				usuario.setNome(rs.getString("NOME_USUARIO"));
				usuario.setSobrenome(rs.getString("SOBRENOME_USUARIO"));
				usuario.setEmail(rs.getString("EMAIL"));
				usuario.setPassword(rs.getString("SENHA"));
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
		return usuario;
	}

	public void atualizarUsuario(UsuarioBEANS usuario) throws SQLException {
		String sql = "UPDATE T_USUARIO SET SOBRENOME_USUARIO = ? , "
				+ "NOME_USUARIO = ?, EMAIL = ?, SENHA = ? WHERE CD_USUARIO = ?";
		PreparedStatement stmt = null;
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getSobrenome());
			stmt.setString(2, usuario.getNome());
			stmt.setString(3, usuario.getEmail());
			stmt.setString(4, usuario.getPassword());
			stmt.setInt(5, usuario.getCdUsuario());

			stmt.executeUpdate();
			stmt.close();
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

	public void deletarUsuario(int cdUsuario) {
		String sql = "DELETE FROM T_USUARIO WHERE CD_USUARIO = ?";
		PreparedStatement stmt = null;
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, cdUsuario);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				conexao.close();
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
}
