package de.tnutzmann.workflowmanagement.controller;

import de.tnutzmann.workflowmanagement.dto.WorkflowRequest;
import de.tnutzmann.workflowmanagement.dto.WorkflowResponse;
import de.tnutzmann.workflowmanagement.dto.WorkflowShortResponse;
import de.tnutzmann.workflowmanagement.service.WorkflowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/workflow")
@RequiredArgsConstructor
public class WorkflowController {

    private final WorkflowService workflowService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WorkflowResponse createWorkflow(@RequestBody WorkflowRequest workflowRequest) {
        return workflowService.createWorkflow(workflowRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<WorkflowShortResponse> getAllWorkflows() {
        return workflowService.getAllWorkflows();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public WorkflowResponse getWorkflow(@PathVariable String id) {
        return workflowService.getWorkflow(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Workflow with id " + id + " not found")
        );
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public WorkflowResponse updateWorkflow(@PathVariable String id, @RequestBody WorkflowRequest workflowRequest) {
        return workflowService.updateWorkflow(id, workflowRequest).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Workflow with id " + id + " not found")
        );
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteWorkflow(@PathVariable String id) {
        workflowService.deleteWorkflow(id);
    }
}
