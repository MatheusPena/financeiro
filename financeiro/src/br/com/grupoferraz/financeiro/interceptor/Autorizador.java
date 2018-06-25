package br.com.grupoferraz.financeiro.interceptor;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.grupoferraz.financeiro.bean.LoginBean;

public class Autorizador implements PhaseListener{

	/**
	 * 
	 */
	//Classe Registrada...
	//...Vide faces-config.xml
	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent event) {
		
		FacesContext context = event.getFacesContext(); // PEGA O EVENTO DA FASE
														// (DEPOIS)
		String pagina = context.getViewRoot().getViewId();
		if ("/login.xhtml".equals(pagina)){
			return;
		}

		//Obtém a instância da memória do managedBean que contém o potencial usuário
		LoginBean login = context.getApplication().evaluateExpressionGet(context, "#{loginBean}", LoginBean.class);

		//Se o usuário não estiver logado (isLogado()) a navegação implícita retorna para 
		//a tela de login
		if(!login.isLogado()){
			NavigationHandler handler = context.getApplication().getNavigationHandler();
			handler.handleNavigation(context, null, "login?faces-redirect=true");
			context.renderResponse();
		}
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		
	}

	@Override
	public PhaseId getPhaseId() {
		 return PhaseId.RESTORE_VIEW;
	}

}
