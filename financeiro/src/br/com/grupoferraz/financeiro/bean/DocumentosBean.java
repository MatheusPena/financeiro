package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.DocumentosDAO;
import br.com.grupoferraz.financeiro.entity.Documentos;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class DocumentosBean implements Serializable {
	private Documentos documento;
	private List<Documentos> listadocumentos;

	public DocumentosBean() {
		setDocumento(new Documentos());
		listarDocumentos();
	}

	public String cadastraDocumentos() {

		ConexaoBD.getConexao();
		DocumentosDAO Documentos = new DocumentosDAO();
		if (Documentos.insertDocumentos(this.getDocumento())) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Documento cadastrado com sucesso!", "Sucesso!"));
			// JSFUtil.mostraMensagemSemFlash(FacesMessage.SEVERITY_INFO, "Empresa
			// cadastrado com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do Documento!", "Erro!"));

		}
		ConexaoBD.fecharConexao();
		setDocumento(new Documentos());

		return "";
	}

	public void listarDocumentos() {
		DocumentosDAO Documentos = new DocumentosDAO();
		setDocumentos(Documentos.listDocumentos());
	}

	public List<Documentos> getDocumentos() {
		return listadocumentos;
	}

	public void setDocumentos(List<Documentos> Documentos) {
		this.listadocumentos = Documentos;
	}

	public Documentos getDocumento() {
		return documento;
	}

	public void setDocumento(Documentos documento) {
		this.documento = documento;
	}

}
