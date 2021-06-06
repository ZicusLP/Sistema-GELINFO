package br.com.gelinfo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.gelinfo.conexao.ConexaoFactory;
import br.com.gelinfo.domain.Equipamento;


public class EquipamentoDAO {

	//METODO PARA INSERIR
		public void inserir(Equipamento e) throws SQLException {
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO equipamento (patrimonio, npatrimonio, nserie, codigo_tipo_equipamento, modelo_codigo, modelo_marca) VALUES (?,?,?,?,?,?) ");
		
			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			comando.setString(1, e.getPatrimonio());
			comando.setString(2, e.getNpatrimonio());
			comando.setString(3, e.getNserie());
			comando.setInt(4, e.getT_equipamento().getCodigo_tipo_equipamento());
			comando.setInt(5, e.getModelo().getCodigo_modelo());
			comando.setInt(6, e.getModelo().getMarca_codigo());
			comando.executeUpdate();
				
		}
		
		// METODO PARA DELETAR
		public void deletar(Equipamento e) throws SQLException {
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM equipamento WHERE codigo_equipamento = ?");

			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			
			comando.setInt(1, e.getCodigo_equipamento());

			comando.executeUpdate();
		}
	
		// METODO PARA EDITAR
		public void editar(Equipamento e) throws SQLException {
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE equipamento SET patrimonio = ? , npatrimonio = ?, nserie = ?, codigo_tipo_equipamento = ?, modelo_codigo = ?, modelo_marca = ? WHERE codigo_equipamento= ?");

			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement comando = conexao.prepareStatement(sql.toString());

			comando.setString(1, e.getPatrimonio());
			comando.setString(2, e.getNpatrimonio());
			comando.setString(3, e.getNserie());
			comando.setInt(4, e.getT_equipamento().getCodigo_tipo_equipamento());
			comando.setInt(5, e.getModelo().getCodigo_modelo());
			comando.setInt(6, e.getModelo().getMarca_codigo());
			comando.executeUpdate();
		}
}
