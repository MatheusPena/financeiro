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

import br.com.grupoferraz.financeiro.entity.Historico;
import br.com.grupoferraz.financeiro.entity.DespesaReceita;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class HistoricoDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertHistorico(Historico historicos) {

		try {

			StringBuilder str = new StringBuilder();
			str.append("insert into historico (codigo, descricao, despesareceita_codigo) values (?,?,?) ");
			str.append("on duplicate key update codigo = ?, descricao = ?, despesareceita_codigo = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, historicos.getCodigo());
			preparedStatement.setString(2, historicos.getDescricao());
			preparedStatement.setInt(3, historicos.getDespesareceita_codigo());

			preparedStatement.setInt(4, historicos.getCodigo());
			preparedStatement.setString(5, historicos.getDescricao());
			preparedStatement.setInt(6, historicos.getDespesareceita_codigo());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os usuarios cadastrados no banco de dados
	public List<Historico> listHistoricos() {

		ArrayList<Historico> lista = new ArrayList<Historico>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select codigo, descricao, despesareceita_codigo from historico ";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				Historico historicos = new Historico();
				historicos.setCodigo(rs.getInt("codigo"));
				historicos.setDescricao(rs.getString("descricao"));
				historicos.setDespesareceita_codigo(rs.getInt("despesareceita_codigo"));
				int idDespesareceita = historicos.getDespesareceita_codigo();
				DespesaReceita despesareceitas = getDespesas(idDespesareceita);
				historicos.setDespesareceita(despesareceitas);
				lista.add(historicos);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

	//Lista as despesas cadastradas na tela dos Históricos
	public DespesaReceita getDespesas(int idDespesareceita) throws SQLException {
		DespesaReceita despesareceita = new DespesaReceita();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement(
				"select codigo, nome from despesa_receita where codigo = ?");
		preparedStatement.setInt(1, idDespesareceita);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			despesareceita.setCodigo(rs.getInt("codigo"));
			despesareceita.setNome(rs.getString("nome"));
		}
		return despesareceita;
	}
	
	// Método do autocomplete na tela de Adiantamentos
		public Historico historico(DespesaReceita despesareceita) {
			
			if (despesareceita == null) {
				return null;
			}
			ArrayList<Historico> lista = new ArrayList<Historico>();

			PreparedStatement preparedStatement = null;
			Integer idDespesareceita = despesareceita.getCodigo();
			ResultSet rs = null;

			try {
				String sql = "select codigo, descricao, despesareceita_codigo from historico where despesareceita_codigo = ?";
				preparedStatement = conexao.prepareStatement(
					sql);
				System.out.println("ID DESPESA RECEITA "+idDespesareceita);
				
				if(idDespesareceita==0) {
					preparedStatement.setNull(1, java.sql.Types.INTEGER);
				}else {
					preparedStatement.setInt(1, idDespesareceita);
				}
				
				rs = preparedStatement.executeQuery();
				
				while (rs.next()) {

					Historico historico = new Historico();
					historico.setCodigo(rs.getInt("codigo"));
					historico.setDescricao(rs.getString("descricao"));
					historico.setDespesareceita_codigo(rs.getInt("despesareceita_codigo"));
					int id = historico.getDespesareceita_codigo();
					DespesaReceita despesareceitas = getDespesas(id);
					historico.setDespesareceita(despesareceitas);
					lista.add(historico);
				}

			} catch (SQLException ex) {
				Logger lgr = Logger.getLogger(Connection.class.getName());
				lgr.log(Level.SEVERE, ex.getMessage(), ex);

			} finally {
			}
			
			if (lista != null && !lista.isEmpty()) {
				return lista.get(0);
			}
			return null;
		}

}
