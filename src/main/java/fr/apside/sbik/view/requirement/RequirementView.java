package fr.apside.sbik.view.requirement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.primefaces.event.ToggleEvent;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;
import org.primefaces.model.Visibility;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.CannotCreateTransactionException;

import fr.apside.sbik.entity.Project;
import fr.apside.sbik.entity.Requirement;
import fr.apside.sbik.entity.User;
import fr.apside.sbik.metier.service.IBusinessServiceRequirement;
import fr.apside.sbik.util.Tools;

@Component
@Scope("view")
public class RequirementView {

  /** Requirement list **/
  private List<Requirement> requirements;
  /**
   * Filtered requirement list (When the user sorts or filters the requirement
   * list in the datatable)
   **/
  private List<Requirement> filteredRequirements;
  /** The project selected ont the previous screen **/
  private Project selectedProject;
  /** The Requirement selected in the datatable **/
  private Requirement selectedRequirement;
  /** Requirement key of the selected requirement **/
  private String selectedRequirementKey;
  
  private String fixJustification;
  

  // Action variables
  private boolean editAction = false;
  private boolean createAction = false;
  private boolean editButtonsClickable = false;
  private boolean enableRequirementView = true;

  /** Object requirement used for Udpate or create requirement **/
  private Requirement requirement = new Requirement();

  // For the filter list of datatable
  private List<String> filterBuildings = new ArrayList<String>();
  private List<String> filterTfes = new ArrayList<String>();
  private List<String> filterRooms = new ArrayList<String>();
  private List<String> filterRooms2 = new ArrayList<String>();
  private List<String> filterFloors = new ArrayList<String>();
  private List<String> filterWorks = new ArrayList<String>();
  private List<String> filterTypes = new ArrayList<String>();
  private List<String> filterCriticalities = new ArrayList<String>();
  private List<String> filterMaturities = new ArrayList<String>();
  private List<String> filterUnits = new ArrayList<String>();
  private List<String> filterApplicabilities = new ArrayList<String>();
  private List<String> filterLinks = new ArrayList<String>();
  private List<String> filterControlTypes = new ArrayList<String>();
  
  private List<Boolean> exportableList = new ArrayList<Boolean>();
  private List<Boolean> visibleList = new ArrayList<Boolean>();

  @Resource
  private IBusinessServiceRequirement businessServiceRequirement;

  /**
   * This method is called when the user select or deselect a row in the
   * requirement datatable. Activate the edit requirement button if a
   * requirement is selected or desactivate the edit button if a requirement
   * is not selected.
   */
  public void activateDesactivateEditButton() {
    if (selectedRequirement != null && enableRequirementView) {
      editButtonsClickable = true;
    } else {
      editButtonsClickable = false;
    }
  }

  /**
   * Initialize requirement list after the class instantiate.
   */
  @PostConstruct
  public void init() {
//    businessServiceRequirement.insertRequirements();
    
    /**
     * Is the number of parameters in the view
     */
    int listSize = 38;
    
    exportableList = new ArrayList<Boolean>(listSize);
    visibleList = new ArrayList<Boolean>(listSize);
    for(int i=1 ; i <= listSize; i++){
      exportableList.add(true);
      visibleList.add(true);
    }
    
    /**
     * Enable requirement view
     * Column FixRequirement (37) is hidden
     */
    if (this.isEnableRequirementView()){
      exportableList.set(37, false);
      visibleList.set(37, false);
    }
    
    fixJustification = new String();
    
    selectedProject = Tools.getNavigationParam("selectedProject");
    if (selectedProject != null) {
      try {
        if (this.isEnableRequirementView()){
          requirements = businessServiceRequirement.getActiveRequirementsByProjectId(selectedProject.getId());
        }else {
          requirements = businessServiceRequirement.getFixedRequirementsByProjectId(selectedProject.getId());
        }
      } catch (Exception e) {
        Tools.addErrorMessage("The list of requirements could not be loaded due to an unexpected error");
      }
    }
    initFilters();
    SortMeta sm1 = new SortMeta();
    sm1.setSortField("id");
    sm1.setSortOrder(SortOrder.DESCENDING);

  }

