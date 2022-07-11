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
        Long id = 1L;
        //When
        Optional<HomeworkEntity> readHomeworkEntity = homeworkService.read(id);
        //Then
        Assertions.assertNotNull(readHomeworkEntity, "readHomeworkEntity is null");

    }

    @Test
    void update() {
        //Given
        HomeworkModel homeworkModel = new HomeworkModel();
        //When
        HomeworkModel updatedHomeworkModel = homeworkService.update(homeworkModel);
        //Then
        Assertions.assertNotNull(updatedHomeworkModel, "updateHomeworkEntity is null");

    }
}