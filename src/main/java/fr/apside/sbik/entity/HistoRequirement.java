package fr.apside.sbik.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@Entity
//@Table(uniqueConstraints = { @UniqueConstraint(name = "ucRequirement", columnNames = {
//		"TFE_ID", "ROOM_ID", "WORK_ID", "NUMBER_ID", "SUBNUMBER_ID" }) }, indexes = { @Index(columnList = "id") })
public class HistoRequirement implements IEntity<Long> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_HISTO")
	private Long idHisto;
	@ManyToOne
	@JoinColumn(name = "ID", nullable = false)
	private Requirement requirement;
	private long tagVersion;
	@Column(nullable = false)
	private Project project;
	@Column(nullable = false)
	private Building building;
	@Column(nullable = false)
	private TFE tfe;
	@Column(nullable = false)
	private Room room;
	private Room door;
	@Column(nullable = false)
	private Floor floor;
	@Column(nullable = false)
	private Work work;
	@Column(nullable = false)
	private RequirementType type;
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
	@Column(nullable = false)
	private Criticality criticality;
	private Maturity maturity;
	private Unit unit;
	@Column(nullable = false)
	private Applicability applicability;
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
	@Column(nullable = false)
	private long version;
	@Column(nullable = false)
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

	public Room getDoor() {
		return door;
	}

	public void setDoor(Room door) {
		this.door = door;
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

	public Long getIdHisto() {
		return idHisto;
	}

	@Override
	public Long getId() {
		return getIdHisto();
	}

	public void setIdHisto(Long idHisto) {
		this.idHisto = idHisto;
	}

	public long getTagVersion() {
		return tagVersion;
	}

	public void setTagVersion(long tagVersion) {
		this.tagVersion = tagVersion;
	}

	public Requirement getRequirement() {
		return requirement;
	}

	public void setRequirement(Requirement requirement) {
		this.requirement = requirement;
	}

}
