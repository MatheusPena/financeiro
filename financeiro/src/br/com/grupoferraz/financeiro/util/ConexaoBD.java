package br.com.grupoferraz.financeiro.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
	private static final String user = "root";
	private static final String password = "1234567";
	private static final String url = "jdbc:mysql://localhost:3306/financeiro";
	
	public static Connection conexao;
	
	public static Connection getConexao() {
		if(conexao == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conexao = DriverManager.getConnection(url,user,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conexao;
	}
	
	public static void fecharConexao () {
		if(conexao != null) {
			try {
				conexao.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conexao = null;
		}
	}
}
