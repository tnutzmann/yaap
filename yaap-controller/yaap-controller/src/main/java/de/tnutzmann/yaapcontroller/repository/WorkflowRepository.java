package de.tnutzmann.yaapcontroller.repository;

import de.tnutzmann.yaapcontroller.model.Workflow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkflowRepository extends JpaRepository<Workflow, Long> {
}
