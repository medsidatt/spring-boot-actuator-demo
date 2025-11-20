package iscae.mpiag.tp1.dao.entities;

import iscae.mpiag.tp1.cours.dtos.CoursDto;
import jakarta.persistence.*;

@Entity
@Table(name = "cours")
public class CoursEntity {

    private Long id;
    private String nom;
    private Long filiereId;
    private FiliereEntity filiere;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    @Column(name = "nom")
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    @Column(name = "id_filiere")
    public Long getFiliereId() { return filiereId; }
    public void setFiliereId(Long filiereId) { this.filiereId = filiereId; }

    @ManyToOne
    @JoinColumn(name = "id_filiere", insertable = false, updatable = false)
    public FiliereEntity getFiliere() { return filiere; }
    public void setFiliere(FiliereEntity filiere) { this.filiere = filiere; }

    public CoursDto toCoursDto() {
        CoursDto dto = new CoursDto();
        dto.setId(id);
        dto.setNom(nom);
        dto.setFiliereId(filiereId);
        dto.setFiliere(filiere != null ? filiere.getNom() : null);
        return dto;
    }
}
