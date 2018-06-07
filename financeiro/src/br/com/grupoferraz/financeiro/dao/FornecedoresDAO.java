package br.com.grupoferraz.financeiro.dao;

import br.com.grupoferraz.financeiro.entity.Fornecedores;
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

public class FornecedoresDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean salvar(Fornecedores fornecedores) {
		try {
			PreparedStatement ps = conexao.prepareCall("INSERT INTO `financeiro`.`fornecedores`\r\n" + "(`nome`,\r\n"
					+ "`cpf`,\r\n" + "`dtnascimento`,\r\n" + "`logradouro`,\r\n" + "`num`,\r\n" + "`com`,\r\n"
					+ "`bairro`,\r\n" + "`cep`,\r\n" + "`cidade`,\r\n" + "`estado`,\r\n" + "`ie`,\r\n"
					+ "`telefone`,\r\n" + "`celular`,\r\n" + "`fax`,\r\n" + "`email`,\r\n" + "`site`,\r\n"
					+ "`contato`,\r\n" + "`codigodes`,\r\n" + "`codigogf`,\r\n" + "`rg`,\r\n" + "`contabil`,\r\n"
					+ "`banco`,\r\n" + "`tipoconta`,\r\n" + "`agenciabanco`,\r\n" + "`digagencia`,\r\n" + "`conta`,\r\n"
					+ "`digconta`,\r\n" + "`nomefantasiaf`,\r\n" + "`febraban`,\r\n" + "`inscmunicipio`,\r\n"
					+ "`prestadorserv`,\r\n" + "`icms`,\r\n" + "`ipi`,\r\n" + "`codigopais`,\r\n" + "`inss`,\r\n"
					+ "`aliquota`,\r\n" + "`docidex`,\r\n"
					+ "`descricao`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)\r\n"
					+ "");
			ps.setString(1, fornecedores.getNome());
			ps.setString(2, fornecedores.getCpf());
			Date dataNascimento = fornecedores.getDtnascimento();
			long t = 0;
			if (dataNascimento != null ) {
				t = dataNascimento.getTime();	
			}
			ps.setDate(3, new java.sql.Date(t));
			ps.setString(4, fornecedores.getLogradouro());
			ps.setString(5, fornecedores.getNum());
			ps.setString(6, fornecedores.getCom());
			ps.setString(7, fornecedores.getBairro());
			ps.setString(8, fornecedores.getCep());
			ps.setString(9, fornecedores.getCidade());
			ps.setString(10, fornecedores.getEstado());
			ps.setString(11, fornecedores.getIe());
			ps.setString(12, fornecedores.getTelefone());
			ps.setString(13, fornecedores.getCelular());
			ps.setString(14, fornecedores.getFax());
			ps.setString(15, fornecedores.getEmail());
			ps.setString(16, fornecedores.getSite());
			ps.setString(17, fornecedores.getContato());
			ps.setString(18, fornecedores.getCodigodes());
			ps.setString(19, fornecedores.getCodigogf());
			ps.setString(20, fornecedores.getRg());
			ps.setString(21, fornecedores.getContabil());
			ps.setString(22, fornecedores.getBanco());
			ps.setString(23, fornecedores.getTipoconta());
			ps.setInt(24, fornecedores.getAgenciabanco());
			ps.setInt(25, fornecedores.getDigagencia());
			ps.setInt(26, fornecedores.getConta());
			ps.setInt(27, fornecedores.getDigconta());
			ps.setString(28, fornecedores.getNomefantasia());
			ps.setInt(29, fornecedores.getFebraban());
			ps.setInt(30, fornecedores.getInscmunicipio());
			ps.setString(31, fornecedores.getPrestadorserv());
			ps.setString(32, fornecedores.getIcms());
			ps.setString(33, fornecedores.getIpi());
			ps.setInt(34, fornecedores.getCodigopais());
			ps.setString(35, fornecedores.getInss());
			ps.setBigDecimal(36, fornecedores.getAliquota());
			ps.setString(37, fornecedores.getDocidex());
			ps.setString(38, fornecedores.getDescricao());
			ps.execute();
			return true;

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os fornecedoress cadastrados no banco de dados
	public List<Fornecedores> listFornecedores() {

		ArrayList<Fornecedores> lista = new ArrayList<Fornecedores>();

		java.sql.Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select * from fornecedores ";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				Fornecedores fornecedores = new Fornecedores();
				fornecedores.setNome(rs.getString(1));
				fornecedores.setCpf(rs.getString(2));
				fornecedores.setDtnascimento(rs.getDate(3));
				fornecedores.setLogradouro(rs.getString(4));
				fornecedores.setNum(rs.getString(5));
				fornecedores.setCom(rs.getString(6));
				fornecedores.setBairro(rs.getString(7));
				fornecedores.setCep(rs.getString(8));
				fornecedores.setCidade(rs.getString(9));
				fornecedores.setEstado(rs.getString(10));
				fornecedores.setIe(rs.getString(11));
				fornecedores.setTelefone(rs.getString(12));
				fornecedores.setCelular(rs.getString(13));
				fornecedores.setFax(rs.getString(14));
				fornecedores.setEmail(rs.getString(15));
				fornecedores.setSite(rs.getString(16));
				fornecedores.setContato(rs.getString(17));
				fornecedores.setCodigodes(rs.getString(18));
				fornecedores.setCodigogf(rs.getString(19));
				fornecedores.setRg(rs.getString(20));
				fornecedores.setContabil(rs.getString(21));
				fornecedores.setBanco(rs.getString(22));
				fornecedores.setTipoconta(rs.getString(23));
				fornecedores.setAgenciabanco(rs.getInt(24));
				fornecedores.setDigagencia(rs.getInt(25));
				fornecedores.setConta(rs.getInt(26));
				fornecedores.setDigconta(rs.getInt(27));
				fornecedores.setNomefantasia(rs.getString(28));
				fornecedores.setFebraban(rs.getInt(29));
				fornecedores.setInscmunicipio(rs.getInt(30));
				fornecedores.setPrestadorserv(rs.getString(31));
				fornecedores.setIcms(rs.getString(32));
				fornecedores.setIpi(rs.getString(33));
				fornecedores.setCodigopais(rs.getInt(34));
				fornecedores.setInss(rs.getString(35));
				fornecedores.setAliquota(rs.getBigDecimal(36));
				fornecedores.setDocidex(rs.getString(37));
				fornecedores.setDescricao(rs.getString(38));
				lista.add(fornecedores);
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
				// if (conexao != null) {
				// conexao.close();
				// }

			} catch (SQLException ex) {
				Logger lgr = Logger.getLogger(Connection.class.getName());
				lgr.log(Level.WARNING, ex.getMessage(), ex);
			}
		}
		return lista;
	}
}
