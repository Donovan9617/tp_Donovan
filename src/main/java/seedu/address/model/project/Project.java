package seedu.address.model.project;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

/**
 * Represents a Project.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Project {

    // Components of a project
    private Name name;
    private Repository repository;
    private Deadline deadline;
    private String client;
    private String issue;

    /**
     * Every field must be present and not null.
     */
    public Project(Name name, Repository repository, Deadline deadline, String client, String issue) {
        requireAllNonNull(name, repository, deadline, client, issue);
        this.name = name;
        this.repository = repository;
        this.deadline = deadline;
        this.client = client;
        this.issue = issue;
    }

    public Name getProjectName() {
        return name;
    }

    public Repository getRepository() {
        return repository;
    }

    public Deadline getDeadline() {
        return deadline;
    }

    public String getClient() {
        return client;
    }

    public String getIssue() {
        return issue;
    }
}