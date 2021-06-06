package br.com.gelinfo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.gelinfo.conexao.ConexaoFactory;
import br.com.gelinfo.domain.Marca;
import br.com.gelinfo.domain.Modelo;


public class ModeloDAO {
	
	// METODO PARA INSERIR
		public void inserir(Modelo md) throws SQLException {
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO modelo (nomemodelo, marca_codigo) VALUES (?,?) ");

			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			comando.setString(1, md.getNomemodelo());
			comando.setInt(2, md.getMarcas().getCodigo_marca());
			
			comando.executeUpdate();

		}

		
		// METODO PARA DELETAR
		public void deletar(Modelo md) throws SQLException {
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM modelo WHERE codigo_modelo = ?");

			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			
			comando.setInt(1, md.getCodigo_modelo());

			comando.executeUpdate();
		}

		
		// METODO PARA EDITAR
		public void editar(Modelo md) throws SQLException {
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE modelo SET nomemodelo = ? , marca_codigo_marca = ? WHERE codigo_modelo = ?");

			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement comando = conexao.prepareStatement(sql.toString());

			comando.setString(1, md.getNomemodelo());
			comando.setInt(2, md.getMarcas().getCodigo_marca());
			comando.setInt(3, md.getCodigo_modelo());
			comando.executeUpdate();
		}
		
		// METODO PARA BUSCAR PELO ID
		public Modelo buscaPorCodigo(Modelo md) throws SQLException {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM modleo WHERE codigo_modelo = ?");

			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement comando = conexao.prepareStatement(sql.toString());

			comando.setInt(1, md.getCodigo_modelo());

			ResultSet resultado = comando.executeQuery();
			Modelo retorno = null;

			if (resultado.next()) {
				retorno = new Modelo();
				retorno.setCodigo_modelo(resultado.getInt("codigo_modelo"));
				retorno.setNomemodelo(resultado.getString("nomemodelo"));
				
			}

			return retorno;

		}
		
		// METODO PARA BUSCAR POR UMA LISTA ESPECIFICA
		public ArrayList<Modelo> buscaPorDescricao(Modelo md) throws SQLException {

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM modelo WHERE nomemodelo LIKE  ? ORDER BY nomemodelo ASC");

			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement comando = conexao.prepareStatement(sql.toString());

			comando.setString(1, "%" + md.getNomemodelo() + "%");

			ResultSet resultado = comando.executeQuery();

			ArrayList<Modelo> lista = new ArrayList<Modelo>();

			while (resultado.next()) {
				Modelo item = new Modelo();
				item.setCodigo_modelo(resultado.getInt("codigo_modelo"));
				item.setNomemodelo(resultado.getString("nomemodelo"));
				lista.add(item);
			}

			return lista;
		}
		
		// METODO PARA BUSCAR POR UMA LISTA
		public ArrayList<Modelo> listar() throws SQLException {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM modelo ");
			sql.append("INNER JOIN marca ON codigo_marca= marca_codigo ");
			
			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement comando = conexao.prepareStatement(sql.toString());

			ResultSet resultado = comando.executeQuery();

			ArrayList<Modelo> lista = new ArrayList<Modelo>();

			while (resultado.next()) {
				Marca m = new Marca();
				m.setCodigo_marca(resultado.getInt("codigo_marca"));
				m.setNomemarca(resultado.getString("nomemarca"));
				
				Modelo md = new Modelo();
				md.setCodigo_modelo(resultado.getInt("codigo_modelo"));
				md.setNomemodelo(resultado.getString("nomemodelo"));
				md.setMarcas(m);
				
				lista.add(md);
			}

			return lista;
		}
}
