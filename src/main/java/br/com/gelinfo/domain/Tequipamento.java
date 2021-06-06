package br.com.gelinfo.domain;

public class Tequipamento {
	
	private int codigo_tipo_equipamento;
	private String tipo_nome;

	
	public String getTipo_nome() {
		return tipo_nome;
	}

	public void setTipo_nome(String tipo_nome) {
		this.tipo_nome = tipo_nome;
	}

	public int getCodigo_tipo_equipamento() {
		return codigo_tipo_equipamento;
	}

	public void setCodigo_tipo_equipamento(int codigo_tipo_equipamento) {
		this.codigo_tipo_equipamento = codigo_tipo_equipamento;
	}

	
}
