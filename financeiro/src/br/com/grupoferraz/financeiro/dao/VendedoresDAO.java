package br.com.grupoferraz.financeiro.dao;

import br.com.grupoferraz.financeiro.entity.Vendedores;
import br.com.grupoferraz.financeiro.util.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendedoresDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean salvar(Vendedores vendedores) {
		try {
			PreparedStatement ps = conexao.prepareCall(
					"INSERT INTO `financeiro`.`vendedores` (`pessoa`,`cpfcnpj`,`nome`,`dtnascimento`,`chave`,`rg`,`emissor`,`sexo`,`estadocivil`,`agencia`,`rua`,`cep`,`numero`,`bairro`,`cidade`,`uf`,`complemento`,`email`,`telefone`,`cel1`,`cel2`,`banco`,`tipoconta`,`agenciabanco`,`digagencia`,`conta`,`digconta`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)\r\n"
							+ "");
			ps.setString(1, vendedores.getPessoa());
			ps.setString(2, vendedores.getCpf());
			ps.setString(3, vendedores.getNome());
			Date data = vendedores.getData();
			long t = 0;
			if (data != null ) {
				t = data.getTime();	
			}
			ps.setDate(4,new java.sql.Date(t));
			ps.setString(5, vendedores.getChave());
			ps.setString(6, vendedores.getRg());
			ps.setString(7, vendedores.getEmissor());
			ps.setString(8, vendedores.getSexo());
			ps.setString(9, vendedores.getEstado_civil());
			ps.setString(10, vendedores.getAgencia());
			ps.setString(11, vendedores.getRua());
			ps.setString(12, vendedores.getCep());
			ps.setInt(13, vendedores.getNumero());
			ps.setString(14, vendedores.getBairro());
			ps.setString(15, vendedores.getCidade());
			ps.setString(16, vendedores.getUf());
			ps.setString(17, vendedores.getComplemento());
			ps.setString(18, vendedores.getEmail());
			ps.setString(19, vendedores.getTelefone());
			ps.setString(20, vendedores.getCel1());
			ps.setString(21, vendedores.getCel2());
			ps.setString(22, vendedores.getBanco());
			ps.setString(23, vendedores.getTipo_conta());
			ps.setInt(24, vendedores.getAgenciabanco());
			ps.setInt(25, vendedores.getDigagencia());
			ps.setInt(26, vendedores.getConta());
			ps.setInt(27, vendedores.getDigconta());
			ps.execute();
			return true;
			
		}  catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os vendedoress cadastrados no banco de dados
	public List<Vendedores> listVendedores() {

		ArrayList<Vendedores> lista = new ArrayList<Vendedores>();

		java.sql.Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select * from vendedores ";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				Vendedores vendedores = new Vendedores();
				vendedores.setPessoa(rs.getString(1));
				vendedores.setCpf(rs.getString(2));
				vendedores.setNome(rs.getString(3));
				vendedores.setData(rs.getDate(4));
				vendedores.setChave(rs.getString(5));
				vendedores.setRg(rs.getString(6));
				vendedores.setEmissor(rs.getString(7));
				vendedores.setSexo(rs.getString(8));
				vendedores.setEstado_civil(rs.getString(9));
				vendedores.setAgencia(rs.getString(10));
				vendedores.setRua(rs.getString(11));
				vendedores.setCep(rs.getString(12));
				vendedores.setNumero(rs.getInt(13));
				vendedores.setBairro(rs.getString(14));
				vendedores.setCidade(rs.getString(15));
				vendedores.setUf(rs.getString(16));
				vendedores.setComplemento(rs.getString(17));
				vendedores.setEmail(rs.getString(18));
				vendedores.setTelefone(rs.getString(19));
				vendedores.setCel1(rs.getString(20));
				vendedores.setCel2(rs.getString(21));
				vendedores.setBanco(rs.getString(22));
				vendedores.setTipo_conta(rs.getString(23));
				vendedores.setAgenciabanco(rs.getInt(24));
				vendedores.setDigagencia(rs.getInt(25));
				vendedores.setConta(rs.getInt(26));
				vendedores.setDigconta(rs.getInt(27));
				lista.add(vendedores);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
//				if (conexao != null) {
//					conexao.close();
//				}

			} catch (SQLException ex) {
				Logger lgr = Logger.getLogger(Connection.class.getName());
				lgr.log(Level.WARNING, ex.getMessage(), ex);
			}
		}
		return lista;
	}

}
