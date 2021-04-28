package org.example.app.services;

import org.apache.log4j.Logger;
import org.example.web.dto.Book;
import org.example.web.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService {

    private Logger logger = Logger.getLogger(UserService.class);
    private final ProjectRepository<User> userRepo;

    @Autowired
    public UserService(ProjectRepository<User> userRepo) {
        this.userRepo = userRepo;
        userRepo.store(new User("root","123"));
    }

    public boolean authenticate(User user) {
        logger.info("try auth with user-form: " + user);
        Map<String,String> users=userRepo.retreiveAll().stream().collect(Collectors.toMap(User::getUsername, User::getUsername));
        String pass=users.get(user.getUsername());
        return  (user.getUsername().equals(pass));
    }

    public boolean register(User user)
    {
        logger.info("try register user:"+user);
        Map<String,String> users=userRepo.retreiveAll().stream().collect(Collectors.toMap(User::getUsername, User::getUsername));
        if (users.containsKey(user.getUsername()))
        {
            logger.error("User name already registered:"+user);
            return false;
        }
        userRepo.store(user);
        return  true;
    }





}
