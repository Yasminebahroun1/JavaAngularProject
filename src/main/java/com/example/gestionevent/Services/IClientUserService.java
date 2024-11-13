package com.example.gestionevent.Services;

import com.example.gestionevent.Entities.ClientUser;
import com.example.gestionevent.Entities.Event;

import java.util.List;

public interface IClientUserService {
    List<ClientUser> retrieveAllUsers();

    ClientUser addUser(ClientUser u);

    ClientUser updateUser1(ClientUser u);


    ClientUser updateUser(ClientUser u);

    ClientUser retrieveUser(Long idUser);

    void removeUser(Long idUser);
    List<ClientUser> addUsers(List<ClientUser> users);
    ClientUser affecterUserAEvent(Long idUser, Long idEvent );
    ClientUser authenticateUser(String email, String password);
    List<Event> retrieveUserParticipations(Long idUser);
}
