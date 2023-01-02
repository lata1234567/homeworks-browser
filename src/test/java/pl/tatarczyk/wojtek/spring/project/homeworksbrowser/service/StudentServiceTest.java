package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.model.StudentModel;

@SpringBootTest
class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    void create() {
        //Given
        StudentModel studentModel = new StudentModel();
        //When
        StudentModel createdStudentModel = studentService.create(studentModel);
        //Then
        Assertions.assertNotNull(createdStudentModel,"createdStudentModel is Null");
    }

    @Test
    void update() {
        //Given
        StudentModel studentModel = new StudentModel();
        //When
        StudentModel updatedStudentModel = studentService.update(studentModel);
        //Then
        Assertions.assertNotNull(updatedStudentModel,"updatedStudentModel is Null");
    }
}