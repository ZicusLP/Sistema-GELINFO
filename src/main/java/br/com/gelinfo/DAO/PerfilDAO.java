package br.com.gelinfo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.gelinfo.conexao.ConexaoFactory;
import br.com.gelinfo.domain.Perfil;

public class PerfilDAO {

	//METODO PARA INSERIR
		public void inserir(Perfil p) throws SQLException {
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO perfil (funcao) VALUES (?) ");
			

			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			comando.setString(1, p.getFuncao());
			comando.executeUpdate();			
		}
		
		//METODO PARA DELETAR
			public void deletar (Perfil p) throws SQLException{
				StringBuilder sql = new StringBuilder();
				sql.append("DELETE FROM perfil WHERE funcao= ?");
			
				
				Connection conexao = ConexaoFactory.conectar();

				PreparedStatement comando = conexao.prepareStatement(sql.toString());
				comando.setString(1, p.getFuncao());
				
				comando.executeUpdate();
			}

			
			//METODO PARA EDITAR
			public void editar(Perfil p) throws SQLException{
				StringBuilder sql = new StringBuilder();
				sql.append("UPDATE perfil SET funcao = ?  WHERE codigo_perfil = ?");
			
				
				Connection conexao = ConexaoFactory.conectar();

				PreparedStatement comando = conexao.prepareStatement(sql.toString());
				
				comando.setString(1, p.getFuncao());
				comando.setInt(2, p.getCodigo_perfil());
				comando.executeUpdate();
			}	
			
			//METODO PARA BUSCAR PELO ID
			public Perfil buscaPorCodigo (Perfil p) throws SQLException{
				StringBuilder sql = new StringBuilder();
				sql.append("SELECT * FROM perfil WHERE codigo_perfil = ?");
			
				
				Connection conexao = ConexaoFactory.conectar();

				PreparedStatement comando = conexao.prepareStatement(sql.toString());
				
				comando.setInt(1, p.getCodigo_perfil());
				
				ResultSet resultado = comando.executeQuery();
				Perfil retorno = null;
				
				if(resultado.next()) {
					retorno = new Perfil();
					retorno.setCodigo_perfil(resultado.getInt("codigo_perfil"));
					retorno.setFuncao(resultado.getString("funcao"));
				}
				
				return retorno;
				
			}
			
			
			//METODO PARA BUSCAR POR UMA LISTA ESPECIFICA
			public ArrayList<Perfil>buscaPorDescricao(Perfil p) throws SQLException{
				
				StringBuilder sql = new StringBuilder();
				sql.append("SELECT * FROM perfil WHERE funcao LIKE  ? ORDER BY funcao ASC");
				
				Connection conexao = ConexaoFactory.conectar();

				PreparedStatement comando = conexao.prepareStatement(sql.toString());
				
				comando.setString(1, "%" + p.getFuncao() + "%");
				

				ResultSet resultado = comando.executeQuery();
				
				ArrayList<Perfil>lista = new ArrayList<Perfil>();
				
				while(resultado.next()) {
					Perfil item = new Perfil();
					item.setCodigo_perfil(resultado.getInt("codigo_perfil"));
					item.setFuncao(resultado.getString("funcao"));
					
					lista.add(item);
				}
				
				return lista;
			}
			
			
			//METODO PARA BUSCAR POR UMA LISTA
			public ArrayList<Perfil> listar() throws SQLException{
				StringBuilder sql = new StringBuilder();
				sql.append("SELECT * FROM perfil ORDER BY funcao ASC");
					
						
						Connection conexao = ConexaoFactory.conectar();

						PreparedStatement comando = conexao.prepareStatement(sql.toString());
						
						
						ResultSet resultado = comando.executeQuery();
						
						ArrayList<Perfil>lista = new ArrayList<Perfil>();
						
						while(resultado.next()) {
							Perfil p = new Perfil();
							p.setCodigo_perfil(resultado.getInt("codigo_perfil"));
							p.setFuncao(resultado.getString("funcao"));
							lista.add(p);
						}
						
						return lista;
			}
}
