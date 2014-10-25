package br.com.fiap.sonha.test;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.sonha.beans.UsuarioBEANS;
import br.com.fiap.sonha.bo.UsuarioBO;

public class TestarAtualizarUsuario {

	public static void main(String[] args) {

		
		try {
			UsuarioBO bo = new UsuarioBO();
			
			int cdUsuario = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do Usuário"));
			UsuarioBEANS usuario = null;
			
			usuario = bo.selecionarUsuario(cdUsuario);
			String nome = JOptionPane.showInputDialog("Atualize seu Nome", usuario.getNome());
			String sobrenome = JOptionPane.showInputDialog("Atualize seu Sobrenome", usuario.getSobrenome());
			String email = JOptionPane.showInputDialog("Atualize seu Email", usuario.getEmail());
			String password = JOptionPane.showInputDialog("Atualize sua Senha", usuario.getPassword());
			usuario.setCdUsuario(cdUsuario);
			usuario.setNome(nome);
			usuario.setSobrenome(sobrenome);
			usuario.setEmail(email);
			usuario.setPassword(password);
			
			bo.atualizarUsuario(usuario);
			
			System.out.println("Dados Atualizados com Sucesso");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		

	}

}
