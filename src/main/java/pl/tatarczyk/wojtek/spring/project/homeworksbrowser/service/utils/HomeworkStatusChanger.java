package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.service.utils;

import org.springframework.stereotype.Component;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.api.model.HomeworkStatus;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.HomeworkRepository;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.HomeworkEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

@Component
public class HomeworkStatusChanger {

    private static final Logger LOGGER = Logger.getLogger(HomeworkStatusChanger.class.getName());

    private final HomeworkRepository homeworkRepository;

    public HomeworkStatusChanger(HomeworkRepository homeworkRepository) {
        this.homeworkRepository = homeworkRepository;
    }

    public void changerStatusIntoInProgress() {
        LOGGER.info("changeStatusIntoInProgress()");

        List<HomeworkEntity> entities = homeworkRepository.findAll();

        for (HomeworkEntity entity : entities) {
            LocalDate addDate = entity.getCreated();
            if (addDate != null) {
                if (addDate.getDayOfMonth() + 1 <= LocalDate.now().getDayOfMonth()) {
                    entity.setStatus(HomeworkStatus.IN_PROGRESS);
                    homeworkRepository.save(entity);
                }
            }
        }
    }
}

// TODO: 20.03.2023 dopisać test jednostkowy i poprawić sprawdznie czy in progress