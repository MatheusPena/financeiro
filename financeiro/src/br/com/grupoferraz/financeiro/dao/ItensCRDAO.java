package br.com.grupoferraz.financeiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.grupoferraz.financeiro.entity.ItensCR;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class ItensCRDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertItensCR(ItensCR ItensCR) {
		try {
			StringBuilder str = new StringBuilder();
			str.append(
					"INSERT INTO financeiro.itenscr (codigo,quantidade,valor,cfop,tributoa,tributob,icms,ipi,unidade,icmssubstituto,calculoicms,valoricms,descricao,tributosimples)"
							+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			str.append(
					"on duplicate key update codigo =?,quantidade =?,valor =?,cfop =?,tributoa =?,tributob =?,icms =?,ipi =?,unidade =?,icmssubstituto =?,calculoicms =?,valoricms =?,descricao =?,tributosimples =?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, ItensCR.getCodigo());
			preparedStatement.setInt(2, ItensCR.getQuantidade());
			preparedStatement.setFloat(3, ItensCR.getValor());
			preparedStatement.setInt(4, ItensCR.getCfop());
			preparedStatement.setInt(5, ItensCR.getTributoa());
			preparedStatement.setInt(6, ItensCR.getTributob());
			preparedStatement.setBigDecimal(7, ItensCR.getIcms());
			preparedStatement.setBigDecimal(8, ItensCR.getIpi());
			preparedStatement.setString(9, ItensCR.getUnidade());
			preparedStatement.setBigDecimal(10, ItensCR.getIcmssubstituto());
			preparedStatement.setBigDecimal(11, ItensCR.getCalculoicms());
			preparedStatement.setBigDecimal(12, ItensCR.getValoricms());
			preparedStatement.setString(13, ItensCR.getDescricao());
			preparedStatement.setInt(14, ItensCR.getTributosimples());
			
			preparedStatement.setInt(15, ItensCR.getCodigo());
			preparedStatement.setInt(16, ItensCR.getQuantidade());
			preparedStatement.setFloat(17, ItensCR.getValor());
			preparedStatement.setInt(18, ItensCR.getCfop());
			preparedStatement.setInt(19, ItensCR.getTributoa());
			preparedStatement.setInt(20, ItensCR.getTributob());
			preparedStatement.setBigDecimal(21, ItensCR.getIcms());
			preparedStatement.setBigDecimal(22, ItensCR.getIpi());
			preparedStatement.setString(23, ItensCR.getUnidade());
			preparedStatement.setBigDecimal(24, ItensCR.getIcmssubstituto());
			preparedStatement.setBigDecimal(25, ItensCR.getCalculoicms());
			preparedStatement.setBigDecimal(26, ItensCR.getValoricms());
			preparedStatement.setString(27, ItensCR.getDescricao());
			preparedStatement.setInt(28, ItensCR.getTributosimples());

			preparedStatement.execute();

			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todas os itens cadastrados no banco de dados
	public List<ItensCR> listItensCR() {

		ArrayList<ItensCR> lista = new ArrayList<ItensCR>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select * from itenscr ";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				ItensCR ItensCR = new ItensCR();
				ItensCR.setCodigo(rs.getInt("codigo"));
				ItensCR.setQuantidade(rs.getInt("quantidade"));
				ItensCR.setValor(rs.getFloat("valor"));
				ItensCR.setCfop(rs.getInt("cfop"));
				ItensCR.setTributoa(rs.getInt("tributoa"));
				ItensCR.setTributob(rs.getInt("tributob"));
				ItensCR.setIcms(rs.getBigDecimal("icms"));
				ItensCR.setIpi(rs.getBigDecimal("ipi"));
				ItensCR.setUnidade(rs.getString("unidade"));
				ItensCR.setIcmssubstituto(rs.getBigDecimal("icmssubstituto"));
				ItensCR.setCalculoicms(rs.getBigDecimal("calculoicms"));
				ItensCR.setValoricms(rs.getBigDecimal("valoricms"));
				ItensCR.setTributosimples(rs.getInt("tributosimples"));
				ItensCR.setDescricao(rs.getString("descricao"));
				lista.add(ItensCR);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}
}
