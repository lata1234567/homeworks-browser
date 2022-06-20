package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class HomeworkModel {
    private Long id;
    //TODO clazz,subject,status
    private String title;
    private String content;
    private LocalDate dueDate;
}

