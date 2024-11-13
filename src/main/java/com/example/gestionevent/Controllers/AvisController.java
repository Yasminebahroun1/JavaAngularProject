package com.example.gestionevent.Controllers;

import com.example.gestionevent.Entities.Avis;
import com.example.gestionevent.Entities.Categorieevent;
import com.example.gestionevent.Entities.ClientUser;
import com.example.gestionevent.Entities.Event;
import com.example.gestionevent.Repositories.AvisRepository;
import com.example.gestionevent.Repositories.ClientUserRepository;
import com.example.gestionevent.Repositories.EventRepository;
import com.example.gestionevent.Services.IAvisService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/avis")
public class AvisController {
    IAvisService avisService;
    ClientUserRepository clientrepo;
    EventRepository eventrepo;
    AvisRepository avisrepo;

    @GetMapping("/retrieveAllAvis")
    public List<Avis> retrieveAllAvis() {
        return  avisService.retrieveAllAvis();
    }
    @PostMapping("/addAvis")
    public Avis addAvis(@RequestBody Avis a){
        return  avisService.addAvis(a);
    }

    @PutMapping("/UpdateAvis")
    public Avis updateAvis(@RequestBody Avis a){
        return avisService.updateAvis(a);
    }

    @DeleteMapping("/remove_avis/{avis-id}")
    public void removeAvis(@PathVariable("avis-id") Long avisId){
        avisService.removeAvis(avisId);
    }
    @GetMapping("retrieveAvis/{avis-id}")
    public Avis retrieveAvis(@PathVariable("avis-id") Long avisId){
        return avisService.retrieveAvis(avisId);
    }
    @GetMapping("/retrieveAvisByEvent/{event-id}")
    public List<Avis> retrieveAvisByEvent(@PathVariable("event-id") Long eventId) {
        return avisService.getAvisParEvent(eventId);
    }

    @PostMapping("/add")
    public Avis addAvis2(
            @RequestParam Long eventId,
            @RequestParam Long note,
            @RequestParam(required = false) String commentaire) {
        Long clientId = 2L;
        ClientUser clientUser = clientrepo.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));
        Event event = eventrepo.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Événement non trouvé"));

        // Créer un nouvel avis
        Avis avis = Avis.builder()
                .clientUser(clientUser)
                .event(event)
                .noteAvis(note)
                .commentaire(commentaire)
                .dateAvis(new Date())
                .build();
        return avisrepo.save(avis);
    }


    @PutMapping("/donner/{idUser}/{idEvent}/{commentaire}/{note}")
    public Avis affecterAvisAEvent(@PathVariable("idUser") Long idUser, @PathVariable("idEvent") Long idEvent,@PathVariable("commentaire") String commentaire,@PathVariable("note") Long note) {
        Avis avis = avisService.affecterAvisAEvent(idUser, idEvent,commentaire,note);
        return  avis;
    }





}
