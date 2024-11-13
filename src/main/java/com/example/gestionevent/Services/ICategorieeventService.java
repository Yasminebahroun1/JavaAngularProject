package com.example.gestionevent.Services;

import com.example.gestionevent.Entities.Avis;
import com.example.gestionevent.Entities.Categorieevent;

import java.util.List;

public interface ICategorieeventService {
    List<Categorieevent> retrieveAllCategorieevents();

    Categorieevent addCategorieevent(Categorieevent c);

    Categorieevent updateCategorieevent(Categorieevent c);

    Categorieevent retrieveCategorieevent(Long idCategorieevent);

    void removeCategorieevent(Long idCategorieevent);

}
