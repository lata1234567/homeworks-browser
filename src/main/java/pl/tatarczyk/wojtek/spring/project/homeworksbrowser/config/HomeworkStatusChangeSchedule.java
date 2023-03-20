package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.service.utils.HomeworkStatusChanger;

import java.util.logging.Logger;

@Component
public class HomeworkStatusChangeSchedule {

    private static final Logger LOGGER = Logger.getLogger(HomeworkStatusChangeSchedule.class.getName());

    private final HomeworkStatusChanger homeworkStatusChanger;

    public HomeworkStatusChangeSchedule(HomeworkStatusChanger homeworkStatusChanger) {
        this.homeworkStatusChanger = homeworkStatusChanger;
    }

    @Scheduled(cron = "10 * * * * *")
    void homeworkStatusChangerSchedule() {
        LOGGER.info("homeworkStatusChangerSchedule");
        homeworkStatusChanger.changerStatusIntoInProgress();
    }


}

// TODO: 13.03.2023 wydzielić zawartość metody changeStatusIntoInProgress() do nowej klasy z jedną metodą (w serwisie pakiet utils)
// nowa metoda w nowej klasie powinna robić zmianę statusu
// napisać test jednostkowy dla tej metody