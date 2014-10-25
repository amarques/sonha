package br.com.fiap.sonha.beans;


public class UsuarioBEANS  {

	private int cdUsuario;
	private String sobrenome;
	private String nome;
	private String email;
	private String password;
	private String dtNascimento;
	private String dtEntrada;
	
	public UsuarioBEANS() {}
	public UsuarioBEANS(int cdUsuario, String sobrenome, String nome, String email, String password, String dtNascimento, String dtEntrada) {
		this.cdUsuario = cdUsuario;
		this.sobrenome = sobrenome;
		this.nome = nome;
		this.email = email;
		this.password = password;
		this.dtNascimento = dtNascimento;
		this.dtEntrada = dtEntrada;
	}

	public int getCdUsuario() {
		return cdUsuario;
	}

	public void setCdUsuario(int cdUsuario) {
		this.cdUsuario = cdUsuario;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public String getDtEntrada() {
		return dtEntrada;
	}
	public void setDtEntrada(String dtEntrada) {
		this.dtEntrada = dtEntrada;
	}
	
}

