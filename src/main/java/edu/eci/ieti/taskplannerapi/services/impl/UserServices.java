package edu.eci.ieti.taskplannerapi.services.impl;

import edu.eci.ieti.taskplannerapi.persistence.IUserPersistence;
import edu.eci.ieti.taskplannerapi.persistence.PersistenseException;
import edu.eci.ieti.taskplannerapi.pojos.User;
import edu.eci.ieti.taskplannerapi.services.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServices implements IUserServices {

    @Autowired
    IUserPersistence up;

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getUserById(String userId) throws PersistenseException {
        return up.getUserById(userId);
    }

    @Override
    public User update(User user ) throws PersistenseException {
        return up.update(user);
    }

    @Override
    public void remove(String userId) throws PersistenseException {
        up.remove(userId);
    }

    @Override
    public User create(User user) throws PersistenseException {
        return up.create(user);
    }

}
