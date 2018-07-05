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

import br.com.grupoferraz.financeiro.entity.ComissaoItemCR;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class ComissaoItemCRDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertComissaoItemCR(ComissaoItemCR ComissaoItemCR) {
		try {
			StringBuilder str = new StringBuilder();
			str.append(
					"INSERT INTO financeiro.comissaoitemcr (codigo, comissao, vendedores_cpfcnpj)"
							+ "VALUES (?,?,?)");
			str.append(
					"on duplicate key update codigo =?, comissao =?, vendedores_cpfcnpj = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, ComissaoItemCR.getCodigo());
			preparedStatement.setFloat(2, ComissaoItemCR.getComissao());
			preparedStatement.setString(3, ComissaoItemCR.getCpfcnpj());
			
			preparedStatement.setInt(4, ComissaoItemCR.getCodigo());
			preparedStatement.setFloat(5, ComissaoItemCR.getComissao());
			preparedStatement.setString(6, ComissaoItemCR.getCpfcnpj());

			preparedStatement.execute();

			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos as comissoes cadastradas no banco de dados
	public List<ComissaoItemCR> listComissaoItemCR() {

		ArrayList<ComissaoItemCR> lista = new ArrayList<ComissaoItemCR>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select * from comissaoitemcr ";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				ComissaoItemCR ComissaoItemCR = new ComissaoItemCR();
				ComissaoItemCR.setCodigo(rs.getInt("codigo"));
				ComissaoItemCR.setCpfcnpj(rs.getString("vendedores_cpfcnpj"));
				ComissaoItemCR.setComissao(rs.getFloat("comissao"));
				lista.add(ComissaoItemCR);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}
}
