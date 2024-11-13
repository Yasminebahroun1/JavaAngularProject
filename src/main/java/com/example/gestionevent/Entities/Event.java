package com.example.gestionevent.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idEvent;
    private String titreEvent;
    private String descriptionEvent;
    private Date dateDebut;
    private Date dateFin;
    private String adresse;
    private String ville;
    private Long capaciteMax;
    private Long placesRestantes;
    @OneToMany(mappedBy = "event",cascade =CascadeType.ALL)
    private Set<Avis> avis;
    @ManyToOne
    private Categorieevent categevent;
    @JsonBackReference
    @ManyToMany
    @JoinTable(name = "event_users", joinColumns = @JoinColumn(name = "event_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    @JsonIgnore
    private Set<ClientUser> clientUsers;
    @ColumnDefault("false")
    private boolean archived;
}
