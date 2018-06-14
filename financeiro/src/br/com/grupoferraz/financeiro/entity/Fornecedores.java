package br.com.grupoferraz.financeiro.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Fornecedores {
	private String nome;
	private String cpf;
	private Date dtnascimento;
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
	private String codigodes;
	private Integer grupofornecedores_codigo;
	private String rg;
	private String contabil;
	private String banco;
	private String tipoconta;
	private int agenciabanco;
	private int digagencia;
	private int conta;
	private int digconta;
	private String nomefantasia;
	private int febraban;
	private int inscmunicipio;
	private String prestadorserv;
	private String icms;
	private String ipi;
	private int codigopais;
	private String inss;
	private BigDecimal aliquota;
	private String docidex;
	private String descricao;
	private Date data_cadastro;
	private GrupoFornecedores grupofornecedores;
	
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
	public Date getDtnascimento() {
		return dtnascimento;
	}
	public void setDtnascimento(Date dtnascimento) {
		this.dtnascimento = dtnascimento;
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
	public String getCodigodes() {
		return codigodes;
	}
	public void setCodigodes(String codigodes) {
		this.codigodes = codigodes;
	}
	public Integer getGrupofornecedores_codigo() {
		return grupofornecedores_codigo;
	}
	public void setGrupofornecedores_codigo(Integer grupofornecedores_codigo) {
		this.grupofornecedores_codigo = grupofornecedores_codigo;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getContabil() {
		return contabil;
	}
	public void setContabil(String contabil) {
		this.contabil = contabil;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public String getTipoconta() {
		return tipoconta;
	}
	public void setTipoconta(String tipoconta) {
		this.tipoconta = tipoconta;
	}
	public int getAgenciabanco() {
		return agenciabanco;
	}
	public void setAgenciabanco(int agenciabanco) {
		this.agenciabanco = agenciabanco;
	}
	public int getDigagencia() {
		return digagencia;
	}
	public void setDigagencia(int digagencia) {
		this.digagencia = digagencia;
	}
	public int getConta() {
		return conta;
	}
	public void setConta(int conta) {
		this.conta = conta;
	}
	public int getDigconta() {
		return digconta;
	}
	public void setDigconta(int digconta) {
		this.digconta = digconta;
	}
	public String getNomefantasia() {
		return nomefantasia;
	}
	public void setNomefantasia(String nomefantasia) {
		this.nomefantasia = nomefantasia;
	}
	public int getFebraban() {
		return febraban;
	}
	public void setFebraban(int febraban) {
		this.febraban = febraban;
	}
	public int getInscmunicipio() {
		return inscmunicipio;
	}
	public void setInscmunicipio(int inscmunicipio) {
		this.inscmunicipio = inscmunicipio;
	}
	public String getPrestadorserv() {
		return prestadorserv;
	}
	public void setPrestadorserv(String prestadorserv) {
		this.prestadorserv = prestadorserv;
	}
	public String getIcms() {
		return icms;
	}
	public void setIcms(String icms) {
		this.icms = icms;
	}
	public String getIpi() {
		return ipi;
	}
	public void setIpi(String ipi) {
		this.ipi = ipi;
	}
	public int getCodigopais() {
		return codigopais;
	}
	public void setCodigopais(int codigopais) {
		this.codigopais = codigopais;
	}
	public String getInss() {
		return inss;
	}
	public void setInss(String inss) {
		this.inss = inss;
	}
	public BigDecimal getAliquota() {
		return aliquota;
	}
	public void setAliquota(BigDecimal aliquota) {
		this.aliquota = aliquota;
	}
	public String getDocidex() {
		return docidex;
	}
	public void setDocidex(String docidex) {
		this.docidex = docidex;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getData_cadastro() {
		return data_cadastro;
	}
	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}
	
	public GrupoFornecedores getGrupofornecedores() {
		return grupofornecedores;
	}
	public void setGrupofornecedores(GrupoFornecedores grupofornecedores) {
		this.grupofornecedores = grupofornecedores;
	}
	
}
