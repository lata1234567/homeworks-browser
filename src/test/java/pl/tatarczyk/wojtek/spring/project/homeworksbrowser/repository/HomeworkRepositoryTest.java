package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.api.model.HomeworkSubject;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.HomeworkEntity;

@SpringBootTest
class HomeworkRepositoryTest {

    @Autowired
    private HomeworkRepository homeworkRepository;

    @Test
    void given_when_then(){
        //Given
        HomeworkEntity homeworkEntity = new HomeworkEntity();
        //When
        HomeworkEntity savedHomeworkEntity = homeworkRepository.save(homeworkEntity);
        //Then
        Assertions.assertNotNull(savedHomeworkEntity,"savedHomeworkEntity is null");

    }

    @Test
    void given_when_then1(){
        //Given
        HomeworkEntity homeworkEntity = new HomeworkEntity();
        homeworkEntity.setSubject(HomeworkSubject.FIZYKA);
        //When
        HomeworkEntity savedHomeworkEntity = homeworkRepository.save(homeworkEntity);
        //Then
        Assertions.assertEquals(HomeworkSubject.FIZYKA, savedHomeworkEntity.getSubject(),"subject is not equals");

    }
}