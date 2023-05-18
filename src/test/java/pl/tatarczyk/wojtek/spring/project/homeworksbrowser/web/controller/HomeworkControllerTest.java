package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.api.exception.ClassNotFoundException;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.HomeworkRepository;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.HomeworkEntity;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.model.HomeworkModel;

import java.util.List;

// TODO: 29.08.2022 spróbować napisać poprawne testy jednoskowe dla warstwy web zgodznie z https://spring.io/guides/gs/testing-web/
@SpringBootTest
class HomeworkControllerTest {

    @Autowired
    private HomeworkController homeworkController;

    @Autowired
    private HomeworkRepository homeworkRepository;

    @Test
    void list() {
        //Given

        //When
        List<HomeworkModel> models = homeworkController.list(null);
        //Then
        Assertions.assertEquals(0, models.size(),"models size not zero");

    }

    @Test
    void list1() {
        //Given

        //When
        homeworkRepository.save(new HomeworkEntity());
        List<HomeworkModel> models = homeworkController.list(null);
        //Then
        Assertions.assertEquals(1, models.size(),"models size not zero");

    }


    @Test
    void create() throws ClassNotFoundException {
        //Given

        //When
        HomeworkModel createdHomeworkModel = homeworkController.create(new HomeworkModel());
        //Then
        Assertions.assertNotNull(createdHomeworkModel, "createdHomeworkEntity is null");

    }

    @Test
    void update() {
        //Given

        //When
        HomeworkModel updateHomeworkModel = homeworkController.update(new HomeworkModel());
        //Then
        Assertions.assertNotNull(updateHomeworkModel, "updateHomeworkEntity is null");

    }
}