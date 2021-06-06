package br.com.gelinfo.teste;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import br.com.gelinfo.DAO.SetorDAO;

import br.com.gelinfo.domain.Bairro;
import br.com.gelinfo.domain.Secretaria;
import br.com.gelinfo.domain.Setor;

public class SetorDAOTeste {

	@Test
	//@Ignore
	public void inserir() throws SQLException {
		// METODO PARA INSERIR
		Setor s1 = new Setor();
		s1.setNomesetor("DIRETOR");
		s1.setSiglasetor("ADSG");
		s1.setAndarsetor("Sub-Solo");

		Secretaria s = new Secretaria();
		s.setCodigo_secretaria(1);
		s1.setSecretaria(s);

		Bairro b = new Bairro();
		b.setCodigo_bairro(1);
		s1.setBairro(b);

		SetorDAO sdao = new SetorDAO();
		sdao.inserir(s1);
	}

	@Ignore
	public void listar() throws SQLException {

		SetorDAO sdao = new SetorDAO();
		ArrayList<Setor> lista = sdao.listar();

		for (Setor se : lista) {
			System.out.println("Codigo do setor: " + se.getCodigo_setor());
			System.out.println("Nome do setor: " + se.getNomesetor());
			System.out.println("Sigla do setor: " + se.getSiglasetor());
			System.out.println("Andar do setor: " + se.getAndarsetor());
			System.out.println("Codigo do bairro: " + se.getBairro());
			System.out.println("Codigo da secretaria: " + se.getSecretaria().getCodigo_secretaria());
			System.out.println("");
		}

	}

	@Test
	@Ignore
	public void excluir() throws SQLException {

		Setor se = new Setor();
		se.setCodigo_setor(7);

		SetorDAO sedao = new SetorDAO();
		sedao.deletar(se);

	}

	@Test
	@Ignore
	public void editar() throws SQLException {

		// METODO PARA EDITAR
		Setor se = new Setor();
		se.setCodigo_setor(8);
		se.setNomesetor("Compras");
		se.setSiglasetor("ADCRP");
		se.setAndarsetor("4");
		
		Secretaria s = new Secretaria();
		s.setCodigo_secretaria(4);
		se.setSecretaria(s);
		
		SetorDAO sedao = new SetorDAO();
		sedao.editar(se);
		
	}

}
