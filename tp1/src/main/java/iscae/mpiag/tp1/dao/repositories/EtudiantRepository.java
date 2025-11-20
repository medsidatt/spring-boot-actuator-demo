package iscae.mpiag.tp1.dao.repositories;

import iscae.mpiag.tp1.dao.entities.EtudiantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<EtudiantEntity, Long> {




}
