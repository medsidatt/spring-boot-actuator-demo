package iscae.mpiag.tp1.dao.entities;

import iscae.mpiag.tp1.filiere.dtos.FiliereDto;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "filiere")
public class FiliereEntity {

    private Long id;
    private String nom;
    private List<EtudiantEntity> etudiants;
    private List<CoursEntity> cours;
    private List<InscriptionEntity> inscriptions;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    @Column(name = "nom")
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    @OneToMany(mappedBy = "filiere")
    public List<EtudiantEntity> getEtudiants() { return etudiants; }
    public void setEtudiants(List<EtudiantEntity> etudiants) { this.etudiants = etudiants; }

    @OneToMany(mappedBy = "filiere")
    public List<CoursEntity> getCours() { return cours; }
    public void setCours(List<CoursEntity> cours) { this.cours = cours; }

    @OneToMany(mappedBy = "filiere")
    public List<InscriptionEntity> getInscriptions() { return inscriptions; }
    public void setInscriptions(List<InscriptionEntity> inscriptions) { this.inscriptions = inscriptions; }

    public FiliereDto toFiliereDto() {
        FiliereDto dto = new FiliereDto();
        dto.setId(id);
        dto.setNom(nom);
        return dto;
    }
}
