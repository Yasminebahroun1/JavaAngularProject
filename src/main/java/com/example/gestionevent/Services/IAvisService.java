package com.example.gestionevent.Services;

import com.example.gestionevent.Entities.Avis;

import java.util.Date;
import java.util.List;

public interface IAvisService {
    List<Avis> retrieveAllAvis();

    Avis addAvis(Avis a);

    Avis updateAvis(Avis a);

    Avis retrieveAvis(Long idAvis);

    void removeAvis(Long idAvis);
    List<Avis> getAvisParEvent(Long eventId);
    Avis affecterAvisAEvent(Long idUser, Long idEvent, String commentaire, Long note);

}
