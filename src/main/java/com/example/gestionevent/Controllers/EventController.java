package com.example.gestionevent.Controllers;

import com.example.gestionevent.Entities.ClientUser;
import com.example.gestionevent.Entities.Event;
import com.example.gestionevent.Services.IEventService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/events")
public class EventController {
    IEventService eventService;
    @GetMapping("/retrieveAllEvent")
    public List<Event> retrieveAllEvent(){
        return  eventService.retrieveAllEvents();
    }
    @PostMapping("/addEvent")
    public Event addEvent(@RequestBody Event e){
        return  eventService.addEvent(e);
    }

    @PutMapping("/UpdateEvent")
    public Event updateEvent(@RequestBody Event e){
        return eventService.updateEvent(e);
    }

    @DeleteMapping("/remove_event/{event-id}")
    public void removeEvent(@PathVariable("event-id") Long eventId){
        eventService.removeEvent(eventId);
    }
    @GetMapping("retrieveEvent/{event-id}")
    public Event retrieveEvent(@PathVariable("event-id") Long eventId){
        return eventService.retrieveEvent(eventId);
    }

    @PostMapping("/addEvents")
    public List<Event> addEvents(@RequestBody List<Event> events) {
        return eventService.addEvents(events);
    }
   //manque une methode
   @PostMapping("/addEventWithCategory/{categoryId}")
   public Event addEventWithCategory(@RequestBody Event event, @PathVariable long categoryId) {
       return eventService.ajouterEventEtAffecterACategorieevent(event, categoryId);
   }
    @GetMapping("/{idEvent}/participants")
    public ResponseEntity<Set<ClientUser>> getEventParticipants(@PathVariable Long idEvent) {
        Set<ClientUser> participants = eventService.retrieveEventParticipants(idEvent);
        return participants != null ? ResponseEntity.ok(participants) : ResponseEntity.notFound().build();
    }
}
