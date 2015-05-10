package fr.apside.sbik.view.parameter;

import java.util.List;
import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.apside.sbik.entity.Applicability;
import fr.apside.sbik.entity.Building;
import fr.apside.sbik.entity.ControlType;
import fr.apside.sbik.entity.Criticality;
import fr.apside.sbik.entity.Floor;
import fr.apside.sbik.entity.Link;
import fr.apside.sbik.entity.Maturity;
import fr.apside.sbik.entity.RequirementType;
import fr.apside.sbik.entity.Room;
import fr.apside.sbik.entity.TFE;
import fr.apside.sbik.entity.Unit;
import fr.apside.sbik.entity.Work;
import fr.apside.sbik.metier.service.IBusinessServiceApplicability;
import fr.apside.sbik.metier.service.IBusinessServiceBuilding;
import fr.apside.sbik.metier.service.IBusinessServiceControlType;
import fr.apside.sbik.metier.service.IBusinessServiceCriticality;
import fr.apside.sbik.metier.service.IBusinessServiceLink;
import fr.apside.sbik.metier.service.IBusinessServiceMaturity;
import fr.apside.sbik.metier.service.IBusinessServiceRequirementType;
import fr.apside.sbik.metier.service.IBusinessServiceUnit;
import fr.apside.sbik.metier.service.IBusinessServiceWork;
import fr.apside.sbik.util.Tools;

/**
 * Class which represent the project HMI. The scope of this class is View.
 * Instance of class is created every time the view is display in ihm
 */
@Component
@Scope("view")
public class GeneralParametersView {

  // Parameters lists
  private List<RequirementType> requirementTypes;
  private List<Criticality> criticalities;
  private List<Maturity> maturities;
  private List<Applicability> applicabilities;
  private List<Work> works;
  private List<Unit> units;
  private List<ControlType> controlTypes;

  private List<Building> buildings;

  private List<TFE> tfes;
  private List<Floor> floors;
  private List<Room> rooms;
  private List<Link> links;

  private RequirementType requirementType;
  private Criticality criticality;
  private Maturity maturity;
  private Applicability applicability;
  private Work work;
  private Unit unit;
  private Building building;
  private TFE tfe;
  private Floor floor;
  private Room room;
  private Link link;
  private ControlType controlType;

  private String parameter;
  private String valueParameter;
  private String selectedParameter;

  // Action variables
  private boolean editAction = false;
  private boolean createAction = false;
  private boolean editButtonsClickable = false;

  @Resource
  private IBusinessServiceRequirementType businessServiceRequirementType;
  @Resource
  private IBusinessServiceCriticality businessServiceCriticality;
  @Resource
  private IBusinessServiceMaturity businessServiceMaturity;
  @Resource
  private IBusinessServiceApplicability businessServiceApplicability;
  @Resource
  private IBusinessServiceBuilding businessServiceBuilding;
  @Resource
  private IBusinessServiceWork businessServiceWork;
  @Resource
  private IBusinessServiceUnit businessServiceUnit;
  @Resource
  private IBusinessServiceLink businessServiceLink;
  @Resource
  private IBusinessServiceControlType businessServiceControlType;

  /**
   * Initialize project list after the class instantiate
   */
  @PostConstruct
  public void init() {

    buildings = businessServiceBuilding.getAll();
    requirementTypes = businessServiceRequirementType.getAll();
    criticalities = businessServiceCriticality.getAll();
    maturities = businessServiceMaturity.getAll();
    applicabilities = businessServiceApplicability.getAll();
    works = businessServiceWork.getAll();
    units = businessServiceUnit.getAll();
    links = businessServiceLink.getAll();
    controlTypes = businessServiceControlType.getAll();

    requirementType = new RequirementType();
    criticality = new Criticality();
    maturity = new Maturity();
    applicability = new Applicability();
    work = new Work();
    unit = new Unit();
    building = new Building();
    tfe = new TFE();
    floor = new Floor();
    room = new Room();
    link = new Link();
    controlType = new ControlType();

    valueParameter = new String();
    parameter = new String();
  }

