package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.api.exception.StudentNotFoundException;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.service.StudentService;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.model.StudentModel;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/students")
public class StudentController {

    private static final Logger LOGGER = Logger.getLogger(StudentController.class.getName());

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentModel> list() {
        LOGGER.info("list()");
        return studentService.list();
    }

    @PostMapping
    public StudentModel create(@RequestBody StudentModel studentModel) {
        LOGGER.info("create(" + studentModel + ")");
        return studentService.create(studentModel);
    }

    @GetMapping(value = "/id")
    public StudentModel read(@PathVariable("id") Long id) throws StudentNotFoundException {
        LOGGER.info("read()");
        return studentService.read(id);
    }

    @PutMapping
    public StudentModel update(@RequestBody StudentModel studentModel) {
        LOGGER.info("update()");
        return studentService.update(studentModel);
    }

    @DeleteMapping
    void delete(){
        LOGGER.info("delete()");
    }
}
