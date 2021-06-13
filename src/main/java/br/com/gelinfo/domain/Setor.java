package br.com.gelinfo.domain;

public class Setor {

	private int codigo_setor;
	private String nomesetor;
	private String siglasetor;
	private String andarsetor;
	
	private Secretaria secretaria = new Secretaria();
	private Secretaria codigo_secretaria;
	
	private Bairro bairro = new Bairro();
	private Bairro codigo_bairro;
	
	
	
	public int getCodigo_setor() {
		return codigo_setor;
	}
	public void setCodigo_setor(int codigo_setor) {
		this.codigo_setor = codigo_setor;
	}
	public Secretaria getCodigo_secretaria() {
		return codigo_secretaria;
	}
	public void setCodigo_secretaria(Secretaria codigo_secretaria) {
		this.codigo_secretaria = codigo_secretaria;
	}
	public Bairro getCodigo_bairro() {
		return codigo_bairro;
	}
	public void setCodigo_bairro(Bairro codigo_bairro) {
		this.codigo_bairro = codigo_bairro;
	}
	public String getAndarsetor() {
		return andarsetor;
	}
	public void setAndarsetor(String andarsetor) {
		this.andarsetor = andarsetor;
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
