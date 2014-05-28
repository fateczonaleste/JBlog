package br.jblog.managedBeans;
 
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
 
@ManagedBean
public class NotificacaoMB {
     
    private String mensagem;
 
    public String getMensagem() {
        return mensagem;
    }
 
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
     
    public void saveMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("Atenção:", mensagem) );        
    }
}
