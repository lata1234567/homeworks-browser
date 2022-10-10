package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.ClassNameEntity;

@SpringBootTest
class ClassNameRepositoryTest {

    @Autowired
    private ClassNameRepository classNameRepository;

    @Test
    void test() {
        //Given
        ClassNameEntity classNameEntity = new ClassNameEntity();
        classNameEntity.setName("2c");
        //When
        classNameRepository.saveAndFlush(classNameEntity);
        classNameRepository.saveAndFlush(classNameEntity);
        //Then

    }
}