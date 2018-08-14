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

import br.com.grupoferraz.financeiro.entity.Documento;
import br.com.grupoferraz.financeiro.entity.VencimentoDiversoCR;
import br.com.grupoferraz.financeiro.entity.Empresa;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class VencimentoDiversoCRDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertVencimentoDiversoCR(VencimentoDiversoCR VencimentoDiversoCR) {
		try {
			StringBuilder str = new StringBuilder();
			str.append(
					"INSERT INTO financeiro.vencimento_diverso_cr (codigo, vencimento,valor, titulo, boleto, desconto, empresa_cnpj, documento_codigo)"
							+ "VALUES (?,?,?,?,?,?,?,?)");
			str.append(
					"on duplicate key update codigo = ?, vencimento = ?,valor = ?, titulo = ?, boleto = ?, desconto = ?, empresa_cnpj = ?, documento_codigo = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, VencimentoDiversoCR.getCodigo());
			Date data = VencimentoDiversoCR.getVencimento();
			long t = 0;
			if (data != null) {
				t = data.getTime();
			}
			preparedStatement.setDate(2, new java.sql.Date(t));
			preparedStatement.setBigDecimal(3, VencimentoDiversoCR.getValor());
			preparedStatement.setInt(4, VencimentoDiversoCR.getTitulo());
			preparedStatement.setInt(5, VencimentoDiversoCR.getBoleto());
			preparedStatement.setBigDecimal(6, VencimentoDiversoCR.getDesconto());
			preparedStatement.setString(7, VencimentoDiversoCR.getEmpresa_cnpj());
			preparedStatement.setInt(8, VencimentoDiversoCR.getDocumento_codigo());

			preparedStatement.setInt(9, VencimentoDiversoCR.getCodigo());
			preparedStatement.setDate(10, new java.sql.Date(t));
			preparedStatement.setBigDecimal(11, VencimentoDiversoCR.getValor());
			preparedStatement.setInt(12, VencimentoDiversoCR.getTitulo());
			preparedStatement.setInt(13, VencimentoDiversoCR.getBoleto());
			preparedStatement.setBigDecimal(14, VencimentoDiversoCR.getDesconto());
			preparedStatement.setString(15, VencimentoDiversoCR.getEmpresa_cnpj());
			preparedStatement.setInt(16, VencimentoDiversoCR.getDocumento_codigo());

			preparedStatement.execute();

			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todas os vencimentos diversos cadastrados no banco de dados
	public List<VencimentoDiversoCR> listVencimentoDiversosCR() {

		ArrayList<VencimentoDiversoCR> lista = new ArrayList<VencimentoDiversoCR>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select * from vencimento_diverso_cr";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				VencimentoDiversoCR VencimentoDiversoCR = new VencimentoDiversoCR();
				VencimentoDiversoCR.setCodigo(rs.getInt("codigo"));
				VencimentoDiversoCR.setVencimento(rs.getDate("vencimento"));
				VencimentoDiversoCR.setValor(rs.getBigDecimal("valor"));
				VencimentoDiversoCR.setDocumento_codigo(rs.getInt("documento_codigo"));
				int obj1 = VencimentoDiversoCR.getDocumento_codigo();
				Documento documento = getDocumento(obj1);
				VencimentoDiversoCR.setDocumento(documento);
				VencimentoDiversoCR.setTitulo(rs.getInt("titulo"));
				VencimentoDiversoCR.setEmpresa_cnpj(rs.getString("empresa_cnpj"));
				String obj2 = VencimentoDiversoCR.getEmpresa_cnpj();
				Empresa empresa = getEmpresa(obj2);
				VencimentoDiversoCR.setEmpresa(empresa);
				VencimentoDiversoCR.setBoleto(rs.getInt("boleto"));
				VencimentoDiversoCR.setDesconto(rs.getBigDecimal("desconto"));
				lista.add(VencimentoDiversoCR);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

	// lista as empresas cadastradas no banco de dados
	public Empresa getEmpresa(String idGrupo) throws SQLException {
		Empresa grupo = new Empresa();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement("select * from empresa where cnpj = ?");
		preparedStatement.setString(1, idGrupo);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCnpj(rs.getString("cnpj"));
			grupo.setNome(rs.getString("nome"));
		}
		return grupo;
	}

	// lista os documentos cadastrados no banco de dados
	public Documento getDocumento(int idDocumentos) throws SQLException {
		Documento documento = new Documento();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement("select codigo, nome from documento where codigo = ?");
		preparedStatement.setInt(1, idDocumentos);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			documento.setCodigo(rs.getInt("codigo"));
			documento.setNome(rs.getString("nome"));
		}
		return documento;
	}
}
