package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.ClassEntity;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.ClassNameEntity;

@SpringBootTest
class ClassRepositoryIntegrationTest {

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private ClassNameRepository classNameRepository;

    @Test
    void given_when_then() {
        //Given
        ClassEntity classEntity = new ClassEntity();
        //When
        ClassEntity savedClassEntity = classRepository.save(classEntity);
        //Then
        Assertions.assertNotNull(savedClassEntity, "savedClassEntity is null");
    }

    @Test
    void given_when_then1() {
        //Given
        ClassEntity classEntity = new ClassEntity();
        ClassNameEntity classNameEntity = new ClassNameEntity();
        classEntity.setClassName(classNameEntity);
        //When
        ClassNameEntity savedClassNameEntity = classNameRepository.save(classNameEntity);
        ClassEntity savedClassEntity = classRepository.save(classEntity);
        //Then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(savedClassEntity, "savedClassEntity is null"),
                () -> Assertions.assertEquals(classNameEntity, savedClassEntity.getClassName(), "classNameEntity is not equals")
        );
    }
}