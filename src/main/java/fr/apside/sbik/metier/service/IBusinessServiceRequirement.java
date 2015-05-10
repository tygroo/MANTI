package fr.apside.sbik.metier.service;

import java.util.List;

import fr.apside.sbik.entity.Requirement;

public interface IBusinessServiceRequirement extends IBusinessService<Requirement, Long> {

  List<Requirement> getRequirementsByProjectId(Long projectId);

  void insertRequirements();

  List<Requirement> getActiveRequirementsByProjectId(Long projectId);

  List<Requirement> getFixedRequirementsByProjectId(Long projectId);

}
