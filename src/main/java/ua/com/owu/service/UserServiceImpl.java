package ua.com.owu.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.owu.dao.UserDAO;
import ua.com.owu.entity.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    public UserServiceImpl( final UserDAO userDAO ) {
        this.userDAO = userDAO;
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDAO.findByUsername(username);
    }
}
