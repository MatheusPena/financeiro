package br.com.grupoferraz.financeiro.dao;

import br.com.grupoferraz.financeiro.entity.Fornecedor;
import br.com.grupoferraz.financeiro.entity.GrupoFornecedor;
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

public class FornecedorDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertFornecedores(Fornecedor fornecedores) {
		
		try {
			StringBuilder str = new StringBuilder();
			str.append("insert into fornecedor (nome, cpf, dtnascimento,"
					+ "logradouro, num, com, bairro, cep, "
					+ "cidade, estado, ie, telefone, celular, fax, email, "
					+ "site, contato, codigodes, grupofornecedor_codigo,  rg,"
					+ "contabil, banco, tipoconta, agenciabanco, digagencia, conta, "
					+ "digconta, nomefantasia, febraban, inscmunicipio,"
					+ "prestadorserv, icms, ipi, codigopais, inss, aliquota, docidex, descricao, data_cadastro)"
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			str.append("on duplicate key update nome = ?, cpf = ?, dtnascimento = ?, "
					+ "logradouro = ?, num = ?, com = ?, bairro = ?, cep = ?, cidade = ?, estado = ?, ie = ?, "
					+ "telefone = ?, celular = ?, fax = ?, email = ?,  site = ?, contato = ?, codigodes = ?, "
					+ "grupofornecedor_codigo = ?, rg = ?, contabil = ?, banco = ?, tipoconta = ?, agenciabanco = ?, "
					+ "digagencia = ?, conta = ?, digconta = ?, nomefantasia = ?, "
					+ "febraban = ?, inscmunicipio = ?, prestadorserv = ?, "
					+ "icms = ?, ipi = ?, codigopais = ?, inss = ?, aliquota = ?, docidex = ?, descricao = ?, data_cadastro = ?");
			
			PreparedStatement PreparedStatement = conexao.prepareStatement(str.toString());
			PreparedStatement.setString(1, fornecedores.getNome());
			PreparedStatement.setString(2, fornecedores.getCpf());
			Date dataNascimento = fornecedores.getDtnascimento();
			long t = 0;
			if (dataNascimento != null ) {
				t = dataNascimento.getTime();	
				PreparedStatement.setDate(3, new java.sql.Date(t));
			}
			PreparedStatement.setString(4, fornecedores.getLogradouro());
			PreparedStatement.setString(5, fornecedores.getNum());
			PreparedStatement.setString(6, fornecedores.getCom());
			PreparedStatement.setString(7, fornecedores.getBairro());
			PreparedStatement.setString(8, fornecedores.getCep());
			PreparedStatement.setString(9, fornecedores.getCidade());
			PreparedStatement.setString(10, fornecedores.getEstado());
			PreparedStatement.setString(11, fornecedores.getIe());
			PreparedStatement.setString(12, fornecedores.getTelefone());
			PreparedStatement.setString(13, fornecedores.getCelular());
			PreparedStatement.setString(14, fornecedores.getFax());
			PreparedStatement.setString(15, fornecedores.getEmail());
			PreparedStatement.setString(16, fornecedores.getSite());
			PreparedStatement.setString(17, fornecedores.getContato());
			PreparedStatement.setString(18, fornecedores.getCodigodes());
			PreparedStatement.setInt(19, fornecedores.getGrupofornecedor_codigo());
			PreparedStatement.setString(20, fornecedores.getRg());
			PreparedStatement.setString(21, fornecedores.getContabil());
			PreparedStatement.setString(22, fornecedores.getBanco());
			PreparedStatement.setString(23, fornecedores.getTipoconta());
			PreparedStatement.setInt(24, fornecedores.getAgenciabanco());
			PreparedStatement.setInt(25, fornecedores.getDigagencia());
			PreparedStatement.setInt(26, fornecedores.getConta());
			PreparedStatement.setInt(27, fornecedores.getDigconta());
			PreparedStatement.setString(28, fornecedores.getNomefantasia());
			PreparedStatement.setInt(29, fornecedores.getFebraban());
			PreparedStatement.setInt(30, fornecedores.getInscmunicipio());
			PreparedStatement.setString(31, fornecedores.getPrestadorserv());
			PreparedStatement.setString(32, fornecedores.getIcms());
			PreparedStatement.setString(33, fornecedores.getIpi());
			PreparedStatement.setInt(34, fornecedores.getCodigopais());
			PreparedStatement.setString(35, fornecedores.getInss());
			PreparedStatement.setBigDecimal(36, fornecedores.getAliquota());
			PreparedStatement.setString(37, fornecedores.getDocidex());
			PreparedStatement.setString(38, fornecedores.getDescricao());
			PreparedStatement.setDate(39, new java.sql.Date(new Date().getTime()));
			
			PreparedStatement.setString(40, fornecedores.getNome());
			PreparedStatement.setString(41, fornecedores.getCpf());
			PreparedStatement.setDate(42, new java.sql.Date(t));
			PreparedStatement.setString(43, fornecedores.getLogradouro());
			PreparedStatement.setString(44, fornecedores.getNum());
			PreparedStatement.setString(45, fornecedores.getCom());
			PreparedStatement.setString(46, fornecedores.getBairro());
			PreparedStatement.setString(47, fornecedores.getCep());
			PreparedStatement.setString(48, fornecedores.getCidade());
			PreparedStatement.setString(49, fornecedores.getEstado());
			PreparedStatement.setString(50, fornecedores.getIe());
			PreparedStatement.setString(51, fornecedores.getTelefone());
			PreparedStatement.setString(52, fornecedores.getCelular());
			PreparedStatement.setString(53, fornecedores.getFax());
			PreparedStatement.setString(54, fornecedores.getEmail());
			PreparedStatement.setString(55, fornecedores.getSite());
			PreparedStatement.setString(56, fornecedores.getContato());
			PreparedStatement.setString(57, fornecedores.getCodigodes());
			PreparedStatement.setInt(58, fornecedores.getGrupofornecedor_codigo());
			PreparedStatement.setString(59, fornecedores.getRg());
			PreparedStatement.setString(60, fornecedores.getContabil());
			PreparedStatement.setString(61, fornecedores.getBanco());
			PreparedStatement.setString(62, fornecedores.getTipoconta());
			PreparedStatement.setInt(63, fornecedores.getAgenciabanco());
			PreparedStatement.setInt(64, fornecedores.getDigagencia());
			PreparedStatement.setInt(65, fornecedores.getConta());
			PreparedStatement.setInt(66, fornecedores.getDigconta());
			PreparedStatement.setString(67, fornecedores.getNomefantasia());
			PreparedStatement.setInt(68, fornecedores.getFebraban());
			PreparedStatement.setInt(69, fornecedores.getInscmunicipio());
			PreparedStatement.setString(70, fornecedores.getPrestadorserv());
			PreparedStatement.setString(71, fornecedores.getIcms());
			PreparedStatement.setString(72, fornecedores.getIpi());
			PreparedStatement.setInt(73, fornecedores.getCodigopais());
			PreparedStatement.setString(74, fornecedores.getInss());
			PreparedStatement.setBigDecimal(75, fornecedores.getAliquota());
			PreparedStatement.setString(76, fornecedores.getDocidex());
			PreparedStatement.setString(77, fornecedores.getDescricao());
			PreparedStatement.setDate(78, new java.sql.Date(new Date().getTime()));
			PreparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		return false;

		}
	}

