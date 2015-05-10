package fr.apside.sbik.view.parameter;

import java.util.ArrayList;
import java.util.List;

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
import fr.apside.sbik.entity.Project;
import fr.apside.sbik.entity.Requirement;
import fr.apside.sbik.entity.RequirementType;
import fr.apside.sbik.entity.Room;
import fr.apside.sbik.entity.TFE;
import fr.apside.sbik.entity.Unit;
import fr.apside.sbik.entity.Work;
import fr.apside.sbik.metier.service.IBusinessServiceApplicability;
import fr.apside.sbik.metier.service.IBusinessServiceBuilding;
import fr.apside.sbik.metier.service.IBusinessServiceControlType;
import fr.apside.sbik.metier.service.IBusinessServiceCriticality;
import fr.apside.sbik.metier.service.IBusinessServiceFloor;
import fr.apside.sbik.metier.service.IBusinessServiceLink;
import fr.apside.sbik.metier.service.IBusinessServiceMaturity;
import fr.apside.sbik.metier.service.IBusinessServiceRequirementType;
import fr.apside.sbik.metier.service.IBusinessServiceRoom;
import fr.apside.sbik.metier.service.IBusinessServiceTFE;
import fr.apside.sbik.metier.service.IBusinessServiceUnit;
import fr.apside.sbik.metier.service.IBusinessServiceWork;
import fr.apside.sbik.util.Tools;

@Component
@Scope("view")
public class ParameterView {

  // Parameters lists
  private List<RequirementType> requirementTypes;
  private List<Criticality> criticalities;
  private List<Maturity> maturities;
  private List<Applicability> applicabilities;
  private List<Link> links;
  private List<Work> works;
  private List<Unit> units;
  private List<Building> buildings;
  private List<TFE> tfes;
  private List<Floor> floors;
  private List<Room> rooms;
  private List<ControlType> controlTypes;

  private Building building;
  private TFE tfe;
  private Floor floor;
  private Room room;

  private String parameter;
  private String valueParameter;
  private Project selectedProject;

  // Action variables
  private boolean editButtonsClickable = false;
  private boolean editAction = false;
  private boolean createAction = false;

  /** Boolean that indicates whether the setting has already been initialized **/
  private boolean initParam = false;

  @Resource
  private IBusinessServiceRequirementType businessServiceRequirementType;

  @Resource
  private IBusinessServiceCriticality businessServiceCriticality;

  @Resource
  private IBusinessServiceMaturity businessServiceMaturity;

  @Resource
  private IBusinessServiceApplicability businessServiceApplicability;

  @Resource
  private IBusinessServiceLink businessServiceLink;

  @Resource
  private IBusinessServiceBuilding businessServiceBuilding;

  @Resource
  private IBusinessServiceFloor businessServiceFloor;

  @Resource
  private IBusinessServiceRoom businessServiceRoom;

  @Resource
  private IBusinessServiceTFE businessServiceTFE;

  @Resource
  private IBusinessServiceWork businessServiceWork;

  @Resource
  private IBusinessServiceUnit businessServiceUnit;

  @Resource
  private IBusinessServiceControlType businessServiceControlType;

  @PostConstruct
  public void init() {
    // businessServiceRequirement.insertRequirements();
    selectedProject = Tools.getNavigationParam("selectedProject");
    if (selectedProject != null) {
      try {
        floors = new ArrayList<Floor>();
        rooms = new ArrayList<Room>();
        // buildings = new ArrayList<Building>(selectedProject.getBuildings());
        buildings = businessServiceBuilding.getBuildingsByProjectId(selectedProject.getId());

        // buildings.addAll(setBuil);

        // Initialization combobox building, floor, room TFE from the data of the selected requirement
        if (selectedProject == null) {
          Tools.addErrorMessage("A project must be selected");
        }

        if (null != building) {
          initFloorsAndTfe(building);
          if (null !=floor){
            initRooms(floor);
          }
         

          setEditAction(false);
          setCreateAction(false);
          parameter = "";
          valueParameter = "";
        }
      } catch (Exception e) {
        // Tools.addErrorMessage("The project parameters could not be loaded due to an unexpected error");
      }
    }

  }

