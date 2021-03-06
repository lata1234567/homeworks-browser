package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class HomeworkEntity {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private ClassEntity clazz;

    @Enumerated(EnumType.STRING)
    private SubjectEntity subject;

    @Enumerated(EnumType.STRING)
    private HomeworkStatusEntity status;

    private String title;
    private String content;
    private LocalDate dueDate;

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

    public SubjectEntity getSubject() {
        return subject;
    }

    public void setSubject(SubjectEntity subject) {
        this.subject = subject;
    }

    public HomeworkStatusEntity getStatus() {
        return status;
    }

    public void setStatus(HomeworkStatusEntity status) {
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
                '}';
    }
}
