package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.api.exception.ClassNotFoundException;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.api.exception.HomeworkNotFoundException;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.api.model.HomeworkStatus;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.ClassRepository;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.HomeworkRepository;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.StudentRepository;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.ClassEntity;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.HomeworkEntity;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.StudentEntity;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.service.mapper.ClassMapper;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.service.mapper.HomeworkMapper;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.service.mapper.StudentMapper;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.model.ClassModel;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.model.HomeworkModel;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class HomeworkService {

    private static final Logger LOGGER = Logger.getLogger(HomeworkService.class.getName());

    private final HomeworkRepository homeworkRepository;
    private final StudentRepository studentRepository;
    private final ClassRepository classRepository;
    private final HomeworkMapper homeworkMapper;
    private final StudentMapper studentMapper;
    private final ClassMapper classMapper;
    private final ClassService classService;

    public HomeworkService(HomeworkRepository homeworkRepository, StudentRepository studentRepository, ClassRepository classRepository, HomeworkMapper homeworkMapper, StudentMapper studentMapper, ClassMapper classMapper, ClassService classService) {
        this.homeworkRepository = homeworkRepository;
        this.studentRepository = studentRepository;
        this.classRepository = classRepository;
        this.homeworkMapper = homeworkMapper;
        this.studentMapper = studentMapper;
        this.classMapper = classMapper;
        this.classService = classService;
    }

    public List<HomeworkModel> list(String principalName) throws ClassNotFoundException {
        LOGGER.info("list(" + principalName + ")");

        StudentEntity studentEntity = studentRepository.findByLogin(principalName);
        LOGGER.info("studentEntity: " + studentEntity);

        Long clazzId = studentEntity.getClazz().getId();
        Optional<ClassEntity> optionalClassEntity = classRepository.findById(clazzId);
        ClassEntity classEntity = optionalClassEntity.orElseThrow(
                () -> new ClassNotFoundException("Not found class with id " + clazzId));

        List<HomeworkEntity> entities = homeworkRepository.findByClazz_ClassName_NameAndClazzYear(
                classEntity.getClassName().getName(), classEntity.getYear());

        LOGGER.info("list(...) = " + entities);
        return homeworkMapper.fromEntities(entities);
    }

    //    @Transactional
    public HomeworkModel create(HomeworkModel homeworkModel) throws ClassNotFoundException {
        LOGGER.info("create(" + homeworkModel + ")");

        homeworkModel.setStatus(HomeworkStatus.NEW);
        homeworkModel.setCreated(LocalDate.now());

        HomeworkEntity mappedEntity = homeworkMapper.from(homeworkModel);

        Long clazzId = homeworkModel.getClazz().getId();
        Optional<ClassEntity> optionalClassEntity = classRepository.findById(clazzId);
        ClassEntity classEntity = optionalClassEntity.orElseThrow(
                () -> new ClassNotFoundException("Not found class with id " + clazzId));
        mappedEntity.setClazz(classEntity);

        HomeworkEntity savedHomeworkEntity = homeworkRepository.save(mappedEntity);

        return homeworkMapper.from(savedHomeworkEntity);
    }

    public HomeworkModel read(Long id) throws HomeworkNotFoundException {
        LOGGER.info("read(" + id + ")");

        Optional<HomeworkEntity> optionalHomeworkEntity = homeworkRepository.findById(id);
        HomeworkEntity homeworkEntity = optionalHomeworkEntity.orElseThrow(
                () -> new HomeworkNotFoundException("Not found homework with id " + id));
        HomeworkModel homeworkModel = homeworkMapper.from(homeworkEntity);
        LOGGER.info("optionalHomeworkEntity: " + optionalHomeworkEntity);

        return homeworkModel;
    }

    public HomeworkModel update(HomeworkModel homeworkModel) throws ClassNotFoundException {
        LOGGER.info("update(" + homeworkModel + ")");

        HomeworkEntity mappedHomeworkEntity = homeworkMapper.from(homeworkModel);

        Long clazzId = homeworkModel.getClazz().getId();
        Optional<ClassEntity> optionalClassEntity = classRepository.findById(clazzId);
        ClassEntity classEntity = optionalClassEntity.orElseThrow(
                () -> new ClassNotFoundException("Not found class with id " + clazzId));
        mappedHomeworkEntity.setClazz(classEntity);

        HomeworkEntity updateHomeworkEntity = homeworkRepository.save(mappedHomeworkEntity);
        HomeworkModel mappedHomeworkModel = homeworkMapper.from(updateHomeworkEntity);

        LOGGER.info("update(...) = " + mappedHomeworkModel);
        return mappedHomeworkModel;
    }

    public void delete(Long id) {
        LOGGER.info("delete(" + id + ")");
        homeworkRepository.deleteById(id);
    }

    public ClassModel studentClass(String username) throws ClassNotFoundException {
        StudentEntity studentEntity = studentRepository.findByLogin(username);
        ClassModel classModel = classService.read(studentEntity.getClazz().getId());
        return classModel;
    }

    public List<HomeworkModel> filterTitle(String title) {
        LOGGER.info("filterTitle(" + title + ")");

        List<HomeworkEntity> homeworkEntities = homeworkRepository.findByTitle(title, PageRequest.of(0, 2));

        return homeworkMapper.fromEntities(homeworkEntities);
    }

    public List<HomeworkModel> search(String keyword) {
        LOGGER.info("search(" + keyword + ")");

        List<HomeworkEntity> homeworkEntities = homeworkRepository.search(keyword);

        return homeworkMapper.fromEntities(homeworkEntities);
    }
}