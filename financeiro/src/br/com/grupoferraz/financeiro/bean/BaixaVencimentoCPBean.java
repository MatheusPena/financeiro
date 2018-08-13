package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.com.grupoferraz.financeiro.dao.BaixaVencimentoCPDAO;
import br.com.grupoferraz.financeiro.dao.ContaPagarDAO;
import br.com.grupoferraz.financeiro.entity.BaixaVencimentoCP;
import br.com.grupoferraz.financeiro.entity.ContaPagar;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class BaixaVencimentoCPBean implements Serializable {
	private BaixaVencimentoCP Baixa;
	private List<BaixaVencimentoCP> Listabaixas;

	public BaixaVencimentoCPBean() {
		Baixa = new BaixaVencimentoCP();
		listarBaixa();
	}

	public String cadastraBaixa() {

		BaixaVencimentoCPDAO BaixaCPDAO = new BaixaVencimentoCPDAO();
		if (BaixaCPDAO.insertBaixaCP(Baixa)) {
			JSFUtil.mostraMensagem(FacesMessage.SEVERITY_INFO, "Baixa cadastrada com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro da baixa!", "Erro!"));
		return "";
		}
		Baixa = new BaixaVencimentoCP();

		return "cadastro_baixavencimentocp?faces-redirect=true";
	}
	
//	Autocomplete referente à Conta Pagar
	public List<ContaPagar> completeConta(String query) {
		ContaPagarDAO contapagarDAO = new ContaPagarDAO();

		return contapagarDAO.listapagar(query);
	}

	public void selecionarConta() {
		
		ContaPagar contapagar = Baixa.getContapagar(); 
		
		if (contapagar != null) {
			Baixa.setConta_codigo(contapagar.getCodigocp());
			Baixa.setConta_nome(contapagar.getContapagar_nome());
			Baixa.setCpf(contapagar.getCpf());
			Baixa.setEmissaocp(contapagar.getEmissaocp());
			Baixa.setContafinanceira_codigo(contapagar.getContafinanceira_codigo());
			Baixa.setEstfinanceira(contapagar.getEstabelecimento_nome());	
			Baixa.setVencimentocp(contapagar.getVencimento().getVencimento());
			Baixa.setVencimentovalor(contapagar.getVencimento().getValor());
			Baixa.setNumerotitulo(contapagar.getVencimento().getTitulo());
		}
	}
	
//	Getters e Setters	
	public void listarBaixa() {
		BaixaVencimentoCPDAO BaixaCPDAO = new BaixaVencimentoCPDAO();
		setListabaixas(BaixaCPDAO.listBaixa());
	}

	public BaixaVencimentoCP getBaixa() {
		return Baixa;
	}

	public void setBaixa(BaixaVencimentoCP baixa) {
		Baixa = baixa;
	}

	public List<BaixaVencimentoCP> getListabaixas() {
		return Listabaixas;
	}

	public void setListabaixas(List<BaixaVencimentoCP> listabaixas) {
		Listabaixas = listabaixas;
	}


}