  /**
   * Create a new parameter
   */
  public void create() {
    if (parameter.equals("unit")) {
      if (null == unit) {
        unit = new Unit();
      }
      unit.setId(null);
      unit.setName(valueParameter);
      businessServiceUnit.add(unit);

    } else if (parameter.equals("link")) {
      if (null == link) {
        link = new Link();
      }
      link.setId(null);
      link.setName(valueParameter);
      businessServiceLink.add(link);

    } else if (parameter.equals("requirementType")) {
      if (null == requirementType) {
        requirementType = new RequirementType();
      }
      requirementType.setId(null);
      requirementType.setName(valueParameter);
      businessServiceRequirementType.add(requirementType);

    } else if (parameter.equals("work")) {
      if (null == work) {
        work = new Work();
      }
      work.setId(null);
      work.setName(valueParameter);
      businessServiceWork.add(work);

    } else if (parameter.equals("criticality")) {
      if (null == criticality) {
        criticality = new Criticality();
      }
      criticality.setId(null);
      criticality.setName(valueParameter);
      businessServiceCriticality.add(criticality);

    } else if (parameter.equals("maturity")) {
      if (null == maturity) {
        maturity = new Maturity();
      }
      maturity.setId(null);
      maturity.setName(valueParameter);
      businessServiceMaturity.add(maturity);

    } else if (parameter.equals("applicability")) {
      if (null == applicability) {
        applicability = new Applicability();
      }
      applicability.setId(null);
      applicability.setName(valueParameter);
      businessServiceApplicability.add(applicability);

    } else if (parameter.equals("controlType")) {
      if (null == controlType) {
        controlType = new ControlType();
      }
      controlType.setId(null);
      controlType.setName(valueParameter);
      businessServiceControlType.add(controlType);

    }
    init();
  }

  /**
   * Update the selected project
   */
  public void update() {
    try {

      if (parameter.equals("unit")) {
        unit.setName(valueParameter);
        unit = businessServiceUnit.update(unit);
      } else if (parameter.equals("link")) {
        link.setName(valueParameter);
        link = businessServiceLink.update(link);
      } else if (parameter.equals("requirementType")) {
        requirementType.setName(valueParameter);
        requirementType = businessServiceRequirementType.update(requirementType);
      } else if (parameter.equals("work")) {
        work.setName(valueParameter);
        work = businessServiceWork.update(work);
      } else if (parameter.equals("criticality")) {
        criticality.setName(valueParameter);
        criticality = businessServiceCriticality.update(criticality);
      } else if (parameter.equals("maturity")) {
        maturity.setName(valueParameter);
        maturity = businessServiceMaturity.update(maturity);
      } else if (parameter.equals("applicability")) {
        applicability.setName(valueParameter);
        applicability = businessServiceApplicability.update(applicability);
      } else if (parameter.equals("controlType")) {
        controlType.setName(valueParameter);
        controlType = businessServiceControlType.update(controlType);
      } else {
        Tools.addErrorMessage("The parmater does not exist");
      }

    } catch (Exception e) {
      if (e instanceof NullPointerException) {
        Tools.addErrorMessage("You must select a parameter");
      } else {
        Tools.addErrorMessage("The parameter " + parameter + " cannot be updated ");
      }
    } finally {
      init();
    }
  }

  /**
   * Delete the selected project
   */
  public void delete() {
    try {

      if (parameter.equals("unit")) {
        unit.setName(valueParameter);
        businessServiceUnit.delete(unit);
      } else if (parameter.equals("link")) {
        link.setName(valueParameter);
        businessServiceLink.delete(link);
      } else if (parameter.equals("requirementType")) {
        requirementType.setName(valueParameter);
        businessServiceRequirementType.delete(requirementType);
      } else if (parameter.equals("criticality")) {
        criticality.setName(valueParameter);
        businessServiceCriticality.delete(criticality);
      } else if (parameter.equals("maturity")) {
        maturity.setName(valueParameter);
        businessServiceMaturity.delete(maturity);
      } else if (parameter.equals("applicability")) {
        applicability.setName(valueParameter);
        businessServiceApplicability.delete(applicability);
      } else if (parameter.equals("controlType")) {
        controlType.setName(valueParameter);
        businessServiceControlType.delete(controlType);
      } else if (parameter.equals("work")) {
        work.setName(valueParameter);
        businessServiceWork.delete(work);
      }
    } catch (Exception e) {
      if (e instanceof NullPointerException) {
        Tools.addErrorMessage("You must select a parameter");
      } else {
        Tools.addErrorMessage("The parameter " + parameter + " is used in a project and cannot be deleted !");
      }
    }

    init();
  }

