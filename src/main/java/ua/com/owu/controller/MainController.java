package ua.com.owu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ua.com.owu.dao.UserDAO;
import ua.com.owu.entity.User;

import java.io.File;
import java.io.IOException;

@Controller
public class MainController {

    private final UserDAO userDAO;

    public MainController( final UserDAO aUserDAO ) {
        userDAO = aUserDAO;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/brandLogo")
    public String brandLogo() {
        return "index";
    }

    @PostMapping("/su")
    public String su(User user, @RequestParam("file") MultipartFile file) throws IOException {
        String path = System.getProperty("user.home") + File.separator + "picturesForProject" + File.separator;
        file.transferTo(new File(path + file.getOriginalFilename()));
        return "redirect:/";
    }

    @GetMapping("/saveUser")
    public String saveUser(@RequestParam("username") String name) {
        return "redirect:/";
    }

    @GetMapping("**/home")
    public String home() {
        return "home";
    }

    @GetMapping("**/gallery")
    public String gallery() {
        return "gallery";
    }

    @GetMapping("**/xxx")
    public String xxx() {
        return "index";
    }

    @GetMapping("**/loginPage")
    public String loginPage() {
        return "loginPage";
    }

}
