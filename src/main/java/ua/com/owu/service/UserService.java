package ua.com.owu.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ua.com.owu.entity.User;

public interface UserService extends UserDetailsService {

    void save(User user);
}