  /**
   * Initialize the data list that are used in the filters combobox.
   */
  public void initFilters() {
    if (requirements != null) {
      // Dump filter lists
      filterApplicabilities.clear();
      filterLinks.clear();
      filterBuildings.clear();
      filterCriticalities.clear();
      filterFloors.clear();
      filterMaturities.clear();
      filterWorks.clear();
      filterRooms.clear();
      filterRooms2.clear();
      filterTfes.clear();
      filterTypes.clear();
      filterUnits.clear();
      filterControlTypes.clear();
      // Filling filter list
      for (Requirement requirement : requirements) {
        if (requirement.getBuilding() != null) {
          String buildingName = requirement.getBuilding().getName();
          addDatatToFilterList(filterBuildings, buildingName);
        }
        if (requirement.getTfe() != null) {
          String tfeName = requirement.getTfe().getName();
          addDatatToFilterList(filterTfes, tfeName);
        }
        if (requirement.getRoom() != null) {
          String roomName = requirement.getRoom().getName();
          addDatatToFilterList(filterRooms, roomName);
        }
        if (requirement.getRoom2() != null) {
          String room2Name = requirement.getRoom2().getName();
          addDatatToFilterList(filterRooms2, room2Name);
        }
        if (requirement.getFloor() != null) {
          String floorName = requirement.getFloor().getName();
          addDatatToFilterList(filterFloors, floorName);
        }
        if (requirement.getWork() != null) {
          String workName = requirement.getWork().getName();
          addDatatToFilterList(filterWorks, workName);
        }
        if (requirement.getType() != null) {
          String typeName = requirement.getType().getName();
          addDatatToFilterList(filterTypes, typeName);
        }
        if (requirement.getCriticality() != null) {
          String criticalityName = requirement.getCriticality().getName();
          addDatatToFilterList(filterCriticalities, criticalityName);
        }
        if (requirement.getMaturity() != null) {
          String maturityName = requirement.getMaturity().getName();
          addDatatToFilterList(filterMaturities, maturityName);
        }
        if (requirement.getUnit() != null) {
          String unitName = requirement.getUnit().getName();
          addDatatToFilterList(filterUnits, unitName);
        }
        if (requirement.getApplicability() != null) {
          String applicabilityName = requirement.getApplicability().getName();
          addDatatToFilterList(filterApplicabilities, applicabilityName);
        }
        if (requirement.getLink() != null) {
          String linkName = requirement.getLink().getName();
          addDatatToFilterList(filterLinks, linkName);
        }
        if (requirement.getControlType() != null) {
          String controlTypeName = requirement.getControlType().getName();
          addDatatToFilterList(filterControlTypes, controlTypeName);
        }
      }
    }
  }

  /**
   * Method for adding a data to a list if it does not exist in the list.
   * 
   * @param list
   *            List to which the data is to be added
   * @param value
   *            The data to add to the list
   */
  private void addDatatToFilterList(List<String> list, String value) {
    if (!list.contains(value)) {
      list.add(value);
    }
  }

  /**
   * Method that is called when a filter is selected in the filter combobox.
   * Compare the data with the filter and return true if they are equals.
   * 
   * @param value
   *            Value of the data to compare the filter. This is the value of
   *            a cell in the table.
   * @param filter
   *            Array of the selected filters (A String array)
   * @param locale
   * @return A boolean indicating whether the cell data is in the filter
   *         array.
   */
  public boolean checkBoxFilter(Object value, Object filter, Locale locale) {
    String filterText = (filter == null) ? null : filter.toString()
      .trim();
    if (filterText == null || filterText.equals("")) {
      return true;
    }
    if (value == null) {
      return false;
    }
    String[] tabFilter = (String[]) filter;
    for (String id : tabFilter) {
      if (id.equals(value)) {
        return true;
      }
    }
    if (tabFilter.length == 0)
      return true;
    return false;
  }

