package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.service.mapper;

import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.HomeworkEntity;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.model.HomeworkModel;

import java.util.logging.Logger;

public class HomeworkMapper {

    private static final Logger LOGGER = Logger.getLogger(HomeworkMapper.class.getName());


    public HomeworkEntity from(HomeworkModel homeworkModel) {
        LOGGER.info("from(" + homeworkModel + ")");

        HomeworkEntity homeworkEntity = new HomeworkEntity();

        homeworkEntity.setId(homeworkModel.getId());
        homeworkEntity.setTitle(homeworkModel.getTitle());

        LOGGER.info("from(...) = " + homeworkEntity);
        return homeworkEntity;
    }
}
