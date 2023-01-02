package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.service.mapper;

import org.junit.jupiter.api.Test;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.StudentEntity;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.model.StudentModel;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    private static final long STUDENT_ID = 1L;
    private static final String NAME = "Name";
    private static final String SURNAME = "Surname";
    private static final String PASSWORD = "Password";
    private static final String LOGIN = "Login";

    private StudentMapper studentMapper = new StudentMapper();

    @Test
    void from() {
        //Given
        StudentModel studentModel = new StudentModel();

        studentModel.setId(STUDENT_ID);
        studentModel.setName(NAME);
        studentModel.setLogin(LOGIN);
        studentModel.setPassword(PASSWORD);
        studentModel.setSurname(SURNAME);
        //When
        StudentEntity studentEntity = studentMapper.from(studentModel);
        //Then
        assertAll(
                ()->assertNotNull(studentEntity,"studentEntity is null"),
                ()->assertEquals(STUDENT_ID,studentEntity.getId(),"studentEntity ID is not equals"),
                ()->assertEquals(NAME,studentEntity.getName(),"studentEntity NAME is not equals"),
                ()->assertEquals(LOGIN,studentEntity.getLogin(),"studentEntity LOGIN is not equals"),
                ()->assertEquals(PASSWORD,studentEntity.getPassword(),"studentEntity PASSWORD is not equals"),
                ()->assertEquals(SURNAME,studentEntity.getSurname(),"studentEntity SURNAME is not equals")
        );
    }

    @Test
    void fromEntities() {
    }
}