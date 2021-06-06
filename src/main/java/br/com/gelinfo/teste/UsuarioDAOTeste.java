package br.com.gelinfo.teste;

import java.sql.SQLException;

import org.junit.Test;


import br.com.gelinfo.DAO.UsuarioDAO;
import br.com.gelinfo.domain.Perfil;

import br.com.gelinfo.domain.Usuario;

public class UsuarioDAOTeste {
	
	@Test
	//@Ignore
	public void inserir() throws SQLException {
		// METODO PARA INSERIR
		Usuario s1 = new Usuario();
		s1.setNome("Lucas");
		s1.setLogin("lucas.santos");
		s1.setSenha("1234");
		s1.setTelefone(123456789);

		Perfil s = new Perfil();
		s.setCodigo_perfil(1);
		s1.setPerfil(s);

		

		UsuarioDAO sdao = new UsuarioDAO();
		sdao.inserir(s1);
	}

}
