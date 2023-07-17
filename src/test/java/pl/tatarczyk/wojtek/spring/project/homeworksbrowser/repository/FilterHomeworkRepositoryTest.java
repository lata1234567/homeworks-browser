package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FilterHomeworkRepositoryTest {

    @Autowired
    private FilterHomeworkRepository filterHomeworkRepository;

    @Test
    void filter() {
        //Given

        //When
        filterHomeworkRepository.filter("sth");

        //Then

    }
}