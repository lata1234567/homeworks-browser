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
    public List<HomeworkModel> list() {
        LOGGER.info("list()");
        return homeworkService.list();
    }

    @PostMapping
    public HomeworkModel create(@RequestBody HomeworkModel homeworkModel) {
        LOGGER.info("create(" + homeworkModel + ")");

        return homeworkService.create(homeworkModel);
    }

    @GetMapping(value = "/{id}")
    public Optional<HomeworkEntity> read(@PathVariable("id") Long id) {
        LOGGER.info("read()");

        return homeworkService.read(id);
    }

    @PutMapping
    public HomeworkModel update(@RequestBody HomeworkModel homeworkModel) {
        LOGGER.info("update()");

        return homeworkService.update(homeworkModel);
    }

    @DeleteMapping
    void delete() {
        LOGGER.info("delete()");
//        homeworkService.delete();
    }
}

