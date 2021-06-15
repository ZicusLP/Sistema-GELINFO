package br.com.gelinfo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.gelinfo.conexao.ConexaoFactory;
import br.com.gelinfo.domain.Tequipamento;

public class TequipamentoDAO {
	
	//METODO PARA INSERIR
			public void inserir(Tequipamento t) throws SQLException {
				StringBuilder sql = new StringBuilder();
				sql.append("INSERT INTO tipo_equipamento (tipo_nome) VALUES (?) ");
			
				Connection conexao = ConexaoFactory.conectar();

				PreparedStatement comando = conexao.prepareStatement(sql.toString());
				comando.setString(1, t.getTipo_nome());
			
				comando.executeUpdate();
					
			}
			
			// METODO PARA DELETAR
			public void deletar(Tequipamento t) throws SQLException {
				StringBuilder sql = new StringBuilder();
				sql.append("DELETE FROM tipo_equipamento WHERE codigo_tipo = ?");

				Connection conexao = ConexaoFactory.conectar();

				PreparedStatement comando = conexao.prepareStatement(sql.toString());
				
				comando.setInt(1, t.getCodigo_tipo());

				comando.executeUpdate();
			}
		
			// METODO PARA EDITAR
			public void editar(Tequipamento t) throws SQLException {
				StringBuilder sql = new StringBuilder();
				sql.append("UPDATE tipo_equipamento SET tipo_nome = ? WHERE codigo_tipo = ? ");
				Connection conexao = ConexaoFactory.conectar();

				PreparedStatement comando = conexao.prepareStatement(sql.toString());

				comando.setString(1, t.getTipo_nome());
				
				comando.executeUpdate();
			}
			
			//METODO PARA BUSCAR PELO ID
			public Tequipamento buscaPorCodigo (Tequipamento t) throws SQLException{
				StringBuilder sql = new StringBuilder();
				sql.append("SELECT * FROM tipo_equipamento WHERE codigo_tipo = ?");
			
				
				Connection conexao = ConexaoFactory.conectar();

				PreparedStatement comando = conexao.prepareStatement(sql.toString());
				
				comando.setInt(1, t.getCodigo_tipo());
				
				ResultSet resultado = comando.executeQuery();
				Tequipamento retorno = null;
				
				if(resultado.next()) {
					retorno = new Tequipamento();
					retorno.setCodigo_tipo(resultado.getInt("codigo_tipo"));
					retorno.setTipo_nome(resultado.getString("tipo_nome"));
				}
				
				return retorno;
				
			}
			
			
			//METODO PARA BUSCAR POR UMA LISTA ESPECIFICA
			public ArrayList<Tequipamento>buscaPorDescricao(Tequipamento t) throws SQLException{
				
				StringBuilder sql = new StringBuilder();
				sql.append("SELECT * FROM tipo_equipamento WHERE tipo_nome LIKE  ? ORDER BY tipo_nome ASC");
				
				Connection conexao = ConexaoFactory.conectar();

				PreparedStatement comando = conexao.prepareStatement(sql.toString());
				
				comando.setString(1, "%" + t.getTipo_nome() + "%");
				

				ResultSet resultado = comando.executeQuery();
				
				ArrayList<Tequipamento>lista = new ArrayList<Tequipamento>();
				
				while(resultado.next()) {
					Tequipamento item = new Tequipamento();
					item.setCodigo_tipo(resultado.getInt("codigo_tipo"));
					item.setTipo_nome(resultado.getString("tipo_nome"));
					
					lista.add(item);
				}
				
				return lista;
			}
			
			
			//METODO PARA BUSCAR POR UMA LISTA
			public ArrayList<Tequipamento> listar() throws SQLException{
				StringBuilder sql = new StringBuilder();
				sql.append("SELECT * FROM tipo_equipamento ORDER BY tipo_nome ASC");
					
						
						Connection conexao = ConexaoFactory.conectar();

						PreparedStatement comando = conexao.prepareStatement(sql.toString());
						
						
						ResultSet resultado = comando.executeQuery();
						
						ArrayList<Tequipamento>lista = new ArrayList<Tequipamento>();
						
						while(resultado.next()) {
							Tequipamento t = new Tequipamento();
							t.setCodigo_tipo(resultado.getInt("codigo_tipo"));
							t.setTipo_nome(resultado.getString("tipo_nome"));
							lista.add(t);
						}
						
						return lista;
			}

}
