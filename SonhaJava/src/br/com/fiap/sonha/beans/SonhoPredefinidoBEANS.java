package br.com.fiap.sonha.beans;

public class SonhoPredefinidoBEANS {
	private int cdSonhoPredefinido;
	private String tituloSonhoPredefinido;
	private String descricaoSonhoPredefinido;
	private int cdCategoriaSonhoPredefinido;
	
	public SonhoPredefinidoBEANS() {}
	public SonhoPredefinidoBEANS(int cdSonhoPredefinido,
			String tituloSonhoPredefinido, String descricaoSonhoPredefinido,
			int cdCategoriaSonhoPredefinido) {
		this.cdSonhoPredefinido = cdSonhoPredefinido;
		this.tituloSonhoPredefinido = tituloSonhoPredefinido;
		this.descricaoSonhoPredefinido = descricaoSonhoPredefinido;
		this.cdCategoriaSonhoPredefinido = cdCategoriaSonhoPredefinido;
	}
	public int getCdSonhoPredefinido() {
		return cdSonhoPredefinido;
	}
	public void setCdSonhoPredefinido(int cdSonhoPredefinido) {
		this.cdSonhoPredefinido = cdSonhoPredefinido;
	}
	public String getTituloSonhoPredefinido() {
		return tituloSonhoPredefinido;
	}
	public void setTituloSonhoPredefinido(String tituloSonhoPredefinido) {
		this.tituloSonhoPredefinido = tituloSonhoPredefinido;
	}
	public String getDescricaoSonhoPredefinido() {
		return descricaoSonhoPredefinido;
	}
	public void setDescricaoSonhoPredefinido(String descricaoSonhoPredefinido) {
		this.descricaoSonhoPredefinido = descricaoSonhoPredefinido;
	}
	public int getCdCategoriaSonhoPredefinido() {
		return cdCategoriaSonhoPredefinido;
	}
	public void setCdCategoriaSonhoPredefinido(int cdCategoriaSonhoPredefinido) {
		this.cdCategoriaSonhoPredefinido = cdCategoriaSonhoPredefinido;
	}
	
	
	
}
