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

import br.com.grupoferraz.financeiro.entity.VencimentoChequeCR;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class VencimentoChequeCRDAO{
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertVencimentoChequeCR(VencimentoChequeCR VencimentoChequeCRDAO) {
		try {
			StringBuilder str = new StringBuilder();
			str.append(
					"INSERT INTO financeiro.vencimentochequecr  (codigo,vencimento,valor,banco,tipoconta,agenciabanco,digagencia,conta,digconta,cheque,titular,febraban)"
							+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
			str.append(
					"on duplicate key update codigo = ?,vencimento = ?,valor = ?,banco = ?,tipoconta = ?,agenciabanco = ?,digagencia = ?,conta = ?,digconta = ?,cheque = ?,titular = ?,febraban = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, VencimentoChequeCRDAO.getCodigo());
			Date data = VencimentoChequeCRDAO.getVencimento();
			long t = 0;
			if (data != null) {
				t = data.getTime();
			}
			preparedStatement.setDate(2, new java.sql.Date(t));
			preparedStatement.setFloat(3, VencimentoChequeCRDAO.getValor());
			preparedStatement.setString(4, VencimentoChequeCRDAO.getBanco());
			preparedStatement.setString(5, VencimentoChequeCRDAO.getTipoconta());
			preparedStatement.setFloat(6, VencimentoChequeCRDAO.getAgencia());
			preparedStatement.setInt(7, VencimentoChequeCRDAO.getDigagencia());
			preparedStatement.setInt(8, VencimentoChequeCRDAO.getConta());
			preparedStatement.setInt(9, VencimentoChequeCRDAO.getDigconta());
			preparedStatement.setInt(10, VencimentoChequeCRDAO.getCheque());
			preparedStatement.setString(11, VencimentoChequeCRDAO.getTitular());
			preparedStatement.setInt(12, VencimentoChequeCRDAO.getFebraban());
			
			preparedStatement.setInt(13, VencimentoChequeCRDAO.getCodigo());
			preparedStatement.setDate(14, new java.sql.Date(t));
			preparedStatement.setFloat(15, VencimentoChequeCRDAO.getValor());
			preparedStatement.setString(16, VencimentoChequeCRDAO.getBanco());
			preparedStatement.setString(17, VencimentoChequeCRDAO.getTipoconta());
			preparedStatement.setFloat(18, VencimentoChequeCRDAO.getAgencia());
			preparedStatement.setInt(19, VencimentoChequeCRDAO.getDigagencia());
			preparedStatement.setInt(20, VencimentoChequeCRDAO.getConta());
			preparedStatement.setInt(21, VencimentoChequeCRDAO.getDigconta());
			preparedStatement.setInt(22, VencimentoChequeCRDAO.getCheque());
			preparedStatement.setString(23, VencimentoChequeCRDAO.getTitular());
			preparedStatement.setInt(24, VencimentoChequeCRDAO.getFebraban());
			
			preparedStatement.execute();

			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os vencimentos de cheque cadastrados no banco de dados
	public List<VencimentoChequeCR> listVencimentoChequeCR() {

		ArrayList<VencimentoChequeCR> lista = new ArrayList<VencimentoChequeCR>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select * from vencimentochequecr";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				VencimentoChequeCR VencimentoChequeCRDAO = new VencimentoChequeCR();
				VencimentoChequeCRDAO.setCodigo(rs.getInt("codigo"));
				VencimentoChequeCRDAO.setVencimento(rs.getDate("vencimento"));
				VencimentoChequeCRDAO.setValor(rs.getFloat("valor"));
				VencimentoChequeCRDAO.setBanco(rs.getString("banco"));
				VencimentoChequeCRDAO.setTipoconta(rs.getString("tipoconta"));
				VencimentoChequeCRDAO.setAgencia(rs.getInt("agenciabanco"));
				VencimentoChequeCRDAO.setDigagencia(rs.getInt("digagencia"));
				VencimentoChequeCRDAO.setConta(rs.getInt("conta"));
				VencimentoChequeCRDAO.setDigconta(rs.getInt("digconta"));
				VencimentoChequeCRDAO.setCheque(rs.getInt("cheque"));
				VencimentoChequeCRDAO.setTitular(rs.getString("titular"));
				VencimentoChequeCRDAO.setFebraban(rs.getInt("febraban"));
				lista.add(VencimentoChequeCRDAO);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}
}
