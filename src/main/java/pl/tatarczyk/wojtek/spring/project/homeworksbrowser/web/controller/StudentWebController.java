package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.api.exception.StudentNotFoundException;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.service.ClassService;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.service.StudentService;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.model.StudentModel;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/students")
public class StudentWebController {

    private static final Logger LOGGER = Logger.getLogger(StudentWebController.class.getName());

    private StudentService studentService;
    private ClassService classService;

    public StudentWebController(StudentService studentService, ClassService classService) {
        this.studentService = studentService;
        this.classService = classService;
    }

    @GetMapping
    public String list(Model model) {
        LOGGER.info("list()");
        List<StudentModel> students = studentService.list();
        model.addAttribute("students", students);
        return "students/list";
    }

    @GetMapping(value = "/create")
    public String createView(ModelMap modelMap) {
        LOGGER.info("createView()");
        modelMap.addAttribute("studentModel", new StudentModel());
//        modelMap.addAttribute("classes", classService.list());
        return "students/add";
    }

    @PostMapping
    public String create(@ModelAttribute StudentModel studentModel) {
        LOGGER.info("create(" + studentModel + ")");

        studentService.create(studentModel);

        return "redirect:/students";
//        return "redirect:/students/success";
//        return "students/success";
//        return "/login";
    }

//    @GetMapping(value = "/create/success")
//    public String createSuccess() {
//        LOGGER.info("createSuccess()");
//        return "students/success";
//    }

    @GetMapping(value = "/{id}")
    public StudentModel read(@PathVariable("id") Long id) throws StudentNotFoundException {
        LOGGER.info("read()");

        return studentService.read(id);
    }

    @GetMapping(value = "/update/{id}")
    public String updateView(ModelMap modelMap, @PathVariable("id") Long id) throws StudentNotFoundException {
        LOGGER.info("updateView(" + id + ")");
        StudentModel studentModel = studentService.read(id);
        return "students/add";
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute StudentModel studentModel) {
        LOGGER.info("update(" + studentModel + ") ");
        return "redirect:/students";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        LOGGER.info("delete()");
        studentService.delete(id);
        return "redirect:/students";
    }

    // TODO: 28.11.2022 dorobić testy do studenta
}