  /**
   * Create a new project object for the update. Method executed when the user
   * clic on the edit button.
   */
  public void edit() {
  }

  /**
   * Method call when the user click on a generalParameter button requirement button. Set
   * editAction and createAction to false.
   */
  public void viewAction() {
    editAction = false;
    createAction = false;
    parameter = selectedParameter;
  }

  /**
   * @param editAction the editAction to set
   */
  public void setEditAction(boolean editAction) {
    if (editAction) {
      createAction = false;

    }
    this.editAction = editAction;
    if (null != unit && parameter.equals("unit")) {
      valueParameter = unit.getName();
    } else if (null != link && parameter.equals("link")) {
      valueParameter = link.getName();
    } else if (null != requirementType && parameter.equals("requirementType")) {
      valueParameter = requirementType.getName();
    } else if (null != work && parameter.equals("work")) {
      valueParameter = work.getName();
    } else if (null != criticality && parameter.equals("criticality")) {
      valueParameter = criticality.getName();
    } else if (null != maturity && parameter.equals("maturity")) {
      valueParameter = maturity.getName();
    } else if (null != applicability && parameter.equals("applicability")) {
      valueParameter = applicability.getName();
    } else if (null != controlType && parameter.equals("controlType")) {
      valueParameter = controlType.getName();
    }
    /**
     * remplace this by a converteurs 
     */
    // if (null != unit.getId()){
    // valueParameter = businessServiceUnit.get(unit.getId()).getName();
    // }
    /*
     * if (null != requirementType.getId()){
     * valueParameter = businessServiceRequirementType.get(requirementType.getId()).getName();
     * }
     * if (null != work.getId()){
     * valueParameter = businessServiceWork.get(work.getId()).getName();
     * }
     */
  }

  /**
   * @return the createAction
   */
  public boolean isCreateAction() {
    return createAction;
  }

  /**
   * @param createAction the createAction to set
   */
  public void setCreateAction(boolean createAction) {
    if (createAction) {
      editAction = false;
      // parameter = "";
    }
    this.createAction = createAction;
  }

  /**
   * @return the editButtonsClickable
   */
  public boolean isEditButtonsClickable() {
    return editButtonsClickable;
  }

  /**
   * @param editButtonsClickable the editButtonsClickable to set
   */
  public void setEditButtonsClickable(boolean editButtonsClickable) {
    this.editButtonsClickable = editButtonsClickable;
  }

  /**
   * @return the requirementTypes
   */
  public List<RequirementType> getRequirementTypes() {
    return requirementTypes;
  }

  /**
   * @param requirementTypes the requirementTypes to set
   */
  public void setRequirementTypes(List<RequirementType> requirementTypes) {
    this.requirementTypes = requirementTypes;
  }

  /**
   * @return the criticalities
   */
  public List<Criticality> getCriticalities() {
    return criticalities;
  }

  /**
   * @param criticalities the criticalities to set
   */
  public void setCriticalities(List<Criticality> criticalities) {
    this.criticalities = criticalities;
  }

  /**
   * @return the maturities
   */
  public List<Maturity> getMaturities() {
    return maturities;
  }

  /**
   * @param maturities the maturities to set
   */
  public void setMaturities(List<Maturity> maturities) {
    this.maturities = maturities;
  }

  /**
   * @return the applicabilities
   */
  public List<Applicability> getApplicabilities() {
    return applicabilities;
  }

