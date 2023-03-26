package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.HomeworkEntity;

import java.util.List;

@Repository
public interface HomeworkRepository extends JpaRepository<HomeworkEntity, Long> {
    List<HomeworkEntity> findByClazz_ClassName_Name(String name);
    List<HomeworkEntity> findByYearAndClazz_ClassName_Name(Integer year, String name);
}
