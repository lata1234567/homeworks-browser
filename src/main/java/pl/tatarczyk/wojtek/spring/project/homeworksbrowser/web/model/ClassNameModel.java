package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassNameModel {
    private Long id;
    private String name;

    public ClassNameModel(String name) {
        this.name = name;
    }
}
