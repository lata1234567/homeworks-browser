package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String password;
    private String login;
}
