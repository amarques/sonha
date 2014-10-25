package br.com.fiap.sonha.test;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.sonha.beans.SonhoBEANS;
import br.com.fiap.sonha.bo.SonhoBO;

public class TestarListarSonhos {

	public static void main(String[] args) {

		try {
			SonhoBO bo = new SonhoBO();
			List<SonhoBEANS> listaSonhos = bo.listarSonhos();
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
