package edu.eci.ieti.taskplannerapi.services;

import edu.eci.ieti.taskplannerapi.persistence.PersistenseException;
import edu.eci.ieti.taskplannerapi.pojos.User;

import java.util.List;

public interface IUserServices {

    List<User> getAll();

    User getUserById(String userId) throws PersistenseException;

    User update(User user) throws PersistenseException;

    void remove(String userId) throws PersistenseException;

    User create(User user) throws PersistenseException;
}
