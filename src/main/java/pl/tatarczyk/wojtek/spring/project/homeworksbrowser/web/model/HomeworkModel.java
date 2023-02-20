package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.api.model.HomeworkStatus;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.api.model.HomeworkSubject;

import java.time.LocalDate;

@Data
public class HomeworkModel {
    private Long id;

    private ClassModel clazz;
    private HomeworkSubject subject;
    private HomeworkStatus status;

    private String title;
    private String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;
//    private String dueDate; //chwilowe
}

