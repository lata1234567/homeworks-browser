package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    StudentEntity findByLogin(String username);
}
