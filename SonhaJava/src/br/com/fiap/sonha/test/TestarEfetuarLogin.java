package br.com.fiap.sonha.test;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.sonha.beans.UsuarioBEANS;
import br.com.fiap.sonha.bo.UsuarioBO;

public class TestarEfetuarLogin {

	public static void main(String[] args) {
		try {
			UsuarioBO usuarioBO = new UsuarioBO();
			
			String email = JOptionPane.showInputDialog("Digite seu email");
			String password = JOptionPane.showInputDialog("Digite sua senha");
			
			UsuarioBEANS usuario = new UsuarioBEANS();
			
			int cdUsuario = usuarioBO.efetuarLogin(email, password);
			if (cdUsuario == 0) {
				System.out.println("Login ou Senha Incorretos");
			}
			else {
				usuario = usuarioBO.selecionarUsuario(cdUsuario);
				usuarioBO.fecharConexao();
				System.out.println("Código do Usuário: " + usuario.getCdUsuario());
				System.out.println("Nome: " + usuario.getNome() + " " + usuario.getSobrenome());
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
