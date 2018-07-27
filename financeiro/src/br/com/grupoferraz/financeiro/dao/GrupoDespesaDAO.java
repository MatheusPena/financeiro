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

import br.com.grupoferraz.financeiro.entity.GrupoDespesa;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class GrupoDespesaDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertGrupoDespesa(GrupoDespesa grupodespesa) {


		try {

			StringBuilder str = new StringBuilder();
			str.append("insert into grupodespesa (codigo, nomegrupodespesa, grupodespesa_codigo) values (?,?,?)");
			str.append("on duplicate key update codigo = ?, nomegrupodespesa = ?, grupodespesa_codigo = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, grupodespesa.getCodigo());
			preparedStatement.setString(2, grupodespesa.getNomegrupodespesa());
			
			Integer cod = grupodespesa.getGrupodespesa_codigo();
			if(cod!=null) {
				preparedStatement.setInt(3, cod);
				preparedStatement.setInt(6, cod);
			}else {
				preparedStatement.setNull(3, Types.INTEGER);
				preparedStatement.setInt(6, Types.INTEGER);
			}
			
			
			
			
			preparedStatement.setInt(4, grupodespesa.getCodigo());
			preparedStatement.setString(5, grupodespesa.getNomegrupodespesa());
			
			
			System.out.println("G D COD "+grupodespesa.getGrupodespesa_codigo());
			
			preparedStatement.execute();
			return true;
	
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os usuarios cadastrados no banco de dados
	public List<GrupoDespesa> listGrupoDespesas() {

		ArrayList<GrupoDespesa> lista = new ArrayList<GrupoDespesa>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select * from grupodespesa";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				GrupoDespesa grupodespesa = new GrupoDespesa();
				grupodespesa.setCodigo(rs.getInt("codigo"));
				grupodespesa.setNomegrupodespesa(rs.getString("nomegrupodespesa"));
				grupodespesa.setGrupodespesa_codigo(rs.getInt("grupodespesa_codigo"));
				int idGrupo = grupodespesa.getGrupodespesa_codigo();		
				GrupoDespesa grupoDespesa = getGrupoDespesa(idGrupo);
				grupodespesa.setSubgrupo(grupoDespesa);		
				lista.add(grupodespesa);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}
	
	//Listagem de Grupos
		public GrupoDespesa getGrupoDespesa(int idGrupo) throws SQLException {
			GrupoDespesa grupo = new GrupoDespesa();
			PreparedStatement preparedStatement;
			ResultSet rs = null;
			preparedStatement = conexao.prepareStatement(
					"select codigo, nomegrupodespesa from grupodespesa where codigo = ?");
			preparedStatement.setInt(1, idGrupo);
			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				grupo.setCodigo(rs.getInt("codigo"));
				grupo.setNomegrupodespesa(rs.getString("nomegrupodespesa"));
			}
			return grupo;
		}

}