  /**
   * Method that initializes the parameters needed to create and update a requirement.
   * This method also allows to load the parameters related to the requirement that has been selected (for update).
   * These lists are used to fill the combobox. 
   * 
   * @param selectedRequirement 
   * 			The selected requirement for his update. This parameter is null in case of requirement creation. 
   * @param createMode
   * 			Indicates whether this is a creation of requirement 
   */
  public void initParameter(Requirement selectedRequirement, boolean createMode) {
    try {
      if (!initParam) {
        // buildings = businessServiceBuilding.getAll();
        requirementTypes = businessServiceRequirementType.getAll();
        criticalities = businessServiceCriticality.getAll();
        maturities = businessServiceMaturity.getAll();
        applicabilities = businessServiceApplicability.getAll();
        links = businessServiceLink.getAll();
        works = businessServiceWork.getAll();
        units = businessServiceUnit.getAll();
        setControlTypes(businessServiceControlType.getAll());
        initParam = true;
      }
      // Initialization combobox building, floor, room TFE from the data of the selected requirement
      if (selectedRequirement != null && !createMode) {
        if (selectedRequirement.getBuilding() != null) {
          tfes = businessServiceTFE.getTFEsByBuildingId(selectedRequirement.getBuilding().getId());
          floors = businessServiceFloor.getFloorsByBuildingId(selectedRequirement.getBuilding().getId());
          if (selectedRequirement.getFloor() != null) {
            rooms = businessServiceRoom.getRoomsByFloorId(selectedRequirement.getFloor().getId());
          }
        }
      } else {
        tfes = new ArrayList<TFE>();
        floors = new ArrayList<Floor>();
        rooms = new ArrayList<Room>();
      }
    } catch (Exception e) {
      Tools.addErrorMessage("The project setting could not be loaded due to an unexpected error");
    }
  }

  public void initProjectParameter(Project projectSelct) {

    floors = new ArrayList<Floor>();
    rooms = new ArrayList<Room>();
    // buildings = new ArrayList<Building>(selectedProject.getBuildings());
    buildings = businessServiceBuilding.getBuildingsByProjectId(projectSelct.getId());

    // buildings.addAll(setBuil);

    // Initialization combobox building, floor, room TFE from the data of the selected requirement
    if (projectSelct != null) {
      Tools.addErrorMessage("A project must be selected");
    }
  }

  /**
   * Initilise lists of floors and tfe for the selected building.
   * The lists of room is initialized to empty
   * 
   * @param building
   * 		The building object selected in the combobox
   */
  public void initFloorsAndTfe(Building building) {
    tfes = businessServiceTFE.getTFEsByBuildingId(building.getId());
    floors = businessServiceFloor.getFloorsByBuildingId(building.getId());
    rooms = new ArrayList<Room>();
  }

  /**
   * @param editAction the editAction to set
   */
  public void setEditAction(boolean editAction) {
    if (editAction) {
      createAction = false;
    }
    this.editAction = editAction;

    if (null != building && parameter.equals("building")) {
      valueParameter = building.getName();
    } else if (null != floor && parameter.equals("floor")) {
      valueParameter = floor.getName();
    } else if (null != room && parameter.equals("room")) {
      valueParameter = room.getName();
    } else if (null != tfe && parameter.equals("tfe")) {
      valueParameter = tfe.getName();
    }
  }

  /**
   * @param createAction the createAction to set
   */
  public void setCreateAction(boolean createAction) {
    if (createAction) {
      editAction = false;
      // valueParameter = parameter ;
    }
    this.createAction = createAction;

  }

  public void updateParameter() {
    try {

      if (parameter.equals("floor")) {
        floor.setName(valueParameter);
        floor = businessServiceFloor.update(floor);
      } else if (parameter.equals("building")) {
        building.setName(valueParameter);
        building = businessServiceBuilding.update(building);
      } else if (parameter.equals("room")) {
        room.setName(valueParameter);
        room = businessServiceRoom.update(room);
      } else if (parameter.equals("tfe")) {
        tfe.setName(valueParameter);
        tfe = businessServiceTFE.update(tfe);
      } else {
        Tools.addErrorMessage("The parameter does not exist");
      }

    } catch (Exception e) {
      if (e instanceof NullPointerException) {
        Tools.addErrorMessage("You must select a parameter");
      } else {
        Tools.addErrorMessage("The parameter " + parameter + " cannot be updated ");
      }
    }
    init();
  }

