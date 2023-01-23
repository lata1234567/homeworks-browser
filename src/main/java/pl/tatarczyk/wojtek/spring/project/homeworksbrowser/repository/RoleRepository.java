package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