  /**
   * Methode for call when toogle event on tooglerColumns
   * to fix the column's header 
   * to fix the excel exporter
   * 
   * @param e
   */
  public void onToggle(ToggleEvent e) {
    Integer idData = (Integer) e.getData();
    Boolean state = ((e.getVisibility() == Visibility.VISIBLE) ? true : false );
    
    exportableList.set(idData, state);
    visibleList.set(idData, state);
  }
  
  /**
   * Update the selected requirement
   */
  public void update() {
    try {
      Requirement bddRequirement = businessServiceRequirement.get(requirement.getId());
      if (requirement.equals(bddRequirement)) {
        Tools.addInfoMessage("No changes", "The requirement has not been updated, no changes made");
      } else if (null == requirement.getValue() || null == requirement.getMargin()) {
        Tools.addErrorMessage("The fields 'Value' and 'Margin' are required");
      } else {
        String finalValue = String.valueOf((Double.valueOf(requirement.getValue()) * Double.valueOf(requirement
          .getMargin())));
        requirement.setFinalValue(finalValue);

        requirement = businessServiceRequirement.update(requirement);
        requirements = businessServiceRequirement.getRequirementsByProjectId(selectedProject.getId());
        initFilters();
        Tools.addSuccessMessage("The requirement has been updated");
      }

    } catch (ObjectOptimisticLockingFailureException oolfe) {
      Tools.addErrorMessage("The requirement " + requirement.getName()
        + " could not be updated because someone else has modified it.");
      oolfe.printStackTrace();
      requirements = businessServiceRequirement.getRequirementsByProjectId(selectedProject.getId());
    } catch (CannotCreateTransactionException ccte) {
      Tools.addErrorMessage("The requirement " + requirement.getName()
        + " could not be updated because the application could not connect to the database.");
      ccte.printStackTrace();
    } catch (DataIntegrityViolationException dive) {
      Tools.addErrorMessage("The requirement " + requirement.getName()
        + " could not be updated because another item already exists with the same key.");
      dive.printStackTrace();
    } catch (Exception e) {
      Tools.addErrorMessage("The requirement " + requirement.getName()
        + " could not be updated due to an unexpected error.");
      e.printStackTrace();
    }
  }

  /**
   * Delete the selected requirement
   */
  public void delete() {
    try {
      //businessServiceRequirement.delete(selectedRequirement); //we don't deleted a requirement we fix it now
      selectedRequirement.setRequirement_fix(true);
      selectedRequirement.setFixJsutification(fixJustification);
      
      businessServiceRequirement.update(selectedRequirement);
      
      requirements.remove(selectedRequirement);
      initFilters();
      Tools.addSuccessMessage("The requirement has been removed");
    } catch (CannotCreateTransactionException ccte) {
      Tools.addErrorMessage("The requirement " + selectedRequirement.getName()
        + " could not be deleted because the application could not connect to the database.");
      ccte.printStackTrace();
    } catch (DataIntegrityViolationException dive) {
      Tools.addErrorMessage("The requirement " + selectedRequirement.getName()
        + " could not be deleted because it is referenced by other items.");
      dive.printStackTrace();
    } catch (Exception e) {
      Tools.addErrorMessage("The requirement " + selectedRequirement.getName()
        + " could not be deleted due to an unexpected error.");
      e.printStackTrace();
    }
  }

  /**
   * Create a new requirement
   */
  public void create() {
    Requirement requirementToCreate = null;
    try {
      if (null != requirement.getValue() && null != requirement.getMargin()) {
        String finalValue = String.valueOf((Double.valueOf(requirement.getValue()) * Double.valueOf(requirement
          .getMargin())));
        requirement.setFinalValue(finalValue);

        requirementToCreate = new Requirement(requirement);
        requirementToCreate.setProject(selectedProject);
        businessServiceRequirement.add(requirementToCreate);
        requirements.add(requirementToCreate);
        requirement = new Requirement();
        initFilters();
        Tools.addSuccessMessage("The requirement has been created");
      } else {
        Tools.addErrorMessage("The fields 'Value' and 'Margin' are required");
      }
    } catch (CannotCreateTransactionException ccte) {
      Tools.addErrorMessage("The requirement " + requirement.getName()
        + " could not be created because the application could not connect to the database.");
      ccte.printStackTrace();
    } catch (DataIntegrityViolationException dive) {
      Tools.addErrorMessage("The requirement " + requirement.getName()
        + " could not be created because another item already exists with the same key.");
      dive.printStackTrace();
    } catch (Exception e) {
      Tools.addErrorMessage("The requirement " + requirement.getName()
        + " could not be created due to an unexpected error.");
      e.printStackTrace();
    }
  }

