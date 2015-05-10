package fr.apside.sbik.view.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.springframework.stereotype.Component;

import fr.apside.sbik.entity.Room;
import fr.apside.sbik.view.parameter.ParameterView;

@Component
public class RoomConverter implements Converter {

  @Override
  public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
    if (value != null && value.trim().length() > 0) {
      try {
        ParameterView parameterView = (ParameterView) fc.getViewRoot().getViewMap().get("parameterView");
        for (Room room : parameterView.getRooms()) {
          if (value != null && room.getId() == Long.parseLong(value))
            return room;
        }
        throw new ConverterException(new FacesMessage(
          FacesMessage.SEVERITY_ERROR, "Conversion Error",
          "Not a valid room."));
      } catch (NumberFormatException e) {
        throw new ConverterException(new FacesMessage(
          FacesMessage.SEVERITY_ERROR, "Conversion Error",
          "Not a valid room."));
      }
    } else {
      return null;
    }
  }

  @Override
  public String getAsString(FacesContext fc, UIComponent uic, Object object) {
    if (object != null) {
      return String.valueOf(((Room) object).getId());
    } else {
      return null;
    }
  }

}
