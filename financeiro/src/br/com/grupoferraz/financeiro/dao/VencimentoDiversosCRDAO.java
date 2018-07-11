package br.com.grupoferraz.financeiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.grupoferraz.financeiro.entity.Documentos;
import br.com.grupoferraz.financeiro.entity.VencimentoDiversosCR;
import br.com.grupoferraz.financeiro.entity.Empresa;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class VencimentoDiversosCRDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertVencimentoDiversosCR(VencimentoDiversosCR VencimentoDiversosCR) {
		try {
			StringBuilder str = new StringBuilder();
			str.append(
					"INSERT INTO financeiro.vencimentodiversoscr (codigo, vencimento,valor, titulo, boleto, desconto, empresas_cnpj, documento_codigo)"
							+ "VALUES (?,?,?,?,?,?,?,?)");
			str.append(
					"on duplicate key update codigo = ?, vencimento = ?,valor = ?, titulo = ?, boleto = ?, desconto = ?, empresas_cnpj = ?, documento_codigo = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, VencimentoDiversosCR.getCodigo());
			Date data = VencimentoDiversosCR.getVencimento();
			long t = 0;
			if (data != null) {
				t = data.getTime();
			}
			preparedStatement.setDate(2, new java.sql.Date(t));
			preparedStatement.setFloat(3, VencimentoDiversosCR.getValor());
			preparedStatement.setInt(4, VencimentoDiversosCR.getTitulo());
			preparedStatement.setInt(5, VencimentoDiversosCR.getBoleto());
			preparedStatement.setFloat(6, VencimentoDiversosCR.getDesconto());
			preparedStatement.setString(7, VencimentoDiversosCR.getEmpresas_cnpj());
			preparedStatement.setInt(8, VencimentoDiversosCR.getDocumento_codigo());
			
			preparedStatement.setInt(9, VencimentoDiversosCR.getCodigo());
			preparedStatement.setDate(10, new java.sql.Date(t));
			preparedStatement.setFloat(11, VencimentoDiversosCR.getValor());
			preparedStatement.setInt(12, VencimentoDiversosCR.getTitulo());
			preparedStatement.setInt(13, VencimentoDiversosCR.getBoleto());
			preparedStatement.setFloat(14, VencimentoDiversosCR.getDesconto());
			preparedStatement.setString(15, VencimentoDiversosCR.getEmpresas_cnpj());
			preparedStatement.setInt(16, VencimentoDiversosCR.getDocumento_codigo());
			
			preparedStatement.execute();

			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todas os vencimentos diversos cadastrados no banco de dados
	public List<VencimentoDiversosCR> listVencimentoDiversosCR() {

		ArrayList<VencimentoDiversosCR> lista = new ArrayList<VencimentoDiversosCR>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select * from VencimentoDiversosCR ";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				VencimentoDiversosCR VencimentoDiversosCR = new VencimentoDiversosCR();
				VencimentoDiversosCR.setCodigo(rs.getInt("codigo"));
				VencimentoDiversosCR.setVencimento(rs.getDate("vencimento"));
				VencimentoDiversosCR.setValor(rs.getFloat("valor"));
				VencimentoDiversosCR.setDocumento_codigo(rs.getInt("documento_codigo"));
				int obj1 = VencimentoDiversosCR.getDocumento_codigo();
				Documentos documento = getDocumentos(obj1);
				VencimentoDiversosCR.setDocumento(documento);
				VencimentoDiversosCR.setTitulo(rs.getInt("titulo"));
				VencimentoDiversosCR.setEmpresas_cnpj(rs.getString("empresas_cnpj"));
				String obj2 = VencimentoDiversosCR.getEmpresas_cnpj();
				Empresa empresa = getEmpresa(obj2);
				//System.out.println("Empresa" + empresa);
				VencimentoDiversosCR.setEmpresa(empresa);
				VencimentoDiversosCR.setBoleto(rs.getInt("boleto"));
				VencimentoDiversosCR.setDesconto(rs.getFloat("desconto"));
				lista.add(VencimentoDiversosCR);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}
	
	public Empresa getEmpresa(String idGrupo) throws SQLException {
		Empresa grupo = new Empresa();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
			preparedStatement = conexao
					.prepareStatement ("select * from empresas where cnpj = ?");
			preparedStatement.setString(1, idGrupo);
			rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCnpj(rs.getString("cnpj"));
			grupo.setNome(rs.getString("nome"));
		}
		return grupo;
	}
	
	public Documentos getDocumentos(int idDocumentos) throws SQLException {
		Documentos documento = new Documentos();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement(
				"select codigo, nome from documento where codigo = ?");
		preparedStatement.setInt(1, idDocumentos);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			documento.setCodigo(rs.getInt("codigo"));
			documento.setNome(rs.getString("nome"));
		}
		return documento;
	}
}