	// lista todos os fornecedoress cadastrados no banco de dados
	public List<Fornecedor> listFornecedores() {

		ArrayList<Fornecedor> lista = new ArrayList<Fornecedor>();

		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conexao.createStatement();
			String sql = "select nome, cpf, dtnascimento,"
					+ "logradouro, num, com, bairro, cep, "
					+ "cidade, estado, ie, telefone, celular, fax, email,"
					+ "site, contato, codigodes, grupofornecedor_codigo, rg,  "
					+ "contabil, banco, tipoconta, agenciabanco, digagencia, conta, "
					+ "digconta, nomefantasia, febraban, inscmunicipio," 
					+ "prestadorserv, icms, ipi, codigopais, inss, aliquota, "
					+ "docidex, descricao, data_cadastro from fornecedor";
			rs = st.executeQuery(sql);

			while (rs.next()) {			
				
				Fornecedor fornecedores = new Fornecedor();
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
				fornecedores.setGrupofornecedor_codigo(rs.getInt(19));
				Integer codigo = fornecedores.getGrupofornecedor_codigo();
				fornecedores.setGrupofornecedor(getFornecedores(codigo)); 
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
				fornecedores.setData_cadastro(rs.getDate(39));
				
				
				lista.add(fornecedores);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}
		
	
	public GrupoFornecedor getFornecedores(Integer codigo) {
		GrupoFornecedor grupoFornecedores = new GrupoFornecedor();
		
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		try {
			preparedStatement = conexao
					.prepareStatement ("select codigo, nome from grupo_fornecedor where codigo = ?");
			preparedStatement.setInt(1, codigo);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Integer cod = rs.getInt("codigo");
				String nome = rs.getString("nome");
				grupoFornecedores.setCodigo(cod);
				grupoFornecedores.setNome(nome);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
							
		
		return grupoFornecedores;
	}
	
}
