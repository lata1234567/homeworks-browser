package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.StudentEntity;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.model.StudentModel;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class StudentMapper {

    private static final Logger LOGGER = Logger.getLogger(StudentMapper.class.getName());

    public List<StudentEntity> fromModels(List<StudentModel> studentModels) {
        LOGGER.info("fromModels(" + studentModels + ")");
        return studentModels.stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    public List<StudentModel> fromEntities(List<StudentEntity> studentEntities) {
        LOGGER.info("fromModels(" + studentEntities + ")");
        return studentEntities.stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    public StudentEntity from(StudentModel studentModel) {
        LOGGER.info("from(" + studentModel + ")");

        ModelMapper modelMapper = new ModelMapper();
        StudentEntity studentEntity = modelMapper.map(studentModel, StudentEntity.class);

        LOGGER.info("from(...) = " + studentEntity);
        return studentEntity;
    }

    public StudentModel from(StudentEntity studentEntity) {
        LOGGER.info("from(" + studentEntity + ")");

        ModelMapper modelMapper = new ModelMapper();
        StudentModel studentModel = modelMapper.map(studentEntity, StudentModel.class);

        LOGGER.info("from(...) = " + studentEntity);
        return studentModel;
    }
}
