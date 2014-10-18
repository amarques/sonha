package br.com.fiap.sonha.test;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.sonha.bo.UsuarioBO;

public class TestarDeletarUsuario {
	public static void main(String[] args) {

		try {
			UsuarioBO bo = new UsuarioBO();
			int cdUsuario = Integer.parseInt(JOptionPane
					.showInputDialog("Digite o Código do Usuário"));

			bo.deletarUsuario(cdUsuario);
			System.out.println("Usuário Excluído com Sucesso!");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
