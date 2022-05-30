package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AdministratorEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String login;
    private String password;
}
