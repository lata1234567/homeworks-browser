package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.model;

import lombok.Data;

@Data
public class HomeworkModel {
    private Long id;
    //TODO clazz,subject,status
    private String title;
    private String content;
//    private LocalDate dueDate;
    private String dueDate; //chwilowe
}

