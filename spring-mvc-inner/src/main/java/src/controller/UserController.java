package src.controller;

import org.springframework.web.bind.annotation.*;
import src.entity.User;
import src.my.UserParam;

@RestController
@RequestMapping(value = "user", method = RequestMethod.GET)
public class UserController {
    @GetMapping("info/{firstName}/{lastName}")
    public User getUser(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName, @UserParam String login) {
        User user = new User(firstName, lastName);
        System.out.println(user);
        return user;
    }
}
