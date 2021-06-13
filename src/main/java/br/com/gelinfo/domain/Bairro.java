package br.com.gelinfo.domain;

public class Bairro {
	
	private int codigo_bairro;
	private String nomebairro;
	private String endereco;
	
	
	public int getCodigo_bairro() {
		return codigo_bairro;
	}
	public void setCodigo_bairro(int codigo_bairro) {
		this.codigo_bairro = codigo_bairro;
	}
	public String getNomebairro() {
		return nomebairro;
	}
	public void setNomebairro(String nomebairro) {
		this.nomebairro = nomebairro;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	@Override
	public String toString() {
		String saida = codigo_bairro + " - " + nomebairro + " " + endereco;
		return saida;
	}

}


