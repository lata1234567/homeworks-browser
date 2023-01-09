package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.model.ClassModel;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.model.ClassNameModel;

import java.util.List;

@SpringBootTest
class ClassServiceTest {
    @Autowired
    private ClassService classService;

    @Test
    void list() {
        //Given

        //When
        List<ClassModel> classModels = classService.list();
        //Then
        System.out.println(classModels);
    }

    @Test
    void create() {
        //Given
        ClassModel classModel = new ClassModel();
        classModel.setYear(999);
    classModel.setClassName(new ClassNameModel("4A"));
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