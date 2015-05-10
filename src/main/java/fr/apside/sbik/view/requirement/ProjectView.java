package fr.apside.sbik.view.requirement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.context.FacesContext;

import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.CannotCreateTransactionException;

import fr.apside.sbik.entity.Building;
import fr.apside.sbik.entity.Floor;
import fr.apside.sbik.entity.Project;
import fr.apside.sbik.entity.Room;
import fr.apside.sbik.entity.TFE;
import fr.apside.sbik.metier.service.IBusinessServiceBuilding;
import fr.apside.sbik.metier.service.IBusinessServiceFloor;
import fr.apside.sbik.metier.service.IBusinessServiceProject;
import fr.apside.sbik.metier.service.IBusinessServiceRoom;
import fr.apside.sbik.metier.service.IBusinessServiceTFE;
import fr.apside.sbik.util.Tools;

/**
 * Class which represent the project HMI. The scope of this class is View.
 * Instance of class is created every time the view is display in ihm
 */
@Component
@Scope("view")
public class ProjectView {

  /** The project business service **/
  @Resource
  private IBusinessServiceProject businessServiceProject;

  @Resource
  private IBusinessServiceBuilding businessServiceBuilding;

  @Resource
  private IBusinessServiceFloor businessServiceFloor;

  @Resource
  private IBusinessServiceRoom businessServiceRoom;

  @Resource
  private IBusinessServiceTFE businessServiceTFE;

  /** The project list **/
  private List<Project> projects;
  /** The selected project into the data table **/
  private Project selectedProject;
  /** The project to create or update **/
  private Project project = new Project();

  // Action variables
  private boolean editButtonsClickable = false;
  private boolean editAction = false;
  private boolean createAction = false;

  private List<Building> buildings;
  private List<TFE> tfes;
  private List<Floor> floors;
  private List<Room> rooms;

  private Building building;
  private TFE tfe;
  private Floor floor;
  private Room room;
  
  private String parameter;
  private String valueParameter;
  


  /**
   * This method is called when the user select or deselect a row in the
   * requirement datatable. Activate the edit requirement button if a
   * requirement is selected or desactivate the edit button if a requirement
   * is not selected.
   */
  public void activateDesactivateEditButton() {
    building = new Building();
    floor = new Floor();
    tfe = new TFE();
    room = new Room();

    if (selectedProject != null) {
      setEditButtonsClickable(true);
    } else {
      setEditButtonsClickable(false);
    }
  }

  /**
   * Initialize project list after the class instantiate
   */
  @PostConstruct
  public void init() {
    valueParameter = new String();
    parameter = new String();
    
    try {
      projects = businessServiceProject.getAll();
      
    } catch (Exception e) {
      Tools.addErrorMessage("The list of projects could not be loaded due to an unexpected error");
    }
  }

  /**
   * Method which redirect on the requirementList of the selected project
   */
  public String showRequirementList() {
    Tools.setNavigationParam("selectedProject", selectedProject);
    return Tools.getUrlRedirectPage("/requirement/requirementList");
  }
  
  /**
   * Method which redirect on the projectList of the selected project
   */
  public String showProjectList() {
    return Tools.getUrlRedirectPage("/project/projectList");
  }

  /**
   * Method which redirect on the requirementList when double click on a
   * project
   * 
   * @throws IOException
   */
  public void showRequirementListOnDblClick() throws IOException {
    Tools.setNavigationParam("selectedProject", selectedProject);
    FacesContext.getCurrentInstance().getExternalContext().redirect("/requirement/requirementList.xhtml");
  }

  /**
   * Method which redirect on the requirementParameters of the selected project
   */
  public String showRequirementParameters() {
    Tools.setNavigationParam("selectedProject", selectedProject);
    return Tools.getUrlRedirectPage("/requirement/requirementList");
  }
  
  /**
   * Method which redirect on the projectParameters of the selected project
   */
  public String showProjectParameters() {
    Tools.setNavigationParam("selectedProject", selectedProject);
    return Tools.getUrlRedirectPage("/project/projectParameters");
  }

  /**
   * Create a new project
   */
  public void create() {
    try {
      Project projectToCreate = new Project(project);
      businessServiceProject.add(projectToCreate);
      projects.add(projectToCreate);
      Tools.addSuccessMessage("The project " + project.getName() + " has been created");
      project = new Project();
    } catch (CannotCreateTransactionException ccte) {
      Tools.addErrorMessage("The project " + project.getName()
        + " could not be created because the application could not connect to the database.");
      ccte.printStackTrace();
    } catch (DataIntegrityViolationException dive) {
      Tools.addErrorMessage("The project " + project.getName()
        + " could not be created because another item already exists with the same name.");
      dive.printStackTrace();
    } catch (Exception e) {
      Tools.addErrorMessage("The project " + project.getName() + " could not be created due to an unexpected error.");
      e.printStackTrace();
    }
  }

