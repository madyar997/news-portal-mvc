package newsportal.service;

import newsportal.entity.security.User;

public interface UserService {
    void save(User user);
    User findByUsername(String username);


}
