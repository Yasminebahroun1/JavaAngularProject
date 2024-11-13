package com.example.gestionevent.Services;

import com.example.gestionevent.Entities.Avis;
import com.example.gestionevent.Entities.ClientUser;
import com.example.gestionevent.Entities.Event;
import com.example.gestionevent.Repositories.AvisRepository;
import com.example.gestionevent.Repositories.ClientUserRepository;
import com.example.gestionevent.Repositories.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class AvisServiceImp implements IAvisService {
    AvisRepository avisrepo;
    ClientUserRepository userrepo;
    EventRepository eventrepo;


    @Override
    public List<Avis> retrieveAllAvis() {
        return avisrepo.findAll();
    }

    @Override
    public Avis addAvis(Avis a) {
        return avisrepo.save(a);
    }


    @Override
    public Avis updateAvis(Avis a) {
        return avisrepo.save(a);
    }

    @Override
    public Avis retrieveAvis(Long idAvis) {
        return avisrepo.findById(idAvis).orElse(null);
    }

    @Override
    public void removeAvis(Long idAvis) {
        avisrepo.deleteById(idAvis);
    }

    @Override
    public List<Avis> getAvisParEvent(Long idEvent) {
        return avisrepo.findByEvent_IdEvent(idEvent);
    }

    @Override
    public Avis affecterAvisAEvent(Long idUser, Long idEvent, String commentaire, Long note) {

        Avis avis = new Avis();
        avis.setNoteAvis(note);
        avis.setCommentaire(commentaire);
        avis.setDateAvis(new Date());


        ClientUser clientUser = userrepo.findById(idUser).orElse(null);
        Event event = eventrepo.findById(idEvent).orElse(null);

        if (clientUser != null && event != null) {
            avis.setClientUser(clientUser);
            avis.setEvent(event);


            avisrepo.save(avis);

            return avis;
        } else {
            return null;
        }
    }

}
