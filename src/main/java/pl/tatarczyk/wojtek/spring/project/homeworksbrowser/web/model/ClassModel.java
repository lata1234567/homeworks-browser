package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.model;

import lombok.Data;

@Data
public class ClassModel {
    private Long id;
    private ClassNameModel className;
    private Integer year;
}
