package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.servise.UserServise;


@Controller
public class UserController {
    private final UserServise userServise;

    @Autowired
    public UserController(UserServise userServise) {
        this.userServise = userServise;
    }

    @GetMapping
    public String getAllUsers(Model model, @ModelAttribute("user") User user) {
        model.addAttribute("users", userServise.getAllUsers());
        return "/index";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userServise.updateUserById(id, user);
        return "redirect:/";
    }
    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user",new User());
        return "/new";
    }
    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        userServise.addUser(user);
        return "redirect:/";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userServise.getUserById(id));
        return "/edit";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userServise.getUserById(id));
        return "/show";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable(name = "id") int id) {
        userServise.getUserById(id);
        userServise.removeUser(id);
        return "redirect:/";
    }


}
