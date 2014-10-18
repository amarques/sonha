package br.com.fiap.sonha.test;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.sonha.beans.SonhoBEANS;
import br.com.fiap.sonha.bo.SonhoBO;

public class TestarListarSonhosPorUsuario {

	public static void main(String[] args) {

		try {
			SonhoBO bo = new SonhoBO();
			int cdUsuario = Integer.parseInt(JOptionPane
					.showInputDialog("Digite o Código do Usuário"));
			List<SonhoBEANS> listaSonhos = bo.listarSonhosPorUsuario(cdUsuario);
			for (SonhoBEANS sonho : listaSonhos) {
				System.out.println("Código do Sonho: " + sonho.getCdSonho());
				System.out
						.println("Título do Sonho: " + sonho.getTituloSonho());
				System.out.println("Descrição do Sonho: "
						+ sonho.getDescricaoSonho());
				System.out.println("==================================");
			}
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

}
