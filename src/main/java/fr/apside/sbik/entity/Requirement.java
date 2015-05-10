package fr.apside.sbik.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(name = "ucRequirement", columnNames = {
  "PROJECT_ID", "TFE_ID", "ROOM_ID", "WORK_ID", "number", "subnumber"})}, indexes = {@Index(columnList = "PROJECT_ID")})
public class Requirement implements IEntity<Long> {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "PROJECT_ID", nullable = false)
  private Project project;

  @ManyToOne
  @JoinColumn(name = "BUILDING_ID", nullable = false)
  private Building building;

  @ManyToOne
  @JoinColumn(name = "TFE_ID", nullable = false)
  private TFE tfe;

  @ManyToOne
  @JoinColumn(name = "ROOM_ID", nullable = false)
  private Room room;

  @ManyToOne
  @JoinColumn(name = "ROOM2_ID", nullable = true)
  private Room room2;

  @ManyToOne
  @JoinColumn(name = "FLOOR_ID", nullable = false)
  private Floor floor;

  @ManyToOne
  @JoinColumn(name = "WORK_ID", nullable = false)
  private Work work;

  @ManyToOne
  @JoinColumn(name = "TYPE_ID", nullable = false)
  private RequirementType type;
  
  @ManyToOne
  @JoinColumn(name = "CONTROLE_TYPE_ID", nullable = true)
  private ControlType controlType;

  @Column(nullable = false)
  private String number;

  @Column(nullable = false)
  private String subnumber;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String value;

  @Column(nullable = false)
  private String margin;

  @Column(nullable = false)
  private String finalValue;

  @ManyToOne
  @JoinColumn(name = "CRITICALITY_ID", nullable = false)
  private Criticality criticality;

  @ManyToOne
  @JoinColumn(name = "MATURITY_ID")
  private Maturity maturity;

  @ManyToOne
  @JoinColumn(name = "UNIT_ID")
  private Unit unit;

  @ManyToOne
  @JoinColumn(name = "APPLICABILITY_ID", nullable = false)
  private Applicability applicability;

  @ManyToOne
  @JoinColumn(name = "LINK_ID", nullable = false)
  private Link link;

  @Column(nullable = false)
  private String refLink;

  private String tolerance;
  @Column(name = "CONFORMITY_DESIGN")
  private boolean conformityDesign;

  @Column(name = "PLANE_REF")
  private String planeRef;

  @Column(name = "JUSTIFICATION_DESIGN")
  private String justificationDesign;

  private boolean control;

  @Column(name = "CONFORMITY_BUILD")
  private boolean conformityBuild;

  @Column(name = "JUSTIFICATION_BUILD")
  private String justificationBuild;

  private String comment;

  private String walver;

  @Column(name = "ADS_JUSTIFICATION")
  private String adsJustification;

  @Temporal(value = TemporalType.DATE)
  @Column(nullable = false, name = "UPDATE_DATE")
  private Date updateDate;

  @Version
  private long version;

  @ManyToOne
  @JoinColumn(name = "USER_ID", nullable = false)
  private User user;

  private String feedback;

  @Column(name = "FIELD_1")
  private String field1;

  @Column(name = "FIELD_2")
  private String field2;

  @Column(name = "FIELD_3")
  private String field3;

  @Column(name = "FIELD_4")
  private String field4;

  @Column(name = "REQUIREMENT_FIX")
  private Boolean requirementFix;
  
  @Column(name = "FIX_JUSTIFICATION", nullable = true)
  private String fixJsutification;
  
  

  // @OneToMany(fetch = FetchType.LAZY, mappedBy = "requirement")
  // private Set<HistoRequirement> histoRequirements = new HashSet<HistoRequirement>();

  public Requirement() {
    this.subnumber = "1";
    this.version = 1;
  }

  public Requirement(Requirement requirement) {
    super();
    this.id = requirement.id;
    this.project = requirement.project;
    this.building = requirement.building;
    this.tfe = requirement.tfe;
    this.room = requirement.room;
    this.room2 = requirement.room2;
    this.floor = requirement.floor;
    this.work = requirement.work;
    this.type = requirement.type;
    this.number = requirement.number;
    this.subnumber = requirement.subnumber;
    this.name = requirement.name;
    this.value = requirement.value;
    this.margin = requirement.margin;
    this.finalValue = requirement.finalValue;
    this.criticality = requirement.criticality;
    this.maturity = requirement.maturity;
    this.unit = requirement.unit;
    this.applicability = requirement.applicability;
    this.link = requirement.link;
    this.refLink = requirement.refLink;
    this.tolerance = requirement.tolerance;
    this.conformityDesign = requirement.conformityDesign;
    this.planeRef = requirement.planeRef;
    this.justificationDesign = requirement.justificationDesign;
    this.control = requirement.control;
    this.conformityBuild = requirement.conformityBuild;
    this.justificationBuild = requirement.justificationBuild;
    this.comment = requirement.comment;
    this.walver = requirement.walver;
    this.adsJustification = requirement.adsJustification;
    this.updateDate = requirement.updateDate;
    this.version = requirement.version;
    this.user = requirement.user;
    this.feedback = requirement.feedback;
    this.field1 = requirement.field1;
    this.field2 = requirement.field2;
    this.field3 = requirement.field3;
    this.field4 = requirement.field4;
    this.requirementFix = requirement.requirementFix;
    this.fixJsutification = requirement.fixJsutification;
    this.controlType = requirement.controlType;
  }

  @Override
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;
  }

  public Building getBuilding() {
    return building;
  }

  public void setBuilding(Building building) {
    this.building = building;
  }

  public TFE getTfe() {
    return tfe;
  }

  public void setTfe(TFE tfe) {
    this.tfe = tfe;
  }

  public Room getRoom() {
    return room;
  }

  public void setRoom(Room room) {
    this.room = room;
  }

  public Room getRoom2() {
    return room2;
  }

  public void setRoom2(Room room2) {
    this.room2 = room2;
  }

  public Floor getFloor() {
    return floor;
  }

  public void setFloor(Floor floor) {
    this.floor = floor;
  }

  public Work getWork() {
    return work;
  }

  public void setWork(Work work) {
    this.work = work;
  }

  public RequirementType getType() {
    return type;
  }

  public void setType(RequirementType type) {
    this.type = type;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getSubnumber() {
    return subnumber;
  }

  public void setSubnumber(String subnumber) {
    this.subnumber = subnumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getMargin() {
    return margin;
  }

  public void setMargin(String margin) {
    this.margin = margin;
  }

  public String getFinalValue() {
    return finalValue;
  }

  public void setFinalValue(String finalValue) {
    this.finalValue = finalValue;
  }

  public Criticality getCriticality() {
    return criticality;
  }

  public void setCriticality(Criticality criticality) {
    this.criticality = criticality;
  }

  public Maturity getMaturity() {
    return maturity;
  }

  public void setMaturity(Maturity maturity) {
    this.maturity = maturity;
  }

  public Unit getUnit() {
    return unit;
  }

  public void setUnit(Unit unit) {
    this.unit = unit;
  }

  public Applicability getApplicability() {
    return applicability;
  }

  public void setApplicability(Applicability applicability) {
    this.applicability = applicability;
  }

  public Link getLink() {
    return link;
  }

  public void setLink(Link link) {
    this.link = link;
  }

  public String getRefLink() {
    return refLink;
  }

  public void setRefLink(String refLink) {
    this.refLink = refLink;
  }

  public String getTolerance() {
    return tolerance;
  }

  public void setTolerance(String tolerance) {
    this.tolerance = tolerance;
  }

  public boolean isConformityDesign() {
    return conformityDesign;
  }

  public void setConformityDesign(boolean conformityDesign) {
    this.conformityDesign = conformityDesign;
  }

  public String getPlaneRef() {
    return planeRef;
  }

  public void setPlaneRef(String planeRef) {
    this.planeRef = planeRef;
  }

  public String getJustificationDesign() {
    return justificationDesign;
  }

  public void setJustificationDesign(String justificationDesign) {
    this.justificationDesign = justificationDesign;
  }

  public boolean isControl() {
    return control;
  }

  public void setControl(boolean control) {
    this.control = control;
  }

  public boolean isConformityBuild() {
    return conformityBuild;
  }

  public void setConformityBuild(boolean conformityBuild) {
    this.conformityBuild = conformityBuild;
  }

  public String getJustificationBuild() {
    return justificationBuild;
  }

  public void setJustificationBuild(String justificationBuild) {
    this.justificationBuild = justificationBuild;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getWalver() {
    return walver;
  }

  public void setWalver(String walver) {
    this.walver = walver;
  }

  public String getAdsJustification() {
    return adsJustification;
  }

  public void setAdsJustification(String adsJustification) {
    this.adsJustification = adsJustification;
  }

  public Date getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }

  public long getVersion() {
    return version;
  }

  public void setVersion(long version) {
    this.version = version;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getFeedback() {
    return feedback;
  }

  public void setFeedback(String feedback) {
    this.feedback = feedback;
  }

  public String getField1() {
    return field1;
  }

  public void setField1(String field1) {
    this.field1 = field1;
  }

  public String getField2() {
    return field2;
  }

  public void setField2(String field2) {
    this.field2 = field2;
  }

  public String getField3() {
    return field3;
  }

  public void setField3(String field3) {
    this.field3 = field3;
  }

  public String getField4() {
    return field4;
  }

  public void setField4(String field4) {
    this.field4 = field4;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Requirement other = (Requirement) obj;
    if (this.getId() != other.getId()) {
      return false;
    } else if (!this.getAdsJustification().equals(other.getAdsJustification())) {
      return false;
    } else if (this.getApplicability().getId() != other.getApplicability().getId()) {
      return false;
    } else if (this.getBuilding().getId() != other.getBuilding().getId()) {
      return false;
    } else if (!this.getComment().equals(other.getComment())) {
      return false;
    } else if (this.getCriticality().getId() != other.getCriticality().getId()) {
      return false;
    } else if (!this.getFeedback().equals(other.getFeedback())) {
      return false;
    } else if (!this.getField1().equals(other.getField1())) {
      return false;
    } else if (!this.getField2().equals(other.getField2())) {
      return false;
    } else if (!this.getField3().equals(other.getField3())) {
      return false;
    } else if (!this.getField4().equals(other.getField4())) {
      return false;
    } else if (!this.getFinalValue().equals(other.getFinalValue())) {
      return false;
    } else if (this.getFloor().getId() != other.getFloor().getId()) {
      return false;
    } else if (!this.getJustificationBuild().equals(other.getJustificationBuild())) {
      return false;
    } else if (!this.getJustificationDesign().equals(other.getJustificationDesign())) {
      return false;
    } else if (this.getLink().getId() != other.getLink().getId()) {
      return false;
    } else if (!this.getMargin().equals(other.getMargin())) {
      return false;
    } else if (this.getMaturity().getId() != other.getMaturity().getId()) {
      return false;
    } else if (!this.getName().equals(other.getName())) {
      return false;
    } else if (!this.getNumber().equals(other.getNumber())) {
      return false;
    } else if (!this.getPlaneRef().equals(other.getPlaneRef())) {
      return false;
    } else if (this.getProject().getId() != other.getProject().getId()) {
      return false;
    } else if (!this.getRefLink().equals(other.getRefLink())) {
      return false;
    } else if (this.getRoom().getId() != other.getRoom().getId()) {
      return false;
    } else if ((null == this.getRoom2() && null != other.getRoom2())
      || (null != this.getRoom2() && null == other.getRoom2())
      || ((null != this.getRoom2() && null != other.getRoom2()) && this.getRoom2().getId() != other.getRoom2().getId())) {
      return false;
    } else if (!this.getSubnumber().equals(other.getSubnumber())) {
      return false;
    } else if (this.getTfe().getId() != other.getTfe().getId()) {
      return false;
    } else if (!this.getTolerance().equals(other.getTolerance())) {
      return false;
    } else if (this.getType().getId() != other.getType().getId()) {
      return false;
    } else if (this.getControlType().getId() != other.getControlType().getId()) {
      return false;
    } else if (this.getUnit().getId() != other.getUnit().getId()) {
      return false;
    } else if (!this.getValue().equals(other.getValue())) {
      return false;
    } else if (!this.getWalver().equals(other.getWalver())) {
      return false;
    } else if (this.getWork().getId() != other.getWork().getId()) {
      return false;
    } else if (this.isConformityBuild() != other.isConformityBuild()) {
      return false;
    } else if (this.isConformityDesign() != other.isConformityDesign()) {
      return false;
    } else if (this.isControl() != other.isControl()) {
      return false;
    } else if (this.getVersion() != other.getVersion()) {
      return false;
    }else if (this.getFixJsutification() != other.getFixJsutification()) {
      return false;
    }else if (this.getRequirement_fix() != other.getRequirement_fix()) {
      return false;
    }
    
    return true;
  }



  /**
   * @return the requirement_fix
   */
  public Boolean getRequirement_fix() {
    return requirementFix;
  }

  /**
   * @param requirement_fix the requirement_fix to set
   */
  public void setRequirement_fix(Boolean requirement_fix) {
    this.requirementFix = requirement_fix;
  }

  /**
   * @return the fixJsutification
   */
  public String getFixJsutification() {
    return fixJsutification;
  }

  /**
   * @param fixJsutification the fixJsutification to set
   */
  public void setFixJsutification(String fixJsutification) {
    this.fixJsutification = fixJsutification;
  }

  /**
   * @return the controleType
   */
  public ControlType getControlType() {
    return controlType;
  }

  /**
   * @param controleType the controleType to set
   */
  public void setControlType(ControlType controleType) {
    this.controlType = controleType;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "Requirement [id=" + id + ", project=" + project + ", building=" + building + ", tfe=" + tfe + ", room="
      + room + ", room2=" + room2 + ", floor=" + floor + ", work=" + work + ", type=" + type + ", controlType="
      + controlType + ", number=" + number + ", subnumber=" + subnumber + ", name=" + name + ", value=" + value
      + ", margin=" + margin + ", finalValue=" + finalValue + ", criticality=" + criticality + ", maturity=" + maturity
      + ", unit=" + unit + ", applicability=" + applicability + ", link=" + link + ", refLink=" + refLink
      + ", tolerance=" + tolerance + ", conformityDesign=" + conformityDesign + ", planeRef=" + planeRef
      + ", justificationDesign=" + justificationDesign + ", control=" + control + ", conformityBuild="
      + conformityBuild + ", justificationBuild=" + justificationBuild + ", comment=" + comment + ", walver=" + walver
      + ", adsJustification=" + adsJustification + ", updateDate=" + updateDate + ", version=" + version + ", user="
      + user + ", feedback=" + feedback + ", field1=" + field1 + ", field2=" + field2 + ", field3=" + field3
      + ", field4=" + field4 + ", requirement_fix=" + requirementFix + ", fixJsutification=" + fixJsutification + "]";
  }



  // public Set<HistoRequirement> getHistoRequirements() {
  // return histoRequirements;
  // }
  //
  // public void setHistoRequirements(Set<HistoRequirement> histoRequirements) {
  // this.histoRequirements = histoRequirements;
  // }

}
