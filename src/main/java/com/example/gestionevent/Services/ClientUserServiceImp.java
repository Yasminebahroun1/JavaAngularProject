package com.example.gestionevent.Services;

import com.example.gestionevent.Entities.Event;
import com.example.gestionevent.Entities.ClientUser;
import com.example.gestionevent.Repositories.EventRepository;
import com.example.gestionevent.Repositories.ClientUserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientUserServiceImp implements IClientUserService {
    ClientUserRepository userrepo;
    EventRepository eventrepo;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Override
    public List<ClientUser> retrieveAllUsers() {
        return userrepo.findAll();
    }

    @Override
    public ClientUser addUser(ClientUser u) {
        u.setPasswordUser(passwordEncoder.encode(u.getPasswordUser()));
        return userrepo.save(u);
    }
    @Override
    public ClientUser updateUser1(ClientUser u) {
        return userrepo.save(u);
    }
    @Override
    public ClientUser updateUser(ClientUser u) {

        Optional<ClientUser> existingUserOptional = userrepo.findById(u.getIdUser());

        if (existingUserOptional.isPresent()) {

            ClientUser existingUser = existingUserOptional.get();


            existingUser.setPrenomUser(u.getPrenomUser());
            existingUser.setNomUser(u.getNomUser());
            existingUser.setDateNaissance(u.getDateNaissance());


            return userrepo.save(existingUser);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public ClientUser retrieveUser(Long idUser) {
        return userrepo.findById(idUser).orElse(null);
    }

    @Override
    public void removeUser(Long idUser) {
        userrepo.deleteById(idUser);

    }

    @Override
    public List<ClientUser> addUsers(List<ClientUser> users) {
        return userrepo.saveAll(users);
    }

    @Override
    @Transactional
    public ClientUser affecterUserAEvent(Long idUser, Long idEvent) {
        Event event = eventrepo.findById(idEvent).orElse(null);
        ClientUser userExist = userrepo.findById(idUser).orElse(null);
        if(userExist==null){
            throw new RuntimeException("User not found");
        }
        if(event==null){
            throw new RuntimeException("Event not found");
        }
        if(event.getClientUsers().contains(userExist)){
            return userExist;
        }
        event.getClientUsers().add(userExist);
        event.setPlacesRestantes(event.getPlacesRestantes()-1);
        eventrepo.save(event);
        return userExist;
    }

    @Override
    public ClientUser authenticateUser(String email, String password) {
        ClientUser user = userrepo.findByEmailUser(email);
        if (user != null && passwordEncoder.matches(password, user.getPasswordUser())) {
            return user; // Authentication successful
        }
        return null; // Authentication failed
    }
    @Override
    public List<Event> retrieveUserParticipations(Long idUser) {
        ClientUser user = userrepo.findById(idUser).orElse(null);
        if (user != null) {
            return eventrepo.findByClientUsersContaining(user);
        }
        return List.of(); // Return an empty list if the user is not found
    }


}