  /**
   * Update the selected project
   */
  public void update() {
    try {
      businessServiceProject.update(project);
      projects.remove(selectedProject);
      projects.add(project);
      Tools.addSuccessMessage("The project " + selectedProject.getName() + " has been updated");
    } catch (CannotCreateTransactionException ccte) {
      Tools.addErrorMessage("The project " + project.getName()
        + " could not be updated because the application could not connect to the database.");
      ccte.printStackTrace();
    } catch (DataIntegrityViolationException dive) {
      Tools.addErrorMessage("The project " + project.getName()
        + " could not be updated because another item already exists with the same name.");
      dive.printStackTrace();
    } catch (Exception e) {
      Tools.addErrorMessage("The project " + project.getName() + " could not be updated due to an unexpected error.");
      e.printStackTrace();
    }
  }


  public void initProjectParameter(Project projectSelct) {

    floors = new ArrayList<Floor>();
    rooms = new ArrayList<Room>();
    // buildings = new ArrayList<Building>(selectedProject.getBuildings());
    buildings = businessServiceBuilding.getBuildingsByProjectId(projectSelct.getId());
//    allFloors =new ArrayList<List<Floor>>();
//    allTfes = new ArrayList<List<TFE>>();
//    allRooms = new ArrayList<List<Room>>();
//    
//    for( Building b: buildings){      
//    allFloors.add(businessServiceFloor.getFloorsByBuildingId(b.getId()));
//    allTfes.add(businessServiceTFE.getTFEsByBuildingId(b.getId()));
//    }

    // buildings.addAll(setBuil);

    // Initialization combobox building, floor, room TFE from the data of the selected requirement
    if (selectedProject != null) {
    
    }
  }

  /**
   * Initilise lists of floors and tfe for the selected building.
   * The lists of room is initialized to empty
   * 
   * @param building
   *    The building object selected in the combobox
   */
  public void initFloorsAndTfe(Building building) {
    rooms = new ArrayList<Room>();

    tfes = businessServiceTFE.getTFEsByBuildingId(building.getId());
    floors = businessServiceFloor.getFloorsByBuildingId(building.getId());
  }

  public void initRoom(Floor floor) {

    rooms = businessServiceRoom.getRoomsByFloorId(floor.getId());
  }
 

  /**
   * Create a new project object for the update. Method executed when the user
   * clic on the edit button.
   */
  public void edit() {
    project = new Project(selectedProject);
  }
  
 
  /**
   * Returns the list of projects which are listed in the init method. No
   * acces to the data base because the sort of data table call this method.
   * 
   * @return List<Project>
   */
  public List<Project> getProjects() {
    return projects;
  }

  /**
   * Set the
   * <code>selectedProject<code> attribute with the selected project into the data table
   * 
   * @param selectedProject
   *            - The project selected into the data table
   */
  public void setSelectedProject(Project selectedProject) {
    this.selectedProject = selectedProject;
  }

  /**
   * Return the selected project into the data table
   * 
   * @return Project
   */
  public Project getSelectedProject() {
    return selectedProject;
  }

  /**
   * Return the <code>newProject<code> object
   * 
   * @return Project
   */
  public Project getProject() {
    return project;
  }

  /**
   * Set the <code>project<code> object
   * 
   * @param newProject
   *            - The project to create
   */
  public void setProject(Project project) {
    this.project = project;
  }

  public boolean isEditButtonsClickable() {
    return editButtonsClickable;
  }

  public void setEditButtonsClickable(boolean editButtonsClickable) {
    this.editButtonsClickable = editButtonsClickable;
  }


  
  /**
   * @return the createAction
   */
  public boolean isCreateAction() {
    return createAction;
  }
  

  
  /**
   * @return the businessServiceProject
   */
  public IBusinessServiceProject getBusinessServiceProject() {
    return businessServiceProject;
  }

  /**
   * @param businessServiceProject the businessServiceProject to set
   */
  public void setBusinessServiceProject(IBusinessServiceProject businessServiceProject) {
    this.businessServiceProject = businessServiceProject;
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
   * @param projects the projects to set
   */
  public void setProjects(List<Project> projects) {
    this.projects = projects;
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
   * @return the editAction
   */
  public boolean isEditAction() {
    return editAction;
  }

}
