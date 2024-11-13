package com.example.gestionevent.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Categorieevent implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idCateg;
    private String nomCateg;
    private String descriptionCateg;
    @OneToMany(mappedBy = "categevent",cascade =CascadeType.ALL)
    @JsonIgnore
    private Set<Event> events;
}
