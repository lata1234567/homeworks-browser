package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity;

import javax.persistence.*;

@Entity
public class StudentEntity {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private ClassEntity clazz;

    private String name;
    private String surname;
}
