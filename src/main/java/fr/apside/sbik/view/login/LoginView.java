package fr.apside.sbik.view.login;

import java.io.IOException;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class LoginView {
  @Autowired
  private Environment environnement;

  private String username;
  private String password;
  private String display_version;

  @PostConstruct
  public void init() {
   
    display_version = environnement.getProperty("manti.version");
  }

  public String login() {
    return "";
  }

  public void checkError()
  {
    FacesContext context = FacesContext.getCurrentInstance();
    Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
    String error = paramMap.get("error");

    if (null != error && error.equals("fail")) {
      FacesContext.getCurrentInstance().addMessage(null,
        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error !", "Bad login / password"));
    }
  }

  /**
   * Method called on logout
   * 
   * @throws IOException
   */
  public void logout() throws IOException {
    FacesContext fctx = FacesContext.getCurrentInstance();
    ExternalContext ectx = fctx.getExternalContext();
    ectx.redirect(ectx.getRequestContextPath());
    SecurityContextHolder.getContext().setAuthentication(null);
    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Déconnecté", ""));
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * @return the display_version
   */
  public String getDisplay_version() {
    return display_version;
  }

  /**
   * @param display_version the display_version to set
   */
  public void setDisplay_version(String display_version) {
    this.display_version = display_version;
  }
}
