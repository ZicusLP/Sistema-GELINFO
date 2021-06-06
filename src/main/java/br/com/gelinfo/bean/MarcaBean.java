package br.com.gelinfo.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.gelinfo.DAO.MarcaDAO;
import br.com.gelinfo.domain.Marca;

import br.com.gelinfo.util.JSFUtil;

@ManagedBean(name = "MBMarca")
@ViewScoped
public class MarcaBean {
	
	private Marca marcas;
	private ArrayList<Marca>itens;
	private ArrayList<Marca>itensFiltrados;
	public Marca getMarcas() {
		return marcas;
	}
	public void setMarcas(Marca marcas) {
		this.marcas = marcas;
	}
	public ArrayList<Marca> getItens() {
		return itens;
	}
	public void setItens(ArrayList<Marca> itens) {
		this.itens = itens;
	}
	public ArrayList<Marca> getItensFiltrados() {
		return itensFiltrados;
	}
	public void setItensFiltrados(ArrayList<Marca> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	@PostConstruct
	public void preparaPesquisa() {
		
		
		
		try {
			MarcaDAO mdao = new MarcaDAO();
			itens = mdao.listar();
			
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
		
		
	}

	public void prepararInserir() {
		marcas = new Marca();
	}

	public void inserir() {
		
		try {
			MarcaDAO mdao = new MarcaDAO();
			mdao.inserir(marcas);
			
			itens = mdao.listar();
		
			JSFUtil.adicionarMensagemSucesso("Marca salva com sucesso!");
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}



	public void excluir() {

		try {
			MarcaDAO mdao = new MarcaDAO();
			mdao.deletar(marcas);
			
			itens = mdao.listar();
		
			JSFUtil.adicionarMensagemSucesso("Marca excluida com sucesso!");
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}



	public void editar() {

		try {
			MarcaDAO mdao = new MarcaDAO();
			mdao.editar(marcas);
			
			itens = mdao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Marca editada com sucesso!");
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			
			e.printStackTrace();
		}
	}

}
