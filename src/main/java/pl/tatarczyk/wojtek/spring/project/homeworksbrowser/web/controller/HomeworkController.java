package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.HomeworkEntity;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.service.HomeworkService;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.model.HomeworkModel;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/homeworks")
public class HomeworkController {

    private static final Logger LOGGER = Logger.getLogger(HomeworkController.class.getName());

    private HomeworkService homeworkService;

    public HomeworkController(HomeworkService homeworkService) {
        this.homeworkService = homeworkService;
    }

    @GetMapping
    public List<HomeworkEntity> list() {
        LOGGER.info("list()");
        List<HomeworkEntity> entities = homeworkService.list();
        return entities;
    }

    @PostMapping
    public HomeworkModel create(@RequestBody HomeworkModel homeworkModel) {
        LOGGER.info("create(" + homeworkModel + ")");
        HomeworkModel createdHomeworkModel = homeworkService.create(homeworkModel);

        return createdHomeworkModel;
    }

    @GetMapping(value = "/{id}")
    public Optional<HomeworkEntity> read(@PathVariable("id") Long id) {
        LOGGER.info("read()");
        Optional<HomeworkEntity> optionalHomeworkEntity = homeworkService.read(id);

        return optionalHomeworkEntity;
    }

    @PutMapping
    public HomeworkEntity update(@RequestBody HomeworkEntity homeworkEntity) {
        LOGGER.info("update()");
        HomeworkEntity updatedHomeworkEntity = homeworkService.update(homeworkEntity);

        return updatedHomeworkEntity;
    }

    @DeleteMapping
    void delete() {
        LOGGER.info("delete()");
//        homeworkService.delete();
    }
}

