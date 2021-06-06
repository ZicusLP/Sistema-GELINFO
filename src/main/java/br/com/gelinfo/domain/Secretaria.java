package br.com.gelinfo.domain;

public class Secretaria {
	
	private String nomesec;
	private String siglasec;
	private int codigo_secretaria;
	
	public String getNomesec() {
		return nomesec;
	}
	public void setNomesec(String nomesec) {
		this.nomesec = nomesec;
	}
	public String getSiglasec() {
		return siglasec;
	}
	public void setSiglasec(String siglasec) {
		this.siglasec = siglasec;
	}
	
	
	public int getCodigo_secretaria() {
		return codigo_secretaria;
	}
	public void setCodigo_secretaria(int codigo_secretaria) {
		this.codigo_secretaria = codigo_secretaria;
	}
	@Override
	public String toString() {
		String saida = codigo_secretaria + " - " + nomesec + " " + siglasec;
		return saida;
	}

}
