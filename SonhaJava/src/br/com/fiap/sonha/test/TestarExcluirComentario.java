package br.com.fiap.sonha.test;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.sonha.bo.ComentarioSonhoBO;

public class TestarExcluirComentario {

	public static void main(String[] args) {
		try {
			ComentarioSonhoBO comentarioSonhoBO = new ComentarioSonhoBO();
			int cdComentarioSonho = Integer.parseInt(JOptionPane.showInputDialog("Digite o Código do Comentário"));
			comentarioSonhoBO.excluirComentario(cdComentarioSonho);
			System.out.println("Comentário Excluído com Sucesso!");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
