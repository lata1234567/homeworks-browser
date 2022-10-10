package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity;

import javax.persistence.*;

@Entity
public class ClassEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name = "name_id")
    private ClassNameEntity className;

    private Integer year;

    public ClassEntity() {
    }

    public ClassEntity(Long id, ClassNameEntity className, Integer year) {
        this.id = id;
        this.className = className;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClassNameEntity getClassName() {
        return className;
    }

    public void setClassName(ClassNameEntity className) {
        this.className = className;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "ClassEntity{" +
                "id=" + id +
                ", name=" + className +
                ", year=" + year +
                '}';
    }
}
