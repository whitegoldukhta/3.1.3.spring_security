package web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.repos.RolesRepository;
import web.repos.UserRepository;
import web.service.UserService;

import javax.validation.Valid;
import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RolesRepository rolesRepository;
    private final UserRepository userRepository;


    @Autowired
    public AdminController(UserService usServ, RolesRepository rolesRepository, UserRepository userRepository) {
        this.userService = usServ;
        this.rolesRepository = rolesRepository;
        this.userRepository = userRepository;
    }


    @GetMapping()
    public String getAllUsers(Model model, Principal principal) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("allRoles", rolesRepository.findAll());
        model.addAttribute("newUser", userService.getUserByName(principal.getName()));
        // все юзеры
        return "admin";
    }


    @PostMapping("/create")
    public String create(@ModelAttribute("user") @Valid User user, @RequestParam("role_select") Long[] roles) {
        userService.setRolesToUser(user, roles);
        userService.save(user);
        return "redirect:/admin";
    }


    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("user") User user, @RequestParam("role_select") Long[] roles) {
        userService.setRolesToUser(user, roles);
        userService.update(user);
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/admin";
    }
}
