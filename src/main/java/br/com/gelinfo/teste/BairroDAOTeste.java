package br.com.gelinfo.teste;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import br.com.gelinfo.DAO.BairroDAO;

import br.com.gelinfo.domain.Bairro;


public class BairroDAOTeste {
	
	//@Test
	@Ignore
	public void inserir() throws SQLException {
		// METODO PARA INSERIR
		Bairro b1 = new Bairro();
		b1.setNomebairro("CENTRO");
		b1.setEndereco("R. da Conceição, 67");
		
		BairroDAO bdao = new BairroDAO();
		bdao.inserir(b1);

		Bairro b2 = new Bairro();
		b2.setNomebairro("CENTRO");
		b2.setEndereco("Av. Visc Sepetiba, 517");
		
		//BairroDAO bdao = new BairroDAO();
		bdao.inserir(b2);
	}
	
	//@Test
	@Ignore
	public void listar() throws SQLException {

		BairroDAO bdao = new BairroDAO();
		ArrayList<Bairro> lista = bdao.listar();

		for (Bairro b : lista) {
			System.out.println("Codigo do bairro: " + b.getCodigo_bairro());
			System.out.println("Nome do bairro " + b.getNomebairro());
			System.out.println("Endereço: " + b.getEndereco());
			System.out.println("");
		}

	}

	//@Test
	@Ignore
	public void excluir() throws SQLException {

		Bairro b = new Bairro();
		b.setCodigo_bairro(7);

		BairroDAO bdao = new BairroDAO();
		bdao.deletar(b);

	}

	//@Test
	@Ignore
	public void editar() throws SQLException {

		// METODO PARA EDITAR
		Bairro b = new Bairro();
		b.setCodigo_bairro(3);
		b.setNomebairro("Teste");
		b.setEndereco("AV. teste");
		
		BairroDAO bdao = new BairroDAO();
		bdao.editar(b);
	}


}
