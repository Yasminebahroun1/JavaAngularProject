package com.example.gestionevent.Services;

import com.example.gestionevent.Entities.Categorieevent;
import com.example.gestionevent.Entities.ClientUser;
import com.example.gestionevent.Entities.Event;
import com.example.gestionevent.Repositories.CategorieeventRepository;
import com.example.gestionevent.Repositories.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class EventServiceImp  implements IEventService{
    EventRepository eventrepo;
    CategorieeventRepository categorieeventrepo;
    @Override
    public List<Event> retrieveAllEvents() {
        return eventrepo.findAll();
    }

    @Override
    public Event addEvent(Event e) {
        return eventrepo.save(e);
    }

    @Override
    public Event updateEvent(Event e) {
        return eventrepo.save(e);
    }

    @Override
    public Event retrieveEvent(Long idEvent) {
        return eventrepo.findById(idEvent).orElse(null);
    }

    @Override
    public void removeEvent(Long idEvent) {
        eventrepo.deleteById(idEvent);

    }

    @Override
    public void archiverEvent(long idEvent) {
        Event event = eventrepo.findById(idEvent).orElse(null);

        if (event != null) {
            event.setArchived(true);
            eventrepo.save(event);
        }
    }

    @Override
    public List<Event> addEvents(List<Event> events) {
        return eventrepo.saveAll(events);

    }


    @Override
    public Event ajouterEventEtAffecterACategorieevent(Event event, long idCategorieevent) {
        Optional<Categorieevent> optionalCategorieevent = categorieeventrepo.findById(idCategorieevent);

        if (optionalCategorieevent.isPresent()) {
            Categorieevent categorieevent = optionalCategorieevent.get();
            event.setCategevent(categorieevent);
            return eventrepo.save(event);
        }
        return null;
    }
    public Set<ClientUser> retrieveEventParticipants(Long idEvent) {
        Optional<Event> event = eventrepo.findById(idEvent);
        return event.map(Event::getClientUsers).orElse(null);
    }

}
