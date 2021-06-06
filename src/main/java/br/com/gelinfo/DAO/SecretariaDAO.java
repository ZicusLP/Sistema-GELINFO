package br.com.gelinfo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.gelinfo.conexao.ConexaoFactory;
import br.com.gelinfo.domain.Secretaria;

public class SecretariaDAO {
	
	//METODO PARA INSERIR
	public void inserir(Secretaria s) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO secretaria (nomesec,siglasec) VALUES (?,?) ");
	
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, s.getNomesec());
		comando.setString(2, s.getSiglasec());
		comando.executeUpdate();
			
	}
	
	//METODO PARA DELETAR
	public void deletar (Secretaria s) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM secretaria WHERE nomesec = ?");
	
		
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		//comando.setInt(1, s.getIdsecretaria());
		comando.setString(1, s.getNomesec());
		
		comando.executeUpdate();
	}
	
	//METODO PARA EDITAR
	public void editar(Secretaria s) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE secretaria SET nomesec = ? , siglasec = ? WHERE codigo_secretaria = ?");
	
		
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setString(1, s.getNomesec());
		comando.setString(2, s.getSiglasec());
		comando.setInt(3, s.getCodigo_secretaria());
		
		
		
		comando.executeUpdate();
	}
	
	//METODO PARA BUSCAR PELO ID
	public Secretaria buscaPorCodigo (Secretaria s) throws SQLException{
		StringBuilder sql = new StringBuilder();
sql.append("SELECT * FROM secretaria WHERE codigo_secretaria = ?");
	
		
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setInt(1, s.getCodigo_secretaria());
		
		ResultSet resultado = comando.executeQuery();
		Secretaria retorno = null;
		
		if(resultado.next()) {
			retorno = new Secretaria();
			retorno.setCodigo_secretaria(resultado.getInt("codigo_secretaria"));
			retorno.setNomesec(resultado.getString("nomesec"));
			retorno.setSiglasec(resultado.getString("siglasec"));
			
		}
		
		return retorno;
		
	}
	
	//METODO PARA BUSCAR POR UMA LISTA ESPECIFICA
	public ArrayList<Secretaria>buscaPorDescricao(Secretaria s) throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM secretaria WHERE nomesec LIKE  ? ORDER BY nomesec ASC");
		
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setString(1, "%" + s.getNomesec() + "%");
		

		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Secretaria>lista = new ArrayList<Secretaria>();
		
		while(resultado.next()) {
			Secretaria item = new Secretaria();
			item.setCodigo_secretaria(resultado.getInt("codigo_secretaria"));
			item.setNomesec(resultado.getString("nomesec"));
			item.setSiglasec(resultado.getString("siglasec"));
			
			lista.add(item);
		}
		
		return lista;
	}
	
	//METODO PARA BUSCAR POR UMA LISTA
	public ArrayList<Secretaria> listar() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM secretaria ORDER BY nomesec ASC");
			
				
				Connection conexao = ConexaoFactory.conectar();

				PreparedStatement comando = conexao.prepareStatement(sql.toString());
				
				
				ResultSet resultado = comando.executeQuery();
				
				ArrayList<Secretaria>lista = new ArrayList<Secretaria>();
				
				while(resultado.next()) {
					Secretaria s = new Secretaria();
					s.setCodigo_secretaria(resultado.getInt("codigo_secretaria"));
					s.setNomesec(resultado.getString("nomesec"));
					s.setSiglasec(resultado.getString("siglasec"));
					
					lista.add(s);
				}
				
				return lista;
	}

	public static void main(String[] args) {
		/*Secretaria s1 = new Secretaria();
		s1.setNomesec("EXECUTIVO");
		s1.setSiglasec("SEXEC");
		
		Secretaria s2 = new Secretaria();
		s2.setNomesec("FAZENDA");
		s2.setSiglasec("SMF");
		
		Secretaria s3 = new Secretaria();
		s3.setNomesec("CONSERVAÇÃO");
		s3.setSiglasec("SECONSER");
		
		Secretaria s4 = new Secretaria();
		s1.setNomesec("CONTROLADORIA");
		s1.setSiglasec("CGM");
		
		Secretaria s5 = new Secretaria();
		s2.setNomesec("PROCURADORIA");
		s2.setSiglasec("PGM");
		
		Secretaria s6 = new Secretaria();
		s3.setNomesec("MEIO AMBIENTE");
		s3.setSiglasec("SMARHRS");
		
		Secretaria s7 = new Secretaria();
		s1.setNomesec("CONTROLADORIA2");
		s1.setSiglasec("CGM2");
		
		Secretaria s8 = new Secretaria();
		s2.setNomesec("PROCURADORIA2");
		s2.setSiglasec("PGM2");
	
		Secretaria s9 = new Secretaria();
		s3.setNomesec("MEIO AMBIENTE2");
		s3.setSiglasec("SMARHRS2");
		
		//METODO PARA INSERIR
		SecretariaDAO sdao = new SecretariaDAO();
		try {
			sdao.inserir(s1);
			sdao.inserir(s2);
			sdao.inserir(s3);
			sdao.inserir(s4);
			sdao.inserir(s5);
			sdao.inserir(s6);
			System.out.println("Salvo com sucesso!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao salvar!!");
			e.printStackTrace();
		}
		
		/*Secretaria s1 = new Secretaria();
		//s1.setIdsecretaria(1);;
		s1.setNomesec("URBANISMO");
		
		//METODO PARA DELETAR
		SecretariaDAO sdao = new SecretariaDAO();
		try {
			sdao.deletar(s1);
			System.out.println("Deletado com sucesso!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao deletar!!");
			e.printStackTrace();
		}*/
		
		/*Secretaria s1 = new Secretaria();
		s1.setIdsecretaria(4);
		s1.setNomesec("SECRETARIA MUNICIPAL DE URBANISMO");
		s1.setSiglasec("SMU");
		
		//METODO PARA EDITAR
		SecretariaDAO sdao = new SecretariaDAO();
		try {
			sdao.editar(s1);
			System.out.println("Alterado com sucesso!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao alterar!!");
			e.printStackTrace();
		}*/
		
		/*
		Secretaria s1 = new Secretaria();
		s1.setIdsecretaria(4);
		Secretaria s2 = new Secretaria();
		s2.setIdsecretaria(5);
		
		//METODO PARA BUSCAR PELO ID
		SecretariaDAO sdao = new SecretariaDAO();
		
		try {
			
			Secretaria s3 = sdao.buscaPorCodigo(s1);
			Secretaria s4 = sdao.buscaPorCodigo(s2);
			
			System.out.println("RESULTADO: " + s3);
			System.out.println("RESULTADO: " + s4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao buscar!!");
			e.printStackTrace();
		}*/
		
		//METODO PARA BUSCAR POR UMA LISTA ESPECIFICA
		/*SecretariaDAO sdao = new SecretariaDAO();
		
try {
	
	ArrayList<Secretaria>lista = sdao.listar();
	
	for (Secretaria s : lista) {
	System.out.println("RESULTADO: " + s );
	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao buscar!!");
			e.printStackTrace();
		}*/
		
		
		//METODO PARA BUSCAR POR UMA LISTA
		SecretariaDAO sdao = new SecretariaDAO();
		Secretaria s1 = new Secretaria();
		s1.setNomesec("S");
		
		
try {
	
	ArrayList<Secretaria>lista = sdao.buscaPorDescricao(s1);
	
	for (Secretaria s : lista) {
	System.out.println("RESULTADO: " + s );
	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao buscar!!");
			e.printStackTrace();
		}
	}
				
}
