package de.tnutzmann.workflowmanagement.repository;

import de.tnutzmann.workflowmanagement.model.Workflow;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorkflowRepository extends MongoRepository<Workflow, String> {

}
