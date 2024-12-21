package de.tnutzmann.yaapcontroller.service;

import de.tnutzmann.yaapcontroller.model.Workflow;
import de.tnutzmann.yaapcontroller.repository.WorkflowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkflowService {

    @Autowired
    private WorkflowRepository workflowRepository;

    public Workflow createWorkflow(Workflow workflow) {
        return workflowRepository.save(workflow);
    }

    public List<Workflow> getAllWorkflows() {
        return workflowRepository.findAll();
    }

    public Optional<Workflow> getWorkflowById(Long workflowId) {
        return workflowRepository.findById(workflowId);
    }
}
