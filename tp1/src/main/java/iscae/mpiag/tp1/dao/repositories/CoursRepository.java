package iscae.mpiag.tp1.dao.repositories;

import iscae.mpiag.tp1.dao.entities.CoursEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursRepository extends JpaRepository<CoursEntity, Long> {
}
