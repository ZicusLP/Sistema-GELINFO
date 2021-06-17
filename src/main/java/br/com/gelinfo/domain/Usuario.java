package br.com.gelinfo.domain;

public class Usuario {
	
	private int codigo_usuario;
	private String nome;
	private String login;
	private String senha;
	private int telefone;
	private String perfil;
	//private Perfil perfil;
	

	
	/*public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}*/
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public int getCodigo_usuario() {
		return codigo_usuario;
	}
	public void setCodigo_usuario(int codigo_usuario) {
		this.codigo_usuario = codigo_usuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	
	@Override
	public String toString() {
		String saida = codigo_usuario + " - " + nome + " " + perfil;
		return saida;
	}
	


}
