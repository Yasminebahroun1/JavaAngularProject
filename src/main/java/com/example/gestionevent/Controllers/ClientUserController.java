package com.example.gestionevent.Controllers;

import com.example.gestionevent.Entities.ClientUser;
import com.example.gestionevent.Entities.Event;
import com.example.gestionevent.Repositories.ClientUserRepository;
import com.example.gestionevent.Services.IClientUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/users")
public class ClientUserController {
    IClientUserService userService;
    ClientUserRepository clientrepo;
    @GetMapping("/retrieveAllUser")
    public List<ClientUser> retrieveAllUser(){
        return  userService.retrieveAllUsers();
    }
    @PostMapping("/addUser")
    public ClientUser addUser(@RequestBody ClientUser u){
        return  userService.addUser(u);
    }

    @PutMapping("/UpdateUser")
    public ClientUser updateUser(@RequestBody ClientUser u){
        return userService.updateUser1(u);
    }

    @DeleteMapping("/remove_user/{user-id}")
    public void removeUser(@PathVariable("user-id") Long userId){
        userService.removeUser(userId);
    }
    @GetMapping("retrieveUser/{user-id}")
    public ClientUser retrieveUser(@PathVariable("user-id") Long userId){
        return userService.retrieveUser(userId);
    }

    @PostMapping("/addUsers")
    public List<ClientUser> addUsers(@RequestBody List<ClientUser> users) {
        return userService.addUsers(users);
    }

    @PutMapping("/participer/{idUser}/{idEvent}")
    public ClientUser participerEvent(@PathVariable("idUser") Long idUser, @PathVariable("idEvent") Long idEvent) {
        ClientUser user = userService.affecterUserAEvent(idUser, idEvent);
        return  user;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("emailUser");
        String password = credentials.get("passwordUser");

        ClientUser user = userService.authenticateUser(email, password);

        if (user != null) {
            return ResponseEntity.ok(user);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password.");
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody ClientUser newUser) {
        // Check if the user already exists
        ClientUser existingUser = clientrepo.findByEmailUser(newUser.getEmailUser());
        if (existingUser != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User with this email already exists.");
        }
        // Save the new user
        ClientUser savedUser = userService.addUser(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
    @GetMapping("/{idUser}/participations")
    public ResponseEntity<List<Event>> getUserParticipations(@PathVariable Long idUser) {
        List<Event> participations = userService.retrieveUserParticipations(idUser);
        return ResponseEntity.ok(participations);
    }


}
