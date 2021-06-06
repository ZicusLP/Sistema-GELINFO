package br.com.gelinfo.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.gelinfo.DAO.CpuDAO;
import br.com.gelinfo.DAO.SecretariaDAO;
import br.com.gelinfo.DAO.SetorDAO;
import br.com.gelinfo.domain.Bairro;
import br.com.gelinfo.domain.Cpu;
import br.com.gelinfo.domain.Secretaria;
import br.com.gelinfo.domain.Setor;
import br.com.gelinfo.util.JSFUtil;

@ManagedBean(name = "MBCpu")
@ViewScoped
public class CpuBean {

	private Cpu cpu;
	private ArrayList<Cpu>itens;
	private ArrayList<Cpu>itensFiltrados;
	
	private ArrayList<Secretaria>comboSecretarias;
	private ArrayList<Bairro>comboBairros;
	private ArrayList<Setor>combosetores;
	public Cpu getCpu() {
		return cpu;
	}
	public void setCpu(Cpu cpu) {
		this.cpu = cpu;
	}
	public ArrayList<Cpu> getItens() {
		return itens;
	}
	public void setItens(ArrayList<Cpu> itens) {
		this.itens = itens;
	}
	public ArrayList<Cpu> getItensFiltrados() {
		return itensFiltrados;
	}
	public void setItensFiltrados(ArrayList<Cpu> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	public ArrayList<Secretaria> getComboSecretarias() {
		return comboSecretarias;
	}
	public void setComboSecretarias(ArrayList<Secretaria> comboSecretarias) {
		this.comboSecretarias = comboSecretarias;
	}
	public ArrayList<Bairro> getComboBairros() {
		return comboBairros;
	}
	public void setComboBairros(ArrayList<Bairro> comboBairros) {
		this.comboBairros = comboBairros;
	}
	public ArrayList<Setor> getCombosetores() {
		return combosetores;
	}
	public void setCombosetores(ArrayList<Setor> combosetores) {
		this.combosetores = combosetores;
	}
	
	@PostConstruct
	public void preparaPesquisa() throws SQLException {
		
		
		
		CpuDAO cdao = new CpuDAO();
		itens = cdao.listar();
		
		
	}



	public void prepararInserir() {

		try {
			cpu = new Cpu();
			
			SecretariaDAO sdao = new SecretariaDAO();
			comboSecretarias = sdao.listar();
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}

	public void inserir() {
		
		try {
			CpuDAO cdao = new CpuDAO();
			cdao.inserir(cpu);
			
			itens = cdao.listar();
		
			JSFUtil.adicionarMensagemSucesso("Cpu salva com sucesso!");
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}



	public void excluir() {

		try {
			CpuDAO cdao = new CpuDAO();
			cdao.deletar(cpu);
			
			itens = cdao.listar();
		
			JSFUtil.adicionarMensagemSucesso("Cpu excluida com sucesso!");
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}



	public void editar() {

		try {
			CpuDAO cdao = new CpuDAO();
			cdao.editar(cpu);
			
			itens = cdao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Cpu editada com sucesso!");
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			
			e.printStackTrace();
		}
	}
	
}
