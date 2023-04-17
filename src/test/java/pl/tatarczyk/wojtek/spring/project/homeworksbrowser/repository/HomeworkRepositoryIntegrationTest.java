package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.ClassEntity;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.ClassNameEntity;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.HomeworkEntity;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
class HomeworkRepositoryIntegrationTest {

    @Autowired
    private HomeworkRepository homeworkRepository;

    @Test
    @Transactional
    void given_when_then(){
        //Given
        HomeworkEntity homeworkEntity = new HomeworkEntity();
        ClassEntity classEntity = new ClassEntity();
        ClassNameEntity classNameEntity = new ClassNameEntity();
        classNameEntity.setName("1C");
        classEntity.setClassName(classNameEntity);
        classEntity.setYear(1926);
        homeworkEntity.setClazz(classEntity);

        HomeworkEntity secondHomeworkEntity = new HomeworkEntity();
        ClassEntity secondClassEntity = new ClassEntity();
        ClassNameEntity secondClassNameEntity = new ClassNameEntity();
        secondClassNameEntity.setName("2C");
        secondClassEntity.setClassName(secondClassNameEntity);
        secondClassEntity.setYear(1927);
        secondHomeworkEntity.setClazz(secondClassEntity);

        //When
        HomeworkEntity savedHomeworkEntity = homeworkRepository.save(homeworkEntity);
        HomeworkEntity savedSecondHomeworkEntity = homeworkRepository.save(secondHomeworkEntity);

        HomeworkEntity thirdHomeworkEntity = new HomeworkEntity();
        ClassEntity thirdClassEntity = new ClassEntity();
//        ClassNameEntity thirdClassNameEntity = new ClassNameEntity();
//        thirdClassNameEntity.setName("1C");
        thirdClassEntity.setClassName(savedHomeworkEntity.getClazz().getClassName());
        thirdClassEntity.setYear(1927);
        thirdHomeworkEntity.setClazz(thirdClassEntity);

        HomeworkEntity savedThirdHomeworkEntity = homeworkRepository.save(thirdHomeworkEntity);

        List<HomeworkEntity> byYearAndClazz_className_name =
                homeworkRepository.findByClazz_ClassName_NameAndClazzYear("1C", 1926);
        System.out.println("filtered homeworks: " + byYearAndClazz_className_name);

        //Then
        Assertions.assertNotNull(byYearAndClazz_className_name,"byYearAndClazz_className_name is null");

    }


}