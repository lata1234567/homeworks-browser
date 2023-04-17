package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.service.mapper;

import org.junit.jupiter.api.Test;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.api.model.HomeworkStatus;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.api.model.HomeworkSubject;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.HomeworkEntity;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.model.ClassModel;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.model.HomeworkModel;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class HomeworkMapperTest {

    public static final long HOMEWORK_ID = 1L;
    public static final String HOMEWORK_TITLE = "Title";
    private static final String HOMEWORK_CONTENT = "Content";
    private static final HomeworkSubject HOMEWORK_SUBJECT = HomeworkSubject.FIZYKA;
    private static final HomeworkStatus HOMEWORK_STATUS = HomeworkStatus.NEW;
    public static final LocalDate HOMEWORK_DUE_DATE = LocalDate.of(2023, Month.FEBRUARY, 5);
    public static final LocalDate HOMEWORK_ADD_DATE = LocalDate.of(2023, Month.NOVEMBER, 21);

    @Test
    void from() {
        //Given
        HomeworkMapper homeworkMapper = new HomeworkMapper();
        HomeworkModel homeworkModel = new HomeworkModel();
        ClassModel classModel = new ClassModel();

        homeworkModel.setId(HOMEWORK_ID);
        homeworkModel.setTitle(HOMEWORK_TITLE);
        homeworkModel.setContent(HOMEWORK_CONTENT);
        homeworkModel.setSubject(HOMEWORK_SUBJECT);
        homeworkModel.setClazz(classModel);
        homeworkModel.setStatus(HOMEWORK_STATUS);
        homeworkModel.setDueDate(HOMEWORK_DUE_DATE);
        homeworkModel.setCreated(HOMEWORK_ADD_DATE);

        //When
        HomeworkEntity homeworkEntity = homeworkMapper.from(homeworkModel);

        //Then
        assertAll(
                () -> assertNotNull(homeworkEntity, "homeworkEntity is null"),
                () -> assertEquals(HOMEWORK_ID, homeworkEntity.getId(), "homeworkModel ID is not equals"),
                () -> assertEquals(HOMEWORK_TITLE, homeworkEntity.getTitle(), "homeworkModel TITLE is not equals"),
                () -> assertEquals(HOMEWORK_CONTENT, homeworkEntity.getContent(), "homeworkModel CONTENT is not equals"),
                () -> assertEquals(HOMEWORK_SUBJECT, homeworkEntity.getSubject(), "homeworkModel SUBJECT is not equals"),
                () -> assertNotNull(homeworkEntity.getClazz(), "homeworkModel CLASS is null"),
                () -> assertEquals(HOMEWORK_STATUS, homeworkEntity.getStatus(), "homeworkModel STATUS is not equals"),
                () -> assertEquals(HOMEWORK_DUE_DATE, homeworkEntity.getDueDate(), "homeworkModel DUE DATE is not equals"),
                () -> assertEquals(HOMEWORK_ADD_DATE, homeworkEntity.getCreated(), "homeworkModel ADD DATE is not equals")
        );
    }

    @Test
    void testFrom() {
        //Given
        HomeworkMapper homeworkMapper = new HomeworkMapper();
        List<HomeworkModel> homeworkModels = new ArrayList<>();
        homeworkModels.add(new HomeworkModel());
        homeworkModels.add(new HomeworkModel());
        //When
        List<HomeworkEntity> homeworkEntities = homeworkMapper.fromModels(homeworkModels);
        //Then
        assertAll(
                () -> assertNotNull(homeworkEntities, "homeworkEntities is null"),
                () -> assertEquals(homeworkModels.size(), homeworkEntities.size(), "models and entities size is not equals")
        );


    }
}