package MovieOn.controller;

import MovieOn.db.entity.Users;
import MovieOn.db.repository.UsersRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {
    private final UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @GetMapping
    public List<Users> getUsers(){
        return usersRepository.findAll();
    }

    @GetMapping("/api/v1/users/{userId}")
    public Users getUser(@PathVariable Long userId) {
        return usersRepository.findById(userId).orElseThrow(RuntimeException::new);
    }

}
