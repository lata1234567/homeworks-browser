package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.model;

import lombok.Data;

@Data
public class StudentModel {
    private Long id;

    private ClassModel clazz;

    private String name;
    private String surname;

    private String password;
    private String login;
}
