package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.service;

import org.springframework.stereotype.Service;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.HomeworkRepository;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.HomeworkEntity;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.service.mapper.HomeworkMapper;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.model.HomeworkModel;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class HomeworkService {

    private static final Logger LOGGER = Logger.getLogger(HomeworkService.class.getName());

    private final HomeworkRepository homeworkRepository;
    private final HomeworkMapper homeworkMapper;

    public HomeworkService(HomeworkRepository homeworkRepository, HomeworkMapper homeworkMapper) {
        this.homeworkRepository = homeworkRepository;
        this.homeworkMapper = homeworkMapper;
    }

    public List<HomeworkEntity> list() {
        LOGGER.info("list()");
        List<HomeworkEntity> entities = homeworkRepository.findAll();

        return entities;
    }

    public HomeworkModel create(HomeworkModel homeworkModel) {
        LOGGER.info("create(" + homeworkModel + ")");

        HomeworkEntity mappedEntity = homeworkMapper.from(homeworkModel);
        HomeworkEntity savedHomeworkEntity = homeworkRepository.save(mappedEntity);
        HomeworkModel mappedHomeworkModel = homeworkMapper.from(savedHomeworkEntity);

        return mappedHomeworkModel;
    }

    public Optional<HomeworkEntity> read(Long id) {
        LOGGER.info("read(" + id + ")");

        Optional<HomeworkEntity> readHomeworkEntity = homeworkRepository.findById(id);
        LOGGER.info("readHomeworkEntity: " + readHomeworkEntity);

        return readHomeworkEntity;
    }

    public HomeworkEntity update(HomeworkEntity homeworkEntity) {
        LOGGER.info("update(" + homeworkEntity + ")");

        HomeworkEntity updateHomeworkEntity = homeworkRepository.save(homeworkEntity);

        return updateHomeworkEntity;
    }

    public void delete(HomeworkEntity homeworkEntity) {
        LOGGER.info("delete()");

        homeworkRepository.delete(homeworkEntity);
    }
}

// TODO: 04.07.2022 wzorując się na metodzie create pozmieniać typy entity na model