  /**
   * @param applicabilities the applicabilities to set
   */
  public void setApplicabilities(List<Applicability> applicabilities) {
    this.applicabilities = applicabilities;
  }

  /**
   * @return the works
   */
  public List<Work> getWorks() {
    return works;
  }

  /**
   * @param works the works to set
   */
  public void setWorks(List<Work> works) {
    this.works = works;
  }

  /**
   * @return the units
   */
  public List<Unit> getUnits() {
    return units;
  }

  /**
   * @param units the units to set
   */
  public void setUnits(List<Unit> units) {
    this.units = units;
  }

  /**
   * @return the buildings
   */
  public List<Building> getBuildings() {
    return buildings;
  }

  /**
   * @param buildings the buildings to set
   */
  public void setBuildings(List<Building> buildings) {
    this.buildings = buildings;
  }

  /**
   * @return the tfes
   */
  public List<TFE> getTfes() {
    return tfes;
  }

  /**
   * @param tfes the tfes to set
   */
  public void setTfes(List<TFE> tfes) {
    this.tfes = tfes;
  }

  /**
   * @return the floors
   */
  public List<Floor> getFloors() {
    return floors;
  }

  /**
   * @param floors the floors to set
   */
  public void setFloors(List<Floor> floors) {
    this.floors = floors;
  }

  /**
   * @return the rooms
   */
  public List<Room> getRooms() {
    return rooms;
  }

  /**
   * @param rooms the rooms to set
   */
  public void setRooms(List<Room> rooms) {
    this.rooms = rooms;
  }

  /**
   * @return the editAction
   */
  public boolean isEditAction() {
    return editAction;
  }

  /**
   * @return the parameter
   */
  public String getParameter() {
    return parameter;
  }

  /**
   * @param parameter the parameter to set
   */
  public void setParameter(String parameter) {
    this.parameter = parameter;
  }

  /**
   * @return the valueParameter
   */
  public String getValueParameter() {
    return valueParameter;
  }

  /**
   * @param valueParameter the valueParameter to set
   */
  public void setValueParameter(String valueParameter) {
    this.valueParameter = valueParameter;
  }

  /**
   * @return the selectedParameter
   */
  public String getSelectedParameter() {
    return selectedParameter;
  }

  /**
   * @param selectedParameter the selectedParameter to set
   */
  public void setSelectedParameter(String selectedParameter) {
    this.selectedParameter = selectedParameter;
  }

  /**
   * @return the requirementType
   */
  public RequirementType getRequirementType() {
    return requirementType;
  }

  /**
   * @param requirementType the requirementType to set
   */
  public void setRequirementType(RequirementType requirementType) {
    this.requirementType = requirementType;
  }

  /**
   * @return the criticality
   */
  public Criticality getCriticality() {
    return criticality;
  }

  /**
   * @param criticality the criticality to set
   */
  public void setCriticality(Criticality criticality) {
    this.criticality = criticality;
  }

  /**
   * @return the maturity
   */
  public Maturity getMaturity() {
    return maturity;
  }

  /**
   * @param maturity the maturity to set
   */
  public void setMaturity(Maturity maturity) {
    this.maturity = maturity;
  }

  /**
   * @return the work
   */
  public Work getWork() {
    return work;
  }

  /**
   * @param work the work to set
   */
  public void setWork(Work work) {
    this.work = work;
  }

  /**
   * @return the unit
   */
  public Unit getUnit() {
    return unit;
  }

  /**
   * @param unit the unit to set
   */
  public void setUnit(Unit unit) {
    this.unit = unit;
  }

  /**
   * @return the tfe
   */
  public TFE getTfe() {
    return tfe;
  }

  /**
   * @param tfe the tfe to set
   */
  public void setTfe(TFE tfe) {
    this.tfe = tfe;
  }

  /**
   * @return the floor
   */
  public Floor getFloor() {
    return floor;
  }

  /**
   * @param floor the floor to set
   */
  public void setFloor(Floor floor) {
    this.floor = floor;
  }

