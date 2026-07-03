import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
public User createUser(@RequestBody User user) {
    return user;
}
@GetMapping("/error")
public String throwException() {
    throw new RuntimeException("User not found");
}

    @GetMapping("/{id}")
public User getUser(@PathVariable("id") Long id) {
    return userService.getUserById(id);}
}


    
