package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.HomeworkEntity;

import java.util.List;

@Repository
public interface HomeworkRepository extends JpaRepository<HomeworkEntity, Long> {
    List<HomeworkEntity> findByClazz_ClassName_Name(String name);
    List<HomeworkEntity> findByClazz_ClassName_NameAndClazzYear(String name, Integer year);

    @Query("SELECT h FROM HomeworkEntity h WHERE " +
            " lower(h.title) LIKE lower(concat('%', ?1,'%')) " +
            " OR lower(h.content) LIKE lower(concat('%', ?1,'%')) ")
    List<HomeworkEntity> search(String keyword);
}
