package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.api.exception.ClassNotFoundException;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.service.ClassService;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.model.ClassModel;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/classes")
public class ClassController {

    private static final Logger LOGGER = Logger.getLogger(ClassController.class.getName());

    private ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    public List<ClassModel> list() {
        LOGGER.info("list()");
        return classService.list();
    }

    public ClassModel create(@RequestBody ClassModel classModel) {
        LOGGER.info("create(" + classModel + ")");

        return classService.create(classModel);
    }

    @GetMapping(value="/{id}")
    public ClassModel read(@PathVariable("id")Long id) throws ClassNotFoundException {
        LOGGER.info("read()");

        return classService.read(id);
    }

    @PutMapping
    public ClassModel update(@RequestBody ClassModel classModel){
        LOGGER.info("update(" + classModel + ")");

        return classService.update(classModel);
    }

    @DeleteMapping
    void delete() {
        LOGGER.info("delete()");
//        classService.delete();
    }
}
