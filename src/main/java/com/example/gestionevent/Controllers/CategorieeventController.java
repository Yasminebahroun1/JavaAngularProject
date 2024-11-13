package com.example.gestionevent.Controllers;

import com.example.gestionevent.Entities.Categorieevent;
import com.example.gestionevent.Services.ICategorieeventService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/categorieevents")
public class CategorieeventController {
    ICategorieeventService categorieeventService;
    @GetMapping("/retrieveAllCategorieevent")
    public List<Categorieevent> retrieveAllCategorieevent() {
        return  categorieeventService.retrieveAllCategorieevents();
    }
    @PostMapping("/addCategorieevent")
    public Categorieevent addCategorieevent(@RequestBody Categorieevent c){
        return  categorieeventService.addCategorieevent(c);
    }

    @PutMapping("/UpdateCategorieevent")
    public Categorieevent updateCategorieevent(@RequestBody Categorieevent c){
        return categorieeventService.updateCategorieevent(c);
    }

    @DeleteMapping("/remove_categorieevent/{categorieevent-id}")
    public void removeCategorieevent(@PathVariable("categorieevent-id") Long categorieeventId){
        categorieeventService.removeCategorieevent(categorieeventId);
    }
    @GetMapping("retrieveCategorieevent/{categorieevent-id}")
    public Categorieevent retrieveCategorieevent(@PathVariable("categorieevent-id") Long categorieeventId){
        return categorieeventService.retrieveCategorieevent(categorieeventId);
    }

}
