package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.service;

import org.springframework.stereotype.Service;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.api.exception.HomeworkNotFoundException;
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

    public List<HomeworkModel> list() {
        LOGGER.info("list()");
        List<HomeworkEntity> entities = homeworkRepository.findAll();

        return homeworkMapper.fromEntities(entities);
    }

    public HomeworkModel create(HomeworkModel homeworkModel) {
        LOGGER.info("create(" + homeworkModel + ")");

        HomeworkEntity mappedEntity = homeworkMapper.from(homeworkModel);
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

    public HomeworkModel update(HomeworkModel homeworkModel) {
        LOGGER.info("update(" + homeworkModel + ")");

        HomeworkEntity mappedHomeworkEntity = homeworkMapper.from(homeworkModel);
        HomeworkEntity updateHomeworkEntity = homeworkRepository.save(mappedHomeworkEntity);

        return homeworkMapper.from(updateHomeworkEntity);
    }

    public void delete(HomeworkModel homeworkModel) {
        LOGGER.info("delete()");

        HomeworkEntity mappedHomeworkEntity = homeworkMapper.from(homeworkModel);
        homeworkRepository.delete(mappedHomeworkEntity);
    }
}

// TODO: 04.07.2022 wzorując się na metodzie create pozmieniać typy entity na model                                                                                    m   m mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmkjJj32
