package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.service;

import org.springframework.stereotype.Service;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.api.exception.ClassNotFoundException;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.ClassRepository;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.ClassEntity;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.service.mapper.ClassMapper;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.model.ClassModel;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ClassService {

    private static final Logger LOGGER = Logger.getLogger(ClassService.class.getName());

    private final ClassRepository classRepository;
    private final ClassMapper classMapper;

    public ClassService(ClassRepository classRepository, ClassMapper classMapper) {
        this.classRepository = classRepository;
        this.classMapper = classMapper;
    }

    public List<ClassModel> list() {
        LOGGER.info("list()");
        List<ClassEntity> entities = classRepository.findAll();

        return classMapper.formEntities(entities);
    }


    @Transactional
    public ClassModel create(ClassModel classModel) {
        LOGGER.info("create(" + classModel + ")");

        ClassEntity mappedEntity = classMapper.from(classModel);
        ClassEntity savedClassEntity = classRepository.save(mappedEntity);

        return classMapper.from(savedClassEntity);
    }

    public ClassModel read(Long id) throws ClassNotFoundException {
        LOGGER.info("read(" + id + ")");

        Optional<ClassEntity> optionalClassEntity = classRepository.findById(id);
        ClassEntity classEntity = optionalClassEntity.orElseThrow(
                () -> new ClassCastException("Not found homework with id " + id));
        ClassModel classModel = classMapper.from(classEntity);
        LOGGER.info("optionalClassEntity: " + optionalClassEntity);

        return classModel;
    }

    public ClassModel update(ClassModel classModel) {
        LOGGER.info("update(" + classModel + ")");

        ClassEntity mappedClassEntity = classMapper.from(classModel);
        ClassEntity updateClassEntity = classRepository.save(mappedClassEntity);

        return classMapper.from(updateClassEntity);
    }

    public void delete(Long id) {
        LOGGER.info("delete(" + id + ")");
        classRepository.deleteById(id);
    }
}
