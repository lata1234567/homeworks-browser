package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.web.model.ClassModel;

@SpringBootTest
class FilterHomeworkRepositoryTest {

    @Autowired
    private FilterHomeworkRepository filterHomeworkRepository;

    @Test
    void filter() {
        //Given
        ClassModel classModel = new ClassModel();
        //When
        filterHomeworkRepository.filter("sth", classModel);

        //Then

    }
}