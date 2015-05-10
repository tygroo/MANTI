package fr.apside.sbik.view.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.springframework.stereotype.Component;

import fr.apside.sbik.entity.RequirementType;
import fr.apside.sbik.view.parameter.ParameterView;

@Component
public class RequirementTypeConverter implements Converter {

  @Override
  public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
    if (value != null && value.trim().length() > 0) {
      try {
        ParameterView parameterView = (ParameterView) fc.getViewRoot().getViewMap().get("parameterView");
        for (RequirementType requirementType : parameterView.getRequirementTypes()) {
          if (value != null && requirementType.getId() == Long.parseLong(value))
            return requirementType;
        }
        throw new ConverterException(new FacesMessage(
          FacesMessage.SEVERITY_ERROR, "Conversion Error",
          "Not a valid requirement type."));
      } catch (NumberFormatException e) {
        throw new ConverterException(new FacesMessage(
          FacesMessage.SEVERITY_ERROR, "Conversion Error",
          "Not a valid requirement type."));
      }
    } else {
      return null;
    }
  }

  @Override
  public String getAsString(FacesContext fc, UIComponent uic, Object object) {
    if (object != null) {
      return String.valueOf(((RequirementType) object).getId());
    } else {
      return null;
    }
  }

}
