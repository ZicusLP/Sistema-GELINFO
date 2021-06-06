package br.com.gelinfo.domain;

public class Marca {
	
	private int codigo_marca;
	private String nomemarca;

	
	
	public int getCodigo_marca() {
		return codigo_marca;
	}

	public void setCodigo_marca(int codigo_marca) {
		this.codigo_marca = codigo_marca;
	}

	public String getNomemarca() {
		return nomemarca;
	}

	public void setNomemarca(String nomemarca) {
		this.nomemarca = nomemarca;
	}
	
	@Override
	public String toString() {
		String saida = codigo_marca + " - " + nomemarca ;
		return saida;
	}
	
}
