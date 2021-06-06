package br.com.gelinfo.domain;

public class Setor {

	private int codigo_setor;
	private String nomesetor;
	private String siglasetor;
	private String andarsetor;
	private int secretaria_codigo;
	private int bairro_codigo;

	private Secretaria secretaria = new Secretaria();
	private Bairro bairro = new Bairro();;
	private String comboSecretarias;
	

	public int getSecretaria_codigo() {
		return secretaria_codigo;
	}
	public void setSecretaria_codigo(int secretaria_codigo) {
		this.secretaria_codigo = secretaria_codigo;
	}
	public int getBairro_codigo() {
		return bairro_codigo;
	}
	public void setBairro_codigo(int bairro_codigo) {
		this.bairro_codigo = bairro_codigo;
	}
	public int getCodigo_setor() {
		return codigo_setor;
	}
	public void setCodigo_setor(int codigo_setor) {
		this.codigo_setor = codigo_setor;
	}
	
	public String getAndarsetor() {
		return andarsetor;
	}
	public void setAndarsetor(String andarsetor) {
		this.andarsetor = andarsetor;
	}
	public String getComboSecretarias() {
		return comboSecretarias;
	}
	public void setComboSecretarias(String comboSecretarias) {
		this.comboSecretarias = comboSecretarias;
	}
	
	public Secretaria getSecretaria() {
		return secretaria;
	}
	public void setSecretaria(Secretaria secretaria) {
		this.secretaria = secretaria;
	}
	public Bairro getBairro() {
		return bairro;
	}
	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
	public String getNomesetor() {
		return nomesetor;
	}
	public void setNomesetor(String nomesetor) {
		this.nomesetor = nomesetor;
	}
	public String getSiglasetor() {
		return siglasetor;
	}
	public void setSiglasetor(String siglasetor) {
		this.siglasetor = siglasetor;
	}
	
	

	@Override
	public String toString() {
		String saida = secretaria + " - " + nomesetor + " " + siglasetor + "-" + bairro;
		return saida;
	}
	
	
	
}
