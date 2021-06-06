package br.com.gelinfo.domain;

public class PerfilUsuario {

	private Perfil codigo_perfil;
	private Usuario codigo_usuario;
	
	

	public Perfil getCodigo_perfil() {
		return codigo_perfil;
	}



	public void setCodigo_perfil(Perfil codigo_perfil) {
		this.codigo_perfil = codigo_perfil;
	}



	public Usuario getCodigo_usuario() {
		return codigo_usuario;
	}



	public void setCodigo_usuario(Usuario codigo_usuario) {
		this.codigo_usuario = codigo_usuario;
	}



	@Override
	public String toString() {
		String saida = codigo_perfil+ " - " + codigo_usuario;
		return saida;
	}
	
}
