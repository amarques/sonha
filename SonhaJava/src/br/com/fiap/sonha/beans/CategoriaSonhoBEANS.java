package br.com.fiap.sonha.beans;

public class CategoriaSonhoBEANS {
	
	private int cdCatgegoria;
	private String nomeCategoria;
	
	public CategoriaSonhoBEANS() {}
	public CategoriaSonhoBEANS(int cdCatgegoria, String nomeCategoria) {
		this.cdCatgegoria = cdCatgegoria;
		this.nomeCategoria = nomeCategoria;
	}
	public int getCdCatgegoria() {
		return cdCatgegoria;
	}
	public void setCdCatgegoria(int cdCatgegoria) {
		this.cdCatgegoria = cdCatgegoria;
	}
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
}
