package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.service.mapper;

import org.junit.jupiter.api.Test;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.HomeworkEntity;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.model.HomeworkModel;

import static org.junit.jupiter.api.Assertions.*;

class HomeworkMapperTest {

    public static final long HOMEWORK_ID = 1L;
    public static final String HOMEWORK_TITLE = "Title";
    HomeworkMapper homeworkMapper = new HomeworkMapper();

    @Test
    void from() {
        //Given
        HomeworkModel homeworkModel = new HomeworkModel();
        homeworkModel.setId(HOMEWORK_ID);
        homeworkModel.setTitle(HOMEWORK_TITLE);

        //When
        HomeworkEntity homeworkEntity = homeworkMapper.from(homeworkModel);

        //Then
        assertAll(
                () -> assertNotNull(homeworkEntity, "homeworkEntity is null"),
                () -> assertEquals(HOMEWORK_ID, homeworkEntity.getId(), "homeworkModel ID is not equals"),
                () -> assertEquals(HOMEWORK_TITLE, homeworkEntity.getTitle(), "homeworkModel TITLE is not equals")

        );
    }
}