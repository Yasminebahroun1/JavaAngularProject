package com.example.gestionevent.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Avis implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idAvis;
    private Long noteAvis;
    private String commentaire;
    private Date dateAvis;
    @ManyToOne
    @ToString.Exclude
    private ClientUser clientUser;
    @ManyToOne
    @JsonIgnore
    private Event event;
}
