package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.ClassEntity;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.model.ClassModel;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class ClassMapper {

    private static final Logger LOGGER = Logger.getLogger(ClassMapper.class.getName());

    public List<ClassEntity> formModels(List<ClassModel> classModels) {
        LOGGER.info("fromModels(" + classModels + ")");
        return classModels.stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    public List<ClassModel> formEntities(List<ClassEntity> classEntities) {
        LOGGER.info("fromModels(" + classEntities + ")");
        return classEntities.stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    public ClassEntity from(ClassModel classModel) {
        LOGGER.info("from(" + classModel + ")");

        ModelMapper modelMapper = new ModelMapper();
        ClassEntity classEntity = modelMapper.map(classModel, ClassEntity.class);

        LOGGER.info("from(...) = " + classEntity);

        return classEntity;
    }

    public ClassModel from(ClassEntity classEntity) {
        LOGGER.info("from(" + classEntity + ")");

        ModelMapper modelMapper = new ModelMapper();
        ClassModel classModel = modelMapper.map(classEntity, ClassModel.class);

        LOGGER.info("from(...) = " + classModel);

        return classModel;
    }
}
