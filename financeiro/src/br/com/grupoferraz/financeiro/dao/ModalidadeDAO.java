package br.com.grupoferraz.financeiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.grupoferraz.financeiro.entity.GrupoModalidade;
import br.com.grupoferraz.financeiro.entity.Modalidade;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class ModalidadeDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertModalidade(Modalidade Modalidade) {

		try {

			StringBuilder str = new StringBuilder();
			str.append("insert into modalidade (codigo,nome,fatura,iss,irpf,pis,inss,atividade,grupo_modalidade_codigo)"
					+ " values (?,?,?,?,?,?,?,?,?)");
			str.append(
					"on duplicate key update codigo = ?, nome = ?,fatura = ?,iss = ?,irpf = ?,pis = ?,inss = ?,atividade = ?,grupo_modalidade_codigo = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, Modalidade.getCodigo());
			preparedStatement.setString(2, Modalidade.getNome());
			preparedStatement.setString(3, Modalidade.getFatura());
			preparedStatement.setBigDecimal(4, Modalidade.getIss());
			preparedStatement.setBigDecimal(5, Modalidade.getIrpf());
			preparedStatement.setBigDecimal(6, Modalidade.getPis());
			preparedStatement.setBigDecimal(7, Modalidade.getInss());
			preparedStatement.setString(8, Modalidade.getAtividade());
			if (Modalidade.getGrupomodalidade_codigo() != null) {
				preparedStatement.setInt(9, Modalidade.getGrupomodalidade_codigo());
			} else {
				preparedStatement.setNull(9, Types.INTEGER);
			}
			preparedStatement.setInt(10, Modalidade.getCodigo());
			preparedStatement.setString(11, Modalidade.getNome());
			preparedStatement.setString(12, Modalidade.getFatura());
			preparedStatement.setBigDecimal(13, Modalidade.getIss());
			preparedStatement.setBigDecimal(14, Modalidade.getIrpf());
			preparedStatement.setBigDecimal(15, Modalidade.getPis());
			preparedStatement.setBigDecimal(16, Modalidade.getInss());
			preparedStatement.setString(17, Modalidade.getAtividade());
			if (Modalidade.getGrupomodalidade_codigo() != null) {
				preparedStatement.setInt(18, Modalidade.getGrupomodalidade_codigo());
			} else {
				preparedStatement.setNull(18, Types.INTEGER);
			}

			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos as modalidades cadastradas no banco de dados
	public List<Modalidade> listModalidade() {

		ArrayList<Modalidade> lista = new ArrayList<Modalidade>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select * from modalidade";

			rs = st.executeQuery(sql);

			while (rs.next()) {

				Modalidade modalidade = new Modalidade();
				modalidade.setCodigo(rs.getInt(1));
				modalidade.setNome(rs.getString(2));
				modalidade.setFatura(rs.getString(3));
				modalidade.setIss(rs.getBigDecimal(4));
				modalidade.setIrpf(rs.getBigDecimal(5));
				modalidade.setPis(rs.getBigDecimal(6));
				modalidade.setInss(rs.getBigDecimal(7));
				modalidade.setGrupomodalidade_codigo(rs.getInt(9));
				int idGrupo = modalidade.getGrupomodalidade_codigo();
				GrupoModalidade gmodalidade = getGrupoModalidade(idGrupo);
				modalidade.setGrupomodalidade(gmodalidade);
				modalidade.setAtividade(rs.getString(8));
				lista.add(modalidade);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

	// Exibe a lista de Grupo de Modalidades cadastradas
	public GrupoModalidade getGrupoModalidade(Integer codigo) {
		GrupoModalidade grupoModalidade = new GrupoModalidade();

		PreparedStatement preparedStatement;
		ResultSet rs = null;
		try {
			preparedStatement = conexao.prepareStatement("select codigo, nome from grupo_modalidade where codigo = ?");
			preparedStatement.setInt(1, codigo);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Integer cod = rs.getInt("codigo");
				String nome = rs.getString("nome");
				grupoModalidade.setCodigo(cod);
				grupoModalidade.setNome(nome);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return grupoModalidade;
	}
}
