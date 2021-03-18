package edu.eci.ieti.taskplannerapi.persistence.impl;

import edu.eci.ieti.taskplannerapi.persistence.IUserPersistence;
import edu.eci.ieti.taskplannerapi.persistence.PersistenseException;
import edu.eci.ieti.taskplannerapi.pojos.User;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserPersistence implements IUserPersistence {

    private Map<String, User> users = new HashMap<>();

    public UserPersistence(){
        users.put("angi", new User("angi", "angi@mail.com", "angi123"));
        users.put("paola", new User("paola", "paola@mail.com", "paola123"));
    }

    @Override
    public User getUserById(String userId) throws PersistenseException {
        if ( users.containsKey(userId)) return users.get(userId);
        throw new PersistenseException("User not found");
    }

    @Override
    public User update(User user) throws PersistenseException {
        if ( users.containsKey(user.getName())){
            users.remove(user.getName());
            users.put(user.getName(), user);
            return user;
        } throw new PersistenseException("User not found");
    }

    @Override
    public void remove(String userId) throws PersistenseException {
        if ( users.containsKey(userId)){
            users.remove(userId); return;
        } throw new PersistenseException("User not found");
    }

    @Override
    public User create(User user) throws PersistenseException {
        if ( users.containsKey(user.getName())) throw new PersistenseException("A user with that name already exists");
        users.put(user.getName(), user);
        return user;
    }

}
