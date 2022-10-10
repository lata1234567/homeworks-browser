package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.api.exception.HomeworkNotFoundException;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.service.ClassService;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.service.HomeworkService;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.model.HomeworkModel;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/homeworks")
public class HomeworkWebController {

    private static final Logger LOGGER = Logger.getLogger(HomeworkWebController.class.getName());

    private HomeworkService homeworkService;
    private ClassService classService;

    public HomeworkWebController(HomeworkService homeworkService, ClassService classService) {
        this.homeworkService = homeworkService;
        this.classService = classService;
    }

    @GetMapping
    public String list(Model model) {
        LOGGER.info("list()");
        List<HomeworkModel> homeworks = homeworkService.list();
        model.addAttribute("homeworks", homeworks);
        return "homeworks/list";
    }

    @GetMapping(value = "/create")
    public String createView(ModelMap modelMap) {
        LOGGER.info("createView()");
        modelMap.addAttribute("homeworkModel", new HomeworkModel());
        modelMap.addAttribute("classes", classService.list());
        return "homeworks/add";
    }

    @PostMapping
    public String create(@ModelAttribute HomeworkModel homeworkModel) {
        LOGGER.info("create(" + homeworkModel + ")");

        homeworkService.create(homeworkModel);

        return "redirect:/homeworks";
    }

    @GetMapping(value = "/{id}")
    public HomeworkModel read(@PathVariable("id") Long id) throws HomeworkNotFoundException {
        LOGGER.info("read()");

        return homeworkService.read(id);
    }

    @GetMapping(value = "/update/{id}")
    public String updateView(ModelMap modelMap, @PathVariable("id") Long id) throws HomeworkNotFoundException {
        LOGGER.info("updateView(" + id + ")");
//        HomeworkModel homeworkModel = new HomeworkModel();
//        homeworkModel.setContent("kanapka");
//        homeworkModel.setTitle("takie cos");
//        homeworkModel.setId(1L);
        HomeworkModel homeworkModel = homeworkService.read(id);
        modelMap.addAttribute("homeworkModel", homeworkModel);
        return "homeworks/add";
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute HomeworkModel homeworkModel) {
        LOGGER.info("update(" + homeworkModel + ") ");
//        homeworkService.update()
        return "redirect:/homeworks";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        LOGGER.info("delete()");
        homeworkService.delete(id);
        return "redirect:/homeworks";
    }
}

// TODO: 03.10.2022 na widoku umożliwiającym dodanie nowej pracy domowej dodać możliwość wyboru klasy, która została wcześniej dodana