package com.example.gestionevent.Services;

import com.example.gestionevent.Entities.Categorieevent;
import com.example.gestionevent.Repositories.CategorieeventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategorieeventServiceImp  implements ICategorieeventService{
    CategorieeventRepository categeventrepo;

    @Override
    public List<Categorieevent> retrieveAllCategorieevents() {
        return categeventrepo.findAll();
    }

    @Override
    public Categorieevent addCategorieevent(Categorieevent c) {
        return categeventrepo.save(c);
    }

    @Override
    public Categorieevent updateCategorieevent(Categorieevent c) {
        return categeventrepo.save(c);
    }

    @Override
    public Categorieevent retrieveCategorieevent(Long idCategorieevent) {
        return categeventrepo.findById(idCategorieevent).orElse(null);
    }

    @Override
    public void removeCategorieevent(Long idCategorieevent) {
        categeventrepo.deleteById(idCategorieevent);

    }
}
