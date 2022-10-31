package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.service.decorator;

import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.model.ClassModel;

import java.util.logging.Logger;

public class ClassDecorator {

    private static final Logger LOGGER = Logger.getLogger(ClassDecorator.class.getName());

    public static String decorate(ClassModel classModel) {
        LOGGER.info("decorate(" + classModel + ")");
        String decoratedClass = "";
        if (classModel != null) {
            if (classModel.getClassName() != null) {
                decoratedClass = "class : " + classModel.getClassName().getName() + ", year : " + classModel.getYear();
            }
        }
        LOGGER.info("decorate(...)= " + decoratedClass);

        return decoratedClass;
    }
}
