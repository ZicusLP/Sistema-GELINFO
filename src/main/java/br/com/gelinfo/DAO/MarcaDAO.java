package br.com.gelinfo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.gelinfo.conexao.ConexaoFactory;
import br.com.gelinfo.domain.Marca;


public class MarcaDAO {

	//METODO PARA INSERIR
	public void inserir(Marca m) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO marca (nomemarca) VALUES (?) ");
		

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, m.getNomemarca());
		comando.executeUpdate();			
	}
	
	//METODO PARA DELETAR
		public void deletar (Marca m) throws SQLException{
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM marca WHERE nomemarca = ?");
		
			
			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			comando.setString(1, m.getNomemarca());
			
			comando.executeUpdate();
		}

		
		//METODO PARA EDITAR
		public void editar(Marca m) throws SQLException{
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE marca SET nomemarca = ?  WHERE codigo_marca = ?");
		
			
			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			
			comando.setString(1, m.getNomemarca());
			comando.setInt(2, m.getCodigo_marca());
			comando.executeUpdate();
		}	
		
		//METODO PARA BUSCAR PELO ID
		public Marca buscaPorCodigo (Marca m) throws SQLException{
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM marca WHERE codigo_marca = ?");
		
			
			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			
			comando.setInt(1, m.getCodigo_marca());
			
			ResultSet resultado = comando.executeQuery();
			Marca retorno = null;
			
			if(resultado.next()) {
				retorno = new Marca();
				retorno.setCodigo_marca(resultado.getInt("codigo_marca"));
				retorno.setNomemarca(resultado.getString("nomemarca"));
			}
			
			return retorno;
			
		}
		
		
		//METODO PARA BUSCAR POR UMA LISTA ESPECIFICA
		public ArrayList<Marca>buscaPorDescricao(Marca m) throws SQLException{
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM marca WHERE nomemarca LIKE  ? ORDER BY nomemarca ASC");
			
			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			
			comando.setString(1, "%" + m.getNomemarca() + "%");
			

			ResultSet resultado = comando.executeQuery();
			
			ArrayList<Marca>lista = new ArrayList<Marca>();
			
			while(resultado.next()) {
				Marca item = new Marca();
				item.setCodigo_marca(resultado.getInt("codigo_marca"));
				item.setNomemarca(resultado.getString("nomemarca"));
				
				lista.add(item);
			}
			
			return lista;
		}
		
		
		//METODO PARA BUSCAR POR UMA LISTA
		public ArrayList<Marca> listar() throws SQLException{
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM marca ORDER BY nomemarca ASC");
				
					
					Connection conexao = ConexaoFactory.conectar();

					PreparedStatement comando = conexao.prepareStatement(sql.toString());
					
					
					ResultSet resultado = comando.executeQuery();
					
					ArrayList<Marca>lista = new ArrayList<Marca>();
					
					while(resultado.next()) {
						Marca m = new Marca();
						m.setCodigo_marca(resultado.getInt("codigo_marca"));
						m.setNomemarca(resultado.getString("nomemarca"));
						lista.add(m);
					}
					
					return lista;
		}
}
