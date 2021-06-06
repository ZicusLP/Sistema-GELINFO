package br.com.gelinfo.teste;

import java.sql.SQLException;

import org.junit.Test;

import br.com.gelinfo.DAO.SecretariaDAO;
import br.com.gelinfo.domain.Secretaria;


public class SecretariaDAOTeste {

	@Test	
	public void inserir() throws SQLException {
	//METODO PARA INSERIR
	Secretaria s1 = new Secretaria();
	s1.setNomesec("Secretaria Municipal de Urbanismo");
	s1.setSiglasec("SMU");
	
	
	
	
	SecretariaDAO sdao = new SecretariaDAO();
	sdao.inserir(s1);
	}
}
