package fr.apside.sbik.view.parameter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.primefaces.context.RequestContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("view")
public class ManageParameterView {

  private String redirectPath = "/parameters/";

  /**
   * Initialization method for modal window
   * 
   * @return
   */
  private Map<String, Object> initialization() {
    Map<String, Object> options = new HashMap<String, Object>();
    options.put("modal", true);
    options.put("draggable", false);
    options.put("resizable", false);
    options.put("contentHeight", 320);
    options.put("includeViewParams", true);

    return options;
  }

  public void test() {
    Map<String, Object> options = initialization();

    RequestContext.getCurrentInstance().openDialog("/parameters/test", options, null);
  }

  public void manage(String window) {

    Map<String, Object> options = initialization();

    Map<String, List<String>> params = new HashMap<String, List<String>>();

    List<String> lstParams = new ArrayList<String>();

    lstParams.add(window);
    params.put("name", lstParams);
    String redirect = redirectPath + window;

    RequestContext.getCurrentInstance().openDialog(redirect, options, params);

  }

}
