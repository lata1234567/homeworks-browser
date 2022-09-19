package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.ClassNameEntity;

@Repository
public interface ClassNameRepository extends JpaRepository<ClassNameEntity, Long> {
}
