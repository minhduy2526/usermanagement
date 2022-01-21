package com.duytm.usermanagement.controllers.User;

import com.duytm.usermanagement.entities.User;
import com.duytm.usermanagement.services.User.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //Create
    @PostMapping(path = "/user/create")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        User user1 = userService.createUser(user);
        if (user1 != null) {
            return ResponseEntity.status(HttpStatus.OK).body(user1);
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("Create Failed!");
    }

    //Search By Like Name
    @GetMapping( path = "/user/searchByLikeName/{name}")
    public ResponseEntity<?> searchByLikeName(@PathVariable("name") String name) {
        List<User> users = userService.searchByLikeName(name);
        if (users != null) {
            return ResponseEntity.status(HttpStatus.OK).body(users);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found!");
    }

    //Update
    @PutMapping(path = "/user/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        boolean check = userService.updateUser(id, user);
        if (check) {
            return ResponseEntity.status(HttpStatus.OK).body("Update Successfully!");
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("Update Failed!");
    }

    //Delete
    @PutMapping(path = "/user/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        boolean check = userService.deleteUser(id);
        if (check) {
            return ResponseEntity.status(HttpStatus.OK).body("Delete Successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("Delete Failed!");
    }

    //Get List
    @GetMapping(path = "/user/getAll")
    public ResponseEntity<?> getAllUser() {
        List<User> users = userService.getAllUsers();
        if (users != null && users.size() > 0) {
            return ResponseEntity.status(HttpStatus.OK).body(users);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The list is empty!");
    }
}
