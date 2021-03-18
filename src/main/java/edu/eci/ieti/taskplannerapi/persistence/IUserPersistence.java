package edu.eci.ieti.taskplannerapi.persistence;

import edu.eci.ieti.taskplannerapi.pojos.User;

public interface IUserPersistence {

    User getUserById(String userId) throws PersistenseException;

    User update(User user) throws PersistenseException;

    void remove(String userId) throws PersistenseException;

    User create(User user) throws PersistenseException;
}
