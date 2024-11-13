package com.example.gestionevent.Repositories;

import com.example.gestionevent.Entities.Avis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvisRepository extends JpaRepository<Avis, Long> {
    List<Avis> findByClientUserNomUser(String nomUser);
    List<Avis> findByEvent_IdEvent(Long idEvent);
}
