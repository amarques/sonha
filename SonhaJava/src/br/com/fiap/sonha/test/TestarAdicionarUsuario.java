package br.com.fiap.sonha.test;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.sonha.beans.UsuarioBEANS;
import br.com.fiap.sonha.bo.UsuarioBO;

public class TestarAdicionarUsuario {

	public static void main(String[] args) {

		
		try {
			UsuarioBO bo = new UsuarioBO();
			
			String nome = JOptionPane.showInputDialog("Digite seu Nome");
			String sobrenome = JOptionPane.showInputDialog("Digite seu Sobrenome");
			String email = JOptionPane.showInputDialog("Digite seu Email");
			String password = JOptionPane.showInputDialog("Digite sua Senha");
			String dtNascimento = JOptionPane.showInputDialog("Digite sua Data de Nascimento");
			
			UsuarioBEANS usuario = new UsuarioBEANS();
			usuario.setNome(nome);
			usuario.setSobrenome(sobrenome);
			usuario.setEmail(email);
			usuario.setPassword(password);
			usuario.setDtNascimento(dtNascimento);
			usuario.setDtEntrada("");
			
			int cdUsuario = bo.adicionarUsuario(usuario);
			usuario.setCdUsuario(cdUsuario);
			
			System.out.println("Usuário Adicionado com Sucesso!");
			System.out.println("Dados do Usuário");
			System.out.println("Nome: " + usuario.getNome() + " " + usuario.getSobrenome());
			System.out.println("Data de Nascimento: " + usuario.getDtNascimento());
			System.out.println("Email: " + usuario.getEmail());
			System.out.println("Senha: " + usuario.getPassword());
			System.out.println("Código de Usuário: " + usuario.getCdUsuario());
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}

}



