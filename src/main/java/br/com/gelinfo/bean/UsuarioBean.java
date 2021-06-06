package br.com.gelinfo.bean;

import java.sql.SQLException;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import br.com.gelinfo.DAO.UsuarioDAO;
import br.com.gelinfo.domain.Perfil;
import br.com.gelinfo.domain.Usuario;
import br.com.gelinfo.util.JSFUtil;

@ManagedBean(name = "MBUsuario")
@ViewScoped
public class UsuarioBean {

	private Usuario usuario;
	private ArrayList<Usuario>itens;
	private ArrayList<Usuario>itensFiltrados;
	private ArrayList<Usuario>perfil;
	
	
	public ArrayList<Usuario> getPerfil() {
		return perfil;
	}
	public void setPerfil(ArrayList<Usuario> perfil) {
		this.perfil = perfil;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public ArrayList<Usuario> getItens() {
		return itens;
	}
	public void setItens(ArrayList<Usuario> itens) {
		this.itens = itens;
	}
	public ArrayList<Usuario> getItensFiltrados() {
		return itensFiltrados;
	}
	public void setItensFiltrados(ArrayList<Usuario> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	

@PostConstruct



public void preparaPesquisa() {
	
	
	
	try {
		UsuarioDAO udao = new UsuarioDAO();
		itens = udao.listar();
		
	} catch (SQLException e) {
		JSFUtil.adicionarMensagemErro(e.getMessage());
		e.printStackTrace();
	}
	
	
}

public void prepararInserir() {
	usuario = new Usuario();
}

public void inserir() {
	
	try {
		UsuarioDAO udao = new UsuarioDAO();
		udao.inserir(usuario);
		
		itens = udao.listar();
	
		JSFUtil.adicionarMensagemSucesso("Usuario salvo com sucesso!");
	} catch (SQLException e) {
		JSFUtil.adicionarMensagemErro(e.getMessage());
		e.printStackTrace();
	}
}



public void excluir() {

	try {
		UsuarioDAO udao = new UsuarioDAO();
		udao.deletar(usuario);
		
		itens = udao.listar();
	
		JSFUtil.adicionarMensagemSucesso("Usuario excluido com sucesso!");
	} catch (SQLException e) {
		JSFUtil.adicionarMensagemErro(e.getMessage());
		e.printStackTrace();
	}
}



public void editar() {

	try {
		UsuarioDAO udao = new UsuarioDAO();
		udao.editar(usuario);
		
		itens = udao.listar();
		
		JSFUtil.adicionarMensagemSucesso("Usuario editado com sucesso!");
	} catch (SQLException e) {
		JSFUtil.adicionarMensagemErro(e.getMessage());
		
		e.printStackTrace();
	}
}
	
}
