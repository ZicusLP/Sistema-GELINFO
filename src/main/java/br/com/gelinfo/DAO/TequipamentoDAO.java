package br.com.gelinfo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
				sql.append("DELETE FROM tipo_equipamento WHERE codigo_tipo_equipamento = ?");

				Connection conexao = ConexaoFactory.conectar();

				PreparedStatement comando = conexao.prepareStatement(sql.toString());
				
				comando.setInt(1, t.getCodigo_tipo_equipamento());

				comando.executeUpdate();
			}
		
			// METODO PARA EDITAR
			public void editar(Tequipamento t) throws SQLException {
				StringBuilder sql = new StringBuilder();
				sql.append("UPDATE equipamento SET tipo_nome = ? WHERE codigo_tipo_equipamento = ? ");
				Connection conexao = ConexaoFactory.conectar();

				PreparedStatement comando = conexao.prepareStatement(sql.toString());

				comando.setString(1, t.getTipo_nome());
				
				comando.executeUpdate();
			}

}
