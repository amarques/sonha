package br.com.fiap.sonha.test;

import java.sql.SQLException;

import br.com.fiap.sonha.beans.UsuarioBEANS;
import br.com.fiap.sonha.bo.UsuarioBO;

public class TestarObterUsuario {

	public static void main(String[] args) {

			try {
				UsuarioBO usuarioBO = new UsuarioBO();
				int cdUsuario = 6;
				UsuarioBEANS usuario = usuarioBO.selecionarUsuario(cdUsuario);
				usuarioBO.fecharConexao();
				System.out.println("Código do Usuário: " + usuario.getCdUsuario());
				System.out.println("Nome do Usuário: " + usuario.getNome());
				
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
	}

}
