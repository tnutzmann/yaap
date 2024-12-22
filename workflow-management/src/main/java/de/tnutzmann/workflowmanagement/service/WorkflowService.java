package de.tnutzmann.workflowmanagement.service;

import de.tnutzmann.workflowmanagement.dto.WorkflowRequest;
import de.tnutzmann.workflowmanagement.dto.WorkflowResponse;
import de.tnutzmann.workflowmanagement.dto.WorkflowShortResponse;
import de.tnutzmann.workflowmanagement.model.Workflow;
import de.tnutzmann.workflowmanagement.repository.WorkflowRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
@Slf4j
public class WorkflowService {
    private final WorkflowRepository workflowRepository;

    private WorkflowResponse workflowResponseFromWorkflow(Workflow workflow) {
        return new WorkflowResponse(workflow.getId(), workflow.getName(), workflow.getDescription(), workflow.getRuntime(), workflow.getDependencies(), workflow.getInstructions());
    }

    public WorkflowResponse createWorkflow(WorkflowRequest workflowRequest) {
        Workflow workflow = Workflow.builder()
                .name(workflowRequest.name())
                .description(workflowRequest.description())
                .runtime(workflowRequest.runtime())
                .dependencies(workflowRequest.dependencies())
                .instructions(workflowRequest.instructions())
                .build();
        workflowRepository.save(workflow);
        log.info("Workflow created successfully");
        return workflowResponseFromWorkflow(workflow);
    }

    public List<WorkflowShortResponse> getAllWorkflows() {
        return workflowRepository.findAll()
                .stream()
                .map(workflow -> new WorkflowShortResponse(workflow.getId(), workflow.getName(), workflow.getDescription(), workflow.getRuntime()))
                .toList();
    }

    public Optional<WorkflowResponse> getWorkflow(String workflowId) {
        return this.workflowRepository.findById(workflowId).map(this::workflowResponseFromWorkflow);
    }

    @Transactional
    public Optional<WorkflowResponse> updateWorkflow(String workflowId, WorkflowRequest workflowRequest) {
        AtomicReference<Optional<WorkflowResponse>> newWorkflow = new AtomicReference<>(Optional.empty());

        workflowRepository.findById(workflowId).ifPresent(workflow -> {

            workflow.setName(workflowRequest.name());
            workflow.setDescription(workflowRequest.description());
            workflow.setRuntime(workflowRequest.runtime());
            workflow.setDependencies(workflowRequest.dependencies());
            workflow.setInstructions(workflowRequest.instructions());

            workflowRepository.save(workflow);
            log.info("Workflow updated successfully");
            newWorkflow.set(Optional.of(this.workflowResponseFromWorkflow(workflow)));
        });

        return newWorkflow.get();
    }

    public void deleteWorkflow(String id) {
        workflowRepository.deleteById(id);
    }
}
