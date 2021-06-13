package br.com.gelinfo.domain;


public class Perfil {
	
	private int codigo_perfil;
	private String funcao;
	
	
	public int getCodigo_perfil() {
		return codigo_perfil;
	}
	public void setCodigo_perfil(int codigo_perfil) {
		this.codigo_perfil = codigo_perfil;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	@Override
	public String toString() {
		String saida = codigo_perfil+ " - " + funcao;
		return saida;
	}
	

}
