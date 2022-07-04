package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.HomeworkEntity;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.model.HomeworkModel;

import java.util.Optional;

@SpringBootTest
class HomeworkServiceTest {
    @Autowired
    private HomeworkService homeworkService;

    @Test
    void create() {
        //Given
        HomeworkModel homeworkModel = new HomeworkModel();
        //When
        HomeworkModel createdHomeworkModel = homeworkService.create(homeworkModel);
        //Then
        Assertions.assertNotNull(createdHomeworkModel,"createdHomeworkModel is null");


    }

    @Test
    void read() {
        //Given
        Long id = null;
        //When
        Optional<HomeworkEntity> readHomeworkEntity = homeworkService.read(id);
        //Then
        Assertions.assertNotNull(readHomeworkEntity, "readHomeworkEntity is null");

    }

    @Test
    void update() {
        //Given
        HomeworkEntity homeworkEntity = new HomeworkEntity();
        //When
        HomeworkEntity updateHomeworkEntity = homeworkService.update(homeworkEntity);
        //Then
        Assertions.assertNotNull(updateHomeworkEntity, "updateHomeworkEntity is null");

    }
}