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

import br.com.grupoferraz.financeiro.entity.GrupoDespesaReceita;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class GrupoDespesaReceitaDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertGrupoDespesaReceita(GrupoDespesaReceita grupodespesareceita) {

		try {
			StringBuilder str = new StringBuilder();
			str.append("insert into grupo_despesa_receita (codigo, nome, grupodespesareceita_codigo) values (?,?,?)");
			str.append(" on duplicate key update codigo = ?, nome = ?, grupodespesareceita_codigo = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, grupodespesareceita.getCodigo());
			preparedStatement.setString(2, grupodespesareceita.getNome());
			
			Integer ce = grupodespesareceita.getGrupodespesareceita_codigo();
			System.out.println("CE "+ce);
			if(ce!=0) {
				preparedStatement.setInt(3, ce); 
				preparedStatement.setInt(6, ce);
			}else {
				preparedStatement.setNull(3, java.sql.Types.INTEGER); 
				preparedStatement.setNull(6, java.sql.Types.INTEGER);
			}
			
			//preparedStatement.setInt(3, grupodespesareceita.getGrupodespesareceita_codigo()); 
			
			preparedStatement.setInt(4, grupodespesareceita.getCodigo());
			preparedStatement.setString(5, grupodespesareceita.getNome());
			//preparedStatement.setInt(6, grupodespesareceita.getGrupodespesareceita_codigo());
			
			preparedStatement.execute();
			
			return true;
	
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os usuarios cadastrados no banco de dados
	public List<GrupoDespesaReceita> listGrupoDespesaReceita() {

		ArrayList<GrupoDespesaReceita> lista = new ArrayList<GrupoDespesaReceita>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select * from grupo_despesa_receita";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				GrupoDespesaReceita grupodespesareceita = new GrupoDespesaReceita();
				grupodespesareceita.setCodigo(rs.getInt("codigo"));
				grupodespesareceita.setNome(rs.getString("nome"));
				grupodespesareceita.setGrupodespesareceita_codigo(rs.getInt("grupodespesareceita_codigo"));
				int idGrupo = grupodespesareceita.getGrupodespesareceita_codigo();		
				GrupoDespesaReceita grupoDespesa = getGrupoDespesa(idGrupo);
				grupodespesareceita.setSubgrupo(grupoDespesa);		
				lista.add(grupodespesareceita);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}
	
	//Listagem de Grupos
		public GrupoDespesaReceita getGrupoDespesa(int idGrupo) throws SQLException {
			GrupoDespesaReceita grupo = new GrupoDespesaReceita();
			PreparedStatement preparedStatement;
			ResultSet rs = null;
			preparedStatement = conexao.prepareStatement(
					"select codigo, nome from grupo_despesa_receita where codigo = ?");
			preparedStatement.setInt(1, idGrupo);
			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				grupo.setCodigo(rs.getInt("codigo"));
				grupo.setNome(rs.getString("nome"));
			}
			return grupo;
		}

}