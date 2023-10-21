package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.ClassEntity;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.ClassNameEntity;

import java.util.List;

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

    @Test
    void findByClassnameName() {
        //Given
        ClassEntity classEntity = new ClassEntity();
        ClassNameEntity classNameEntity = new ClassNameEntity();
        classNameEntity.setName("1C");
        classEntity.setClassName(classNameEntity);

        ClassEntity secondClassEntity = new ClassEntity();
        ClassNameEntity secondClassNameEntity = new ClassNameEntity();
        secondClassNameEntity.setName("1D");
        secondClassEntity.setClassName(secondClassNameEntity);

        ClassEntity thirdClassEntity = new ClassEntity();
        ClassNameEntity thirdClassNameEntity = new ClassNameEntity();
        thirdClassNameEntity.setName("1E");
        thirdClassEntity.setClassName(thirdClassNameEntity);
        //When
        ClassEntity savedClassEntity = classRepository.save(classEntity);
        ClassEntity savedSecondEntity = classRepository.save(secondClassEntity);
        ClassEntity savedThirdClassEntity = classRepository.save(thirdClassEntity);

        List<ClassEntity> entities = classRepository.findByClassName_Name("1D");
        System.out.println("searched classes: " + entities);
        //Then
        Assertions.assertNotNull(entities, "entities is null");
    }
}