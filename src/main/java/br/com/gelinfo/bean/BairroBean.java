package br.com.gelinfo.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.gelinfo.DAO.BairroDAO;
import br.com.gelinfo.domain.Bairro;

import br.com.gelinfo.util.JSFUtil;

@ManagedBean(name = "MBBairro")
@ViewScoped
public class BairroBean {
	
	private Bairro bairro;
	private ArrayList<Bairro>itens;
	private ArrayList<Bairro>itensFiltrados;
	
	
	public Bairro getBairro() {
		return bairro;
	}



	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}



	public ArrayList<Bairro> getItens() {
		return itens;
	}



	public void setItens(ArrayList<Bairro> itens) {
		this.itens = itens;
	}



	public ArrayList<Bairro> getItensFiltrados() {
		return itensFiltrados;
	}



	public void setItensFiltrados(ArrayList<Bairro> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}



	@PostConstruct
	public void preparaPesquisa() {
		
		
		
		try {
			BairroDAO bdao = new BairroDAO();
			itens = bdao.listar();
			
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
		
		
	}



	public void prepararInserir() {
		bairro = new Bairro();
	}
		

	public void inserir() {
		
		try {
			BairroDAO bdao = new BairroDAO();
			bdao.inserir(bairro);
			
			itens = bdao.listar();
		
			JSFUtil.adicionarMensagemSucesso("Bairro salvo com sucesso!");
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}



	public void excluir() {

		try {
			BairroDAO bdao = new BairroDAO();
			bdao.deletar(bairro);
			
			itens = bdao.listar();
		
			JSFUtil.adicionarMensagemSucesso("Bairro excluido com sucesso!");
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}



	public void editar() {

		try {
			BairroDAO bdao = new BairroDAO();
			bdao.editar(bairro);
			
			itens = bdao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Bairro editado com sucesso!");
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			
			e.printStackTrace();
		}
	}

}
