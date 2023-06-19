package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.api.model.HomeworkSubject;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.ClassEntity;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.ClassNameEntity;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.HomeworkEntity;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
class HomeworkRepositoryIntegrationTest {

    private static final int SEARCHED_HOMEWORKS_MATH_SIZE_2 = 2;

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

    @Test
    void search() {
        // given
        HomeworkEntity simpleHomeworkEntity = new HomeworkEntity();
        simpleHomeworkEntity.setSubject(HomeworkSubject.MATEMATYKA);
        simpleHomeworkEntity.setTitle("Simple Math Homework");
        simpleHomeworkEntity.setContent("Simple Content: Equations and Formulas");

        HomeworkEntity complexHomeworkEntity = new HomeworkEntity();
        complexHomeworkEntity.setSubject(HomeworkSubject.MATEMATYKA);
        complexHomeworkEntity.setTitle("Complex Math Homework");
        complexHomeworkEntity.setContent("Complex Content: Integrals and Derivatives");

        HomeworkEntity littleHomeworkEntity = new HomeworkEntity();
        littleHomeworkEntity.setSubject(HomeworkSubject.J_POLSKI);
        littleHomeworkEntity.setTitle("Mała praca domowa");
        littleHomeworkEntity.setContent("Treść: Fraszki i Bajki");

        HomeworkEntity niceHomeworkEntity = new HomeworkEntity();
        niceHomeworkEntity.setSubject(HomeworkSubject.J_POLSKI);
        niceHomeworkEntity.setTitle("Miła homework");
        niceHomeworkEntity.setContent("Content: Miód i Honey");

        // when
        homeworkRepository.save(simpleHomeworkEntity);
        homeworkRepository.save(complexHomeworkEntity);
        homeworkRepository.save(littleHomeworkEntity);
        homeworkRepository.save(niceHomeworkEntity);

        List<HomeworkEntity> searchedMathHomeworks = homeworkRepository.search("MaTh");

        // then
        Assertions.assertEquals(SEARCHED_HOMEWORKS_MATH_SIZE_2, searchedMathHomeworks.size());
    }


}