  /**
   * Requirement key build. This method is used to display the title of the
   * requirement in the update window. This method is called each time a user
   * select a requirement (see setSelectedRequirement() method)
   */
  public void buildRequirementKey() {
    if (selectedRequirement != null) {
      this.selectedRequirementKey = new StringBuilder(selectedRequirement.getProject()
        .getName()).append("-")
        .append(selectedRequirement.getBuilding()
          .getName())
        .append("-")
        .append(selectedRequirement.getTfe()
          .getName())
        .append("-")
        .append(selectedRequirement.getRoom()
          .getName())
        .append("-")
        .append(selectedRequirement.getWork()
          .getName())
        .append("-")
        .append(selectedRequirement.getNumber())
        .append("-")
        .append(selectedRequirement.getSubnumber())
        .toString();
    }
  }

  /**
   * Method call when the user click on the view requirement button. Set
   * editAction and createAction to false.
   */
  public void viewAction() {
    editAction = false;
    createAction = false;
    requirement = selectedRequirement;
  }

  /**
   * Method call when the user click on the edit requirement button. Values
   * the editAction variable with the value passed in parameter. Update fields
   * that are not editable.
   * 
   * @param editAction
   */
  public void setEditAction(boolean editAction) {
    if (editAction) {
      createAction = false;
      requirement = new Requirement(selectedRequirement);
      updateNonEditableFields(requirement);
    }
    this.editAction = editAction;
  }

  /**
   * Method call when the user click on the create requirement button. Values
   * the createAction variable with the value passed in parameter. Update
   * fields that are not editable.
   * 
   * @param createAction
   */
  public void setCreateAction(boolean createAction) {
    if (createAction) {
      editAction = false;
      requirement = new Requirement();
      updateNonEditableFields(requirement);
    }
    this.createAction = createAction;
  }

  /**
   * 
   * @return
   */
  public Requirement getRequirement() {
    return requirement;
  }

  /**
   * 
   * @param requirement
   */
  public void setRequirement(Requirement requirement) {
    this.requirement = requirement;
  }

  /**
   * 
   * @param requirement
   */
  private void updateNonEditableFields(Requirement requirement) {
    requirement.setUpdateDate(new Date());
    User user = new User();
    user.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
    requirement.setUser(user);
  }

  public boolean isCreateAction() {
    return createAction;
  }

  public boolean isEditAction() {
    return editAction;
  }

  public List<Requirement> getFilteredRequirements() {
    return filteredRequirements;
  }

  public void setFilteredRequirements(List<Requirement> filteredRequirements) {
    this.filteredRequirements = filteredRequirements;
  }

  public List<String> getFilterBuildings() {
    return filterBuildings;
  }

  public void setFilterBuildings(List<String> filterBuildings) {
    this.filterBuildings = filterBuildings;
  }

  public List<String> getFilterTfes() {
    return filterTfes;
  }

  public void setFilterTfes(List<String> filterTfes) {
    this.filterTfes = filterTfes;
  }

  public List<String> getFilterRooms() {
    return filterRooms;
  }

  public void setFilterRooms(List<String> filterRooms) {
    this.filterRooms = filterRooms;
  }

  public List<String> getFilterRooms2() {
    return filterRooms2;
  }

  public void setFilterRooms2(List<String> filterRooms2) {
    this.filterRooms2 = filterRooms2;
  }

  public List<String> getFilterFloors() {
    return filterFloors;
  }

  public void setFilterFloors(List<String> filterFloors) {
    this.filterFloors = filterFloors;
  }

