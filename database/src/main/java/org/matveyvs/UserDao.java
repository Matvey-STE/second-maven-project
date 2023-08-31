package org.matveyvs;

import java.util.Optional;

public class UserDao {
    public Optional<User> findById(Long id) {
        User user = new User();
        user.setName("Dmitry");
        user.setCompany("IBM");
        return Optional.of(user);
    }

}
