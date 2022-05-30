package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.controller;

import org.springframework.stereotype.Controller;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.service.HomeworkService;

import java.util.logging.Logger;

@Controller
public class HomeworkController {

    private static final Logger LOGGER = Logger.getLogger(HomeworkController.class.getName());

    private HomeworkService homeworkService;

    public HomeworkController(HomeworkService homeworkService) {
        this.homeworkService = homeworkService;
    }

    void list(){
        LOGGER.info("list()");
//        homeworkService.
    }

    void create(){
        LOGGER.info("create()");
    }

    void read(){
        LOGGER.info("read()");
    }

    void update(){
        LOGGER.info("update()");
    }

    void delete(){
        LOGGER.info("delete()");
    }
}
