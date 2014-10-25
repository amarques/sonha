package br.com.fiap.sonha.test;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.sonha.beans.ComentarioSonhoBEANS;
import br.com.fiap.sonha.bo.ComentarioSonhoBO;

public class TestarAdicionarComentario {

	public static void main(String[] args) {

			try {
				ComentarioSonhoBO comentarioSonhoBO = new ComentarioSonhoBO();
				ComentarioSonhoBEANS comentarioSonho = new ComentarioSonhoBEANS();
				
				int cdUsuario = Integer.parseInt(JOptionPane.showInputDialog("Digite o Código do Usuário"));
				int cdSonho = Integer.parseInt(JOptionPane.showInputDialog("Digite o Código do Sonho"));
				String comentario = JOptionPane.showInputDialog("Digite o Comentário para o Sonho");
				comentarioSonho.setCdComentario(0);
				comentarioSonho.setCdSonho(cdSonho);
				comentarioSonho.setCdUsuario(cdUsuario);
				comentarioSonho.setComentario(comentario);
				comentarioSonho.setDtCriacaoComentario("");

				comentarioSonhoBO.adicionarComentario(comentarioSonho);
				System.out.println("Comentário Incluído com sucesso");
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
	}

}
