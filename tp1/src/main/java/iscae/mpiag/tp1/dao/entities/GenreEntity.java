package iscae.mpiag.tp1.dao.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "genre")
public class GenreEntity {

    private Integer id;
    private String lib;
    private List<EtudiantEntity> etudiants;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    @Column(name = "lib")
    public String getLib() { return lib; }
    public void setLib(String lib) { this.lib = lib; }

    @OneToMany(mappedBy = "genre")
    public List<EtudiantEntity> getEtudiants() { return etudiants; }
    public void setEtudiants(List<EtudiantEntity> etudiants) { this.etudiants = etudiants; }
}
