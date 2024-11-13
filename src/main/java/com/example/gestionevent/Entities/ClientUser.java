package com.example.gestionevent.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

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
public class ClientUser implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idUser;
    private String nomUser;
    private String prenomUser;
    private String emailUser;
    private String passwordUser;
    private String roleUser;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateNaissance;
    @OneToMany(mappedBy = "clientUser",cascade =CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    private Set<Avis> avis;
    @ManyToMany(mappedBy = "clientUsers")
    @JsonIgnore
    private Set<Event> events;


}
