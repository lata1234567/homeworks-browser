package pl.tatarczyk.wojtek.spring.project.homeworksbrowser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HomeworksBrowserApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeworksBrowserApplication.class, args);
	}

}
