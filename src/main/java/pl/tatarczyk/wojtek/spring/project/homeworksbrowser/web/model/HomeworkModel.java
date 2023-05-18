package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.api.model.HomeworkStatus;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.api.model.HomeworkSubject;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
public class HomeworkModel {
    private Long id;

    private ClassModel clazz;
    private HomeworkSubject subject;
    private HomeworkStatus status;

    @NotEmpty(message = "Tytuł pracy domowej nie może być pusty")
    private String title;
    @NotEmpty(message = "Treść pracy domowej nie może być pusta")
    private String content;
//    @NotNull(message = "Data wykonania nie może być pusta")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate created;
}

