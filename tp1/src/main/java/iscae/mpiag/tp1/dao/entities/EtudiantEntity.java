package iscae.mpiag.tp1.dao.entities;

import iscae.mpiag.tp1.etudiant.dtos.EtudiantDto;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
@Table(name = "etudiant")
public class EtudiantEntity {

    private Long id;
    private String prenom;
    private String nom;
    private String tel;
    private String email;
    private LocalDate dateNaissance;
    private Integer genreId;
    private Long filiereId;

    private GenreEntity genre;
    private FiliereEntity filiere;
    private List<InscriptionEntity> inscriptions;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    @Column(name = "prenom")
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    @Column(name = "nom")
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    @Column(name = "tel")
    public String getTel() { return tel; }
    public void setTel(String tel) { this.tel = tel; }

    @Column(name = "email")
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Column(name = "date_naissance")
    public LocalDate getDateNaissance() { return dateNaissance; }
    public void setDateNaissance(LocalDate dateNaissance) { this.dateNaissance = dateNaissance; }

    @Column(name = "id_genre")
    public Integer getGenreId() { return genreId; }
    public void setGenreId(Integer genreId) { this.genreId = genreId; }

    @Column(name = "id_filiere")
    public Long getFiliereId() { return filiereId; }
    public void setFiliereId(Long filiereId) { this.filiereId = filiereId; }

    @ManyToOne
    @JoinColumn(name = "id_genre", insertable = false, updatable = false)
    public GenreEntity getGenre() { return genre; }
    public void setGenre(GenreEntity genre) { this.genre = genre; }

    @ManyToOne
    @JoinColumn(name = "id_filiere", insertable = false, updatable = false)
    public FiliereEntity getFiliere() { return filiere; }
    public void setFiliere(FiliereEntity filiere) { this.filiere = filiere; }

    @OneToMany(mappedBy = "etudiant")
    public List<InscriptionEntity> getInscriptions() { return inscriptions; }
    public void setInscriptions(List<InscriptionEntity> inscriptions) { this.inscriptions = inscriptions; }

    public EtudiantDto toEtudiantDto() {
        EtudiantDto dto = new EtudiantDto();

        dto.setId(id);
        dto.setPrenom(prenom);
        dto.setNom(nom);
        dto.setTel(tel);
        dto.setEmail(email);
        dto.setDateNaissance(dateNaissance);

        // Compute age automatically
        if (dateNaissance != null) {
            dto.setAge(Period.between(dateNaissance, LocalDate.now()).getYears());
        }

        dto.setGenreId(genreId);
        dto.setGenre(genre != null ? genre.getLib() : null);
        dto.setFiliereId(filiereId);
        dto.setFiliere(filiere != null ? filiere.getNom() : null);

        return dto;
    }
}
