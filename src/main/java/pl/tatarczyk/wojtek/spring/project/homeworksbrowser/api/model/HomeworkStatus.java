package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.api.model;

public enum HomeworkStatus {
    NEW("New"),
    IN_PROGRESS("In progress"),
    DONE("Done");

    private String name;

    HomeworkStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
