package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.service.decorator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.model.ClassModel;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.model.ClassNameModel;

class ClassDecoratorTest {
    private static final String CLASS_NAME = "1c";
    private static final int YEAR = 1;

    @Test
    void decorate() {
        //Given
        ClassModel classModel = new ClassModel();
        ClassNameModel classNameModel = new ClassNameModel();
        classNameModel.setName(CLASS_NAME);
        classModel.setClassName(classNameModel);
        classModel.setYear(YEAR);
        //When
        String decoratedClass = ClassDecorator.decorate(classModel);
        //Then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(decoratedClass, "decoratedClass is null")
        );

    }

}