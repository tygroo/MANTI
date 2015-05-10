package fr.apside.sbik.metier.dao;

import java.util.List;

import fr.apside.sbik.entity.Requirement;

public interface IDaoRequirement extends IDao<Requirement, Long> {

	List<Requirement> getRequirementsByProjectId(Long projectId);

  void insertRequirements();

  List<Requirement> getActiveRequirementsByProjectId(Long projectId);

  List<Requirement> getFixedRequirementsByProjectId(Long projectId);
}
