package ua.com.owu.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ua.com.owu.dao.UserDAO;
import ua.com.owu.entity.User;
import ua.com.owu.service.UserService;

import java.io.File;
import java.io.IOException;

@Controller
public class MainController {

    private final UserService userService;

    private final UserDAO userDAO;

    private final PasswordEncoder passwordEncoder;

    public MainController(final UserDAO UserDAO, UserService userService, PasswordEncoder passwordEncoder) {
        this.userDAO = UserDAO;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
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
        return "index";
    }

    @GetMapping("**/home")
    public String home() {
        return "home";
    }

    @GetMapping("**/gallery")
    public String gallery() {
        return "gallery";
    }

    @GetMapping("**/loginPage")
    public String loginPage() {
        return "loginPage";
    }

    @PostMapping("**/successLoginPage")
    public String successLoginPage() {
        System.out.println("login is successful!");
        return "redirect:/";
    }

    @PostMapping("**/saveUser")
    public String saveUser(User user) {
        String encode = passwordEncoder.encode(user.getPassword());
        user.setPassword(encode);
        userService.save(user);
        return "redirect:/";
    }


}
