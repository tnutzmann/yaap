package de.tnutzmann.yaapcontroller.controller;

import de.tnutzmann.yaapcontroller.model.Workflow;
import de.tnutzmann.yaapcontroller.service.WorkflowService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/workflow")
public class WorkflowController {
    @Autowired
    private WorkflowService workflowService;

    @Tag(name = "Workflow")
    @PostMapping()
    public Workflow createWorkflow(@RequestBody Workflow workflow) {
        return workflowService.createWorkflow(workflow);
    }

    @Tag(name = "Workflow")
    @GetMapping()
    public List<Workflow> getAllWorkflows() {
        return workflowService.getAllWorkflows();
    }

    @Tag(name = "Workflow")
    @GetMapping("/{id}")
    public ResponseEntity<Workflow> getWorkflowById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(workflowService.getWorkflowById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        ));
    }


}
