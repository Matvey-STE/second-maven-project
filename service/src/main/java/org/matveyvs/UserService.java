package org.matveyvs;

import java.util.List;
import java.util.Optional;

public class UserService {
    private final UserDao userDao = new UserDao();

    public void createAllUsersAndWriteToJson() {
        userDao.createListOfUserAndWriteToJson();
    }

    public Optional<UserDto> getUser(Long id) {
        return userDao.findById(id).map(it -> new UserDto(it.getId(), it.getName(), it.getCompany()));
    }

    public Optional<List<UserDto>> getAllUsers() {
        return userDao.findAll().map(users -> users.stream()
                .map(user -> new UserDto(user.getId(), user.getName(), user.getCompany()))
                .toList());
    }

    public boolean updateUserAndWriteToJson(Long id, String name) {
        return userDao.changeNameByIdAndWriteToJson(id, name);
    }

}
