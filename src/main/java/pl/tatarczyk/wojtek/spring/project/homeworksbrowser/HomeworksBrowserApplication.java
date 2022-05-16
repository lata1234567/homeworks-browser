package pl.tatarczyk.wojtek.spring.project.homeworksbrowser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HomeworksBrowserApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeworksBrowserApplication.class, args);
	}

}
// TODO: 09.05.2022 storzyć dla modeli odpowiadające im encje (@Entity)
// dla każdego modelu stworzyć nową klase serwis(class,homework,user), która będzie zawiera metody(wydmuszka) CRUD