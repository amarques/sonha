package br.com.fiap.sonha.test;


public class Teste {

	public static void main(String[] args) {

		String sql = "SELECT CD_SONHO, TO_CHAR(DT_CRIACAO, 'dd/MM/yyyy') \"DT_CRIACAO\", "
				+ "TITULO_SONHO, DESCRICAO_SONHO, CD_USUARIO, SONHO_REALIZADO, "
				+ "CD_CATG_SONHO FROM T_SONHO";
		System.out.println(sql);
	}

}
