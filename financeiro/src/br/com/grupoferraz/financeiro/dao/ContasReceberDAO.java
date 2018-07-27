package br.com.grupoferraz.financeiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.grupoferraz.financeiro.entity.CentroResultado;
import br.com.grupoferraz.financeiro.entity.ContasReceber;
import br.com.grupoferraz.financeiro.entity.Estabelecimento;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class ContasReceberDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertContasReceber(ContasReceber ContasReceber) {
		try {
			StringBuilder str = new StringBuilder();
			str.append(
					"INSERT INTO financeiro.contasreceber (codigo,cpf,receita,documento,emissao,valor,contabilidade,observacao,estabelecimentos_codigo,centroresultados_codigo)"
							+ "VALUES (?,?,?,?,?,?,?,?,?,?)");
			str.append(
					"on duplicate key update codigo = ?,cpf = ?,receita = ?,documento = ?,emissao = ?,valor = ?,contabilidade = ?,observacao = ?,estabelecimentos_codigo = ?,centroresultados_codigo = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, ContasReceber.getCodigo());
			preparedStatement.setString(2, ContasReceber.getCpf());
			preparedStatement.setInt(3, ContasReceber.getReceita());
			preparedStatement.setInt(4, ContasReceber.getDocumento());
			Date data = ContasReceber.getEmissao();
			long t = 0;
			if (data != null) {
				t = data.getTime();
			}
			preparedStatement.setDate(5, new java.sql.Date(t));
			preparedStatement.setFloat(6, ContasReceber.getValor());
			preparedStatement.setString(7, ContasReceber.getContabilidade());
			preparedStatement.setString(8, ContasReceber.getObservacao());
			preparedStatement.setInt(9, ContasReceber.getEstabelecimentos_codigo());
			if (ContasReceber.getCentro_resultados() != null) {
			preparedStatement.setInt(10, ContasReceber.getCentro_resultados());
			}
			else {
				preparedStatement.setNull(10, Types.INTEGER);
			}
			preparedStatement.setInt(11, ContasReceber.getCodigo());
			preparedStatement.setString(12, ContasReceber.getCpf());
			preparedStatement.setInt(13, ContasReceber.getReceita());
			preparedStatement.setInt(14, ContasReceber.getDocumento());
			preparedStatement.setDate(15, new java.sql.Date(t));
			preparedStatement.setFloat(16, ContasReceber.getValor());
			preparedStatement.setString(17, ContasReceber.getContabilidade());
			preparedStatement.setString(18, ContasReceber.getObservacao());
			preparedStatement.setInt(19, ContasReceber.getEstabelecimentos_codigo());
			if (ContasReceber.getCentro_resultados() != null) {
			preparedStatement.setInt(20, ContasReceber.getCentro_resultados());
			}
			else {
				preparedStatement.setNull(20, Types.INTEGER);
			}
			
			preparedStatement.execute();

			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todas as contas cadastradas no banco de dados
	public List<ContasReceber> listContasReceber() {

		ArrayList<ContasReceber> lista = new ArrayList<ContasReceber>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select * from contasreceber ";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				ContasReceber contasreceber = new ContasReceber();
				contasreceber.setCodigo(rs.getInt("codigo"));
				contasreceber.setEstabelecimentos_codigo(rs.getInt("estabelecimentos_codigo"));
				int obj1 = contasreceber.getEstabelecimentos_codigo();
				Estabelecimento estabelecimento = getEstabelecimento(obj1);
				contasreceber.setEstabelecimento(estabelecimento);
				contasreceber.setCpf(rs.getString("cpf"));
				contasreceber.setReceita(rs.getInt("receita"));
				contasreceber.setDocumento(rs.getInt("documento"));
				contasreceber.setEmissao(rs.getDate("emissao"));
				contasreceber.setValor(rs.getFloat("valor"));
				contasreceber.setContabilidade(rs.getString("contabilidade"));
				contasreceber.setCentro_resultados(rs.getInt("centroresultados_codigo"));
				CentroResultado obj3 = getCentroResultados(contasreceber.getCentro_resultados());
				contasreceber.setCentroresultados(obj3);
				contasreceber.setObservacao(rs.getString("observacao"));
				lista.add(contasreceber);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}
	
	public Estabelecimento getEstabelecimento(int idGrupo) throws SQLException {
		Estabelecimento grupo = new Estabelecimento();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
			preparedStatement = conexao
					.prepareStatement ("select * from estabelecimentos where codigo = ?");
			preparedStatement.setInt(1, idGrupo);
			rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCodigo(rs.getInt("codigo"));
			grupo.setNome(rs.getString("nome"));
			grupo.setGrupoestabelecimento_codigo(rs.getInt("grupoestabelecimento_codigo"));
		}
		return grupo;
	}
	
	public CentroResultado getCentroResultados(int idGrupo) throws SQLException {
		CentroResultado grupo = new CentroResultado();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
			preparedStatement = conexao
					.prepareStatement ("select * from centroresultados where codigo = ?");
			preparedStatement.setInt(1, idGrupo);
			rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCodigo(rs.getInt("codigo"));
			grupo.setNome(rs.getString("nome"));
			grupo.setAtividade(rs.getString("atividade"));
			grupo.setCrcontabil(rs.getString("crcontabil"));
			grupo.setPeso(rs.getBigDecimal("peso"));
			grupo.setGrupocentroresultados_codigo(rs.getInt("grupocentroresultados_codigo"));
		}
		return grupo;
	}
}
