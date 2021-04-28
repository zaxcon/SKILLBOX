package org.example.app.services;

import org.apache.log4j.Logger;
import org.example.web.dto.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements ProjectRepository<User> {

    private final Logger logger = Logger.getLogger(BookRepository.class);
    private final List<User> repo = new ArrayList<>();



    @Override
    public List<User> retreiveAll() {
        return repo;

    }


    @Override
    public void store(User user) {
    repo.add(user);
    }

    @Override
    public boolean removeItemById(Integer userIdToRemove) {
        return false;
    }
}
