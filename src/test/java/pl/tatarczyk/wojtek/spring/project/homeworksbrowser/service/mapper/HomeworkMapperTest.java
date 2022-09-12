package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.service.mapper;

import org.junit.jupiter.api.Test;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.api.model.HomeworkSubject;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.HomeworkEntity;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.model.HomeworkModel;

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
    HomeworkMapper homeworkMapper = new HomeworkMapper();

    @Test
    void from() {
        //Given
        HomeworkModel homeworkModel = new HomeworkModel();
        homeworkModel.setId(HOMEWORK_ID);
        homeworkModel.setTitle(HOMEWORK_TITLE);
        homeworkModel.setContent(HOMEWORK_CONTENT);
        homeworkModel.setSubject(HOMEWORK_SUBJECT);

        //When
        HomeworkEntity homeworkEntity = homeworkMapper.from(homeworkModel);

        //Then
        assertAll(
                () -> assertNotNull(homeworkEntity, "homeworkEntity is null"),
                () -> assertEquals(HOMEWORK_ID, homeworkEntity.getId(), "homeworkModel ID is not equals"),
                () -> assertEquals(HOMEWORK_TITLE, homeworkEntity.getTitle(), "homeworkModel TITLE is not equals"),
                () -> assertEquals(HOMEWORK_CONTENT, homeworkEntity.getContent(), "homeworkModel CONTENT is not equals"),
                () -> assertEquals(HOMEWORK_SUBJECT, homeworkEntity.getSubject(), "homeworkModel SUBJECT is not equals")
        );
    }

    @Test
    void testFrom() {
        //Given
        List<HomeworkModel> homeworkModels = new ArrayList<>();
        homeworkModels.add(new HomeworkModel());
        homeworkModels.add(new HomeworkModel());
        //When
        List<HomeworkEntity> homeworkEntities = homeworkMapper.fromModels(homeworkModels);
        //Then
        assertAll(
                () -> assertNotNull(homeworkEntities, "homeworkEntities is null"),
                () -> assertEquals(homeworkModels.size(), homeworkEntities.size(),"models and entities size is not equals")
        );


    }
}