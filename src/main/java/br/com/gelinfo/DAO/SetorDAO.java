package br.com.gelinfo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.gelinfo.conexao.ConexaoFactory;
import br.com.gelinfo.domain.Bairro;
import br.com.gelinfo.domain.Secretaria;
import br.com.gelinfo.domain.Setor;

public class SetorDAO {
	// METODO PARA INSERIR
	public void inserir(Setor se) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO setor (nomesetor,siglasetor,andarsetor, codigo_secretaria, codigo_bairro) VALUES (?,?,?,?,?) ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, se.getNomesetor());
		comando.setString(2, se.getSiglasetor());
		comando.setString(3, se.getAndarsetor());
		comando.setInt(4, se.getSecretaria().getCodigo_secretaria());
		comando.setInt(5, se.getBairro().getCodigo_bairro());
		comando.executeUpdate();

	}

	// METODO PARA DELETAR
	public void deletar(Setor se) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM setor WHERE codigo_setor = ?");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setInt(1, se.getCodigo_setor());

		comando.executeUpdate();
	}

	// METODO PARA EDITAR
	public void editar(Setor se) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE setor SET nomesetor = ? , siglasetor = ?, andarsetor = ?, secretaria_codigo_secretaria = ? WHERE codigo_setor = ?");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, se.getNomesetor());
		comando.setString(2, se.getSiglasetor());
		comando.setString(3, se.getAndarsetor());
		comando.setInt(4, se.getSecretaria().getCodigo_secretaria());
		comando.setInt(5, se.getCodigo_setor());
		comando.executeUpdate();
	}

	// METODO PARA BUSCAR PELO ID
	public Setor buscaPorCodigo(Setor se) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM setor WHERE codigo_setor = ?");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setInt(1, se.getCodigo_setor());

		ResultSet resultado = comando.executeQuery();
		Setor retorno = null;

		if (resultado.next()) {
			retorno = new Setor();
			retorno.setCodigo_setor(resultado.getInt("codigo_setor"));
			retorno.setNomesetor(resultado.getString("nomesetor"));
			retorno.setSiglasetor(resultado.getString("siglasetor"));

		}

		return retorno;

	}

	// METODO PARA BUSCAR POR UMA LISTA ESPECIFICA
	public ArrayList<Setor> buscaPorDescricao(Setor se) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM setor WHERE nomesec LIKE  ? ORDER BY nomesetor ASC");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, "%" + se.getNomesetor() + "%");

		ResultSet resultado = comando.executeQuery();

		ArrayList<Setor> lista = new ArrayList<Setor>();

		while (resultado.next()) {
			Setor item = new Setor();
			item.setCodigo_setor(resultado.getInt("codigo_setor"));
			item.setNomesetor(resultado.getString("nomesetor"));
			item.setSiglasetor(resultado.getString("siglasetor"));

			lista.add(item);
		}

		return lista;
	}

	// METODO PARA BUSCAR POR UMA LISTA
	public ArrayList<Setor> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM setor ");
		sql.append("INNER JOIN secretaria ON secretaria.codigo_secretaria = setor.codigo_setor  ");
		sql.append("INNER JOIN bairro ON bairro.codigo_bairro = setor.codigo_setor");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Setor> lista = new ArrayList<Setor>();

		while (resultado.next()) {
			Secretaria s = new Secretaria();
			s.setCodigo_secretaria(resultado.getInt("codigo_secretaria"));
			s.setNomesec(resultado.getString("nomesec"));
			s.setSiglasec(resultado.getString("siglasec"));
			
			Bairro b = new Bairro();
			b.setCodigo_bairro(resultado.getInt("codigo_bairro"));
			b.setNomebairro(resultado.getString("nomebairro"));
			b.setEndereco(resultado.getString("endereco"));

			Setor se = new Setor();
			se.setCodigo_setor(resultado.getInt("codigo_setor"));
			se.setNomesetor(resultado.getString("nomesetor"));
			se.setSiglasetor(resultado.getString("siglasetor"));
			se.setAndarsetor(resultado.getString("andarsetor"));
			se.setSecretaria(s);
			
			lista.add(se);
		}

		return lista;
	}
	
	public static void main(String[] args) {
		//METODO PARA BUSCAR POR UMA LISTA
		SetorDAO sdao = new SetorDAO();
		Setor s1 = new Setor();
		s1.setNomesetor("S");
		
		
try {
	
	ArrayList<Setor>lista = sdao.buscaPorDescricao(s1);
	
	for (Setor s : lista) {
	System.out.println("RESULTADO: " + s );
	}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar!!");
			e.printStackTrace();
		}
	}
}
