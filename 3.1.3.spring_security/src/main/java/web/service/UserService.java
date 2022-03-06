package web.service;

import web.model.Role;
import web.model.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public User getUserById(Long id);

    public void save(User user);

    public void update(User updatedUser);

    public void delete(Long id);

    void setRolesToUser(User user, Long[] roles);

    User getUserByName(String name);

    Role getRoleById(Long id);
}

