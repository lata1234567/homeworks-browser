package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.model.ClassModel;

@SpringBootTest
class ClassServiceTest {
    @Autowired
    private ClassService classService;

    @Test
    void create() {
        //Given
        ClassModel classModel = new ClassModel();
        //When
        ClassModel createdClassModel = classService.create(classModel);
        //Then
        Assertions.assertNotNull(createdClassModel,"createdClassModel is not null");
    }

    @Test
    void update() {
        //Given
        ClassModel classModel = new ClassModel();
        //When
        ClassModel updatedClassModel = classService.update(classModel);
        //Then
        Assertions.assertNotNull(updatedClassModel,"updatedClassModel is not null");
    }
}