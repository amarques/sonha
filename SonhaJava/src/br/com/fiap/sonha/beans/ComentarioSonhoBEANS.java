package br.com.fiap.sonha.beans;

public class ComentarioSonhoBEANS {
	private int cdComentario;
	private String dtCriacaoComentario;
	private String comentario;
	private int cdUsuario;
	private int cdSonho;
	
	public ComentarioSonhoBEANS() {}
	public ComentarioSonhoBEANS(int cdComentario, String dtCriacaoComentario, String comentario,
			int cdUsuario, int cdSonho) {
		this.cdComentario = cdComentario;
		this.dtCriacaoComentario = dtCriacaoComentario;
		this.comentario = comentario;
		this.cdUsuario = cdUsuario;
		this.cdSonho = cdSonho;
	}
	
	public int getCdComentario() {
		return cdComentario;
	}
	public void setCdComentario(int cdComentario) {
		this.cdComentario = cdComentario;
	}
	
	public String getDtCriacaoComentario() {
		return dtCriacaoComentario;
	}
	public void setDtCriacaoComentario(String dtCriacaoComentario) {
		this.dtCriacaoComentario = dtCriacaoComentario;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public int getCdUsuario() {
		return cdUsuario;
	}
	public void setCdUsuario(int cdUsuario) {
		this.cdUsuario = cdUsuario;
	}
	public int getCdSonho() {
		return cdSonho;
	}
	public void setCdSonho(int cdSonho) {
		this.cdSonho = cdSonho;
	}
}
