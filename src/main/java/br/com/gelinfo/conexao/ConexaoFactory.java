package br.com.gelinfo.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.gelinfo.domain.Usuario;

public class ConexaoFactory {
	
private static final String USUARIO = "root";
private static final String SENHA = "";
private static final String URL = "jdbc:mysql://localhost:3306/gelinfo";

public static Connection conectar() throws SQLException {
	
	//REFERENCIA AO DRIVER MYSQL PARA VERSOES ANTIGAS DO JAVA
	DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	
	Connection conexao = DriverManager.getConnection(URL,USUARIO,SENHA);
	return conexao;
}

public static void main(String[] args) {
	try {
	Connection conexao = ConexaoFactory.conectar();
	
	Usuario u = new Usuario();
	
	System.out.println("Conectado com sucesso!!");
	}
	
	catch(SQLException ex) {
		ex.printStackTrace();
		System.out.println("A conexão falhou!!");
	}
	}

public static PreparedStatement prepareStatement(String sql) {
	// TODO Auto-generated method stub
	return null;
}

public static void close() {
	// TODO Auto-generated method stub
	
}

}
