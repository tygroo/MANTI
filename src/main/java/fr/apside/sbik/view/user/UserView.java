package fr.apside.sbik.view.user;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.component.datatable.DataTable;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.CannotCreateTransactionException;

import fr.apside.sbik.entity.User;
import fr.apside.sbik.entity.UserRole;
import fr.apside.sbik.metier.service.IBusinessServiceUser;
import fr.apside.sbik.metier.service.IBusinessServiceUserRole;
import fr.apside.sbik.util.Tools;
import fr.apside.sbik.util.WordTreatments;

@Component
@Scope("view")
public class UserView {

  /** The project business service **/
  @Resource
  private IBusinessServiceUser businessServiceUser;

  @Resource
  private IBusinessServiceUserRole businessServiceUserRole;

  /** The project list **/
  private List<User> users;
  /** The selected user into the data table **/
  private User selectedUser;
  /** The user to create **/
  private User newUser = new User();
  /** The role list */
  private List<UserRole> roles;
  /** The dataTable */
  private DataTable dataTableUser = new DataTable();
  
  /**
  * Initialize project list after the class instantiate
  * 
  * @throws BusinessServiceException
  */
  @PostConstruct
  public String init() {
    dataTableUser.getAttributes();
    users = businessServiceUser.getAll();
    roles = businessServiceUserRole.getAll();
    // Authentication request = new UsernamePasswordAuthenticationToken(
    // this.getUsername(), getPassword());
    // Authentication result = am.authenticate(request);
    // SecurityContextHolder.getContext().setAuthentication(result);
    // SecurityContextHolder.getContext().getAuthentication().getDetails();

    // System.out.println("COUCOU");
    selectedUser = new User();
    return "";
  }

  /**
   * Returns the list of projects which are listed in the init method. No
   * acces to the data base because the sort of data table call this method.
   * 
   * @return List<Project>
   */
  public List<User> getUsers() {
    // System.out.println(projects.get(1).getBuildings().size());
    return users;
  }

  /**
   * Create a new user
   */
  public void create() {
    try {
      newUser.setEnabled(true);
      User user = new User(newUser);
      businessServiceUser.add(newUser);
      users.add(user);
      Tools.addSuccessMessage("The user " + newUser.getUsername() + " has been created");
      newUser = new User();
    } catch (CannotCreateTransactionException ccte) {
      Tools.addErrorMessage("The user " + newUser.getUsername()
        + " could not be created because the application could not connect to the database.");
      ccte.printStackTrace();
    } catch (DataIntegrityViolationException dive) {
      Tools.addErrorMessage("The user " + newUser.getUsername()
        + " could not be created because another item already exists with the same key.");
      dive.printStackTrace();
    } catch (Exception e) {
      Tools.addErrorMessage("The user " + newUser.getUsername() + " could not be created due to an unexpected error.");
      e.printStackTrace();
    }
  }

  /**
   * Update the selected user
   */
  public void update() {
    try {
      businessServiceUser.update(selectedUser);
      Tools.addSuccessMessage("The user " + selectedUser.getUsername() + " has been updated");
    } catch (CannotCreateTransactionException ccte) {
      Tools.addErrorMessage("The user " + selectedUser.getUsername()
        + " could not be updated because the application could not connect to the database.");
      ccte.printStackTrace();
    } catch (DataIntegrityViolationException dive) {
      Tools.addErrorMessage("The user " + selectedUser.getUsername()
        + " could not be updated because another item already exists with the same key.");
      dive.printStackTrace();
    } catch (Exception e) {
      Tools.addErrorMessage("The user " + selectedUser.getUsername()
        + " could not be updated due to an unexpected error.");
      e.printStackTrace();
    }
  }

  /**
   * Delete the selected project
   */
  public void delete() {
    try {
      businessServiceUser.delete(selectedUser);
      users.remove(selectedUser);
      Tools.addSuccessMessage("The user " + selectedUser.getUsername() + " has been removed");
    } catch (JpaObjectRetrievalFailureException jorfe) {
      Tools.addErrorMessage("The user " + selectedUser.getUsername()
        + " could not be deleted because it does not exist.");
      jorfe.printStackTrace();
    } catch (CannotCreateTransactionException ccte) {
      Tools.addErrorMessage("The user " + selectedUser.getUsername()
        + " could not be deleted because the application could not connect to the database.");
      ccte.printStackTrace();
    } catch (DataIntegrityViolationException dive) {
      Tools.addErrorMessage("The user " + selectedUser.getUsername()
        + " could not be deleted because it is referenced by other items.");
      dive.printStackTrace();
    } catch (Exception e) {
      Tools.addErrorMessage("The user " + selectedUser.getUsername()
        + " could not be deleted due to an unexpected error.");
      e.printStackTrace();
    }
  }

  /**
   * Generate a wordFile
   * 
   * @throws IOException
   */
  public void generateWord() {

    String filename = "D:\\tmp\\testWord.doc";

    try {
      WordTreatments.createWordByDatatable(filename, dataTableUser);

    } catch (FileNotFoundException e) {

      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "The file could not be created"));
    } catch (IOException e) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "The file could not be saved"));
    }

    try {
      WordTreatments.openFile(filename);
    } catch (IOException e) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "The file could not be opened"));
    }
  }

  /**
   * 
   * @return the selectedUser
   */
  public User getSelectedUser() {
    return selectedUser;
  }

  /**
   * o
   * 
   * @param selectedUser
   */
  public void setSelectedUser(User selectedUser) {
    this.selectedUser = selectedUser;
  }

  /**
   * @return the newUser
   */
  public User getNewUser() {
    return newUser;
  }

  /**
   * @param newUser
   *            the newUser to set
   */
  public void setNewUser(User newUser) {
    this.newUser = newUser;
  }

  /**
   * @param users
   *            the users to set
   */
  public void setUsers(List<User> users) {
    this.users = users;
  }

  /**
   * @return the roles
   */
  public List<UserRole> getRoles() {
    return roles;
  }

  /**
   * @param roles
   *            the roles to set
   */
  public void setRoles(List<UserRole> roles) {
    this.roles = roles;
  }

  /**
   * @return the dataTableUser
   */
  public DataTable getDataTableUser() {
    return dataTableUser;
  }

  /**
   * @param dataTableUser the dataTableUser to set
   */
  public void setDataTableUser(DataTable dataTableUser) {
    this.dataTableUser = dataTableUser;
  }

}
