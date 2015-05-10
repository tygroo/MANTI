package fr.apside.sbik.view.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.springframework.stereotype.Component;

import fr.apside.sbik.entity.Applicability;
import fr.apside.sbik.view.parameter.ParameterView;

@Component
public class ApplicabilityConverter implements Converter {

  @Override
  public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
    if (value != null && value.trim().length() > 0) {
      try {
        ParameterView parameterView = (ParameterView) fc.getViewRoot().getViewMap().get("parameterView");
        for (Applicability applicability : parameterView.getApplicabilities()) {
          if (value != null
            && applicability.getId() == Long.parseLong(value))
            return applicability;
        }
        throw new ConverterException(new FacesMessage(
          FacesMessage.SEVERITY_ERROR, "Conversion Error",
          "Not a valid applicability."));
      } catch (NumberFormatException e) {
        throw new ConverterException(new FacesMessage(
          FacesMessage.SEVERITY_ERROR, "Conversion Error",
          "Not a valid applicability."));
      }
    } else {
      return null;
    }
  }

  @Override
  public String getAsString(FacesContext fc, UIComponent uic, Object object) {
    if (object != null) {
      return String.valueOf(((Applicability) object).getId());
    } else {
      return null;
    }
  }

}