  /**
   * @return the room
   */
  public Room getRoom() {
    return room;
  }

  /**
   * @param room the room to set
   */
  public void setRoom(Room room) {
    this.room = room;
  }

  /**
   * @return the applicability
   */
  public Applicability getApplicability() {
    return applicability;
  }

  /**
   * @param applicability the applicability to set
   */
  public void setApplicability(Applicability applicability) {
    this.applicability = applicability;
  }

  /**
   * @return the building
   */
  public Building getBuilding() {
    return building;
  }

  /**
   * @param building the building to set
   */
  public void setBuilding(Building building) {
    this.building = building;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    GeneralParametersView that = (GeneralParametersView) o;
    return Objects.equals(editAction, that.editAction) &&
      Objects.equals(createAction, that.createAction) &&
      Objects.equals(editButtonsClickable, that.editButtonsClickable) &&
      Objects.equals(requirementTypes, that.requirementTypes) &&
      Objects.equals(criticalities, that.criticalities) &&
      Objects.equals(maturities, that.maturities) &&
      Objects.equals(applicabilities, that.applicabilities) &&
      Objects.equals(works, that.works) &&
      Objects.equals(units, that.units) &&
      Objects.equals(buildings, that.buildings) &&
      Objects.equals(tfes, that.tfes) &&
      Objects.equals(floors, that.floors) &&
      Objects.equals(rooms, that.rooms) &&
      Objects.equals(requirementType, that.requirementType) &&
      Objects.equals(criticality, that.criticality) &&
      Objects.equals(maturity, that.maturity) &&
      Objects.equals(applicability, that.applicability) &&
      Objects.equals(work, that.work) &&
      Objects.equals(unit, that.unit) &&
      Objects.equals(building, that.building) &&
      Objects.equals(tfe, that.tfe) &&
      Objects.equals(floor, that.floor) &&
      Objects.equals(room, that.room) &&
      Objects.equals(parameter, that.parameter) &&
      Objects.equals(valueParameter, that.valueParameter) &&
      Objects.equals(selectedParameter, that.selectedParameter) &&
      Objects.equals(businessServiceRequirementType, that.businessServiceRequirementType) &&
      Objects.equals(businessServiceCriticality, that.businessServiceCriticality) &&
      Objects.equals(businessServiceMaturity, that.businessServiceMaturity) &&
      Objects.equals(businessServiceApplicability, that.businessServiceApplicability) &&
      Objects.equals(businessServiceBuilding, that.businessServiceBuilding) &&
      Objects.equals(businessServiceWork, that.businessServiceWork) &&
      Objects.equals(businessServiceUnit, that.businessServiceUnit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requirementTypes, criticalities, maturities, applicabilities, works, units, buildings, tfes,
      floors, rooms, requirementType, criticality, maturity, applicability, work, unit, building, tfe, floor, room,
      parameter, valueParameter, selectedParameter, editAction, createAction, editButtonsClickable,
      businessServiceRequirementType, businessServiceCriticality, businessServiceMaturity,
      businessServiceApplicability, businessServiceBuilding, businessServiceWork, businessServiceUnit);
  }

  /**
   * @return the links
   */
  public List<Link> getLinks() {
    return links;
  }

  /**
   * @param links the links to set
   */
  public void setLinks(List<Link> links) {
    this.links = links;
  }

  /**
   * @return the link
   */
  public Link getLink() {
    return link;
  }

  /**
   * @param link the link to set
   */
  public void setLink(Link link) {
    this.link = link;
  }

  /**
   * @return the controlTypes
   */
  public List<ControlType> getControlTypes() {
    return controlTypes;
  }

  /**
   * @param controlTypes the controlTypes to set
   */
  public void setControlTypes(List<ControlType> controlTypes) {
    this.controlTypes = controlTypes;
  }

  /**
   * @return the controlType
   */
  public ControlType getControlType() {
    return controlType;
  }

  /**
   * @param controlType the controlType to set
   */
  public void setControlType(ControlType controlType) {
    this.controlType = controlType;
  }

}
