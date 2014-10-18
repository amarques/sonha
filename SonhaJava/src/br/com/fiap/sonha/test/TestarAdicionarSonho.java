package br.com.fiap.sonha.test;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.sonha.beans.SonhoBEANS;
import br.com.fiap.sonha.bo.SonhoBO;

public class TestarAdicionarSonho {
	
	public static void main(String[] args) {
		
		try {
			SonhoBO bo = new SonhoBO();
			
			SonhoBEANS sonho = new SonhoBEANS();
			String tituloSonho = JOptionPane.showInputDialog("Digite o Título do Sonho");
			String descricaoSonho = JOptionPane.showInputDialog("Digite a Descrição do Sonho");
			int cdUsuario = Integer.parseInt(JOptionPane.showInputDialog("Digite o Código do Usuário"));
			int cdCategoria = Integer.parseInt(JOptionPane.showInputDialog("Digite o Código da Categoria do Sonho"));
			
			sonho.setTituloSonho(tituloSonho);
			sonho.setDescricaoSonho(descricaoSonho);
			sonho.setCdUsuario(cdUsuario);
			sonho.setCdCategoria(cdCategoria);
			sonho.setSonhoRealizado(false);
			sonho.setDtCriacao("");
			bo.adicionarSonho(sonho);
			System.out.println("Sonho Adicionado com Sucesso!");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
