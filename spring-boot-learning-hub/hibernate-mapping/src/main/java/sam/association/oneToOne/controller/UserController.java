package sam.association.oneToOne.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sam.association.oneToOne.dto.UserDto;
import sam.association.oneToOne.service.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

    private UserServiceImpl userService;

    @PostMapping("/save")
    public void save(@RequestBody UserDto userDto) {
        System.out.println("Request received for save operation! => " + userDto);
        userService.save(userDto);
    }

    @GetMapping("/getAllUsers")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }
}
