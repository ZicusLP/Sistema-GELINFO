package br.com.gelinfo.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.gelinfo.DAO.SecretariaDAO;
import br.com.gelinfo.DAO.SetorDAO;
import br.com.gelinfo.domain.Bairro;
import br.com.gelinfo.domain.Secretaria;
import br.com.gelinfo.domain.Setor;
import br.com.gelinfo.util.JSFUtil;

@ManagedBean(name = "MBSetor")
@ViewScoped

public class SetorBean {
	
	private Setor setor;
	private ArrayList<Setor>itens;
	private ArrayList<Setor>itensFiltrados;
	
	private ArrayList<Secretaria>comboSecretarias;
	private ArrayList<Bairro>comboBairros;
	
	
	
	public ArrayList<Bairro> getComboBairros() {
		return comboBairros;
	}
	public void setComboBairros(ArrayList<Bairro> comboBairros) {
		this.comboBairros = comboBairros;
	}
	public ArrayList<Secretaria> getComboSecretarias() {
		return comboSecretarias;
	}
	public void setComboSecretarias(ArrayList<Secretaria> comboSecretarias) {
		this.comboSecretarias = comboSecretarias;
	}
	public Setor getSetor() {
		return setor;
	}
	public void setSetor(Setor setor) {
		this.setor = setor;
	}
	public ArrayList<Setor> getItens() {
		return itens;
	}
	public void setItens(ArrayList<Setor> itens) {
		this.itens = itens;
	}
	public ArrayList<Setor> getItensFiltrados() {
		return itensFiltrados;
	}
	public void setItensFiltrados(ArrayList<Setor> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	

@PostConstruct
public void preparaPesquisa() {
	
	
	
	try {
		SetorDAO sedao = new SetorDAO();
		itens = sedao.listar();
		
	} catch (SQLException e) {
		JSFUtil.adicionarMensagemErro(e.getMessage());
		e.printStackTrace();
	}
	
	
}



public void prepararInserir() {

	try {
		setor = new Setor();
		
		SecretariaDAO sdao = new SecretariaDAO();
		comboSecretarias = sdao.listar();
	} catch (SQLException e) {
		JSFUtil.adicionarMensagemErro(e.getMessage());
		e.printStackTrace();
	}
}

public void inserir() {
	
	try {
		SetorDAO sedao = new SetorDAO();
		sedao.inserir(setor);
		
		itens = sedao.listar();
	
		JSFUtil.adicionarMensagemSucesso("Setor salvo com sucesso!");
	} catch (SQLException e) {
		JSFUtil.adicionarMensagemErro(e.getMessage());
		e.printStackTrace();
	}
}



public void excluir() {

	try {
		SetorDAO sedao = new SetorDAO();
		sedao.deletar(setor);
		
		itens = sedao.listar();
	
		JSFUtil.adicionarMensagemSucesso("Setor excluido com sucesso!");
	} catch (SQLException e) {
		JSFUtil.adicionarMensagemErro(e.getMessage());
		e.printStackTrace();
	}
}



public void editar() {

	try {
		SetorDAO sedao = new SetorDAO();
		sedao.editar(setor);
		
		itens = sedao.listar();
		
		JSFUtil.adicionarMensagemSucesso("Setor editado com sucesso!");
	} catch (SQLException e) {
		JSFUtil.adicionarMensagemErro(e.getMessage());
		
		e.printStackTrace();
	}
}

}
