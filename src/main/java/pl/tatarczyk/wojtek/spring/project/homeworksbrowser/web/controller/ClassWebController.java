package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.api.exception.ClassNotFoundException;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.service.ClassService;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.model.ClassModel;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/classes")
public class ClassWebController {
    private static final Logger LOGGER = Logger.getLogger(ClassWebController.class.getName());

    private ClassService classService;

    public ClassWebController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping
    public String list(ModelMap modelMap, Model model) {
        LOGGER.info("list()");
        List<ClassModel> classes = classService.list();
        model.addAttribute("classes", classes);
        modelMap.addAttribute("typeOfPage", "listOfClasses");
        return "classes/list";
    }

    @PostMapping
    public String create(@ModelAttribute ClassModel classModel) {
        LOGGER.info("create(" + classModel + ")");

        classService.create(classModel);

        return "redirect:/classes";
    }

    @GetMapping(value = "/create")
    public String createView(ModelMap modelMap) {
        LOGGER.info("createView()");
        modelMap.addAttribute("classModel", new ClassModel());

        return "classes/add";
    }

    @GetMapping(value = "/{id}")
    public ClassModel read(@PathVariable("id") Long id) throws ClassNotFoundException {
        LOGGER.info("read()");

        return classService.read(id);
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute ClassModel classModel) {
        LOGGER.info("update(" + classModel + ") ");
        return null;
    }

    @GetMapping(value = "/update/{id}")
    public String updateView(ModelMap modelMap, @PathVariable("id") Long id) throws ClassNotFoundException, ClassNotFoundException {
        LOGGER.info("updateView(" + id + ")");
        ClassModel classModel = classService.read(id);
        modelMap.addAttribute("classModel", classModel);
        return null;
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        LOGGER.info("delete()");
        classService.delete(id);
        return "redirect:/classes";
    }

    @GetMapping(value = "/filter/keyword")
    public String filterKeyword(ModelMap modelMap, Model model, String keyword) {
        LOGGER.info("list(" + keyword + ")");
        List<ClassModel> classes = classService.search(keyword);
        model.addAttribute("classes", classes);
        modelMap.addAttribute("typeOfPage", "listOfClasses");
        return "classes/list";
    }
}
