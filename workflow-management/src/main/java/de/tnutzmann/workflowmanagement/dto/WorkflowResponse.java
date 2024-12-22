package de.tnutzmann.workflowmanagement.dto;

import java.util.List;

public record WorkflowResponse(String id,
                               String name,
                               String description,
                               String runtime,
                               List<String> dependencies,
                               String instructions) {
}

