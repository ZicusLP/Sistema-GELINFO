package br.com.gelinfo.bean;


import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import br.com.gelinfo.DAO.TequipamentoDAO;

import br.com.gelinfo.domain.Tequipamento;

import br.com.gelinfo.util.JSFUtil;

@ManagedBean(name = "MBTipo")
@ViewScoped
public class TipoBean {
	
	private Tequipamento tipo;
	private ArrayList<Tequipamento>itens;
	private ArrayList<Tequipamento>itensFiltrados;
	public Tequipamento getTipo() {
		return tipo;
	}
	public void setTipo(Tequipamento tipo) {
		this.tipo = tipo;
	}
	public ArrayList<Tequipamento> getItens() {
		return itens;
	}
	public void setItens(ArrayList<Tequipamento> itens) {
		this.itens = itens;
	}
	public ArrayList<Tequipamento> getItensFiltrados() {
		return itensFiltrados;
	}
	public void setItensFiltrados(ArrayList<Tequipamento> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	
	@PostConstruct
	public void preparaPesquisa() {
		
		
		
		try {
			TequipamentoDAO tdao = new TequipamentoDAO();
			itens = tdao.listar();
			
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
		
		
	}

	public void prepararInserir() {
		tipo = new Tequipamento();
	}

	public void inserir() {
		
		try {
			TequipamentoDAO tdao = new TequipamentoDAO();
			tdao.inserir(tipo);
			
			itens = tdao.listar();
		
			JSFUtil.adicionarMensagemSucesso("Tipo salvo com sucesso!");
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}



	public void excluir() {

		try {
			TequipamentoDAO tdao = new TequipamentoDAO();
			tdao.deletar(tipo);
			
			itens = tdao.listar();
		
			JSFUtil.adicionarMensagemSucesso("Tipo excluido com sucesso!");
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}



	public void editar() {

		try {
			TequipamentoDAO tdao = new TequipamentoDAO();
			tdao.editar(tipo);
			
			itens = tdao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Tipo editado com sucesso!");
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			
			e.printStackTrace();
		}
	}

}
