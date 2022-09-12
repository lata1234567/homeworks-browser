package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.api.model;

public enum HomeworkSubject {
    J_POLSKI("Język polski"),
    J_ANGIELSKI("Język angielski"),
    MATEMATYKA("Matematyka"),
    FIZYKA("Fizyka"),
    BIOLOGIA("Biologia");

    private String name;

    HomeworkSubject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
