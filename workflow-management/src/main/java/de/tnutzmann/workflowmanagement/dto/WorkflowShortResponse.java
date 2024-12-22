package de.tnutzmann.workflowmanagement.dto;

public record WorkflowShortResponse(String id,
                                    String name,
                                    String description,
                                    String runtime) {
}
