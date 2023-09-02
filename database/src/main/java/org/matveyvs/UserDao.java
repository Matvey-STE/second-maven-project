package org.matveyvs;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao {
    private static final String pathToFile = "/Users/matvey/MyProjects/third-maven-project/database/src/main/resources/file.json";

    public void writeToJson(List<User> listOfUser) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(pathToFile), listOfUser);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Optional<List<User>> readFromJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> listOfUser = null;
        try {
            listOfUser = objectMapper.readValue(new File(pathToFile), new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(listOfUser);
    }

    public Optional<User> findById(Long id) {
        Optional<List<User>> listOfUser = readFromJson();
        return listOfUser.flatMap(users -> users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst());
    }

    public Optional<List<User>> findAll() {
        return readFromJson();
    }

    public boolean changeNameByIdAndWriteToJson(Long id, String name) {
        Optional<List<User>> listOfUserOptional = readFromJson();
        if (listOfUserOptional.isPresent()) {
            List<User> listOfUser = listOfUserOptional.get();
            listOfUser.stream()
                    .filter(user -> user.getId().equals(id))
                    .findFirst()
                    .ifPresent(user -> user.setName(name));
            writeToJson(listOfUser);
            return true;
        }
        return false;
    }

    public void createListOfUserAndWriteToJson() {
        List<User> listOfUser = new ArrayList<>();

        User user1 = new User(1L, "Anton", "IBM");
        User user2 = new User(2L, "Dmitry", "Windows Inc.");
        User user3 = new User(3L, "Olesya", "Apple Inc.");
        User user4 = new User(4L, "Daria", "IBM");
        User user5 = new User(5L, "Konstantin", "Windows Inc.");

        listOfUser.add(user1);
        listOfUser.add(user2);
        listOfUser.add(user3);
        listOfUser.add(user4);
        listOfUser.add(user5);

        writeToJson(listOfUser);
    }
}
