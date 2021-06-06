package br.com.gelinfo.domain;

public class Equipamento {
	
	private int codigo_equipamento;
	private String patrimonio;
	private String npatrimonio;
	private String nserie;
	private Setor setor;
	private Modelo modelo;
	private Tequipamento t_equipamento;
	
	public Setor getSetor() {
		return setor;
	}
	public void setSetor(Setor setor) {
		this.setor = setor;
	}
	public Modelo getModelo() {
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	public Tequipamento getT_equipamento() {
		return t_equipamento;
	}
	public void setT_equipamento(Tequipamento t_equipamento) {
		this.t_equipamento = t_equipamento;
	}
	public int getCodigo_equipamento() {
		return codigo_equipamento;
	}
	public void setCodigo_equipamento(int codigo_equipamento) {
		this.codigo_equipamento = codigo_equipamento;
	}
	public String getPatrimonio() {
		return patrimonio;
	}
	public void setPatrimonio(String patrimonio) {
		this.patrimonio = patrimonio;
	}
	public String getNpatrimonio() {
		return npatrimonio;
	}
	public void setNpatrimonio(String npatrimonio) {
		this.npatrimonio = npatrimonio;
	}
	public String getNserie() {
		return nserie;
	}
	public void setNserie(String nserie) {
		this.nserie = nserie;
	}
	
	
	
	
}