  public void createParameter() {
    if (parameter.equals("building")) {
      if (null == building) {
        building = new Building();
        building.setProject(selectedProject);
      }
      building.setId(null);
      building.setName(valueParameter);
      businessServiceBuilding.add(building);

    } else if (parameter.equals("room")) {
      if (null != floor) {
        if (null == room) {
          room = new Room();
          room.setFloor(floor);
        }
        room.setId(null);
        room.setName(valueParameter);
        businessServiceRoom.add(room);
      } else {
        Tools.addErrorMessage("You must create or select a floor ");
      }

    } else if (parameter.equals("floor")) {
      if (null != building) {
        if (null == floor) {
          floor = new Floor();
          floor.setBuilding(building);
        }
        floor.setId(null);
        floor.setName(valueParameter);
        businessServiceFloor.add(floor);
      } else {
        Tools.addErrorMessage("You must create or select a building ");
      }

    } else if (parameter.equals("tfe")) {
      if (null != building) {
        if (null == tfe) {
          tfe = new TFE();
          tfe.setBuilding(building);
        }
        tfe.setId(null);
        tfe.setName(valueParameter);
        businessServiceTFE.add(tfe);
      } else {
        Tools.addErrorMessage("You must create or select a building ");
      }
    }
    init();
  }

  public void deleteParameter() {
    try {

      if (parameter.equals("building")) {
        building.setName(valueParameter);
        businessServiceBuilding.delete(building);
      } else if (parameter.equals("room")) {
        room.setName(valueParameter);
        businessServiceRoom.delete(room);
      } else if (parameter.equals("floor")) {
        floor.setName(valueParameter);
        businessServiceFloor.delete(floor);
      } else if (parameter.equals("tfe")) {
        tfe.setName(valueParameter);
        businessServiceTFE.delete(tfe);
      }
    } catch (Exception e) {
      if (e instanceof NullPointerException) {
        Tools.addErrorMessage("You must select a parameter");
      } else if (parameter.equals("floor") && !businessServiceRoom.getRoomsByFloorId(floor.getId()).isEmpty()) {
        Tools.addErrorMessage("The parameter " + parameter + " have a room and cannot be deleted !");
      } else if (parameter.equals("building") && (!businessServiceFloor.getFloorsByBuildingId(building.getId()).isEmpty() || !businessServiceTFE.getTFEsByBuildingId(building.getId()).isEmpty())) {
        Tools.addErrorMessage("The parameter " + parameter + " have a floor or a TFE and cannot be deleted !");
      }else {
        Tools.addErrorMessage("The parameter " + parameter + " is used in a project and cannot be deleted !");
      }
    }finally{
      init();
    }

  }

  /**
   * Initilise lists of rooms for the selected floor.
   * 
   * @param floor
   * 		The floor object selected in the combobox
   */
  public void initRooms(Floor floor) {
    rooms = businessServiceRoom.getRoomsByFloorId(floor.getId());
  }

  public List<RequirementType> getRequirementTypes() {
    return requirementTypes;
  }

  public void setRequirementTypes(List<RequirementType> requirementTypes) {
    this.requirementTypes = requirementTypes;
  }

  public List<Criticality> getCriticalities() {
    return criticalities;
  }

  public void setCriticalities(List<Criticality> criticalities) {
    this.criticalities = criticalities;
  }

  public List<Maturity> getMaturities() {
    return maturities;
  }

  public void setMaturities(List<Maturity> maturities) {
    this.maturities = maturities;
  }

  public List<Applicability> getApplicabilities() {
    return applicabilities;
  }

  public void setApplicabilities(List<Applicability> applicabilities) {
    this.applicabilities = applicabilities;
  }

  public List<Link> getLinks() {
    return links;
  }

  public void setLinks(List<Link> links) {
    this.links = links;
  }

  public List<Building> getBuildings() {
    return buildings;
  }

  public void setBuildings(List<Building> buildings) {
    this.buildings = buildings;
  }

  public List<TFE> getTfes() {
    return tfes;
  }

  public void setTfes(List<TFE> tfes) {
    this.tfes = tfes;
  }

  public List<Floor> getFloorss(Building building) {
    return floors;
  }

  public List<Floor> getFloors() {
    return floors;
  }

  public void setFloors(List<Floor> floors) {
    this.floors = floors;
  }

  public List<Room> getRooms() {
    return rooms;
  }

  public void setRooms(List<Room> rooms) {
    this.rooms = rooms;
  }

  public List<Work> getWorks() {
    return works;
  }

  public void setWorks(List<Work> works) {
    this.works = works;
  }

  public List<Unit> getUnits() {
    return units;
  }

  public void setUnits(List<Unit> units) {
    this.units = units;
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
   * @return the editAction
   */
  public boolean isEditAction() {
    return editAction;
  }

  /**
   * @return the createAction
   */
  public boolean isCreateAction() {
    return createAction;
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

  /**
   * @return the selectedProject
   */
  public Project getSelectedProject() {
    return selectedProject;
  }

  /**
   * @param selectedProject the selectedProject to set
   */
  public void setSelectedProject(Project selectedProject) {
    this.selectedProject = selectedProject;
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

}
