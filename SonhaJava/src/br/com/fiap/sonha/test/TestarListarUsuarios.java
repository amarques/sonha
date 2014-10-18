package br.com.fiap.sonha.test;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.sonha.beans.UsuarioBEANS;
import br.com.fiap.sonha.bo.UsuarioBO;

public class TestarListarUsuarios {

	public static void main(String[] args) {

		try {
			UsuarioBO bo = new UsuarioBO();
			List<UsuarioBEANS> listaUsuarios = bo.listarUsuarios();

			for (UsuarioBEANS usuario : listaUsuarios) {
				System.out.println("Nome: " + usuario.getNome() + " "
						+ usuario.getSobrenome());
				System.out
						.println("==========================================");
			}
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			//TODO: Teste Java
		}
	}

}
