package fr.apside.sbik.metier.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

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
import fr.apside.sbik.entity.User;
import fr.apside.sbik.entity.Work;
import fr.apside.sbik.metier.dao.IDaoRequirement;

@Repository
public class DaoRequirement extends AbstractDao<Requirement, Long> implements IDaoRequirement {

  @Override
  public List<Requirement> getRequirementsByProjectId(Long projectId) {
    String jpql = "from Requirement r where r.project.id=" + projectId;
    return em.createQuery(jpql, Requirement.class).getResultList();
  }
  
  @Override
  public List<Requirement> getActiveRequirementsByProjectId(Long projectId) {
    String jpql = "from Requirement r where r.project.id=" + projectId+ " and r.requirementFix = false";
    return em.createQuery(jpql, Requirement.class).getResultList();
  }
  
  @Override
  public List<Requirement> getFixedRequirementsByProjectId(Long projectId) {
    String jpql = "from Requirement r where r.project.id=" + projectId+ " and r.requirementFix = true";
    return em.createQuery(jpql, Requirement.class).getResultList();
  }

  @Override
  public void insertRequirements() {
    for (int i = 100; i < 5100; i++) {
      try {
        Requirement req = createDefaultRequirement(i, (long) 1);
        add(req);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    for (int i = 100; i < 10100; i++) {
      try {
        Requirement req = createDefaultRequirement(i, (long) 2);
        add(req);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  private static Requirement createDefaultRequirement(int index, long projectId) {
    Applicability applicability = new Applicability();
    applicability.setId((long) 1);

    Building building = new Building();
    building.setId((long) 1);

    Criticality criticality = new Criticality();
    criticality.setId((long) 1);

    Floor floor = new Floor();
    floor.setId((long) 1);

    Link link = new Link();
    link.setId((long) 1);

    Maturity maturity = new Maturity();
    maturity.setId((long) 1);

    Project project = new Project();
    project.setId(projectId);

    Room room = new Room();
    room.setId((long) 1);

    Room room2 = new Room();
    room2.setId((long) 1);

    TFE tfe = new TFE();
    tfe.setId((long) 1);

    RequirementType requirementType = new RequirementType();
    requirementType.setId((long) 1);

    Unit unit = new Unit();
    unit.setId((long) 1);

    User user = new User();
    user.setUsername("seb");

    Work work = new Work();
    work.setId((long) 1);
    
    ControlType controlType = new ControlType();
    controlType.setId((long) 1);

    Requirement req = new Requirement();
    req.setAdsJustification("ADS");
    req.setComment("comment");
    req.setConformityBuild(true);
    req.setConformityDesign(true);
    req.setControl(false);
    req.setFeedback("feedback");
    req.setField1("field1");
    req.setField2("field2");
    req.setField3("field3");
    req.setField4("field4");
    req.setFinalValue("10");
    req.setJustificationBuild("justifbuild");
    req.setJustificationDesign("justifDesign");
    req.setMargin("2");
    req.setName("nameEx" + index);
    req.setNumber(String.valueOf(index));
    req.setPlaneRef("planeref");
    req.setRefLink("ref link " + index);
    req.setSubnumber("1");
    req.setTolerance("1");
    req.setUpdateDate(new Date());
    req.setValue("5");
    req.setVersion(1);
    req.setWalver("walver");

    req.setApplicability(applicability);
    req.setBuilding(building);
    req.setCriticality(criticality);
    req.setFloor(floor);
    req.setLink(link);
    req.setMaturity(maturity);
    req.setProject(project);
    req.setRoom(room);
    req.setRoom2(room2);
    req.setTfe(tfe);
    req.setType(requirementType);
    req.setUnit(unit);
    req.setUser(user);
    req.setWork(work);
    req.setControlType(controlType);
    req.setRequirement_fix(false);
    
    return req;
  }

}
