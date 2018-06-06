package br.com.grupoferraz.financeiro.entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.faces.bean.ManagedBean;

@ManagedBean
@SuppressWarnings("serial")
public class Clientes implements Serializable {
 
	//private int id;
	private String nome;
	private String cpf;
	private Date dataCadastro;
	private Date nascimento;
	private String descricao;
	private String logradouro;
	private String num;
	private String com;
	private String bairro;
	private String cep;
	private String cidade;
	private String estado;
	private String ie;
	private String telefone;
	private String celular;
	private String fax;
	private String email;
	private String site;
	private String contato;
	private String codigorec;
	private String codigogc;
	private String codigorep;
	private String codigoac;
	private String nomefantasia;
	private String rg;
	private String cpfcp;
	private byte exterior;
	private String contabil; 
	private String debito;
	private String nf;
	private String ident;
	private String docidex;
	private String insc;
	private String codigopais;
	private String iseninscr;
	private String inss;
	private String iss;
	private BigDecimal aliquota;
	private String indicadorie;

	

	public byte getExterior() {
        return exterior;
    }
 
    public void setExterior(byte exterior) {
        this.exterior = exterior;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getCom() {
		return com;
	}

	public void setCom(String com) {
		this.com = com;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getIe() {
		return ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getCodigorec() {
		return codigorec;
	}

	public void setCodigorec(String codigorec) {
		this.codigorec = codigorec;
	}

	public String getCodigogc() {
		return codigogc;
	}

	public void setCodigogc(String codigogc) {
		this.codigogc = codigogc;
	}

	public String getCodigorep() {
		return codigorep;
	}

	public void setCodigorep(String codigorep) {
		this.codigorep = codigorep;
	}

	public String getCodigoac() {
		return codigoac;
	}

	public void setCodigoac(String codigoac) {
		this.codigoac = codigoac;
	}

	public String getNomefantasia() {
		return nomefantasia;
	}

	public void setNomefantasia(String nomefantasia) {
		this.nomefantasia = nomefantasia;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpfcp() {
		return cpfcp;
	}

	public void setCpfcp(String cpfcp) {
		this.cpfcp = cpfcp;
	}

	public String getContabil() {
		return contabil;
	}

	public void setContabil(String contabil) {
		this.contabil = contabil;
	}

	public String getDebito() {
		return debito;
	}

	public void setDebito(String debito) {
		this.debito = debito;
	}

	public String getNf() {
		return nf;
	}

	public void setNf(String nf) {
		this.nf = nf;
	}

	public String getIdent() {
		return ident;
	}

	public void setIdent(String ident) {
		this.ident = ident;
	}

	public String getDocidex() {
		return docidex;
	}

	public void setDocidex(String docidex) {
		this.docidex = docidex;
	}

	public String getInsc() {
		return insc;
	}

	public void setInsc(String insc) {
		this.insc = insc;
	}

	public String getCodigopais() {
		return codigopais;
	}

	public void setCodigopais(String codigopais) {
		this.codigopais = codigopais;
	}

	public String getIseninscr() {
		return iseninscr;
	}

	public void setIseninscr(String iseninscr) {
		this.iseninscr = iseninscr;
	}

	public String getInss() {
		return inss;
	}

	public void setInss(String inss) {
		this.inss = inss;
	}

	public String getIss() {
		return iss;
	}

	public void setIss(String iss) {
		this.iss = iss;
	}

	public BigDecimal getAliquota() {
		return aliquota;
	}

	public void setAliquota(BigDecimal aliquota) {
		this.aliquota = aliquota;
	}

	public String getIndicadorie() {
		return indicadorie;
	}

	public void setIndicadorie(String indicadorie) {
		this.indicadorie = indicadorie;
	}
	
	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	

	

}