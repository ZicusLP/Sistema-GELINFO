package br.com.gelinfo.domain;

public class Cpu {
	
	private int codigo_cpu;
	private int ipcpu;
	private Equipamento equipamento;
	private Modelo modelos;
	private Marca marcas;
	private Tequipamento tipo_equipamento;

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}


	public int getIpcpu() {
		return ipcpu;
	}

	public void setIpcpu(int ipcpu) {
		this.ipcpu = ipcpu;
	}

	public int getCodigo_cpu() {
		return codigo_cpu;
	}

	public void setCodigo_cpu(int codigo_cpu) {
		this.codigo_cpu = codigo_cpu;
	}

	public Modelo getModelos() {
		return modelos;
	}

	public void setModelos(Modelo modelos) {
		this.modelos = modelos;
	}

	public Marca getMarcas() {
		return marcas;
	}

	public void setMarcas(Marca marcas) {
		this.marcas = marcas;
	}

	public Tequipamento getTipo_equipamento() {
		return tipo_equipamento;
	}

	public void setTipo_equipamento(Tequipamento tipo_equipamento) {
		this.tipo_equipamento = tipo_equipamento;
	}
	
	

}
