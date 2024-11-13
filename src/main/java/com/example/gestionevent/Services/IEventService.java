package com.example.gestionevent.Services;

import com.example.gestionevent.Entities.ClientUser;
import com.example.gestionevent.Entities.Event;

import java.util.List;
import java.util.Set;

public interface IEventService {
    List<Event> retrieveAllEvents();

    Event addEvent(Event e);

    Event updateEvent(Event e);

    Event retrieveEvent(Long idEvent);

    void removeEvent(Long idEvent);
    void archiverEvent (long idEvent);
    List<Event> addEvents(List<Event> events);
    Event ajouterEventEtAffecterACategorieevent(Event event, long idCategorieevent);
    Set<ClientUser> retrieveEventParticipants(Long idEvent);
}
