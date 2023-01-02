package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.StudentEntity;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void given_when_then() {
        //Given
        StudentEntity studentEntity = new StudentEntity();
        //When
        StudentEntity savedStudentEntity = studentRepository.save(studentEntity);
        //Then
        Assertions.assertNotNull(savedStudentEntity,"savedStudentEntity is not null");
    }
}
