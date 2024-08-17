package com.microservice.user.domain.services;


import com.microservice.user.domain.entities.User;
import com.microservice.user.domain.producers.UserProducer;
import com.microservice.user.domain.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProducer userProducer;


    @Transactional
    public User save(User user) {
        user = userRepository.save(user);

        userProducer.publishMessageEmail(user);

        return user;
    }
}
