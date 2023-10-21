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

        LOGGER.info("entities = " + entities);

        List<ClassModel> classModels = classMapper.formEntities(entities);

        LOGGER.info("list() = " + classModels);

        return classModels;
    }


    @Transactional
    public ClassModel create(ClassModel classModel) {
        LOGGER.info("create(" + classModel + ")");

        ClassEntity mappedEntity = classMapper.from(classModel);
        ClassEntity savedClassEntity = classRepository.save(mappedEntity);

        ClassModel createdClassModel = classMapper.from(savedClassEntity);
        LOGGER.info("create(...) = " + createdClassModel);
        return createdClassModel;
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

    public List<ClassModel> search(String title){
        LOGGER.info("search("+title+")");

        List<ClassEntity> classEntities = classRepository.findByClassName_Name(title);

        return classMapper.formEntities(classEntities);
    }
}
