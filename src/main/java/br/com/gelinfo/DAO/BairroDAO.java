package br.com.gelinfo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.gelinfo.conexao.ConexaoFactory;
import br.com.gelinfo.domain.Bairro;


public class BairroDAO {
	// METODO PARA INSERIR
		public void inserir(Bairro b) throws SQLException {
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO bairro (nomebairro,endereco) VALUES (?,?) ");

			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			comando.setString(1, b.getNomebairro());
			comando.setString(2, b.getEndereco());
			comando.executeUpdate();

		}

		// METODO PARA DELETAR
		public void deletar(Bairro b) throws SQLException {
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM bairro WHERE codigo_bairro = ?");

			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			
			comando.setInt(1, b.getCodigo_bairro());

			comando.executeUpdate();
		}

		// METODO PARA EDITAR
		public void editar(Bairro b) throws SQLException {
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE bairro SET nomebairro = ? , endereco = ? WHERE codigo_bairro = ?");

			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement comando = conexao.prepareStatement(sql.toString());

			comando.setString(1, b.getNomebairro());
			comando.setString(2, b.getEndereco());
			comando.setInt(3, b.getCodigo_bairro());
			comando.executeUpdate();
		}

		// METODO PARA BUSCAR PELO ID
		public Bairro buscaPorCodigo(Bairro b) throws SQLException {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM bairro WHERE codigo_bairro = ?");

			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement comando = conexao.prepareStatement(sql.toString());

			comando.setInt(1, b.getCodigo_bairro());

			ResultSet resultado = comando.executeQuery();
			Bairro retorno = null;

			if (resultado.next()) {
				retorno = new Bairro();
				retorno.setCodigo_bairro(resultado.getInt("codigo_bairro"));
				retorno.setNomebairro(resultado.getString("nomebairro"));
				retorno.setEndereco(resultado.getString("endereco"));

			}

			return retorno;

		}

		// METODO PARA BUSCAR POR UMA LISTA ESPECIFICA
		public ArrayList<Bairro> buscaPorDescricao(Bairro b) throws SQLException {

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM bairro WHERE nomebairro LIKE  ? ORDER BY nomebairro ASC");

			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement comando = conexao.prepareStatement(sql.toString());

			comando.setString(1, "%" + b.getNomebairro() + "%");

			ResultSet resultado = comando.executeQuery();

			ArrayList<Bairro> lista = new ArrayList<Bairro>();

			while (resultado.next()) {
				Bairro  item = new Bairro();
				b.setCodigo_bairro(resultado.getInt("codigo_bairro"));
				b.setNomebairro(resultado.getString("nomebairro"));
				b.setEndereco(resultado.getString("endereco"));

				lista.add(item);
			}

			return lista;
		}

		// METODO PARA BUSCAR POR UMA LISTA
		public ArrayList<Bairro> listar() throws SQLException {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM bairro");

			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement comando = conexao.prepareStatement(sql.toString());

			ResultSet resultado = comando.executeQuery();

			ArrayList<Bairro> lista = new ArrayList<Bairro>();

			while (resultado.next()) {
			
				
				Bairro b = new Bairro();
				b.setCodigo_bairro(resultado.getInt("codigo_bairro"));
				b.setNomebairro(resultado.getString("nomebairro"));
				b.setEndereco(resultado.getString("endereco"));

				lista.add(b);
			}

			return lista;
		}
		
		public static void main(String[] args) {
			//METODO PARA BUSCAR POR UMA LISTA
			BairroDAO bdao = new BairroDAO();
			Bairro b1  = new Bairro();
			b1.setNomebairro("S");
			
			
	try {
		
		ArrayList<Bairro>lista = bdao.buscaPorDescricao(b1);
		
		for (Bairro b  : lista) {
		System.out.println("RESULTADO: " + b );
		}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Erro ao buscar!!");
				e.printStackTrace();
			}
		}

}
