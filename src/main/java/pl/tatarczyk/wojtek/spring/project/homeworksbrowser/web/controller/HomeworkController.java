package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.HomeworkEntity;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.service.HomeworkService;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/homeworks")
public class HomeworkController {

    private static final Logger LOGGER = Logger.getLogger(HomeworkController.class.getName());

    private HomeworkService homeworkService;

    public HomeworkController(HomeworkService homeworkService) {
        this.homeworkService = homeworkService;
    }

    @GetMapping
    public List<HomeworkEntity> list(){
        LOGGER.info("list()");
        List<HomeworkEntity> entities = homeworkService.list();
        return entities;
    }

    @GetMapping
    public HomeworkEntity create(){
        LOGGER.info("create()");
        HomeworkEntity homeworkEntity = homeworkService.create(new HomeworkEntity());

        return homeworkEntity;
    }

    @GetMapping
    void read(){
        LOGGER.info("read()");
//        homeworkService.read();
    }

    @GetMapping
    public HomeworkEntity update(){
        LOGGER.info("update()");
        HomeworkEntity updatedHomeworkEntity = homeworkService.update(new HomeworkEntity());

        return updatedHomeworkEntity;
    }

    void delete(){
        LOGGER.info("delete()");
//        homeworkService.delete();
    }
}

