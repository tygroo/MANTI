package fr.apside.sbik.view.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.springframework.stereotype.Component;

import fr.apside.sbik.entity.UserRole;
import fr.apside.sbik.view.user.UserView;

@Component
public class UserRoleConverter implements Converter {

  @Override
  public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
    if (value != null && value.trim().length() > 0) {
      try {
        UserView userView = (UserView) fc.getViewRoot().getViewMap().get("userView");
        fc.getViewRoot().getViewMap();
        for (UserRole userRole : userView.getRoles()) {
          if (value != null && userRole.getId() == Long.parseLong(value))
            return userRole;
        }
        throw new ConverterException(new FacesMessage(
          FacesMessage.SEVERITY_ERROR, "Conversion Error",
          "Not a valid userRole."));
      } catch (NumberFormatException e) {
        throw new ConverterException(new FacesMessage(
          FacesMessage.SEVERITY_ERROR, "Conversion Error",
          "Not a valid userRole."));
      }
    } else {
      return null;
    }
  }

  @Override
  public String getAsString(FacesContext fc, UIComponent uic, Object object) {
    if (object != null) {
      return String.valueOf(((UserRole) object).getId());
    } else {
      return null;
    }
  }

}
