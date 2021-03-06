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
			String tituloSonho = JOptionPane.showInputDialog("Digite o T�tulo do Sonho");
			String descricaoSonho = JOptionPane.showInputDialog("Digite a Descri��o do Sonho");
			int cdUsuario = Integer.parseInt(JOptionPane.showInputDialog("Digite o C�digo do Usu�rio"));
			int cdCategoria = Integer.parseInt(JOptionPane.showInputDialog("Digite o C�digo da Categoria do Sonho"));
			
			sonho.setTituloSonho(tituloSonho);
			sonho.setDescricaoSonho(descricaoSonho);
			sonho.setCdUsuario(cdUsuario);
			sonho.setCdCategoria(cdCategoria);
			sonho.setSonhoRealizado(false);
			sonho.setDtCriacao("");
			int cdSonho = bo.adicionarSonho(sonho);
			sonho.setCdSonho(cdSonho);
			System.out.println("Sonho Adicionado com Sucesso!");
			System.out.println("C�digo do Sonho: " + sonho.getCdSonho());
			System.out.println("T�tulo do Sonho: " + sonho.getTituloSonho());
			System.out.println("Descri��o do Sonho: " + sonho.getDescricaoSonho());
			System.out.println("Data de Cria��o: " + sonho.getDtCriacao());
			System.out.println("C�digo do Usu�rio: " + sonho.getCdUsuario());
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
