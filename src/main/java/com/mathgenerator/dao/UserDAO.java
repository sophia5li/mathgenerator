package com.mathgenerator.dao;

import com.mathgenerator.module.User;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.Optional;
import java.util.UUID;

public class UserDAO extends AbstractDAO<User> {

    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    public UserDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
    public Optional<User> findById(int id){
        return Optional.of(get(id));
    }
}
