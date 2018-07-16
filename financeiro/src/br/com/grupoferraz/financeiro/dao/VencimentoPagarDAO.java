package br.com.grupoferraz.financeiro.dao;


import br.com.grupoferraz.financeiro.entity.VencimentoPagar;
import br.com.grupoferraz.financeiro.util.ConexaoBD;
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

public class VencimentoPagarDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertVencimento(VencimentoPagar vencimento) {
		try {
			StringBuilder str = new StringBuilder();
			str.append("INSERT INTO vencimento (vencimento_codigo, vencimento, titulo, valor, desconto,"
					+ "codigoag, nomeag, lancamento, banco, agenciabanco,"
					+ "digagencia, conta, digconta, agendar) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			str.append("on duplicate key update vencimento_codigo = ?, vencimento = ?, titulo = ?, valor = ?, desconto = ?, "
					+ "codigoag = ?, nomeag = ?, lancamento = ?, banco = ?, agenciabanco = ?, digagencia = ?, conta = ?, "
					+ "digconta = ?, agendar = ? ");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, vencimento.getVencimento_codigo());
			Date datavencimento = vencimento.getVencimento();
			long t = 0;
			if (datavencimento != null ) {
				t = datavencimento.getTime();	
			}
			preparedStatement.setDate(2, new java.sql.Date(t));
			preparedStatement.setString(3, vencimento.getTitulo());
			preparedStatement.setString(4, vencimento.getValor());
			preparedStatement.setString(5, vencimento.getDesconto());
			preparedStatement.setString(6, vencimento.getCodigoag());
			preparedStatement.setString(7, vencimento.getNomeag());
			preparedStatement.setString(8, vencimento.getLancamento());
			preparedStatement.setString(9, vencimento.getBanco());
			preparedStatement.setString(10, vencimento.getAgenciabanco());
			preparedStatement.setString(11, vencimento.getDigagencia());
			preparedStatement.setString(12, vencimento.getConta());
			Date agendar = vencimento.getAgendar();
			long j = 0;
			if (agendar != null ) {
				j = agendar.getTime();	
			}
			preparedStatement.setDate(13, new java.sql.Date(j));
			
			preparedStatement.setInt(14, vencimento.getVencimento_codigo());
			preparedStatement.setDate(15, new java.sql.Date(t));
			preparedStatement.setString(16, vencimento.getTitulo());
			preparedStatement.setString(17, vencimento.getValor());
			preparedStatement.setString(18, vencimento.getDesconto());
			preparedStatement.setString(19, vencimento.getCodigoag());
			preparedStatement.setString(20, vencimento.getNomeag());
			preparedStatement.setString(21, vencimento.getLancamento());
			preparedStatement.setString(22, vencimento.getBanco());
			preparedStatement.setString(23, vencimento.getAgenciabanco());
			preparedStatement.setString(24, vencimento.getDigagencia());
			preparedStatement.setString(25, vencimento.getConta());
			preparedStatement.setDate(26, new java.sql.Date(j));

			preparedStatement.execute();

			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os vendedoress cadastrados no banco de dados
	public List<VencimentoPagar> listVencimento() {

		ArrayList<VencimentoPagar> lista = new ArrayList<VencimentoPagar>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select * from vencimento";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				VencimentoPagar vencimento = new VencimentoPagar();
				vencimento.setVencimento_codigo(rs.getInt("vencimento_codigo"));
				vencimento.setVencimento(rs.getDate("vencimento"));
				vencimento.setTitulo(rs.getString("titulo"));
				vencimento.setValor(rs.getString("valor"));
				vencimento.setDesconto(rs.getString("desconto"));
				vencimento.setCodigoag(rs.getString("codigoag"));
				vencimento.setNomeag(rs.getString("nomeag"));
				vencimento.setLancamento(rs.getString("lancamento"));
				vencimento.setBanco(rs.getString("banco"));
				vencimento.setAgenciabanco(rs.getString("agenciabanco"));
				vencimento.setDigagencia(rs.getString("digagencia"));
				vencimento.setConta(rs.getString("conta"));
				vencimento.setAgendar(rs.getDate("agendar"));

				lista.add(vencimento);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

}
