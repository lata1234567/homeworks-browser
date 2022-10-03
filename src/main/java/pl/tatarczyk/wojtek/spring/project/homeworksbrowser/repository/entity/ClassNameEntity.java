package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ClassNameEntity {
//    A1,B1,C1,D1,E1,F1

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String name;

    public ClassNameEntity() {
    }

    public ClassNameEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ClassNameEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
