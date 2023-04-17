package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity;

import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.api.model.HomeworkStatus;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.api.model.HomeworkSubject;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Entity
public class HomeworkEntity {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private ClassEntity clazz;

    @Enumerated(EnumType.STRING)
    private HomeworkSubject subject;

    @Enumerated(EnumType.STRING)
    private HomeworkStatus status;

    private String title;
    private String content;
    private LocalDate dueDate;
    private LocalDate created;

    public HomeworkEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClassEntity getClazz() {
        return clazz;
    }

    public void setClazz(ClassEntity clazz) {
        this.clazz = clazz;
    }

    public HomeworkSubject getSubject() {
        return subject;
    }

    public void setSubject(HomeworkSubject subject) {
        this.subject = subject;
    }

    public HomeworkStatus getStatus() {
        return status;
    }

    public void setStatus(HomeworkStatus status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "HomeworkEntity{" +
                "id=" + id +
                ", clazz=" + clazz +
                ", subject=" + subject +
                ", status=" + status +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", dueDate=" + dueDate +
                ", addDate=" + created +
                '}';
    }
}
