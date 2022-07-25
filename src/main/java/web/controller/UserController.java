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
        model.addAttribute("userList", userServise.getAllUsers());
        return "/index";
    }

    @PostMapping(value = {"/add"})
    public String addUser(@ModelAttribute("user") User user) {
        userServise.addUser(user);
        return "/user_add";
    }

    @GetMapping(value = "/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userServise.updateUser(user);
        return "users_update";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userServise.getUserById(id));
        return "pagesUser/userById";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable(name = "id") int id) {
        User user = userServise.getUserById(id);
        userServise.removeUser(id);
        return "redirect:/";
    }


}
