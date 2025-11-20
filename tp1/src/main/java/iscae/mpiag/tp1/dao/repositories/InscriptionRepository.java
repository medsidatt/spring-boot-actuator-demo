package iscae.mpiag.tp1.dao.repositories;

import iscae.mpiag.tp1.dao.entities.InscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscriptionRepository extends JpaRepository<InscriptionEntity, Long> {
}