  public List<String> getFilterWorks() {
    return filterWorks;
  }

  public void setFilterWorks(List<String> filterWorks) {
    this.filterWorks = filterWorks;
  }

  public List<String> getFilterTypes() {
    return filterTypes;
  }

  public void setFilterTypes(List<String> filterTypes) {
    this.filterTypes = filterTypes;
  }

  public List<String> getFilterCriticalities() {
    return filterCriticalities;
  }

  public void setFilterCriticalities(List<String> filterCriticalities) {
    this.filterCriticalities = filterCriticalities;
  }

  public List<String> getFilterMaturities() {
    return filterMaturities;
  }

  public void setFilterMaturities(List<String> filterMaturities) {
    this.filterMaturities = filterMaturities;
  }

  public List<String> getFilterUnits() {
    return filterUnits;
  }

  public void setFilterUnits(List<String> filterUnits) {
    this.filterUnits = filterUnits;
  }

  public List<String> getFilterApplicabilities() {
    return filterApplicabilities;
  }

  public void setFilterApplicabilities(List<String> filterApplicabilities) {
    this.filterApplicabilities = filterApplicabilities;
  }

  public List<String> getFilterLinks() {
    return filterLinks;
  }

  public void setFilterLinks(List<String> filterLinks) {
    this.filterLinks = filterLinks;
  }

  public IBusinessServiceRequirement getBusinessServiceRequirement() {
    return businessServiceRequirement;
  }

  public void setBusinessServiceRequirement(IBusinessServiceRequirement businessServiceRequirement) {
    this.businessServiceRequirement = businessServiceRequirement;
  }

  public void setSelectedRequirementKey(String selectedRequirementKey) {
    this.selectedRequirementKey = selectedRequirementKey;
  }

  public boolean isEditButtonsClickable() {
    return editButtonsClickable;
  }

  public void setEditButtonsClickable(boolean editButtonsClickable) {
    this.editButtonsClickable = editButtonsClickable;
  }

  public List<Requirement> getRequirements() {
    return requirements;
  }

  public void setRequirements(List<Requirement> requirements) {
    this.requirements = requirements;
  }

  public Project getSelectedProject() {
    return selectedProject;
  }

  public void setSelectedProject(Project selectedProject) {
    this.selectedProject = selectedProject;
  }

  public Requirement getSelectedRequirement() {
    return selectedRequirement;
  }

  public void setSelectedRequirement(Requirement selectedRequirement) {
    this.selectedRequirement = selectedRequirement;
    buildRequirementKey();
  }

  public String getSelectedRequirementKey() {
    return selectedRequirementKey;
  }

  /**
   * @return the exportableList
   */
  public List<Boolean> getExportableList() {
    return exportableList;
  }

  /**
   * @param exportableList the exportableList to set
   */
  public void setExportableList(List<Boolean> exportableList) {
    this.exportableList = exportableList;
  }

  /**
   * @return the visibleList
   */
  public List<Boolean> getVisibleList() {
    return visibleList;
  }

  /**
   * @param visibleList the visibleList to set
   */
  public void setVisibleList(List<Boolean> visibleList) {
    this.visibleList = visibleList;
  }

  /**
   * @return the fixJustification
   */
  public String getFixJustification() {
    return fixJustification;
  }

  /**
   * @param fixJustification the fixJustification to set
   */
  public void setFixJustification(String fixJustification) {
    this.fixJustification = fixJustification;
  }

  /**
   * @return the filterControlTypes
   */
  public List<String> getFilterControlTypes() {
    return filterControlTypes;
  }

  /**
   * @param filterControlTypes the filterControlTypes to set
   */
  public void setFilterControlTypes(List<String> filterControlTypes) {
    this.filterControlTypes = filterControlTypes;
  }

  /**
   * @return the enableRequirementView
   */
  public boolean isEnableRequirementView() {
    return enableRequirementView;
  }

  /**
   * @param enableRequirementView the enableRequirementView to set
   */
  public void setEnableRequirementView(boolean enableRequirementView) {
    this.enableRequirementView = enableRequirementView;
  }

}
