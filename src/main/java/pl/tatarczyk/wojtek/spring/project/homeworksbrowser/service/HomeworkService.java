package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.service;

import org.springframework.stereotype.Service;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.HomeworkRepository;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.HomeworkEntity;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class HomeworkService {

    private static final Logger LOGGER = Logger.getLogger(HomeworkService.class.getName());

    private HomeworkRepository homeworkRepository;

    public HomeworkService(HomeworkRepository homeworkRepository) {
        this.homeworkRepository = homeworkRepository;
    }

    public List<HomeworkEntity> list() {
        LOGGER.info("list()");
        List<HomeworkEntity> entities = homeworkRepository.findAll();

        return entities;
    }

    public HomeworkEntity create(HomeworkEntity homeworkEntity) {
        LOGGER.info("create(" + homeworkEntity + ")");

        HomeworkEntity savedHomeworkEntity = homeworkRepository.save(homeworkEntity);

        return savedHomeworkEntity;
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
