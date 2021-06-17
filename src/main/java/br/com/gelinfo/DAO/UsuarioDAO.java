package br.com.gelinfo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.gelinfo.conexao.ConexaoFactory;
import br.com.gelinfo.domain.Perfil;

import br.com.gelinfo.domain.Usuario;

public class UsuarioDAO {

	// METODO PARA INSERIR
	public void inserir(Usuario u) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO usuario (nome,login,senha,telefone,perfil) VALUES (?,?,?,?,?) ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, u.getNome());
		comando.setString(2, u.getLogin());
		comando.setString(3, u.getSenha());
		comando.setInt(4, u.getTelefone());
		comando.setString(5, u.getPerfil());

		comando.executeUpdate();

	}

	// METODO PARA DELETAR
	public void deletar(Usuario u) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM usuario WHERE nome = ?");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, u.getNome());
		
		
		comando.executeUpdate();
	}

	// METODO PARA EDITAR
	public void editar(Usuario u) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE usuario SET nome = ?, login =?, telefone = ?, perfil = ? WHERE codigo_usuario = ?");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, u.getNome());
		comando.setString(3, u.getLogin());
		comando.setInt(4, u.getTelefone());
		comando.setString(5, u.getPerfil());
		
		comando.setInt(5, u.getCodigo_usuario());

		ResultSet resultado = comando.executeQuery();
		Usuario retorno = null;

		if (resultado.next()) {
			retorno = new Usuario();
			retorno.setCodigo_usuario(resultado.getInt("codigo_usuario"));
		}

		comando.executeUpdate();
	}

	// METODO PARA BUSCAR PELO ID
	public Usuario buscaPorCodigo(Usuario u) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM usuario WHERE codigo_usuario = ?");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setInt(1, u.getCodigo_usuario());

		ResultSet resultado = comando.executeQuery();
		Usuario retorno = null;

		if (resultado.next()) {
			retorno = new Usuario();
			retorno.setCodigo_usuario(resultado.getInt("codigo_usuario"));
			retorno.setNome(resultado.getString("nome"));

		}

		return retorno;

	}

	// METODO PARA BUSCAR POR UMA LISTA ESPECIFICA
	public ArrayList<Usuario> buscaPorDescricao(Usuario u) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM usuario WHERE nome LIKE  ? ORDER BY nome ASC");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, "%" + u.getNome() + "%");

		ResultSet resultado = comando.executeQuery();

		ArrayList<Usuario> lista = new ArrayList<Usuario>();

		while (resultado.next()) {
			Usuario item = new Usuario();
			item.setCodigo_usuario(resultado.getInt("codigo_usuario"));
			item.setNome(resultado.getString("nome"));
			item.setLogin(resultado.getString("login"));
			item.setTelefone(resultado.getInt("telefone"));
			
			

			lista.add(item);
		}

		return lista;
	}

	// METODO PARA BUSCAR POR UMA LISTA
	public ArrayList<Usuario> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM usuario");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Usuario> lista = new ArrayList<Usuario>();

		while (resultado.next()) {
			
			Usuario u = new Usuario();
			u.setCodigo_usuario(resultado.getInt("codigo_usuario"));
			u.setNome(resultado.getString("nome"));
			u.setLogin(resultado.getString("login"));
			u.setTelefone(resultado.getInt("telefone"));
			u.setPerfil(resultado.getString("perfil"));
			
			Perfil p = new Perfil();
			p.setCodigo_perfil(resultado.getInt("codigo_perfil"));
			p.setFuncao(resultado.getString("funcao"));
					
			lista.add(u);
		}

		return lista;

	}
	
	public Usuario autenticacao(Usuario u) {
		Usuario ureturn = null;
		String sql = "select * usuario where login = ? and senha = ?";
		
		try {
			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			
			comando.setString(1, u.getLogin());
			comando.setString(2, u.getSenha());
			
			ResultSet resultado = comando.executeQuery();
			comando.close();
			
			if(resultado.next()) {
				ureturn = new Usuario();
				
				ureturn.setCodigo_usuario(resultado.getInt("codigo_usuario"));
				ureturn.setNome(resultado.getString("nome"));
				ureturn.setLogin(resultado.getString("login"));
				ureturn.setSenha(resultado.getString("senha"));
				ureturn.setTelefone(resultado.getInt("telefone"));
				
				Perfil p = new Perfil();
				p.setCodigo_perfil(resultado.getInt("codigo_perfil"));
				p.setFuncao(resultado.getString("funcao"));

			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ureturn;
	}
	
	public static void main(String[] args) {
		//METODO PARA BUSCAR POR UMA LISTA
		UsuarioDAO udao = new UsuarioDAO();
		Usuario u1 = new Usuario();
		u1.setNome("p");
		
		
try {
	
	ArrayList<Usuario>lista = udao.buscaPorDescricao(u1);
	
	for (Usuario u : lista) {
	System.out.println("RESULTADO: " + u );
	}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar!!");
			e.printStackTrace();
		}
	}
	
}
