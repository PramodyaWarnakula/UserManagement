package lk.my.assignment.controllers;


import lk.my.assignment.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/user-mgt")
public class UserManagementController {

    @Autowired
   private UserDetailsServiceImpl userDetailsService;

    @GetMapping(value = "/admin-view-of-users",produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> adminViewOfUsers(){
        try {
            return ResponseEntity.ok(userDetailsService.getAllUsers());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping(value = "/admin-view-of-users/{userName}",produces = MediaType.APPLICATION_JSON_VALUE)
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> findUserById(@PathVariable("userName") String userName){
        try {
            return ResponseEntity.ok(userDetailsService.getfindUserByUserName(userName));
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
