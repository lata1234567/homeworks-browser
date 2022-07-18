package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.api.exception.HomeworkNotFoundException;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.service.HomeworkService;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.model.HomeworkModel;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/homeworks")
public class HomeworkWebController {

    private static final Logger LOGGER = Logger.getLogger(HomeworkWebController.class.getName());

    private HomeworkService homeworkService;

    public HomeworkWebController(HomeworkService homeworkService) {
        this.homeworkService = homeworkService;
    }

    @GetMapping
    public List<HomeworkModel> list() {
        LOGGER.info("list()");
        return homeworkService.list();
    }

    @GetMapping(value = "/create")
    public String createView() {
        return "homework/add";
        // TODO: 11.07.2022 stworzyć html z formularzem umożliwiającym dodanie nowej pracy domowej (wzorować sięna instniejącym kodzie) 
    }

    @PostMapping
    public String create(@ModelAttribute HomeworkModel homeworkModel) {
        LOGGER.info("create(" + homeworkModel + ")");

        homeworkService.create(homeworkModel);

        return "redirect:/homeworks/create";
    }

    @GetMapping(value = "/{id}")
    public HomeworkModel read(@PathVariable("id") Long id) throws HomeworkNotFoundException {
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

