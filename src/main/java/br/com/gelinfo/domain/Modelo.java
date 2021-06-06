package br.com.gelinfo.domain;

public class Modelo {
	
	private int codigo_modelo;
	private String nomemodelo;
	private int marca_codigo;
	
	private Marca marcas = new Marca();
	private String comboMarcas;
	
	
	
	public Marca getMarcas() {
		return marcas;
	}
	public void setMarcas(Marca marcas) {
		this.marcas = marcas;
	}
	public String getComboMarcas() {
		return comboMarcas;
	}
	public void setComboMarcas(String comboMarcas) {
		this.comboMarcas = comboMarcas;
	}
	public int getCodigo_modelo() {
		return codigo_modelo;
	}
	public void setCodigo_modelo(int codigo_modelo) {
		this.codigo_modelo = codigo_modelo;
	}
	
	public int getMarca_codigo() {
		return marca_codigo;
	}
	public void setMarca_codigo(int marca_codigo) {
		this.marca_codigo = marca_codigo;
	}
	public String getNomemodelo() {
		return nomemodelo;
	}
	public void setNomemodelo(String nomemodelo) {
		this.nomemodelo = nomemodelo;
	}

	@Override
	public String toString() {
		String saida = marcas + " - " + nomemodelo ;
		return saida;
	}
	
	

}
