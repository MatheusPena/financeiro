package br.com.grupoferraz.financeiro.dao;

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

import br.com.grupoferraz.financeiro.entity.Clientes;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class ClientesDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertUsuario(Clientes usuario) {

		// Statement st = null;
		// ResultSet rs = null;

		try {
			// st = con.createStatement();

			PreparedStatement preparedStatement = conexao
					.prepareStatement("insert into usuario (id, nome, cpf, logradouro, num, com, bairro, cep,"
							+ "cidade, estado, ie, telefone, celular, fax, email, "
							+ "site, contato, codigorec, codigogc, codigoac, codigorep, nomefantasia, rg, cpfcp, exterior, "
							+ "contabil, debito, nf, ident, docidex, insc, codigopais, iseninscr, inss, iss, indicadorie,"
							+ "descricao, data_cadastro, nascimento)"
							+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setInt(1, usuario.getId());
			preparedStatement.setString(2, usuario.getNome());
			preparedStatement.setString(3, usuario.getCpf());
			preparedStatement.setString(4, usuario.getNascimento());
			preparedStatement.setString(5, "" + usuario.getDescricao());
			preparedStatement.setDate(6, new java.sql.Date(new Date().getTime()));
			preparedStatement.setString(7, usuario.getLogradouro());
			preparedStatement.setString(8, usuario.getNum());
			preparedStatement.setString(9, usuario.getCom());
			preparedStatement.setString(10, usuario.getBairro());
			preparedStatement.setString(11, usuario.getCep());
			preparedStatement.setString(12, usuario.getCidade());
			preparedStatement.setString(13, usuario.getEstado());
			preparedStatement.setString(14, usuario.getIe());
			preparedStatement.setString(15, usuario.getTelefone());
			preparedStatement.setString(16, usuario.getCelular());
			preparedStatement.setString(17, usuario.getFax());
			preparedStatement.setString(18, usuario.getEmail());
			preparedStatement.setString(19, usuario.getSite());
			preparedStatement.setString(20, usuario.getContato());
			preparedStatement.setString(21, usuario.getCodigorec());
			preparedStatement.setString(22, usuario.getCodigogc());
			preparedStatement.setString(23, usuario.getCodigoac());
			preparedStatement.setString(24, usuario.getCodigorep());
			preparedStatement.setString(25, usuario.getNomefantasia());
			preparedStatement.setString(26, usuario.getRg());
			preparedStatement.setString(27, usuario.getCpfcp());
			preparedStatement.setString(28, usuario.getExterior());
			preparedStatement.setString(29, usuario.getContabil());
			preparedStatement.setString(30, usuario.getDebito());
			preparedStatement.setString(31, usuario.getNf());
			preparedStatement.setString(32, usuario.getIdent());
			preparedStatement.setString(33, usuario.getDocidex());
			preparedStatement.setString(34, usuario.getInsc());
			preparedStatement.setString(35, usuario.getCodigopais());
			preparedStatement.setString(36, usuario.getIseninscr());
			preparedStatement.setString(37, usuario.getInss());
			preparedStatement.setString(38, usuario.getIss());
			preparedStatement.setString(39, usuario.getIndicadorie());

			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os usuarios cadastrados no banco de dados
	public List<Clientes> listUsuarios() {

		ArrayList<Clientes> lista = new ArrayList<Clientes>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select * from usuario ";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				Clientes usuario = new Clientes();
				usuario.setId(rs.getInt(1));
				usuario.setNome(rs.getString(2));
				usuario.setCpf(rs.getString(3));
				usuario.setNascimento(rs.getString(4));
				usuario.setDescricao(rs.getString(5));
				usuario.setDataCadastro(rs.getDate(6));
				usuario.setLogradouro(rs.getString(7));
				usuario.setNum(rs.getString(8));
				usuario.setCom(rs.getString(9));
				usuario.setBairro(rs.getString(10));
				usuario.setCep(rs.getString(11));
				usuario.setCidade(rs.getString(12));
				usuario.setEstado(rs.getString(13));
				usuario.setIe(rs.getString(14));
				usuario.setTelefone(rs.getString(15));
				usuario.setCelular(rs.getString(16));
				usuario.setFax(rs.getString(17));
				usuario.setEmail(rs.getString(18));
				usuario.setSite(rs.getString(19));
				usuario.setContato(rs.getString(20));
				usuario.setCodigorec(rs.getString(21));
				usuario.setCodigogc(rs.getString(22));
				usuario.setCodigoac(rs.getString(23));
				usuario.setCodigorep(rs.getString(24));
				usuario.setNomefantasia(rs.getString(25));
				usuario.setRg(rs.getString(26));
				usuario.setCpfcp(rs.getString(27));
				usuario.setExterior(rs.getString(28));
				usuario.setContabil(rs.getString(29));
				usuario.setDebito(rs.getString(30));
				usuario.setNf(rs.getString(31));
				usuario.setIdent(rs.getString(32));
				usuario.setDocidex(rs.getString(33));
				usuario.setInsc(rs.getString(34));
				usuario.setCodigopais(rs.getString(35));
				usuario.setIseninscr(rs.getString(36));
				usuario.setInss(rs.getString(37));
				usuario.setIss(rs.getString(38));
				usuario.setIndicadorie(rs.getString(39));
				lista.add(usuario);
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
				if (conexao != null) {
					conexao.close();
				}

			} catch (SQLException ex) {
				Logger lgr = Logger.getLogger(Connection.class.getName());
				lgr.log(Level.WARNING, ex.getMessage(), ex);
			}
		}
		return lista;
	}

}
