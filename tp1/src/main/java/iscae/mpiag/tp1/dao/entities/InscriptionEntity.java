package iscae.mpiag.tp1.dao.entities;

import iscae.mpiag.tp1.inscription.dtos.InscriptionDto;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "inscription")
public class InscriptionEntity {

    private Long id;
    private Long etudiantId;
    private Long filiereId;
    private LocalDate dateInscription;

    private EtudiantEntity etudiant;
    private FiliereEntity filiere;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    @Column(name = "id_etudiant")
    public Long getEtudiantId() { return etudiantId; }
    public void setEtudiantId(Long etudiantId) { this.etudiantId = etudiantId; }

    @Column(name = "id_filiere")
    public Long getFiliereId() { return filiereId; }
    public void setFiliereId(Long filiereId) { this.filiereId = filiereId; }

    @Column(name = "date_inscription")
    public LocalDate getDateInscription() { return dateInscription; }
    public void setDateInscription(LocalDate dateInscription) { this.dateInscription = dateInscription; }

    @ManyToOne
    @JoinColumn(name = "id_etudiant", insertable = false, updatable = false)
    public EtudiantEntity getEtudiant() { return etudiant; }
    public void setEtudiant(EtudiantEntity etudiant) { this.etudiant = etudiant; }

    @ManyToOne
    @JoinColumn(name = "id_filiere", insertable = false, updatable = false)
    public FiliereEntity getFiliere() { return filiere; }
    public void setFiliere(FiliereEntity filiere) { this.filiere = filiere; }

    public InscriptionDto toInscriptionDto() {
        InscriptionDto dto = new InscriptionDto();
        dto.setId(id);
        dto.setEtudiantId(etudiantId);
        dto.setEtudiant(etudiant != null ? etudiant.getPrenom() + " " + etudiant.getNom() : null);
        dto.setFiliereId(filiereId);
        dto.setFiliere(filiere != null ? filiere.getNom() : null);
        dto.setDateInscription(dateInscription);
        return dto;
    }
}
