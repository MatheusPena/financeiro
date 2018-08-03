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

import br.com.grupoferraz.financeiro.entity.GrupoServico;
import br.com.grupoferraz.financeiro.entity.Modalidade;
import br.com.grupoferraz.financeiro.entity.Servico;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class ServicoDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertServico(Servico servico) {

		try {

			StringBuilder str = new StringBuilder();
			str.append("insert into servico (codigo,nome,valor,quantidade,grupo_servico_codigo,modalidade_codigo)"
					+ " values (?,?,?,?,?,?)");
			str.append(
					"on duplicate key update codigo =?,nome =?,valor =?,quantidade =?,grupo_servico_codigo =?,modalidade_codigo =?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, servico.getCodigo());
			preparedStatement.setString(2, servico.getNome());
			preparedStatement.setBigDecimal(3, servico.getValor());
			preparedStatement.setInt(4, servico.getQuantidade());
			if (servico.getGruposervico_codigo() != null) {
				preparedStatement.setInt(5, servico.getGruposervico_codigo());
			} else {
				preparedStatement.setNull(5, Types.INTEGER);
			}
			preparedStatement.setInt(6, servico.getModalidade_codigo());

			preparedStatement.setInt(7, servico.getCodigo());
			preparedStatement.setString(8, servico.getNome());
			preparedStatement.setBigDecimal(9, servico.getValor());
			preparedStatement.setInt(10, servico.getQuantidade());
			if (servico.getGruposervico_codigo() != null) {
				preparedStatement.setInt(11, servico.getGruposervico_codigo());
			} else {
				preparedStatement.setNull(11, Types.INTEGER);
			}
			preparedStatement.setInt(12, servico.getModalidade_codigo());

			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os serviços cadastradas no banco de dados
	public List<Servico> listServico() {

		ArrayList<Servico> lista = new ArrayList<Servico>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select * from servico";

			rs = st.executeQuery(sql);

			while (rs.next()) {

				Servico servico = new Servico();
				servico.setCodigo(rs.getInt(1));
				servico.setNome(rs.getString(2));
				servico.setModalidade_codigo(rs.getInt(6));
				int id = servico.getModalidade_codigo();
				Modalidade modalidade = getModalidade(id);
				servico.setModalidade(modalidade);
				servico.setValor(rs.getBigDecimal(3));
				servico.setQuantidade(rs.getInt(4));
				servico.setGruposervico_codigo(rs.getInt(5));
				int idGrupo = servico.getGruposervico_codigo();
				GrupoServico gservico = getGrupoServico(idGrupo);
				servico.setGruposervico(gservico);
				lista.add(servico);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

	// Exibe a lista de Grupo de Serviços cadastrados
	public GrupoServico getGrupoServico(Integer codigo) {
		GrupoServico grupoServico = new GrupoServico();

		PreparedStatement preparedStatement;
		ResultSet rs = null;
		try {
			preparedStatement = conexao.prepareStatement("select codigo, nome from grupo_servico where codigo = ?");
			preparedStatement.setInt(1, codigo);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Integer cod = rs.getInt("codigo");
				String nome = rs.getString("nome");
				grupoServico.setCodigo(cod);
				grupoServico.setNome(nome);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return grupoServico;
	}

	// Exibe a lista de Modalidades cadastradas
	public Modalidade getModalidade(Integer codigo) {
		Modalidade modalidade = new Modalidade();

		PreparedStatement preparedStatement;
		ResultSet rs = null;
		try {
			preparedStatement = conexao.prepareStatement("select * from modalidade where codigo = ?");
			preparedStatement.setInt(1, codigo);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				modalidade.setCodigo(rs.getInt(1));
				modalidade.setNome(rs.getString(2));
				modalidade.setFatura(rs.getString(3));
				modalidade.setIss(rs.getBigDecimal(4));
				modalidade.setIrpf(rs.getBigDecimal(5));
				modalidade.setPis(rs.getBigDecimal(6));
				modalidade.setInss(rs.getBigDecimal(7));
				modalidade.setAtividade(rs.getString(8));
				modalidade.setGrupomodalidade_codigo(rs.getInt(9));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return modalidade;
	}
}
