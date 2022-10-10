package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.service.mapper;

import org.junit.jupiter.api.Test;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.ClassEntity;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.model.ClassModel;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ClassMapperTest {

    public static final Long CLASS_ID = 1L;
//    public static final ClassNameEntity CLASS_NAME_ENTITY = new ClassNameEntity();
    public static final Integer YEAR = 1;
    ClassMapper classMapper = new ClassMapper();

    @Test
    void from() {
        //Given
        ClassEntity classEntity = new ClassEntity();
//        classEntity.setClassName(CLASS_NAME_ENTITY);
        classEntity.setId(CLASS_ID);
        classEntity.setYear(YEAR);
        //When
        ClassModel classModel = classMapper.from(classEntity);
        //Then
        assertAll(
                () -> assertNotNull(classModel, "classModel is null"),
//                () -> assertNotNull(classModel.getClassNameModel(), "classNameEntity is null"),
                () -> assertEquals(CLASS_ID, classModel.getId(), "classModelId is not equels"),
                () -> assertEquals(YEAR, classModel.getYear(), "classYear is not equels")
        );
    }
}