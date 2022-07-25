package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.HomeworkEntity;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.model.HomeworkModel;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class HomeworkMapper {

    private static final Logger LOGGER = Logger.getLogger(HomeworkMapper.class.getName());

    public List<HomeworkEntity> fromModels(List<HomeworkModel> homeworkModels) {
        LOGGER.info("fromModels(" + homeworkModels + ")");
        return homeworkModels.stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    public List<HomeworkModel> fromEntities(List<HomeworkEntity> homeworkEntities) {
        LOGGER.info("fromEntities(" + homeworkEntities + ")");
        return homeworkEntities.stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    public HomeworkEntity from(HomeworkModel homeworkModel) {
        LOGGER.info("from(" + homeworkModel + ")");

//        HomeworkEntity homeworkEntity = new HomeworkEntity();
        ModelMapper modelMapper = new ModelMapper();
        HomeworkEntity homeworkEntity = modelMapper.map(homeworkModel, HomeworkEntity.class);

//        homeworkEntity.setId(homeworkModel.getId());
//        homeworkEntity.setTitle(homeworkModel.getTitle());
//        homeworkEntity.setContent(homeworkModel.getContent());

        LOGGER.info("from(...) = " + homeworkEntity);
        return homeworkEntity;
    }

    public HomeworkModel from(HomeworkEntity homeworkEntity) {
        LOGGER.info("from(" + homeworkEntity + ")");
//        HomeworkModel homeworkModel = new HomeworkModel();
        ModelMapper modelMapper = new ModelMapper();
        HomeworkModel homeworkModel = modelMapper.map(homeworkEntity, HomeworkModel.class);

//        homeworkModel.setId(homeworkEntity.getId());
//        homeworkModel.setTitle(homeworkEntity.getTitle());

        LOGGER.info("from(...) = " + homeworkModel);

        return homeworkModel;
    }

}

// TODO: 18.07.2022 poprawić homeworkmapper by używał Mdoelmapper,
// w controlerze HomeworkWebControler dodać obsługę wyświetlania listy prac domowych (odpowiedni end point + nowy html)