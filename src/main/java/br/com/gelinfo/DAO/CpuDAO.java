package br.com.gelinfo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.gelinfo.conexao.ConexaoFactory;
import br.com.gelinfo.domain.Cpu;
import br.com.gelinfo.domain.Setor;

public class CpuDAO {
	
	// METODO PARA INSERIR
		public void inserir(Cpu c) throws SQLException {
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO cpu (equipamento_codigo,tipo_equipamento_codigo,modelo_codigo, modelo_marca, ipcpu) VALUES (?,?,?,?,?) ");

			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			comando.setInt(1, c.getEquipamento().getCodigo_equipamento());
			comando.setInt(2, c.getTipo_equipamento().getCodigo_tipo_equipamento());
			comando.setInt(3, c.getModelos().getCodigo_modelo());
			comando.setInt(4, c.getMarcas().getCodigo_marca());
			comando.setInt(5, c.getIpcpu());
			
			comando.executeUpdate();

		}

		// METODO PARA DELETAR
		public void deletar(Cpu c) throws SQLException {
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM cpu WHERE codigo_cpu = ?");

			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			
			comando.setInt(1, c.getCodigo_cpu());

			comando.executeUpdate();
		}
		
		// METODO PARA EDITAR
		public void editar(Cpu c) throws SQLException {
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE cpu SET equipamento_codigo = ?,tipo_equipamento_codigo = ?,modelo_codigo = ?, modelo_marca = ?, ipcpu = ? WHERE codigo_cpu = ?");

			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement comando = conexao.prepareStatement(sql.toString());

			comando.setInt(1, c.getEquipamento().getCodigo_equipamento());
			comando.setInt(2, c.getTipo_equipamento().getCodigo_tipo_equipamento());
			comando.setInt(3, c.getModelos().getCodigo_modelo());
			comando.setInt(4, c.getMarcas().getCodigo_marca());
			comando.setInt(5, c.getEquipamento().getCodigo_equipamento());
			comando.executeUpdate();
		}
		
		// METODO PARA BUSCAR PELO ID
		public Cpu buscaPorCodigo(Cpu c) throws SQLException {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM cpu WHERE codigo_cpu = ?");

			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement comando = conexao.prepareStatement(sql.toString());

			comando.setInt(1, c.getCodigo_cpu());

			ResultSet resultado = comando.executeQuery();
			Cpu retorno = null;

			if (resultado.next()) {
				retorno = new Cpu();
				retorno.setCodigo_cpu(resultado.getInt("codigo_cpu"));
				

			}

			return retorno;

		}
		
		// METODO PARA BUSCAR POR UMA LISTA ESPECIFICA
		public ArrayList<Cpu> buscaPorDescricao(Cpu c) throws SQLException {

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM cpu WHERE codigo_cpu LIKE  ? ORDER BY codigo_cpu ASC");

			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement comando = conexao.prepareStatement(sql.toString());

			comando.setString(1, "%" + c.getCodigo_cpu() + "%");

			ResultSet resultado = comando.executeQuery();

			ArrayList<Cpu> lista = new ArrayList<Cpu>();

			while (resultado.next()) {
				Cpu item = new Cpu();
				item.setCodigo_cpu(resultado.getInt("codigo_setor"));
				item.setIpcpu(resultado.getInt("ipcpu"));
		

				lista.add(item);
			}

			return lista;
		}

		public ArrayList<Cpu> listar() {
			// TODO Auto-generated method stub
			return null;
		}
}
