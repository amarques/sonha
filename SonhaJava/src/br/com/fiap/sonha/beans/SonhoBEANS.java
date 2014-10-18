package br.com.fiap.sonha.beans;

public class SonhoBEANS {
	
	private int cdSonho;
	private String dtCriacao;
	private String tituloSonho;
	private String descricaoSonho;
	private int cdUsuario;
	private boolean sonhoRealizado;
	private int cdCategoria;
	
	public SonhoBEANS() {}
	public SonhoBEANS(int cdSonho, String dtCriacao, String tituloSonho, String descricaoSonho,
			int cdUsuario, boolean sonhoRealizado, int cdCategoria) {
		this.cdSonho = cdSonho;
		this.dtCriacao = dtCriacao;
		this.tituloSonho = tituloSonho;
		this.descricaoSonho = descricaoSonho;
		this.cdUsuario = cdUsuario;
		this.sonhoRealizado = sonhoRealizado;
		this.cdCategoria = cdCategoria;
	}
	public int getCdSonho() {
		return cdSonho;
	}
	public void setCdSonho(int cdSonho) {
		this.cdSonho = cdSonho;
	}
	
	public String getDtCriacao() {
		return dtCriacao;
	}
	public void setDtCriacao(String dtCriacao) {
		this.dtCriacao = dtCriacao;
	}
	public String getTituloSonho() {
		return tituloSonho;
	}
	public void setTituloSonho(String tituloSonho) {
		this.tituloSonho = tituloSonho;
	}
	public String getDescricaoSonho() {
		return descricaoSonho;
	}
	public void setDescricaoSonho(String descricaoSonho) {
		this.descricaoSonho = descricaoSonho;
	}
	public int getCdUsuario() {
		return cdUsuario;
	}
	public void setCdUsuario(int cdUsuario) {
		this.cdUsuario = cdUsuario;
	}
	public boolean isSonhoRealizado() {
		return sonhoRealizado;
	}
	public void setSonhoRealizado(boolean sonhoRealizado) {
		this.sonhoRealizado = sonhoRealizado;
	}
	public int getCdCategoria() {
		return cdCategoria;
	}
	public void setCdCategoria(int cdCategoria) {
		this.cdCategoria = cdCategoria;
	}
	
	
}
