package com.ifsc.tds.artur.andre.felipe.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private static final String LOGIN_BANCO = "root";
	private static final String SENHA_BANCO = "";
	private static final String URL_BANCO = "jdbc:mysql://localhost:3306/agenda?useSSL=false&useTimezone=true&serverTimezone=UTC\r\n"; 

	public Connection getConnection() {
		
		Connection conexao = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexao = DriverManager.getConnection(Conexao.URL_BANCO, Conexao.LOGIN_BANCO, Conexao.SENHA_BANCO);
		} catch (SQLException e) {
			System.out.println("Erro ao conectar ao banco de dados. Erro: " + e);
		} catch (ClassNotFoundException e) {
			System.out.println("N�o foi poss�vel carregar a classe JDBC MySQL. Erro: " + e);
		} catch (Exception e) {
			System.out.println("Erro geral. Erro: " + e);
		}
		return conexao;
	}
}
